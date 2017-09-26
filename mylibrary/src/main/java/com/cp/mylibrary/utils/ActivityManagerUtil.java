package com.cp.mylibrary.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * activity堆栈式管理
 * activity管理类，防止activity跳转混乱
 */
public class ActivityManagerUtil {

    private static Stack<Activity> activityStack;
    private static ActivityManagerUtil instance;

    private ActivityManagerUtil() {
    }

    /**
     * 单一实例
     */
    public static ActivityManagerUtil getInstance() {
        if (instance == null) {
            instance = new ActivityManagerUtil();
        }

        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }

        return instance;
    }

    /**
     * 获取指定的Activity
     *
     * @author kymjs
     */
    public static Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        return null;
    }

    /**
     * 添加Activity到堆栈
     */
    public void pushActivty(Activity activity) {
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {

        LogCp.i(LogCp.CP, ActivityManagerUtil.class + "  结束的activity   之前  " + activity);

        if (activity != null && activityStack.contains(activity)) {

            LogCp.i(LogCp.CP, ActivityManagerUtil.class + "  结束的activity  " + activity);


            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定的Activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity);
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {


        LogCp.i(LogCp.CP, ActivityManagerUtil.class + "   堆中的数量   " + activityStack.size());

//        for (int i = 0 ; i < activityStack.size(); i++) {

        for (Activity activity : activityStack) {

            LogCp.i(LogCp.CP, ActivityManagerUtil.class + "   堆中的 Activity     " + activity);

            if (null != activity) {

                finishActivity(activity);

            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            LogCp.i(LogCp.CP, ActivityManagerUtil.class + " 退出程序 ");

            finishAllActivity();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
