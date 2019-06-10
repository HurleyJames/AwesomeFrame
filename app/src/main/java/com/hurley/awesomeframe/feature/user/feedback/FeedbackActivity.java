package com.hurley.awesomeframe.feature.user.feedback;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.app.App;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.data.local.FrameBean;
import com.hurley.awesomeframe.feature.found.adapter.FrameAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-06-01 16:36
 *      github  : https://github.com/HurleyJames
 *      desc    : 反馈界面
 * </pre>
 */
public class FeedbackActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_feedback)
    RecyclerView mRvFeedback;

    @Override
    protected int getLayoutId() {
        return R.layout.feedback_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_feedback;
    }

    @Override
    protected void initView() {
        mRvFeedback.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        List<FrameBean> mList = new ArrayList<>();
        FrameAdapter mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvFeedback.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                ((App) getApplication()).getShaky().startFeedbackFlow();
                break;
            default:
                break;
        }
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("shaky-android", "linkedin", "Shake to send feedback for Android."));
        return list;
    }
}
