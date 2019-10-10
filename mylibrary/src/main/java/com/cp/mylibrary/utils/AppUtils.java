package com.cp.mylibrary.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * 跟App相关的辅助类
 * Created by Jerry on 2016/7/5.
 */
public class AppUtils {


    public static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;

    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 2;

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 3;

    public static final int MY_PERMISSIONS_READ_PHONE_STATE = 4;


    /**
     * @param context
     * @return
     */
    public static String getPackageName(Context context) {
        return context.getPackageName();
    }


    /**
     * 取sdcard权限
     */
    public static void getSDCardPromission(Activity context) {
        LogCp.i(LogCp.CP, AppUtils.class + "  来取权限!");

        // 读取sdcard 权限
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            LogCp.i(LogCp.CP, AppUtils.class + " 已经有了读取sdcard 的权限!");
        } else {
            //do not have permission
            LogCp.i(LogCp.CP, AppUtils.class + "  没有 读取sdcard 的权限!");
            // Should we show an explanation?
//            if (ActivityCompat.shouldShowRequestPermissionRationale(context,
//                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
//            } else {

            ActivityCompat.requestPermissions(context,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            //  }
        }


        // 写入sdcard 权限
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            LogCp.i(LogCp.CP, AppUtils.class + " 已经有了写入sdcard 的权限!");

        } else {
            //do not have permission
            LogCp.i(LogCp.CP, AppUtils.class + "  没有 写入sdcard 的权限!");
            // Should we show an explanation?
            //    if (ActivityCompat.shouldShowRequestPermissionRationale(context,
            //           Manifest.permission.WRITE_EXTERNAL_STORAGE)) {


            //    } else {


            ActivityCompat.requestPermissions(context,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);


            //   }
        }

    }


    /**
     * 取相机
     */
    public static void getPromissionCAMERA(Activity context) {


        //  使用相机的权限
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)) {

            LogCp.i(LogCp.CP, AppUtils.class + " 已经有了  使用相机  的权限!");
        } else {
            //do not have permission
            LogCp.i(LogCp.CP, AppUtils.class + "  没有  使用相机  的权限!");
            // Should we show an explanation?
            //     if (ActivityCompat.shouldShowRequestPermissionRationale(context,
            //            Manifest.permission.CAMERA)) {


            //   } else {


            ActivityCompat.requestPermissions(context,
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CAMERA);


            //  }
        }





    }

    public static void getPromissionPhoneState(Activity context) {


        //
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE)) {

            LogCp.i(LogCp.CP, AppUtils.class + " 已经有了  读取手机状态   的权限!");
        } else {
            //do not have permission
            LogCp.i(LogCp.CP, AppUtils.class + "  没有 读取手机状态  的权限!");
            // Should we show an explanation?
            //     if (ActivityCompat.shouldShowRequestPermissionRationale(context,
            //            Manifest.permission.CAMERA)) {


            //   } else {


            ActivityCompat.requestPermissions(context,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    MY_PERMISSIONS_READ_PHONE_STATE);


            //  }
        }


    }


}


