package cn.licaidashi.main.ui;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cp.mylibrary.city.CityPicker;
import com.cp.mylibrary.city.ScrollerNumberPicker;
import com.cp.mylibrary.custom.CPScrollView;
import com.cp.mylibrary.custom.TitleBarView;
import com.cp.mylibrary.datechoosewell.DateChooseWheelViewDialog;
import com.cp.mylibrary.res.UpdateRes;
import com.cp.mylibrary.utils.AreaParserUitl;
import com.cp.mylibrary.utils.DateTimeUtil;
import com.cp.mylibrary.utils.IDCardUitl;
import com.cp.mylibrary.utils.ImageUtils;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.NoDoubleClickUtils;
import com.cp.mylibrary.utils.ScreenUtils;
import com.cp.mylibrary.utils.StringUtils;
import com.cp.mylibrary.utils.UpdateManagerUtil;

import org.kymjs.kjframe.ui.BindView;

import java.util.Date;

import cn.licaidashi.main.R;
import cn.licaidashi.main.TestUIhelper;
import cn.licaidashi.main.bean.UserBean;
import cn.licaidashi.main.music.PlayFragment;


/**
 * Created by Jerry on 2016/6/24.
 */
public class TestActivity extends BaseActivity {


    private Dialog dialog;


    @BindView(id = R.id.test_app_utils, click = true)
    private TextView test_app_utils;


    @BindView(id = R.id.text_title, click = true)
    private TitleBarView text_title;


    @BindView(id = R.id.test_date_time_util, click = true)
    private TextView test_date_time_util;


    @BindView(id = R.id.file_test, click = true)
    private TextView file_test;


    @BindView(id = R.id.key_board_test, click = true)
    private TextView key_board_test;


    @BindView(id = R.id.object_utils_test, click = true)
    private TextView object_utils_test;

    @BindView(id = R.id.random_utils_test, click = true)
    private TextView random_utils_test;


    @BindView(id = R.id.screen_utils_test, click = true)
    private TextView screen_utils_test;


    @BindView(id = R.id.cache_utils_test, click = true)
    private TextView cache_utils_test;

    @BindView(id = R.id.two_codes_test, click = true)
    private TextView two_codes_test;


    @BindView(id = R.id.create_two_codes_test, click = true)
    private TextView create_two_codes_test;

    @BindView(id = R.id.image_load_test, click = true)
    private TextView image_load_test;

    @BindView(id = R.id.banner_test, click = true)
    private TextView banner_test;

    @BindView(id = R.id.webview_test, click = true)
    private TextView webview_test;

    @BindView(id = R.id.viewpage_test, click = true)
    private TextView viewpage_test;
    @BindView(id = R.id.pullto_test, click = true)
    private TextView pullto_test;


    @BindView(id = R.id.dialog_test, click = true)
    private TextView dialog_test;


    @BindView(id = R.id.url_test, click = true)
    private TextView url_test;

    @BindView(id = R.id.pickview_test, click = true)
    private TextView pickview_test;


    @BindView(id = R.id.guestture_test, click = true)
    private TextView guestture_test;

    @BindView(id = R.id.xrefreshview_scrollview_test, click = true)
    private TextView xrefreshview_listview_test;

    @BindView(id = R.id.xrefreshview_receylie_test, click = true)
    private TextView xrefreshview_receylie_test;


    @BindView(id = R.id.date_select_test, click = true)
    private TextView date_select_test;


    @BindView(id = R.id.city_select_test, click = true)
    private TextView city_select_test;


    @BindView(id = R.id.city_parse_area, click = true)
    private TextView city_parse_area;

    @BindView(id = R.id.email_check_text, click = true)
    private TextView email_check_text;


    @BindView(id = R.id.nest_scrollview_viewpager, click = true)
    private TextView nest_scrollview_viewpager;


    @BindView(id = R.id.nest_scrollview_text, click = true)
    private TextView nest_scrollview_text;


    @BindView(id = R.id.fuwenben_text, click = true)
    private TextView fuwenben_text;


