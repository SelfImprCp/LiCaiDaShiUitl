package com.cp.mylibrary.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cp.mylibrary.R;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.StringUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.io.File;


/**
 * 分享界面
 *  图片用的
 * dialog
 *
 * @author kymjs
 */
public class ShareImageDialog extends CommonDialog implements
        View.OnClickListener {
    private Context context;

    private Activity mActivity;
    private String title;
    private String content;
    private String link;
    // 分享中显示 的图片
    private File share_img_file;


    private LinearLayout ly_share_weichat_circle;


//    private ShareListener shareListenr;


    private ShareImageDialog(Context context, boolean flag, OnCancelListener listener) {
        super(context, flag, listener);
        this.context = context;
    }

    public ShareImageDialog(Context context, Activity activity) {
        this(context);

        this.context = context;
        this.mActivity = activity;


    }


    @SuppressLint("InflateParams")
    private ShareImageDialog(Context context, int defStyle) {
        super(context, defStyle);
        this.context = context;
        View shareView = getLayoutInflater().inflate(
                R.layout.dialog_cotent_share, null);
        shareView.findViewById(R.id.ly_share_qq).setOnClickListener(this);
//        shareView.findViewById(R.id.ly_share_copy_link)
//                .setOnClickListener(this);
//        shareView.findViewById(R.id.ly_share_more_option).setOnClickListener(
//                this);
        shareView.findViewById(R.id.ly_share_sina_weibo).setOnClickListener(
                this);
        shareView.findViewById(R.id.ly_share_weichat).setOnClickListener(this);
        shareView.findViewById(R.id.ly_share_weichat_circle)
                .setOnClickListener(this);


        ly_share_weichat_circle = (LinearLayout) shareView.findViewById(R.id.ly_share_weichat_circle);


        setContent(shareView, 0);
    }

    public ShareImageDialog(Context context) {
        this(context, R.style.dialog_bottom);
    }


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setGravity(Gravity.BOTTOM);

        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = d.getWidth();
        getWindow().setAttributes(p);
    }

    // 设置需要分享的内容
    public void setShareInfo(String title, String content, String link, File share_img_url) {
        this.title = title;
        this.content = content;
        this.link = link;
        this.share_img_file = share_img_url;
    }


    // 设置需要分享的内容
    public void setWeichatCircleGone(int gone) {
        ly_share_weichat_circle.setVisibility(gone);

    }


    @Override
    public void onClick(View v) {
//        if (!checkCanShare()) {
//            AppContext.showToast("内容加载中，请稍候...");
//            return;
//        }


        if (v.getId() == R.id.ly_share_weichat_circle) {

            shareToWeiChatCircleImage();

        }

        if (v.getId() == R.id.ly_share_weichat) {


          shareToWeiChatImage();


        }

        if (v.getId() == R.id.ly_share_sina_weibo) {


            shareToSinaWeibo();
        }

        if (v.getId() == R.id.ly_share_qq) {
            shareToQQ();

        }


        this.dismiss();
    }


    @SuppressWarnings("deprecation")
    private void shareToWeiChatCircleImage() {

        LogCp.i(LogCp.CP, ShareImageDialog.class + " 来分享到weChat 朋友圈" + title + content + link + share_img_file);


        UMImage thumb = new UMImage(mActivity, share_img_file);


        thumb.setTitle(title);//标题
        thumb.setThumb(thumb);  //缩略图
        thumb.setDescription(content);//描述
        thumb.mText = " 来试试";

//        UMWeb  thumb = new UMWeb("http://dev.umeng.com/social/android/quick-integration#umweb");
//        thumb.setTitle("This is music title");//标题
//     //   thumb.setThumb(thumb);  //缩略图
//        thumb.setDescription("my description");//描述
//




        new ShareAction(mActivity).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                .withText("内容，，")
                .withMedia(thumb)
                .withSubject(" what are you dong? moment ")
                .withFollow(" 是这个吗？ 不是")
                .setCallback(umShareListener)
                .share();


    }





    private void shareToWeiChatImage(   ) {

        LogCp.i(LogCp.CP, ShareImageDialog.class + " 来分享到weChat  " + title + content + link + share_img_file);

        UMImage thumb = new UMImage(mActivity,share_img_file);

        thumb.setTitle(title);//标题
        thumb.setThumb(thumb);  //缩略图
        thumb.setDescription(content);//描述
        thumb.mText = "6541565";


        new ShareAction(mActivity).setPlatform(SHARE_MEDIA.WEIXIN)
                .withText("内容，，")
                .withSubject("你想说个屁")
                .withMedia(thumb)
                .withFollow(" 是这个吗？")

                .setCallback(umShareListener)
                .share();


    }









    private void shareToSinaWeibo() {


        UMImage image = new UMImage(mActivity, share_img_file);

        new ShareAction(mActivity).setPlatform(SHARE_MEDIA.SINA)
                .withText(content)
                //  .withTitle(title)
                //.withTargetUrl(link)
                .withMedia(image)
                .setCallback(umShareListener)
                .share();


    }

    private void shareToQQ() {
        UMImage image = new UMImage(mActivity, share_img_file);

        new ShareAction(mActivity).setPlatform(SHARE_MEDIA.QQ)
                .withText(content)
                //  .withTitle(title)
                //    .withTargetUrl(link)
                .withMedia(image)
                .setCallback(umShareListener)
                .share();
    }


    private UMShareListener umShareListener = new UMShareListener() {

        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);
//            ,
//                    ,


            Toast.makeText(context, "分享成功", Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context, "分享失败", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context, "分享取消了", Toast.LENGTH_SHORT).show();
        }


    };


    private void getSinaImg() {


    }

    private UMImage getShareImg() {
        LogCp.i(LogCp.CP, ShareImageDialog.class + " 分享的图片：  " + share_img_file);

        UMImage img;
        if (share_img_file!=null) {
            img = new UMImage(context, share_img_file);
        } else {

            img = new UMImage(context, R.drawable.ic_launcher);
        }


        return img;
    }

    private boolean checkCanShare() {
        boolean canShare = true;
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(content) || StringUtils.isEmpty(link)) {
            canShare = false;
        }
        return canShare;
    }


}
