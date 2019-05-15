package com.hurley.awesomeframe.base.fragment;

import com.gyf.barlibrary.ImmersionBar;
import com.hurley.awesomeframe.base.activity.AbstractUIActivity;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 18:11
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public abstract class AbstractUIFragment<A extends AbstractUIActivity> extends AbstractSimpleFragment<A> {

    /**
     * 状态栏沉浸
     */
    private ImmersionBar mImmersionBar;

    @Override
    protected void initFragment() {
        initImmersion();
        super.initFragment();
    }

    /**
     * 初始化沉浸式
     */
    protected void initImmersion() {

        // 初始化沉浸式状态栏
        if (isStatusBarEnabled()) {
            statusBarConfig().init();

            // 设置标题栏
            if (getTitleId() > 0) {
                ImmersionBar.setTitleBar(mActivity, findViewById(getTitleId()));
            }
        }
    }

    /**
     * 是否在Fragment使用沉浸式
     */
    public boolean isStatusBarEnabled() {
        return false;
    }

    /**
     * 获取状态栏沉浸的配置对象
     */
    protected ImmersionBar getStatusBarConfig() {
        return mImmersionBar;
    }

    /**
     * 初始化沉浸式
     */
    private ImmersionBar statusBarConfig() {
        // 在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
                // 默认状态栏字体颜色为黑色
                .statusBarDarkFont(statusBarDarkFont())
                // 解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
                .keyboardEnable(true);
        return mImmersionBar;
    }

    /**
     * 获取状态栏字体颜色
     */
    protected boolean statusBarDarkFont() {
        // 返回true表示黑色字体
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isStatusBarEnabled() && isLazyLoad()) {
            // 重新初始化状态栏
            statusBarConfig().init();
        }
    }
}