    @BindView(id = R.id.super_textview_text, click = true)
    private TextView super_textview_text;


    @BindView(id = R.id.screen_shot_textview_text, click = true)
    private TextView screen_shot_textview_text;


    @BindView(id = R.id.music_play_textview_text, click = true)
    private TextView music_play_textview_text;



    @BindView(id = R.id.fund, click = true)
    private TextView fund;




    @BindView(id = R.id.test_cp_scrollview)
    private CPScrollView test_cp_scrollview;


    private CityPicker cityPicker1;
    private PlayFragment mPlayFragment;

    private boolean isPlayFragmentShow;


    @Override
    public void setRootView() {

        setContentView(R.layout.activity_test);

    }


    @Override
    protected void initView() {
        super.initView();

        text_title.setTitleStr("我的测试标题");

        IDCardUitl idCardUitl = new IDCardUitl();
        LogCp.i(LogCp.CP, TestActivity.class + "测试性别 ： " + idCardUitl.getSexForID("140202199410223078"));


    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);

        switch (v.getId()) {
            // 测试AppUtils
            case R.id.test_app_utils:

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
//                        new UpdateManagerUtil(TestActivity.this)
//                                .checkUpdate();
                    }
                }, 2000);

                break;




            case R.id.fund:
                TestUIhelper.showFund(this);
                break;

            //DateTimeUtil 测试
            case R.id.test_date_time_util:
                TestUIhelper.showTestDateTimeUtil(this);
                break;

            // 测试  文件
            case R.id.file_test:
                TestUIhelper.showTestFileActivity(this);
                break;


            // KeyBoardUtils 测试
            case R.id.key_board_test:

                TestUIhelper.showtestKeyBoardUitls(this);

                break;
            //NetWorkUtil 测试
            case R.id.net_work_test:
                TestUIhelper.showTestNetWorkUitls(this);
                break;

            // 测试 ObjectUtils
            case R.id.object_utils_test:
                TestUIhelper.showTesObjectsUitls(this);

                break;

            // 测试 RandomUtils
            case R.id.random_utils_test:

                TestUIhelper.showTestRandomUtils(this);
                break;

            // 测试 screen
            case R.id.screen_utils_test:
                TestUIhelper.showTestScreenUtils(this);
                break;


            // 测试异常保存
            case R.id.cache_utils_test:
                UserBean user = null;
                user.getName();


                break;

            case R.id.two_codes_test:

                TestUIhelper.showTwoCode(this);
                break;


            case R.id.create_two_codes_test:

                TestUIhelper.showCreateTwoCode(this);

                break;

            case R.id.image_load_test:

                TestUIhelper.showImageLoad(this);

                break;

            case R.id.banner_test:

                TestUIhelper.showBanner(this);

                break;

            case R.id.webview_test:

                TestUIhelper.showWebView(TestActivity.this,
                        "理财规划手册",
                        "",
                        "", "", "", "", "", "");

                break;


            case R.id.pullto_test:

                TestUIhelper.showPullableListViewActivity(this);

                break;


            case R.id.viewpage_test:

                TestUIhelper.showTextViewPageFragment(this);

//                MainFocusListRes res = new  MainFocusListRes();
//
//                List<MainFocus> result = new ArrayList<MainFocus>();
//
//                 for (int i = 0;i<10;i++)
//
//                 {
//
//                     MainFocus  mainFocus = new MainFocus();
//                     mainFocus.setId(i);
//                     mainFocus.setShopName(i+"爱理");
//
//                     result.add(mainFocus);
//
//                 }
//                res.setResult(result);
//                res.setCode(0);
//                res.setMsg("成功");
//                String gson = GsonUtil.beanTojsonStr(res);
//
//                LogCp.i(LogCp.CP,TestActivity.class + "生成的json：" + gson);

                break;


            case R.id.dialog_test:

                TestUIhelper.showDialogTestActivity(this);

                break;


            case R.id.url_test:

                TestUIhelper.showUrlTestActivity(this);

                break;

            case R.id.pickview_test:

                TestUIhelper.showTestPickerView(this);
                break;


            case R.id.xrefreshview_scrollview_test:


                break;


            case R.id.xrefreshview_receylie_test:

                 break;


            case R.id.guestture_test:

                TestUIhelper.showGestureLockActivity(this);


                break;


            case R.id.date_select_test:
