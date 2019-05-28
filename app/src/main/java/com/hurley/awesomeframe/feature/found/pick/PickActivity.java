package com.hurley.awesomeframe.feature.found.pick;

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
 *      date    : 2019-05-11 13:30
 *      github  : https://github.com/HurleyJames
 *      desc    : 选择器界面
 * </pre>
 */
public class PickActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_pick)
    RecyclerView mRvPick;

    private FrameAdapter mAdapter;

    private List<FrameBean> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.pick_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_pick;
    }

    @Override
    protected void initView() {
        mRvPick.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        mList = new ArrayList<>();
        mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvPick.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("Android-PickerView", "Bigkoo", "This is a picker view for android , support linkage effect, timepicker and optionspicker.（时间选择器、省市区三级联动）"));
        list.add(new FrameBean("CityPicker", "zaaach", "城市选择、定位、搜索及右侧字母导航，类似美团 百度糯米 饿了么等APP选择城市功能"));
        return list;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                startActivity(AndroidPickViewActivity.class);
                break;
            case 1:
                startActivity(CityPickerActivity.class);
                break;
            default:
                break;
        }
    }
}
