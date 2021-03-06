package com.hurley.awesomeframe.feature.found.refresh;

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
 *      date    : 2019-05-11 20:39
 *      github  : https://github.com/HurleyJames
 *      desc    : 刷新界面
 * </pre>
 */
public class RefreshActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_refresh)
    RecyclerView mRvRefresh;

    @Override
    protected int getLayoutId() {
        return R.layout.refresh_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_refresh;
    }

    @Override
    protected void initView() {
        mRvRefresh.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        List<FrameBean> mList = new ArrayList<>();
        FrameAdapter mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvRefresh.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                startActivity(SmartRefreshLayoutActivity.class);
                break;
            default:
                break;
        }
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("SmartRefreshLayout", "scwang90", "\uD83D\uDD25下拉刷新、上拉加载、二级刷新、淘宝二楼、RefreshLayout、OverScroll，Android智能下拉刷新框架，支持越界回弹、越界拖动，具有极强的扩展性，集成了几十种炫酷的Header和 Footer。"));
        return list;
    }
}