//                String initStartDateTime = "2013-09-03"; // 初始化开始时间
//                String initEndDateTime = "2014-08-23"; // 初始化结束时间
//                final DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
//                        TestActivity.this, initEndDateTime, "选择时间");
//                dateTimePicKDialog.dateTimePicKDialog(initStartDateTime, initEndDateTime, "确认", "取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        String str = dateTimePicKDialog.getSelectDate();
//
//                        LogCp.i(LogCp.CP, TestActivity.class + "选择的日期 " + str);
//
//                    }
//                }, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });


                DateChooseWheelViewDialog startDateChooseDialog =
                        new DateChooseWheelViewDialog(TestActivity.this,
                                new DateChooseWheelViewDialog.DateChooseInterface() {
                    @Override
                    public void getDateTime(String date,String time, boolean longTimeChecked) {




                        date =   date.replace("月","-");
                        date =  date.replace("日","");


                        String currentTime = DateTimeUtil.getCurrentYear() + "-" + date + " " +time +":00";
                        LogCp.i(LogCp.CP,TestActivity.class + "选择的时间 "  + currentTime);

                        Date date1 = DateTimeUtil.strToDateLong(currentTime)
                        ;
                        Date date2 = DateTimeUtil.strToDateLong("2018-4-20 16:01:00")
                                ;


                        LogCp.i(LogCp.CP,TestActivity.class + "两个小时差" +
                                DateTimeUtil.getDatePoor(date1,date2));



                    }
                });
                startDateChooseDialog.setDateDialogTitle("开始时间");
                startDateChooseDialog.showDateChooseDialog();


                break;


            case R.id.city_select_test:


                AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
                View view = LayoutInflater.from(TestActivity.this).inflate(R.layout.addressdialog, null);
                builder.setView(view);
                LinearLayout addressdialog_linearlayout = (LinearLayout) view.findViewById(R.id.addressdialog_linearlayout);
                final ScrollerNumberPicker provincePicker = (ScrollerNumberPicker) view.findViewById(R.id.province);


                final ScrollerNumberPicker cityPicker = (ScrollerNumberPicker) view.findViewById(R.id.city);
                cityPicker1 = (CityPicker) view.findViewById(R.id.citypicker);

                cityPicker1.setCityDefault("海南", "乐东黎族自治县");

                final AlertDialog dialog = builder.show();

                addressdialog_linearlayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        dialog.dismiss();

                        LogCp.i(LogCp.CP, TestActivity.class + "选择的省ID：" + ", 是执行这里了，," + provincePicker.getSelectedText());

                        String provinceStr = provincePicker.getSelectedText();
                        String provinceID = provincePicker.getSelectedProvinceID(provinceStr);


                        String cityStr = cityPicker.getSelectedText();
                        String cityID = cityPicker.getSelectedCityID(provinceID, cityStr);


                        LogCp.i(LogCp.CP, TestActivity.class + "选择的省ID：" + provinceID + ",,选择的市ID：" + cityID + ",,选择的区ID：");
//                        user_info_userarea.setText(provinceStr + " " + cityStr);


                    }
                });


                break;


            case R.id.city_parse_area:

                AreaParserUitl areaParserUitl = new AreaParserUitl();
                areaParserUitl.openGson(TestActivity.this);


                break;


            case R.id.email_check_text:


                String strEmail = "321@qq.com";
                LogCp.i(LogCp.CP, TestActivity.class + "是不是一个emaial :" + StringUtils.isEmail(strEmail));


                break;

            case R.id.nest_scrollview_viewpager:


                TestUIhelper.showResumeActivity(TestActivity.this);


                break;

            case R.id.nest_scrollview_text:


                TestUIhelper.showScrollViewText(TestActivity.this);


                break;


            case R.id.fuwenben_text:






                UpdateRes updateRes = new UpdateRes();
                updateRes.setVersion("123.3");
                updateRes.setUrl("");
                updateRes.setDesc("新版本，新版本，新手");

