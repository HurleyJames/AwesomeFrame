package com.hurley.awesomeframe.feature.user.donate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.king.pay.apppay.AppPay;
import com.king.pay.wxpay.WXPayReq;
import com.king.pay.wxpay.wxapi.WXPayActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-28 10:09
 *      github  : https://github.com/HurleyJames
 *      desc    : AppPay框架页面
 * </pre>
 */
public class AppPayActivity extends BaseActivity {

    @BindView(R.id.btn_alipay)
    Button mBtnAlipay;
    @BindView(R.id.btn_wxpay)
    Button mBtnWxpay;
    @BindView(R.id.btn_ali_auth)
    Button mBtnAliAuth;

    AppPay mAppPay;

    @Override
    protected int getLayoutId() {
        return R.layout.app_pay_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_app_pay;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {
        mAppPay = new AppPay(this);
        //支付宝支付监听
        mAppPay.setOnAliPayListener((isSuccess, resultInfo) -> {
            if (isSuccess) {
                // TODO 支付宝支付成功
                // 务必以服务端结果为准
            }
        });

        mAppPay.setOnAliPayAuthListener((isSuccess, resultInfo) -> {
            if (isSuccess) {
                // TODO 支付宝授权成功

            }
        });
    }

    @OnClick({R.id.btn_alipay, R.id.btn_wxpay, R.id.btn_ali_auth})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alipay:
                // TODO 配置好支付宝支付请求相关的参数,发送支付宝支付请求，可参见：https://docs.open.alipay.com/204/105296/
                // 支付宝支付请求的订单信息，务必放在服务端通过接口返回，这样比较安全。
//                String orderInfo = "";
//                mAppPay.sendAliPayReq(orderInfo);
                break;
            case R.id.btn_wxpay:
                // TODO 配置好微信支付请求相关的参数,发送微信支付请求，可参见：https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=8_5
                // 微信请求相关属性务必放在服务端，通过预支付下单接口返回相关参数，这样比较安全。
                WXPayReq req = new WXPayReq();
                req.setAppId("");
                mAppPay.sendWXPayReq(req);
                break;
            case R.id.btn_ali_auth:
                // ODO 支付宝授权信息privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成
                // 支付宝授权信息
//                String authInfo = "";
//                mAppPay.checkAliAuth(authInfo);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
//        unregisterPayResultReceiver();
        super.onDestroy();
    }

    /**
     * 注册广播广播
     */
    private void registerPayResultReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(WXPayActivity.ACTION_WX_PAY_RESULT);
        registerReceiver(mPayResultReceiver, filter);
    }

    /**
     * 注销广播
     */
    private void unregisterPayResultReceiver() {
        unregisterReceiver(mPayResultReceiver);
    }

    /**
     * 支付结果广播接收
     */
    private BroadcastReceiver mPayResultReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int code = intent.getIntExtra(WXPayActivity.KEY_CODE, 0);
            String error = intent.getStringExtra(WXPayActivity.KEY_ERROR);
            LogUtils.d("code=" + code + ",error=" + error);
            // 接收到客户端支付结果，这里一般与服务器同步支付结果，以服务器端的接收的支付通知或查询API返回的结果为准
            switch (code) {
                case 0:
                    // 成功
                    ToastUtils.showShort(R.string.pay_success);
                    break;
                case -1:
                    // 错误
                    ToastUtils.showShort(R.string.pay_error);
                    break;
                case -2:
                    // 用户取消
                    ToastUtils.showShort(R.string.pay_cancel);
                    break;
                default:
                    break;
            }
        }
    };
}
