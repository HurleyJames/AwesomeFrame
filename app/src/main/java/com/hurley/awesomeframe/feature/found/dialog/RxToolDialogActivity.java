package com.hurley.awesomeframe.feature.found.dialog;

import android.view.View;
import android.widget.Button;

import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-06-10 15:35
 *      github  : https://github.com/HurleyJames
 *      desc    : RxToolDialog框架页面
 * </pre>
 */
public class RxToolDialogActivity extends BaseActivity {

    @BindView(R.id.btn_ok)
    Button mBtnOk;
    @BindView(R.id.btn_ok_cancel)
    Button mBtnOkCancel;
    @BindView(R.id.btn_input)
    Button mBtnInput;
    @BindView(R.id.btn_date)
    Button mBtnDate;
    @BindView(R.id.btn_shape)
    Button mBtnShape;
    @BindView(R.id.btn_acfun)
    Button mBtnAcfun;

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_rxtool_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_rxtool_dialog;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick({R.id.btn_ok, R.id.btn_ok_cancel, R.id.btn_input, R.id.btn_date, R.id.btn_shape, R.id.btn_acfun})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok:
                break;
            case R.id.btn_ok_cancel:
                break;
            case R.id.btn_input:
                break;
            case R.id.btn_date:
                break;
            case R.id.btn_shape:
                break;
            case R.id.btn_acfun:
                break;
            default:
                break;
        }
    }
}
