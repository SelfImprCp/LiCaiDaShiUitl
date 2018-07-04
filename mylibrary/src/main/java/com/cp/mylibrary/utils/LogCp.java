package com.cp.mylibrary.utils;


import android.util.Log;


/**
 * 打印日志工具
 *
 * @author Administrator
 */

public class LogCp {

    private static boolean isDebug = true;
    private static String TAG = "mycp";
    public static String CP = "mycp";
    //规定每段显示的长度
    private static int LOG_MAXLENGTH = 2000;

    public static void w(String msg) {
        if (isDebug)
            if (null == msg) {
                msg = "msg is null ";
            }
        Log.i(TAG, msg);
    }


    public static void setIsDebug(boolean isDebug) {
        LogCp.isDebug = isDebug;
    }

    public static void w(int msg) {
        w(msg + "");
    }

    public static void w(float msg) {
        w(msg + "");
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.v(tag, msg);
    }

    public static void v(String tag, String msg, Throwable t) {
        if (isDebug)
            Log.v(tag, msg, t);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void d(String tag, String msg, Throwable t) {
        if (isDebug)
            Log.d(tag, msg, t);
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            int strLength = msg.length();
            int start = 0;
            int end = LOG_MAXLENGTH;
            for (int i = 0; i < 100; i++) {
                //剩下的文本还是大于规定长度则继续重复截取并输出
                if (strLength > end) {
                    Log.i(TAG + i, msg.substring(start, end));
                    start = end;
                    end = end + LOG_MAXLENGTH;
                } else {
                    Log.i(TAG, msg.substring(start, strLength));
                    break;
                }


            }
        }


    }

    /**
     * d显示购买课程
     */

    public static void showLongLog(String xml) {


        if (xml.length() > 4000) {
            for (int i = 0; i < xml.length(); i += 4000) {
                if (i + 4000 < xml.length())
                    Log.i("rescounter" + i, xml.substring(i, i + 4000));
                else
                    Log.i("rescounter" + i, xml.substring(i, xml.length()));
            }
        } else
            Log.i("resinfo", xml);
    }

    public static void i(String tag, String msg, Throwable t) {
        if (isDebug)
            Log.i(tag, msg, t);
    }

    public static void w(String tag, String msg) {
        if (isDebug)
            Log.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable t) {
        if (isDebug)
            Log.w(tag, msg, t);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable t) {
        if (isDebug)
            Log.e(tag, msg, t);
    }

    public static final void analytics(String log) {
        if (isDebug)
            Log.d(TAG, log);
    }

    public static final void error(String log) {
        if (isDebug)
            Log.e(TAG, "" + log);
    }

    public static final void log(String log) {
        if (isDebug)
            Log.i(TAG, log);
    }

    public static final void log(String tag, String log) {
        if (isDebug)
            Log.i(tag, log);
    }

    public static final void logv(String log) {
        if (isDebug)
            Log.v(TAG, log);
    }

    public static final void warn(String log) {
        if (isDebug)
            Log.w(TAG, log);
    }
}
