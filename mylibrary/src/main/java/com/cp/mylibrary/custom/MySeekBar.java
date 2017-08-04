package com.cp.mylibrary.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Created by Jerry on 2017/2/21.
 */

public class MySeekBar extends SeekBar {
    public MySeekBar(Context context) {
        super(context);
    }

    public MySeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    /**

     * Tries to claim the user‘s drag motion, and requests disallowing any

     * ancestors from stealing events in the drag.

     *

     * 试图告诉父view不要拦截子控件的drag

     */



    private void attemptClaimDrag() {



    }





}