//                LogCp.i(LogCp.CP, UpdateManagerUtil.class + "是否强制更新 :" + versionBean.getCompellent());

                updateRes.setForceupdate(0);


                String strVersion = UpdateManagerUtil.getVersionNameAndVersionCode(TestActivity.this);




                updateManagerUtilS.onFinshCheck(updateRes, strVersion, true);






//                TestUIhelper.showTestFuWenBenUtil(TestActivity.this);


                //    textRxJava();


//                ProvinceBean userBean = new ProvinceBean();
//
//
//                try {
//                    LogCp.i(LogCp.CP, TestActivity.class + " 是否为空的判断" + GsonUtil.checkObjFieldIsNull(userBean));
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }


                break;


            case R.id.super_textview_text:

                //  TestUIhelper.showTestSuperTextView(TestActivity.this);

                // 退出APP
                //    ActivityManagerUtil.getInstance().AppExit();

                // 防止重复提交
                if (!NoDoubleClickUtils.isDoubleClick()) {
                    LogCp.i(LogCp.CP, TestActivity.class + " 重复提交");
                }
                break;


            case R.id.screen_shot_textview_text:

                ScreenUtils screenUtils = new ScreenUtils();


                Bitmap bitmap = screenUtils.snapShotWithoutStatusBar(TestActivity.this);

                String path = ImageUtils.saveBitmapToSDCard(bitmap, "anyin1_screen_shot");

                LogCp.i(LogCp.CP, TestActivity.class + " 保存的图片的地址:" + path);

                break;

            case R.id.music_play_textview_text:


                showPlayingFragment();


                break;


        }

    }

    // 检查版本

    private UpdateManagerUtil updateManagerUtilS = new UpdateManagerUtil(TestActivity.this) {
        @Override
        public void getServerUpdate() {

        }
    };




    private void showPlayingFragment() {
        if (isPlayFragmentShow) {
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fragment_slide_up, 0);
        if (mPlayFragment == null) {
            mPlayFragment = new PlayFragment();
            ft.replace(android.R.id.content, mPlayFragment);
        } else {
            ft.show(mPlayFragment);
        }
        ft.commitAllowingStateLoss();
        isPlayFragmentShow = true;
    }


//
//    private void textRxJava() {
////创建被观察者
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//
//                LogCp.i(LogCp.CP,TestActivity.class + "  emit 1");
//                emitter.onNext(1);
//                LogCp.i(LogCp.CP,TestActivity.class + "  emit 2");
//
//                emitter.onNext(2);
//                LogCp.i(LogCp.CP,TestActivity.class + "   emit 3");
//
//                emitter.onNext(3);
//                LogCp.i(LogCp.CP,TestActivity.class + "  emit  onComplete");
//
//                emitter.onComplete();
//                LogCp.i(LogCp.CP,TestActivity.class + "  emit 4");
//
//                emitter.onNext(4);
//            }
//        }).subscribe(new Observer<Integer>() {
//            private Disposable mDisposable;
//            private int i;
//
//            @Override
//            public void onSubscribe(Disposable d) {
//                LogCp.i(LogCp.CP,TestActivity.class + "   onSubscribe");
//
//                mDisposable = d;
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                LogCp.i(LogCp.CP,TestActivity.class + "   onNext   "  + value +" i " + i);
//
//                i++;
//                if (i == 2) {
//                    LogCp.i(LogCp.CP,TestActivity.class + "   dispose");
//
//                    mDisposable.dispose();
//
//                    LogCp.i(LogCp.CP,TestActivity.class + "   isDisposed"  + mDisposable.isDisposed());
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                LogCp.i(LogCp.CP,TestActivity.class + "   onError");
//
//            }
//
//            @Override
//            public void onComplete() {
//                LogCp.i(LogCp.CP,TestActivity.class + "   onComplete");
//
//            }
//        });
//
//
//    }


}
