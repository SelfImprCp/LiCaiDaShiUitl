package com.cp.mylibrary.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.cp.mylibrary.R;
import com.cp.mylibrary.app.MyBaseApp;

import com.cp.mylibrary.event.BaseEvent;
import com.cp.mylibrary.utils.ActivityManagerUtil;
import com.cp.mylibrary.utils.AppUtils;
import com.cp.mylibrary.utils.NetWorkUtil;
import com.cp.mylibrary.utils.ShowToastUtil;
import com.cp.mylibrary.utils.StatusBarU;
import com.readystatesoftware.systembartint.SystemBarTintManager;


import org.kymjs.kjframe.KJActivity;

import de.greenrobot.event.EventBus;


/**
 * Created by Jerry on 2016/7/6.
 */
public class MyBaseActivity extends KJActivity {

    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActivityManagerUtil.getInstance().pushActivty(this);


        mContext = MyBaseApp.getInstance();


        super.onCreate(savedInstanceState);


        StatusBarU.with(MyBaseActivity.this)

                .setDrawable(getResources().getDrawable(R.drawable.status_bar_shape))
                .init();
       


    }


    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    @Override
    protected void onDestroy() {

        ((MyBaseApp) this.getApplication()).getActivityManager().finishActivity(
                this);
        mContext = null;

        super.onDestroy();
      //  EventBus.getDefault().unregister(this);
    }

//    public void onEvent(BaseEvent event) {
//    }


    @Override
    public void initWidget() {
        super.initWidget();

        initView();
    }

    @Override
    public void initData() {
        super.initData();

        initMyData();
    }

    /**
     * 子类复写，初始化UI
     */
    protected void initView() {
        if (!NetWorkUtil.hasInternetConnected(this)) {

            ShowToastUtil.showToast(this, "请检查网络");

        }

    }


    @Override
    public void setRootView() {

    }

//
//    /**
//     *  初始化字体
//     */
//    protected void initFont() {
//
//    }


    /**
     * 子类复写，初始化数据
     */
    public void initMyData() {
    }


    @Override
    protected void onStart() {

        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}
