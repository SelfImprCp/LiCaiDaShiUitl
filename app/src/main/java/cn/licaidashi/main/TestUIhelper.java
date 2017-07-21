package cn.licaidashi.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cp.mylibrary.utils.OpenActivityUtil;

import cn.licaidashi.main.domian.SimpleBackPage;

import cn.licaidashi.main.ui.DialogTestActivity;
import cn.licaidashi.main.ui.GestureLockActivity;
import cn.licaidashi.main.ui.GestureVerifyActivity;
import cn.licaidashi.main.ui.ResumeActivity;
import cn.licaidashi.main.ui.ScrollViewTextActivity;
import cn.licaidashi.main.ui.TestListViewRefreshActivity;
import cn.licaidashi.main.ui.SimpleBackActivity;
import cn.licaidashi.main.ui.TestActivity;
import cn.licaidashi.main.ui.TestBanner;
import cn.licaidashi.main.ui.TestCreateTwoCode;
import cn.licaidashi.main.ui.TestDateTimeUtil;
import cn.licaidashi.main.ui.TestFileUtil;
import cn.licaidashi.main.ui.TestImageLoad;
import cn.licaidashi.main.ui.TestKeyBoardUtils;
import cn.licaidashi.main.ui.TestObjectUtils;
import cn.licaidashi.main.ui.TestPickerView;
import cn.licaidashi.main.ui.TestRecyclerRefreshActivity;
import cn.licaidashi.main.ui.TestScreentUtils;
import cn.licaidashi.main.ui.TestScrollViewRefreshActivity;
import cn.licaidashi.main.ui.TestTwoCode;
import cn.licaidashi.main.ui.TestWebView;
import cn.licaidashi.main.ui.TextNetWorkUtils;
import cn.licaidashi.main.ui.TextRandomUtils;
import cn.licaidashi.main.ui.TestUrlActivity;


/**
 * Created by Jerry on 2016/7/4.
 */
public class TestUIhelper {

     public   static  void showTestActivity(Context context){
         OpenActivityUtil.getInstance().openActivity(context,TestActivity.class);

     }

    public   static  void showTestFileActivity(Context context){
        OpenActivityUtil.getInstance().openActivity(context,TestFileUtil.class);

    }


    public static void showTestDateTimeUtil(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestDateTimeUtil.class);

    }

    public static void showtestKeyBoardUitls(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestKeyBoardUtils.class);
    }


    public static void showTestNetWorkUitls(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TextNetWorkUtils.class);
    }



    public static void showTesObjectsUitls(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestObjectUtils.class);
    }




    public static void showTestRandomUtils(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TextRandomUtils.class);
    }

    public static void showTestScreenUtils(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestScreentUtils.class);
    }
    public static void showTwoCode(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestTwoCode.class);
    }

    public static void showCreateTwoCode(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestCreateTwoCode.class);
    }
    public static void showImageLoad(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestImageLoad.class);
    }

    public static void showBanner(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestBanner.class);
    }
    public static void showWebView(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestWebView.class);
    }


    public static void showPullableListViewActivity(Context context) {
       OpenActivityUtil.getInstance().openActivity(context,TestListViewRefreshActivity.class);
    }


    public static void showDialogTestActivity(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,DialogTestActivity.class);
    }

    public static void showUrlTestActivity(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestUrlActivity.class);
    }


    public static void showTestPickerView(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestPickerView.class);
    }

    public static void showTestScrollViewRefreshActivity(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,TestScrollViewRefreshActivity.class);
    }


    public static void showXRefreshListViewActivity(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,    TestRecyclerRefreshActivity
                .class);
    }


    public static void showGestureLockActivity(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,    GestureLockActivity
                .class);
    }


    public static void showGestureVerifyActivity(Context context,String gustrue) {

         Bundle bundle = new Bundle();
        bundle.putString(GestureVerifyActivity.GESTURE,gustrue);

        OpenActivityUtil.getInstance().openActivity(context,    GestureVerifyActivity
                .class,bundle);
    }



    public static void showResumeActivity(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,    ResumeActivity
                .class);
    }




    public static void showScrollViewText(Context context) {
        OpenActivityUtil.getInstance().openActivity(context,    ScrollViewTextActivity
                .class);
    }




    /**
     *  test view
     * @param context
     */
    public static void showTextViewPageFragment(Context context   ) {
        showSimpleBack(context, SimpleBackPage.VIEW_PAGE);


    }







    // ===============================以下代码勿改动======================================//



    /**
     *
     * @param context
     * @param page
     */
    public static void showSimpleBack(Context context, SimpleBackPage page) {
        Intent intent = new Intent(context, SimpleBackActivity.class);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, page.getValue());
        context.startActivity(intent);
    }

    /**
     *
     * @param context
     * @param page
     * @param args
     */

    public static void showSimpleBack(Context context, SimpleBackPage page,
                                      Bundle args) {
        Intent intent = new Intent(context, SimpleBackActivity.class);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_ARGS, args);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, page.getValue());
        context.startActivity(intent);
    }



}
