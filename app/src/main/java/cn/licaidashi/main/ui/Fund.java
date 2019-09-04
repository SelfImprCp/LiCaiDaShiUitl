package cn.licaidashi.main.ui;


import com.cp.mylibrary.custom.TitleBarView;

import org.kymjs.kjframe.ui.BindView;


import cn.licaidashi.main.R;

/**
 * Created by Jerry on 2016/7/7.
 * 测试 仿微信中加载网页时带线行进度条的WebView的实现
 */
public class Fund extends BaseActivity {

    @BindView(id = R.id.fund_title)
    private TitleBarView fund_title;



    @Override
    public void setRootView() {
        super.setRootView();

        setContentView(R.layout.activity_fund);
    }

    @Override
    protected void initView() {
        super.initView();




    }




}
