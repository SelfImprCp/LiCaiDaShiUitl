package cn.licaidashi.main.ui;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.cp.mylibrary.custom.TitleBarView;

import org.kymjs.kjframe.ui.BindView;

import cn.licaidashi.main.R;


/**
 * Created by Jerry on 2016/7/4.
 * <p/>
 * <p/>
 * 测试文件工具类
 */
public class TestFuWenBenUtil extends BaseActivity {


    @BindView(id = R.id.fuwenben_test_title)
    private TitleBarView fuwenben_test_title;


    @BindView(id = R.id.fuwenben_test_text)
    private TextView fuwenben_test_text;


    @Override
    public void setRootView() {
        setContentView(R.layout.activity_fuwenben_test);
    }

    @Override
    protected void initView() {
        super.initView();

        fuwenben_test_title.setTitleBackFinshActivity(this);
        fuwenben_test_title.setTitleStr("富文本测试");


        String str = "<p><strong>制定理财目标</strong></p>\\r\\n\\r\\n<p>一般来说，理财目标分长期理财、中期理财和短期理财三种，短期目标可能是为一年后购房储备足够的首付款，中期目标可能是为十几年后子女去海外上大学筹措教育经费，而长期目标可能是为退休养老做好准备。有了目标后自然而然就会有相应的计划去一步步完成，不过切记给自己制定不切实际的目标，想一口吃成个胖子是不太可能的。</p>\\r\\n\\r\\n<p><strong>了解财务状况</strong></p>\\r\\n\\r\\n<p>首先你需要对自己的家庭财政状况有个清晰明确的了解，然后结合家庭成员的收入和开支，制定一个合理的理财投资计划。在分析家庭财务状况时，需要用到最主要的5个财务指标。</p>\\r\\n\\r\\n<p><strong>1</strong><strong>、偿付比率</strong></p>\\r\\n\\r\\n<p>计算公式：偿付比率=净资产&divide;总资产</p>\\r\\n\\r\\n<p>这个指标反映了个人的财务结构是否合理，它反映了客户综合还债能力的高低。一般来说，偿付比例的变化范围在0到1之间，该项数值为0.5较为适宜。</p>\\r\\n\\r\\n<p><strong>2</strong><strong>、负债比率</strong></p>\\r\\n\\r\\n<p>计算公式：负债比率=负债总额&divide;总资产</p>\\r\\n\\r\\n<p>负债比率是家庭负债总额与总资产的比值，它是衡量家庭财务状况是否良好的一项重要指标。该项数值应控制在0.5以下，才能预防因流动资产不足而可能出现的财务危机。</p>\\r\\n\\r\\n<p><strong>3</strong><strong>、流动性比率</strong></p>\\r\\n\\r\\n<p>计算公式：流动性比率=流动性资产&divide;每月支出</p>\\r\\n\\r\\n<p>流动性比率反映了客户支出能力的强弱。一般来说，家庭流动性资产应满足3-6个月的日常开支。该数值不宜过大，该数值若过大，由于流动资产的收益一般不高，因此就会影响到客户资产的进一步升值能力。</p>\\r\\n\\r\\n<p><strong>4</strong><strong>、负债收入比率</strong></p>\\r\\n\\r\\n<p>计算公式：负债收入比率=每年偿债额&divide;税前年收入</p>\\r\\n\\r\\n<p>负债收入比率是指家庭到期需支付的债务本息与同期收入的比值，它是衡量家庭一定时期财务状况是否良好的重要指标。该项数值保持在0.5以下比较合适。负债收入比率过高，则家庭在进行借贷融资时会出现一定困难。</p>\\r\\n\\r\\n<p><strong>5</strong><strong>、投资与净资产比率</strong></p>\\r\\n\\r\\n<p>计算公式：投资与净资产比率=投资资产&divide;净资产</p>\\r\\n\\r\\n<p>投资与净资产比率是指家庭投资资产与净资产的比值，它反映了家庭通过投资提高净资产的能力。该项数值在0.5左右为宜，在0.5的水平下，即可保持适当的投资收益，又不会面临太高的风险</p>\\r\\n";

        CharSequence charSequence = Html.fromHtml(str);

        fuwenben_test_text.setText(charSequence);
        //该语句在设置后必加，不然没有任何效果
        fuwenben_test_text.setMovementMethod(LinkMovementMethod.getInstance());


    }


}
