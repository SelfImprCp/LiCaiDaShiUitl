package com.cp.mylibrary.custom;

import android.content.Context;
import android.util.AttributeSet;

import com.cp.mylibrary.utils.SpannableStringUitl;

/**
 * Created by Jerry on 2018/6/12.
 */

public class RadixPointLimitTwoEditText extends android.support.v7.widget.AppCompatEditText {
    public RadixPointLimitTwoEditText(Context context) {
        super(context);
        initView();
    }

    public RadixPointLimitTwoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public RadixPointLimitTwoEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView() {

        SpannableStringUitl.radixPointNoInputTwo(this);

    }


}
