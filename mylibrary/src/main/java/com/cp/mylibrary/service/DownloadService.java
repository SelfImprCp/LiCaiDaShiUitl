package com.cp.mylibrary.service;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.cp.mylibrary.R;
import com.cp.mylibrary.app.Config;
import com.cp.mylibrary.base.MyBaseActivity;
import com.cp.mylibrary.interf.ICallbackResult;

import com.cp.mylibrary.utils.FileUtil;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.StringUtils;
import com.cp.mylibrary.utils.TDevice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * download service
 *
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年11月18日 下午3:02:36
 */
public class DownloadService extends Service {

    public static final String BUNDLE_KEY_DOWNLOAD_URL = "download_url";

    public static final String BUNDLE_KEY_TITLE = "title";

    private final String tag = "download";
    private static final int NOTIFY_ID = 0;
    private int progress;
    private NotificationManager mNotificationManager;
    private boolean canceled;

    private String downloadUrl;

    private String mTitle = "正在下载%s";


    // 下载的apk保存的位置
    public String saveFileName = Config.DEFAULT_SAVE_FILE_PATH;

    private ICallbackResult callback;

    private DownloadBinder binder;

    private boolean serviceIsDestroy = false;

    private Context mContext = this;

    private Thread downLoadThread;

    private Notification mNotification;
//
// 	public  static   Class mActivity;

//	 public  static  void setActivity(Class activity)
//	 {
//		 mActivity = activity;
//	 }

    //
    private Handler mHandler = new Handler() {

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    // 下载完毕

                    LogCp.i(LogCp.CP, DownloadService.this + "   下载   good   ");


                    mNotificationManager.cancel(NOTIFY_ID);
                    installApk();
                    break;
                case 2:
                    // 取消通知
                    mNotificationManager.cancel(NOTIFY_ID);
                    break;
                case 1:
                    int rate = msg.arg1;


                    LogCp.i(LogCp.CP, DownloadService.this + "   下载 版本 " + rate);


                    if (rate < 100) {
                        RemoteViews contentview = mNotification.contentView;
                        contentview.setTextViewText(R.id.tv_download_state, mTitle + "(" + rate
                                + "%" + ")");
                        contentview.setProgressBar(R.id.pb_download, 100, rate,
                                false);


                        mNotificationManager.notify(NOTIFY_ID, mNotification);
                    } else {
                        // 下载完毕后变换通知形式
                        mNotification.flags = Notification.FLAG_AUTO_CANCEL;
                        mNotification.contentView = null;
                        //  Intent intent = new Intent(mContext, MainActivity.class);
                        // 告知已完成
                        //intent.putExtra("completed", "yes");
                        // 更新参数,注意flags要使用FLAG_UPDATE_CURRENT
                        //PendingIntent contentIntent = PendingIntent.getActivity(
                        //      mContext, 0, intent,
                        //    PendingIntent.FLAG_UPDATE_CURRENT);
// 				mNotification.setLatestEventInfo(mContext, "下载完成",
// 						"文件已下载完毕", contentIntent);
                        serviceIsDestroy = true;
                        stopSelf();// 停掉服务自身

                    }

//

                    break;
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        downloadUrl = intent.getStringExtra(BUNDLE_KEY_DOWNLOAD_URL);
        saveFileName = saveFileName + getSaveFileName(downloadUrl);

        mTitle = String.format(mTitle, intent.getStringExtra(BUNDLE_KEY_TITLE));
        return binder;
    }

    private String getSaveFileName(String downloadUrl) {
        if (downloadUrl == null || StringUtils.isEmpty(downloadUrl)) {
            return "";
        }
        return downloadUrl.substring(downloadUrl.lastIndexOf("/"));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        binder = new DownloadBinder();
        mNotificationManager = (NotificationManager) getSystemService(android.content.Context.NOTIFICATION_SERVICE);
        stopForeground(true);// 这个不确定是否有作用
    }

    private void startDownload() {
        canceled = false;
        downloadApk();
    }

    /**
     * 创建通知
     */
    private void setUpNotification() {
        int icon = R.drawable.ic_launcher;
        CharSequence tickerText = "准备下载";
        long when = System.currentTimeMillis();


        // 此处必须兼容android O设备，否则系统版本在O以上可能不展示通知栏

        String id = "0001";
        String name = "download";
        RemoteViews contentView = new RemoteViews(getPackageName(),
                R.layout.download_notification_show);
        contentView.setTextViewText(R.id.tv_download_state, mTitle);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_LOW);
            mChannel.setDescription(name);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.BLUE);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});


            mNotificationManager.createNotificationChannel(mChannel);


            Notification.Builder builder = new Notification.Builder(mContext, "channel_anyin");
            //设置小图标
            builder.setSmallIcon(R.drawable.ic_launcher)
                    .setContent(contentView)
                    .setWhen(System.currentTimeMillis())
                    .setAutoCancel(true);//用户触摸时，自动关闭

            mNotification = builder.build();
        } else {
            mNotification = new Notification.Builder(mContext)
                    .setAutoCancel(true)

                    .setSmallIcon(R.drawable.ic_launcher)
                    .setWhen(System.currentTimeMillis())
                    .setContent(contentView)
                    .build();

        }


