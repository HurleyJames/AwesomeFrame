package com.hurley.awesomeframe.feature.user.rate;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.data.local.FrameBean;
import com.hurley.awesomeframe.feature.found.adapter.FrameAdapter;
import com.hurley.awesomeframe.feature.user.donate.AppPayActivity;
import com.hurley.awesomeframe.feature.user.donate.RxToolPayActivity;
import com.kobakei.ratethisapp.RateThisApp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-29 12:07
 *      github  : https://github.com/HurleyJames
 *      desc    : 评价界面
 * </pre>
 */
public class RateActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_rate)
    RecyclerView mRvRate;

    private FrameAdapter mAdapter;

    private List<FrameBean> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.rate_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_rate;
    }

    @Override
    protected void initView() {
        mRvRate.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        mList = new ArrayList<>();
        mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvRate.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                setRate();
                break;
            default:
                break;
        }
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("Android-RateThisApp", "kobakei", "Android library to show \"Rate this app\" dialog"));
        return list;
    }

    private void setRate() {
        RateThisApp.onCreate(this);
        // 设置样式
        RateThisApp.Config config = new RateThisApp.Config();
        config.setTitle(R.string.rate_title);
        config.setMessage(R.string.rate_message);
        config.setYesButtonText(R.string.rate);
        // 设置url
        config.setUrl("hurley.fun");
        RateThisApp.init(config);
        RateThisApp.showRateDialog(this);
        // 设置回调
        RateThisApp.setCallback(new RateThisApp.Callback() {
            @Override
            public void onYesClicked() {
                // TODO 跳转至应用市场（酷安）进行评价
            }

            @Override
            public void onNoClicked() {

            }

            @Override
            public void onCancelClicked() {

            }
        });
    }
}
