package com.hurley.awesomeframe.feature.user.share;

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
 *      date    : 2019-05-28 20:44
 *      github  : https://github.com/HurleyJames
 *      desc    : 分享界面
 * </pre>
 */
public class ShareActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_share)
    RecyclerView mRvShare;

    private FrameAdapter mAdapter;

    private List<FrameBean> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.share_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_share;
    }

    @Override
    protected void initView() {
        mRvShare.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        mList = new ArrayList<>();
        mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvShare.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        return list;
    }
}
