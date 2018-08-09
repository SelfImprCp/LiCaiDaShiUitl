package com.cp.mylibrary.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cp.mylibrary.R;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.SpannableStringUitl;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by Jerry on 2018/8/9.
 */

public class VersionDialog extends Dialog {

    private Context mContext;

    private String msg;

    private String rightStr;
    private String leftStr;
    private String title;
    private View.OnClickListener itemsOnClick;

    public VersionDialog(  Context context, String title,
                           String msg, String rightStr, String leftStr,
                           View.OnClickListener itemsOnClick) {
        super(context, R.style.dialog);

        mContext = context;
        this.msg = msg;
        this
                .title = title;
        this.rightStr = rightStr;
        this.leftStr = leftStr;
        this.itemsOnClick = (View.OnClickListener) itemsOnClick;

        setCustomDialog();

    }


    private void setCustomDialog() {

        View dialogLayout = LayoutInflater.from(getContext()).inflate(R.layout.base_version_dialog, null);

        Window window = getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        //  wlp.layout_gravity = Gravity.CENTER;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        window.setAttributes(wlp);



        // 设置标题
        TextView title_tv = (TextView) dialogLayout
                .findViewById(R.id.base_version_dialog_title);
        title_tv.setText(title);
        // 设置内容
        TextView msg_tv = (TextView) dialogLayout
                .findViewById(R.id.base_version_dialog_txt);
        msg_tv.setVisibility(View.VISIBLE);
        msg_tv.setText(msg);
        ImageView cancelbtn = (ImageView) dialogLayout
                .findViewById(R.id.base_version_dialog_cannel_btn);
//		if (leftStr != null) {
//			cancelbtn.setText(leftStr);
//		}
        Button delbtn = (Button) dialogLayout
                .findViewById(R.id.base_version_dialog_sure_btn);
        if (rightStr != null) {
            delbtn.setText(rightStr);
        }
        delbtn.setOnClickListener((View.OnClickListener) itemsOnClick);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });






        super.setContentView(dialogLayout);
    }


}

