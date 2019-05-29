package com.hurley.awesomeframe.feature.user.rate;

import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.feature.main.MainActivity;
import com.kobakei.ratethisapp.RateThisApp;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-29 12:16
 *      github  : https://github.com/HurleyJames
 *      desc    : AndroidRate框架页面
 * </pre>
 */
public class AndroidRateActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.rate_androidrate_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_rate_androidrate;
    }

    @Override
    protected void initView() {
        RateThisApp.onCreate(this);
        RateThisApp.showRateDialog(this);
    }

    @Override
    protected void initEventAndData() {
        RateThisApp.setCallback(new RateThisApp.Callback() {
            @Override
            public void onYesClicked() {
                ToastUtils.showShort("yes");
            }

            @Override
            public void onNoClicked() {
                ToastUtils.showShort("no");
            }

            @Override
            public void onCancelClicked() {
                ToastUtils.showShort("cancel");
            }
        });
    }
}
