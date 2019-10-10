package cn.licaidashi.main.ui;


import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cp.mylibrary.custom.TitleBarView;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.MathExtend;
import com.cp.mylibrary.utils.StringUtils;

import org.kymjs.kjframe.ui.BindView;


import cn.licaidashi.main.R;

/**
 * Created by Jerry on 2016/7/7.
 * <p>
 * <p>
 * 基金分AB两只，
 * A基金为波动更大：权重 6
 * B基金为波动较小：权重 4
 * <p>
 * <p激进账户
 * <p>
 * <p>
 * 卖出
 * 0.到手收益在10%以下，不卖出。
 * 1.到手收益达到12%，卖出四分之一
 * 2.到手收益达到13%，卖出三分之一，
 * 3.到手收益达到14%，卖出三分之二，
 * 4.到手收益达到16%，全部卖出。
 * <p>
 * 买入 （操作两只基金，涨跌以平均跌幅算，买入比例以跌幅占比相同 如：A基金跌：1.5，B基金跌0.5，平均跌 1，若准备投入100元，刚A基金投入75元，B基金投入25元）
 * 1.拿出三分之一的资金建仓，分十个交易日，基本建仓完毕
 * 2.持有收益在0%以下，投入可动用资金10%，
 * 3.持有收益在-5%以下，投入可动用资金15%，进行投入
 * 4.持有收益在-10%以下，投入可动用资金20%，进行投入
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 5.正收益在当日预估上涨时均不投入。
 * 6.持有收益在0%-5%之间，
 * 当天预估跌1%以内，投入4%，
 * 跌1%以上，投入5%，
 * 跌1.5%以上，投入7%
 * 跌2%以上，投入8%
 * //        7.持有收益在5%到7%之间：
 * //        跌1.5%以上，投入3%
 * //                跌2%以上，投入4%
 * <p>
 * 8.收益到7%以上，不再买入。
 */
public class Fund extends BaseActivity {

    @BindView(id = R.id.fund_title)
    private TitleBarView fund_title;


    @BindView(id = R.id.fund_a_down)
    private EditText fund_a_down;


    @BindView(id = R.id.fund_money_all)
    private EditText fund_money_all;


    @BindView(id = R.id.fund_b_down)
    private EditText fund_b_down;


    @BindView(id = R.id.fund_a_buy)
    private TextView fund_a_buy;
    @BindView(id = R.id.fund_b_buy)
    private TextView fund_b_buy;

    @BindView(id = R.id.fund_a_b_buy)
    private TextView fund_a_b_buy;


    @BindView(id = R.id.fund_jisuan, click = true)
    private TextView fund_jisuan;


    @BindView(id = R.id.fund_qinling, click = true)
    private TextView fund_qinling;


    @BindView(id = R.id.fund_shouyi_10_down, click = true)
    private TextView fund_shouyi_10_down;

    @BindView(id = R.id.fund_shouyi_5_down, click = true)
    private TextView fund_shouyi_5_down;


    @BindView(id = R.id.fund_shouyi_0_down, click = true)
    private TextView fund_shouyi_0_down;


    @BindView(id = R.id.fund_shouyi_0_5, click = true)
    private TextView fund_shouyi_0_5;


    @BindView(id = R.id.fund_shouyi_5_10, click = true)
    private TextView fund_shouyi_5_10;


    //总收益率，分五个档次次：
    //A:-10以下
    //B:-5以下
    //C:0以下
    //D:0-5
    //E:5-7
    private String shouyiAll = "C";

    @Override
    public void setRootView() {
        super.setRootView();

        setContentView(R.layout.activity_fund);
    }

