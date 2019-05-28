package com.hurley.awesomeframe.feature.user.donate;

import android.view.View;
import android.widget.Button;

import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.vondear.rxfeature.module.alipay.AliPayModel;
import com.vondear.rxfeature.module.alipay.AliPayTool;
import com.vondear.rxtool.RxTimeTool;
import com.vondear.rxtool.interfaces.OnSuccessAndErrorListener;
import com.vondear.rxtool.view.RxToast;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-28 18:41
 *      github  : https://github.com/HurleyJames
 *      desc    : RxTool支付框架页面
 * </pre>
 */
public class RxToolPayActivity extends BaseActivity {

    @BindView(R.id.btn_alipay)
    Button mBtnAlipay;
    @BindView(R.id.btn_ali_auth)
    Button mBtnAliAuth;

    @Override
    protected int getLayoutId() {
        return R.layout.rxtool_pay_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_rxtool_pay;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick({R.id.btn_alipay, R.id.btn_ali_auth})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alipay:
                // 需要填写APPID 与 私钥
//                AliPayTool.aliPay(getApplicationContext(), SelfInfo.ALIPAY_APPID, true, SelfInfo.ALIPAY_RSA2_PRIVATE, new AliPayModel(RxTimeTool.date2String(RxTimeTool.getCurTimeDate()), "0.01", "爱心", "一份爱心"), new OnSuccessAndErrorListener() {
//                    @Override
//                    public void onSuccess(String s) {
//                        RxToast.success("支付成功");
//                    }
//
//                    @Override
//                    public void onError(String s) {
//                        RxToast.error("支付失败" + s);
//                    }
//                });
                break;
            case R.id.btn_ali_auth:
                break;
            default:
                break;
        }
    }
}
