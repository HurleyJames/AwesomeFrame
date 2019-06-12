package com.hurley.awesomeframe.feature.found.dialog;

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
 *      date    : 2019-05-14 09:58
 *      github  : https://github.com/HurleyJames
 *      desc    : Dialog页面
 * </pre>
 */
public class DialogActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_dialog)
    RecyclerView mRvDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_dialog;
    }

    @Override
    protected void initView() {
        mRvDialog.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        List<FrameBean> mList = new ArrayList<>();
        FrameAdapter mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvDialog.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                startActivity(RxToolDialogActivity.class);
                break;
            case 1:
                startActivity(SweetAlertDialogActivity.class);
            default:
                break;
        }
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("RxTool", "vondear", "Android开发人员不得不收集的工具类集合"));
        list.add(new FrameBean("sweet-alert-dialog", "pedant", "Android版的SweetAlert，清新文艺，快意灵动的甜心弹框"));
        return list;
    }
}
