package com.hurley.awesomeframe.feature.index;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.gyf.barlibrary.ImmersionBar;
import com.hjq.bar.TitleBar;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.fragment.BaseFragment;
import com.hurley.awesomeframe.widget.ChangeCollapsingToolbarLayout;

import java.util.Objects;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 14:50
 *      github  : https://github.com/HurleyJames
 *      desc    : 首页页面
 * </pre>
 */
public class IndexFragment extends BaseFragment implements ChangeCollapsingToolbarLayout.OnScrimsListener {

    @BindView(R.id.ctl_index)
    ChangeCollapsingToolbarLayout mCtlIndex;
    @BindView(R.id.toolbar_index)
    Toolbar mTbIndex;
    @BindView(R.id.tb_index)
    TitleBar mTitleBarIndex;

    public static IndexFragment newInstance() {
        Bundle args = new Bundle();
        IndexFragment fragment = new IndexFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.index_fragment;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_index;
    }

    @Override
    protected void initView() {
        // 给这个ToolBar设置顶部内边距，才能和TitleBar进行对齐
        ImmersionBar.setTitleBar(getActivity(), mTbIndex);
        // 设置渐变监听
        mCtlIndex.setOnScrimsListener(this);
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    @Override
    public boolean statusBarDarkFont() {
        return mCtlIndex.isScrimsShown();
    }

    /**
     * CollapsingToolbarLayout 渐变回调
     *
     * @param shown 渐变开关
     */
    @Override
    public void onScrimsStateChange(boolean shown) {
        if (shown) {
            mTitleBarIndex.setTitleColor(ContextCompat.getColor(Objects.requireNonNull(getContext()), R.color.black));
            getStatusBarConfig().statusBarDarkFont(true).init();
        } else {
            mTitleBarIndex.setTitleColor(ContextCompat.getColor(Objects.requireNonNull(getContext()), R.color.white));
            getStatusBarConfig().statusBarDarkFont(false).init();
        }
    }
}
