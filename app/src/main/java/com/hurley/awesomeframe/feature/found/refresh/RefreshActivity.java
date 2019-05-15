package com.hurley.awesomeframe.feature.found.refresh;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.data.local.FrameBean;
import com.hurley.awesomeframe.feature.found.adapter.FrameAdapter;
import com.hurley.awesomeframe.feature.found.pick.CityPickerActivity;

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

    private FrameAdapter mAdapter;

    private List<FrameBean> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_refresh;
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
        mList = new ArrayList<>();
        mAdapter = new FrameAdapter(R.layout.item_frame, mList);
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
            case 1:
                startActivity(CityPickerActivity.class);
                break;
            default:
                break;
        }
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("SmartRefreshLayout", "scwang90", "\uD83D\uDD25下拉刷新、上拉加载、二级刷新、淘宝二楼、RefreshLayout、OverScroll，Android智能下拉刷新框架，支持越界回弹、越界拖动，具有极强的扩展性，集成了几十种炫酷的Header和 Footer。"));
        list.add(new FrameBean("CityPicker", "zaaach", "城市选择、定位、搜索及右侧字母导航，类似美团 百度糯米 饿了么等APP选择城市功能"));
        return list;
    }
}