    @Override
    protected void initView() {
        super.initView();


        fund_title.setTitleStr("基金交易");

    }


    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);

        switch (v.getId()) {
            case R.id.fund_jisuan:

                jiSuan();
                break;

            case R.id.fund_qinling:


                fund_money_all.setText("");


                fund_a_down.setText("");


                fund_b_down.setText("");

                fund_a_b_buy.setText("0");
                fund_a_buy.setText("0");
                fund_b_buy.setText("0");

                break;


            case R.id.fund_shouyi_10_down:

                shouyiAll = "A";

                fund_shouyi_10_down.setBackgroundResource(R.drawable.round_corners_red_nei_corners_25);

                fund_shouyi_5_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_0_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_0_5.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_5_10.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);


                break;
            case R.id.fund_shouyi_5_down:
                shouyiAll = "B";
                fund_shouyi_5_down.setBackgroundResource(R.drawable.round_corners_red_nei_corners_25);

                fund_shouyi_10_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_0_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_0_5.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_5_10.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);


                break;
            case R.id.fund_shouyi_0_down:
                shouyiAll = "C";
                fund_shouyi_0_down.setBackgroundResource(R.drawable.round_corners_red_nei_corners_25);

                fund_shouyi_10_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_5_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_0_5.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_5_10.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);

                break;
            case R.id.fund_shouyi_0_5:
                shouyiAll = "D";
                fund_shouyi_0_5.setBackgroundResource(R.drawable.round_corners_red_nei_corners_25);

                fund_shouyi_10_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_5_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_0_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_5_10.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);

                break;
            case R.id.fund_shouyi_5_10:
                shouyiAll = "E";
                fund_shouyi_5_10.setBackgroundResource(R.drawable.round_corners_red_nei_corners_25);

                fund_shouyi_10_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_5_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_0_down.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);
                fund_shouyi_0_5.setBackgroundResource(R.drawable.round_corners_blue_nei_corners_25);

                break;


        }


    }


    private void jiSuan() {


        //收益率在A档：
//总收益率，分五个档次次：
        //A:-10以下
        //B:-5以下
        //C:0以下
        //D:0-5
        //E:5-10
        if (shouyiAll.equals("A")) {
            shouyi0Down("0.2");
        }

        if (shouyiAll.equals("B")) {
            shouyi0Down("0.15");
        }
        if (shouyiAll.equals("C")) {
            shouyi0Down("0.1");
        }
        if (shouyiAll.equals("D")) {
            shouyiD();
        }
        if (shouyiAll.equals("E")) {
            shouyiE();
        }
    }

    private void shouyiD() {
        // 持有收益在0%-5%之间，
//        当天预估跌1%以内，投入4%，
//        跌1%以上，投入5%，
//        跌1.5%以上，投入7%
//                跌2%以上，投入8%
        String rate = "0.04";

        //两只基金总共下跌
        float a_b_down_f = getABDownRate();

        if (a_b_down_f < 1 || a_b_down_f == 1) {
            rate = "0.04";
        } else if (a_b_down_f > 1 && a_b_down_f < 1.5 || a_b_down_f == 1.5) {
            rate = "0.05";
        } else if (a_b_down_f > 1.5 && a_b_down_f < 2 || a_b_down_f == 2) {
            rate = "0.07";
        } else if (a_b_down_f > 2) {
            rate = "0.08";
        }

        shouyi0Down(rate);


    }


    private void shouyiE() {
//        7.持有收益在5%到7%之间：
//        跌1.5%以上，投入3%
//                跌2%以上，投入4%

        String rate = "0.01";


        float a_b_down_f = getABDownRate();

        if (a_b_down_f > 1.5 && a_b_down_f < 2 || a_b_down_f == 2) {
            rate = "0.03";
        } else if (a_b_down_f > 2) {
            rate = "0.04";
        }

        shouyi0Down(rate);
    }


    /**
     * 传入可投放金额的比例
     */
    private void
    shouyi0Down(String rate) {

        //两只基金总共下跌
        String a_b_down = MathExtend.add(fund_a_down.getText().toString(), fund_b_down.getText().toString());

        String moneyAll = StringUtils.toFloat(fund_money_all.getText().toString()) * 10000 + "";

        LogCp.i(LogCp.CP, Fund.class + "可投入金额：" + moneyAll);

        //应该投放金额
        String touRuMoney = MathExtend.multiply(moneyAll, rate);

        //A基金下跌占比
        String a_down_rate = MathExtend.divide(fund_a_down.getText().toString(), a_b_down);
        //B基金下跌占比
        String b_down_rate = MathExtend.divide(fund_b_down.getText().toString(), a_b_down);
        LogCp.i(LogCp.CP, Fund.class + "可投入占比 未加权重： a" + a_down_rate + " b:" + b_down_rate);
        // A 基金权重为6
        float a = (float) (StringUtils.toFloat(a_down_rate) + 0.1);
        // B 基金权重为4

        float b = (float) (StringUtils.toFloat(b_down_rate) - 0.1);
        //如果b的比例小于0.1，那么就不加权重了 b按最小值 算
        if (b < 0.1) {
            b = (float) 0.1;
            a = (float) 0.9;
        }

        LogCp.i(LogCp.CP, Fund.class + "可投入占比： a" + a + " b:" + b);
        //A 基金应该投入
        String a_buy = MathExtend.multiply(touRuMoney, a + "");

        //B 基金应该投入
        String b_buy = MathExtend.multiply(touRuMoney, b + "");


        fund_a_b_buy.setText(MathExtend.round(touRuMoney, 2));
        fund_a_buy.setText(MathExtend.round(a_buy, 2));
        fund_b_buy.setText(MathExtend.round(b_buy, 2));


    }


    /**
     * @return
     */
    private float getABDownRate() {

        //两只基金总共下跌
        String a_b_down = MathExtend.round(MathExtend.add(fund_a_down.getText().toString(), fund_b_down.getText().toString()), 2);
        String pinju = MathExtend.divide(a_b_down, "2");
        float a_b_down_f = StringUtils.toFloat(pinju);

        LogCp.i(LogCp.CP, Fund.class + "两只基金平均下跌：" + a_b_down_f);

        return a_b_down_f;


    }


}
