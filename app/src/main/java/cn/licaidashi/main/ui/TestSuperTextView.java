package cn.licaidashi.main.ui;

import android.widget.TextView;

import com.allen.library.SuperTextView;
import com.cp.mylibrary.custom.TitleBarView;
import com.cp.mylibrary.utils.ImageLoaderUtils;
import com.cp.mylibrary.utils.SpannableStringUitl;

import org.kymjs.kjframe.ui.BindView;

import cn.licaidashi.main.R;

/**
 * Created by Jerry on 2017/9/12.
 */

public class TestSuperTextView extends BaseActivity {





    @BindView(id = R.id.super_textview_test_title)
    private TitleBarView super_textview_test_title;







    @BindView(id = R.id.supertextview_load_img)
    private SuperTextView supertextview_load_img;







    @Override
    public void setRootView() {
        super.setRootView();

        setContentView(R.layout.activity_supertextview_test);



    }

    @Override
    protected void initView() {
        super.initView();


        super_textview_test_title.setTitleBackFinshActivity(this);
        super_textview_test_title.setTitleStr("测试  superTextView  ");







    }

}
