package cn.licaidashi.main.ui;

import android.app.Dialog;
import android.view.View;
import android.widget.TextView;

import com.cp.mylibrary.custom.TitleBarView;
import com.cp.mylibrary.dialog.DialogHelper;
import com.cp.mylibrary.dialog.ShareDialog;

import org.kymjs.kjframe.ui.BindView;

import cn.licaidashi.main.R;

/**
 * Created by Jerry on 2016/6/28.
 * <p>
 * 测试对话框
 */
public class DialogTestActivity extends BaseActivity {


    private Dialog simplecDialog;


    @BindView(id = R.id.dialog_test_title)
    private TitleBarView dialog_test_title;


    @BindView(id = R.id.dialog_wait, click = true)
    private TextView dialog_wait;
    @BindView(id = R.id.dialog_share, click = true)
    private TextView dialog_share;



    private ShareDialog mDialog;


    @Override
    public void setRootView() {
        super.setRootView();

        setContentView(R.layout.activity_test_dialog);
    }

    @Override
    protected void initView() {
        super.initView();

        dialog_test_title.setTitleStr("测试对话框");
        dialog_test_title.setTitleBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);

        switch (v.getId()) {
            case R.id.dialog_wait:


                // DialogHelper.getWaitDialog(this,"加载中").show();

                //    DialogHelper.getCancelableWaitDialog(this,"加载中").show();

                //     DialogHelper.getPinterestDialog(this);
//
                simplecDialog = DialogHelper.configDialog(DialogTestActivity.this,
                        "温馨提示", "确认删除", "删除", "消",
                        new View.OnClickListener() {

                            @Override
                            public void onClick(View arg0) {
                                switch (arg0.getId()) {
                                    case R.id.base_config_dialog_sure_btn_b:

                                        simplecDialog.dismiss();

                                        break;
                                    case R.id.base_config_dialog_cannel_btn_b:
                                        simplecDialog.dismiss();

                                        break;
                                    default:
                                        break;
                                }

                            }
                        }).getConfigDialog();
                simplecDialog.show();


                // 提示对话框

//                simplecDialog = DialogHelper.getTiShiDialog(DialogTestActivity.this, "标题", "提示", "知道了", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        switch (v.getId()) {
//                            case R.id.base_tishi_dialog_sure_btn_b:
////
////                                simplecDialog.dismiss();
////
////                                EditText editText = DialogHelper.getDialogEditText();
////                                String str = editText.getText().toString();
////                                ShowToastUtil.showToast(DialogTestActivity.this," ,," + str);
////
//                                break;
//
//                        }
//
//                    }
//                }).getConfigDialog();
//
//                simplecDialog.show();


//                EditTextDialog dialog = (EditTextDialog) DialogHelper.getEditTextDialog(DialogTestActivity.this, "来啊，", "cc");
//                dialog.show();
//                dialog.getEditText();


//
//                simplecDialog = DialogHelper.EditTextDialog(DialogTestActivity.this, "delete ", null, null, " 不超过", "confim ", "ttest", new View.OnClickListener() {
//
//
//                    @Override
//                    public void onClick(View v) {
//
//                        switch (v.getId()) {
//                            case R.id.base_config_dialog_sure_btn_b:
//
//                                simplecDialog.dismiss();
//
//                                EditText editText = DialogHelper.getDialogEditText();
//                                String str = editText.getText().toString();
//                                ShowToastUtil.showToast(DialogTestActivity.this, " ,," + str);
//
//                                break;
//                            case R.id.base_config_dialog_cannel_btn_b:
//                                simplecDialog.dismiss();
//
//
//                                break;
//                            default:
//                                break;
//                        }
//
//                    }
//                }).getConfigDialog();
//
//                simplecDialog.show();
//


                break;

            case R.id.dialog_share:


//                final TimePickerDialog timePickerDialog = new TimePickerDialog(DialogTestActivity.this);
//                timePickerDialog.showDatePickerDialog();
//
//                TimePickerDialog.TimePickerDialogInterface timePickerDialogInterface = new TimePickerDialog.TimePickerDialogInterface() {
//                    @Override
//                    public void positiveListener() {
//
//
//                        LogCp.i(LogCp.CP, "取到的日期" + timePickerDialog.getYear() + "-" + timePickerDialog.getMonth());
//
//                    }
//
//                    @Override
//                    public void negativeListener() {
//
//                    }
//                };
//                timePickerDialog.setAlertDialogListener(timePickerDialogInterface);


//                if (mDialog == null)
//                    mDialog = new ShareDialog(this  ,this);
//                mDialog.setShareInfo("标题","内容","http://www.baidu.com","https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=468645589,1337744426&fm=173&s=5EAFB0441763BB5B1CD0AD830300A08F&w=302&h=187&img.JPEG");
//                mDialog.setCancelable(true);
//                mDialog.setCanceledOnTouchOutside(true);
//                mDialog.setTitle(R.string.share_to);
//                mDialog.show();
//


//                WaitDialog waitDialog = DialogHelper.getWaitDialog(DialogTestActivity.this,"加载中...");
//                 waitDialog.show();


//            Dialog    simplecDialog = BasicDialog.versionDialog(DialogTestActivity.this, "发现新版本:",
//                        "有新处，，，", "立即更新", "下次再说", new View.OnClickListener() {
//
//                            @Override
//                            public void onClick(View arg0) {
//
//
//
//
//                            }
//                        }).getConfigDialog();
//
//                simplecDialog.show();


                break;

        }
    }


}
