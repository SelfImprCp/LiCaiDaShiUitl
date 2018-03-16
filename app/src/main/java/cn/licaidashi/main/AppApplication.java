package cn.licaidashi.main;

import android.content.Intent;

import com.cp.mylibrary.app.MyBaseApp;
import com.cp.mylibrary.utils.ImageLoaderUtils;


import cn.licaidashi.main.music.PlayService;
import cn.licaidashi.main.music.Preferences;

/**
 * Created by Jerry on 2016/7/5.
 */
public class AppApplication extends MyBaseApp {


    @Override
    public void onCreate() {
        super.onCreate();

        // 异常处理，不需要处理时注释掉这两句即可！
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        // 注册crashHandler
//        crashHandler.init(getApplicationContext());

        // 配置图片

        ImageLoaderUtils.configImageLoader(this, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, AppConfig.DEFAULT_SAVE_IMAGE_PATH);
        // 初始化网络 请求
//        MyHttpClient.initHttp(AppConfig.HOST,AppConfig.SUFFIX);
//        MyHttpClient.Cookie = "我的cookie ";
//
//        DBManager.get().init(this);


        Preferences.init(this);

        Intent intent = new Intent(this, PlayService.class);
        startService(intent);

    }
}
