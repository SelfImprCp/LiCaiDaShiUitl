package com.cp.mylibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * Created by Administrator on 2019/5/9 0009.
 */

public class ShareUitl {
    public final static String FILE_PROVIDER= "com.cp.fileprovider";


    /**
     * 调用系统 分享文件
     *
     * @param context
     * @param title
     * @param url
     */
    public static void shareSystemFile(Context context,
                                       final String filePath) {
        File file = new File(filePath);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        Uri photoUri = FileProvider.getUriForFile(
                context,
                FILE_PROVIDER,
                file);

        intent.putExtra(Intent.EXTRA_STREAM, photoUri);
        intent.setType("*/*");

        try {
            context.startActivity(Intent.createChooser(intent, "分享到"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 调用系统安装了的应用分享
     *
     * @param context
     * @param title
     * @param url
     */
    public static void showSystemShareOption(Context context,
                                             final String title, final String url) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享：" + title);
        intent.putExtra(Intent.EXTRA_TEXT, title + " " + url);
        context.startActivity(Intent.createChooser(intent, "选择分享"));
    }


}
