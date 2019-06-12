package com.hurley.awesomeframe.feature.found.dialog;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-06-12 09:52
 *      github  : https://github.com/HurleyJames
 *      desc    : sweet-alert-dialog框架页面
 * </pre>
 */
public class SweetAlertDialogActivity extends BaseActivity {

    @BindView(R.id.btn_material)
    Button mBtnMaterial;
    @BindView(R.id.btn_title)
    Button mBtnTitle;
    @BindView(R.id.btn_title_content)
    Button mBtnTitleContent;
    @BindView(R.id.btn_error)
    Button mBtnError;
    @BindView(R.id.btn_warning)
    Button mBtnWarning;
    @BindView(R.id.btn_success)
    Button mBtnSuccess;
    @BindView(R.id.btn_header_image)
    Button mBtnHeaderImage;
    @BindView(R.id.btn_change)
    Button mBtnChange;


    @Override
    protected int getLayoutId() {
        return R.layout.dialog_sweet_alert_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_sweet_alert_dialog;
    }

    @Override
    protected void initView() {
        /**
         * 出现Unknown animation name错误
         * java.lang.RuntimeException: Unknown animation name: cn.pedant.SweetAlert.Rotate3dAnimation error:null
         * 解决方法见issue：https://github.com/pedant/sweet-alert-dialog/issues/184
         * 改用implementation 'com.github.f0ris.sweetalert:library:1.5.1'
         */
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick({R.id.btn_material, R.id.btn_title, R.id.btn_title_content, R.id.btn_error, R.id.btn_warning, R.id.btn_success, R.id.btn_header_image, R.id.btn_change})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_material:
                SweetAlertDialog dialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                dialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                dialog.setTitleText("Loading");
                dialog.setCancelable(false);
                dialog.show();
                break;
            case R.id.btn_title:
                new SweetAlertDialog(this)
                        .setTitleText("Here's a message!")
                        .show();
                break;
            case R.id.btn_title_content:
                new SweetAlertDialog(this)
                        .setTitleText("Here's a message!")
                        .setContentText("It's pretty, isn't it?")
                        .show();
                break;
            case R.id.btn_error:
                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Something went wrong!")
                        .show();
                break;
            case R.id.btn_warning:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setCancelText("No,don't delete it!")
                        .showCancelButton(true)
                        .setConfirmClickListener(SweetAlertDialog::dismissWithAnimation)
                        .setCancelClickListener(SweetAlertDialog::cancel)
                        .show();
                break;
            case R.id.btn_success:
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Good job!")
                        .setContentText("You clicked the button!")
                        .show();
                break;
            case R.id.btn_header_image:
                new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("Sweet!")
                        .setContentText("Here's a custom image.")
                        .setCustomImage(R.mipmap.ic_logo)
                        .show();
                break;
            case R.id.btn_change:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setCancelText("No,don't delete it!")
                        .setConfirmClickListener(sDialog -> {
                            sDialog
                                    .setTitleText("Deleted!")
                                    .setContentText("Your imaginary file has been deleted!")
                                    .setConfirmText("OK")
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            sDialog.showCancelButton(false);
                        })
                        .setCancelClickListener(cDialog -> {
                            cDialog
                                    .setTitleText("Not deleted!")
                                    .setConfirmText("OK")
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.ERROR_TYPE);
                            cDialog.showCancelButton(false);
                        })
                        .show();
                break;
            default:
                break;
        }
    }
}
