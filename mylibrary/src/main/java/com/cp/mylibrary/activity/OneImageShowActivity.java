package com.cp.mylibrary.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cp.mylibrary.R;
import com.cp.mylibrary.base.MyBaseActivity;
import com.cp.mylibrary.imagepreview.BasePagerAdapter;
import com.cp.mylibrary.imagepreview.GalleryViewPager;
import com.cp.mylibrary.imagepreview.UrlPagerAdapter;
import com.cp.mylibrary.utils.ImageUtils;
import com.cp.mylibrary.utils.LogCp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 图片预览界面
 *
 * @param
 * @param
 * @author kymjs
 */
public class OneImageShowActivity extends MyBaseActivity {


    public static final String BUNDLE_KEY_IMAGES = "bundle_key_images";


    private ImageView image_one_show_img;
    private TextView image_one_show_commit;

    private String imgPath ;

    // //

    @Override
    public void setRootView() {

        setContentView(R.layout.activity_image_one_show);
    }


    @Override
    public void initWidget() {

        super.initWidget();

        Bundle bundle = getIntent().getExtras();


        imgPath = bundle.getString(BUNDLE_KEY_IMAGES);

        image_one_show_img = (ImageView) findViewById(R.id.image_one_show_img);


        image_one_show_commit = (TextView)findViewById(R.id.image_one_show_commit);
        image_one_show_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;

        LogCp.i(LogCp.CP,OneImageShowActivity.class + " 要显示和图片的路径 " + imgPath);
        Bitmap bm = BitmapFactory.decodeFile(imgPath, options);
        LogCp.i(LogCp.CP,OneImageShowActivity.class + "  图片 是否为null: " + bm);

        image_one_show_img.setImageBitmap(bm);


    }



}