//        mNotification = new Notification(icon, tickerText, when);
        // 放置在"正在运行"栏目中
        mNotification.flags = Notification.FLAG_ONGOING_EVENT;


        // 指定个性化视图
//        mNotification.contentView = contentView;


        mNotificationManager.notify(NOTIFY_ID, mNotification);
    }

    private void downloadApk() {
        downLoadThread = new Thread(mdownApkRunnable);
        downLoadThread.start();
    }

    /**
     * 安装apk
     */
    private void installApk() {
        File apkfile = new File(saveFileName);


        LogCp.i(LogCp.CP, DownloadService.this + "   下载 版本  installApk   " + saveFileName + " apk File " + apkfile);


        if (!apkfile.exists()) {


            return;
        }

        LogCp.i(LogCp.CP, DownloadService.this + "  手机  android 版本 :   " + Build.VERSION.SDK_INT);


        if (Build.VERSION.SDK_INT >= 24) { //判读版本是否在7.0以上
            TDevice.install(mContext, apkfile);
        } else {
            TDevice.installAPK(mContext, apkfile);
        }


    }

    private Runnable mdownApkRunnable = new Runnable() {
        @Override
        public void run() {
            File file = new File(Config.DEFAULT_SAVE_FILE_PATH);

            if (!file.exists()) {
                file.mkdirs();
            }
            String apkFile = saveFileName;
            File saveFile = new File(apkFile);
            try {
                downloadUpdateFile(downloadUrl, saveFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public long downloadUpdateFile(String downloadUrl, File saveFile)
            throws Exception {


        // 注，需要这样的下载链接


        LogCp.i(LogCp.CP, DownloadService.this + "   下载 downloadUpdateFile " + downloadUrl + " file n：" + saveFile);


        int downloadCount = 0;
        int currentSize = 0;
        long totalSize = 0;
        int updateTotalSize = 0;

        HttpURLConnection httpConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;

        try {
            URL url = new URL(downloadUrl);
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection
                    .setRequestProperty("User-Agent", "PacificHttpClient");


            if (currentSize > 0) {
                httpConnection.setRequestProperty("RANGE", "bytes="
                        + currentSize + "-");
            }


            httpConnection.setConnectTimeout(10000);
            httpConnection.setReadTimeout(20000);
            updateTotalSize = httpConnection.getContentLength();

            if (httpConnection.getResponseCode() == 404) {
                throw new Exception("fail!");
            }


            is = httpConnection.getInputStream();


            fos = new FileOutputStream(saveFile, false);


            byte buffer[] = new byte[1024];


            int readsize = 0;


            while ((readsize = is.read(buffer)) > 0) {
                fos.write(buffer, 0, readsize);
                totalSize += readsize;
                // 为了防止频繁的通知导致应用吃紧，百分比增加10才通知一次
                if ((downloadCount == 0)
                        || (int) (totalSize * 100 / updateTotalSize) - 5 >= downloadCount) {
                    downloadCount += 5;


                    LogCp.i(LogCp.CP, DownloadService.this + "   下载  更新进度  " + downloadCount);


                    // 更新进度
                    Message msg = mHandler.obtainMessage();
                    msg.what = 1;
                    msg.arg1 = downloadCount;
                    mHandler.sendMessage(msg);
                    if (callback != null)
                        callback.OnBackResult(progress);
                }
            }

            // 下载完成通知安装
            mHandler.sendEmptyMessage(0);
            // 下载完了，cancelled也要设置
            canceled = true;

        } finally {
            if (httpConnection != null) {
                httpConnection.disconnect();
            }
            if (is != null) {
                is.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
        return totalSize;
    }

    public class DownloadBinder extends Binder {
        public void start() {
            if (downLoadThread == null || !downLoadThread.isAlive()) {
                progress = 0;
                setUpNotification();
                new Thread() {
                    public void run() {


                        LogCp.i(LogCp.CP, DownloadService.this + "   启动下载   ");


                        // 下载
                        startDownload();
                    }

                    ;
                }.start();
            }
        }

        public void cancel() {
            canceled = true;
        }

        public int getProgress() {
            return progress;
        }

        public boolean isCanceled() {
            return canceled;
        }

        public boolean serviceIsDestroy() {
            return serviceIsDestroy;
        }

        public void cancelNotification() {
            mHandler.sendEmptyMessage(2);
        }

        public void addCallback(ICallbackResult callback) {
            DownloadService.this.callback = callback;
        }
    }
}
