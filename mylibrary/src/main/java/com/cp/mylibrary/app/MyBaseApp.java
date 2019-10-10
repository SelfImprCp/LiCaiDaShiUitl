package com.cp.mylibrary.app;

import android.app.Application;

import com.cp.mylibrary.utils.ActivityManagerUtil;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Jerry on 2016/7/6.
 */
public class MyBaseApp extends Application {
    private static MyBaseApp context;
    private static ActivityManagerUtil activityManager = null;


    {
        //在application文件中配置三方平台的appkey：
        PlatformConfig.setWeixin(Config.WEICHAT_APPID, Config.WEICHAT_SECRET);

        PlatformConfig.setQQZone(Config.QQ_APPID,Config.QQ_APPKEY);



    }


    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        activityManager = ActivityManagerUtil.getInstance();


        //application中初始化sdk，这个初始化最好放在application的程序入口中，防止意外发生：

        UMShareAPI.get(this);


    }

    /**
     * 获得当前app运行的AppContext
     *
     * @return
     */
    public static MyBaseApp getInstance() {
        return context;
    }


    /**
     * @return
     */
    public ActivityManagerUtil getActivityManager() {
        return activityManager;
    }

    public static void exit() {
        activityManager.finishAllActivity();
    }


}
