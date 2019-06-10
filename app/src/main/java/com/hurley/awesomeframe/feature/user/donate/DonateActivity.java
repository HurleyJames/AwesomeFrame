package com.hurley.awesomeframe.feature.user.donate;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.data.local.FrameBean;
import com.hurley.awesomeframe.feature.found.adapter.FrameAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-28 09:51
 *      github  : https://github.com/HurleyJames
 *      desc    : 赞助界面
 * </pre>
 */
public class DonateActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_donate)
    RecyclerView mRvDonate;

    @Override
    protected int getLayoutId() {
        return R.layout.donate_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_donate;
    }

    @Override
    protected void initView() {
        mRvDonate.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        List<FrameBean> mList = new ArrayList<>();
        FrameAdapter mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvDonate.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                startActivity(AppPayActivity.class);
                break;
            case 1:
                startActivity(RxToolPayActivity.class);
            default:
                break;
        }
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("AppPay", "jenly1314", "\uD83D\uDCB8 AppPay专注于App支付的库，几句代码轻松搞定微信支付、支付宝支付。集成更简单。"));
        list.add(new FrameBean("RxTool", "vondear", "支付宝支付 | 微信支付（统一下单）"));
        return list;
    }
}
