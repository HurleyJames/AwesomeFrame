package com.hurley.awesomeframe.feature.found.card;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.data.local.FrameBean;
import com.hurley.awesomeframe.feature.found.adapter.FrameAdapter;
import com.hurley.awesomeframe.feature.found.dialog.RxToolDialogActivity;
import com.hurley.awesomeframe.feature.found.dialog.SweetAlertDialogActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-14 09:57
 *      github  : https://github.com/HurleyJames
 *      desc    : 卡片页面
 * </pre>
 */
public class CardActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_card)
    RecyclerView mRvCard;

    @Override
    protected int getLayoutId() {
        return R.layout.card_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_card;
    }

    @Override
    protected void initView() {
        mRvCard.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        List<FrameBean> mList = new ArrayList<>();
        FrameAdapter mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvCard.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                startActivity(FoldingCellActivity.class);
                break;
            case 1:
                startActivity(SwipeStackActivity.class);
            default:
                break;
        }
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("folding-cell-android", "Ramotion", "FoldingCell is a material design expanding content cell inspired by folding paper material made by @Ramotion"));
        list.add(new FrameBean("SwipeStack", "flschweiger", "A simple, customizable and easy to use swipeable view stack for Android."));
        return list;
    }
}
