package com.hurley.awesomeframe.feature.found.banner;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.data.local.FrameBean;
import com.hurley.awesomeframe.feature.found.adapter.FrameAdapter;
import com.hurley.awesomeframe.feature.found.refresh.SmartRefreshLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-14 10:00
 *      github  : https://github.com/HurleyJames
 *      desc    : 轮播图界面
 * </pre>
 */
public class BannerActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_banner)
    RecyclerView mRvBanner;

    @Override
    protected int getLayoutId() {
        return R.layout.banner_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_banner;
    }

    @Override
    protected void initView() {
        mRvBanner.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        List<FrameBean> mList = new ArrayList<>();
        FrameAdapter mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvBanner.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                startActivity(BannerFrameActivity.class);
                break;
            default:
                break;
        }
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("banner", "youth5201314", "Android广告图片轮播控件，支持无限循环和多种主题，可以灵活设置轮播样式、动画、轮播和切换时间、位置、图片加载框架等！"));
        return list;
    }
}
