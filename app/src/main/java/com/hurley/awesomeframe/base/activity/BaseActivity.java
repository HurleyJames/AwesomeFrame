package com.hurley.awesomeframe.base.activity;

import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hurley.awesomeframe.R;
import com.trello.rxlifecycle2.LifecycleTransformer;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 09:28
 *      github  : https://github.com/HurleyJames
 *      desc    : Activity基类
 * </pre>
 */
public abstract class BaseActivity extends AbstractUIActivity implements OnTitleBarListener {

    /**
     * ButterKnife 注解
     */
    private Unbinder unBinder;

    @Override
    protected void initActivity() {
        super.initActivity();
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        // 初始化标题栏的监听
        if (getTitleId() > 0) {
            if (findViewById(getTitleId()) instanceof TitleBar) {
                ((TitleBar) findViewById(getTitleId())).setOnTitleBarListener(this);
            }
        }

        unBinder = ButterKnife.bind(this);
        initOrientation();
    }

    /**
     * 初始化横竖屏方向，会和 LauncherTheme 主题样式有冲突，注意不要同时使用
     */
    protected void initOrientation() {
        // 当前 Activity 不能是透明的并且没有指定屏幕方向，默认设置为竖屏
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    /**
     * 设置标题栏的标题
     */
    @Override
    public void setTitle(int titleId) {
        setTitle(getText(titleId));
    }

    /**
     * 设置标题栏的标题
     */
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        TitleBar titleBar = getTitleBar();
        if (titleBar != null) {
            titleBar.setTitle(title);
        }
    }

    /**
     * 获得标题栏的标题
     *
     * @return
     */
    @Nullable
    public TitleBar getTitleBar() {
        if (getTitleId() > 0 && findViewById(getTitleId()) instanceof TitleBar) {
            return findViewById(getTitleId());
        }
        return null;
    }

    /**
     * TitleBar 左边的View被点击了
     *
     * @param v
     */
    @Override
    public void onLeftClick(View v) {
        onBackPressed();
    }

    /**
     * TitleBar 中间的View被点击了
     *
     * @param v
     */
    @Override
    public void onTitleClick(View v) {
    }

    /**
     * TitleBar 右边的View被点击了
     *
     * @param v
     */
    @Override
    public void onRightClick(View v) {
    }

    @Override
    protected void onResume() {
        // TODO 友盟
        super.onResume();
    }

    @Override
    protected void onPause() {
        // TODO 友盟
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
    }

    public void showLoading() {

    }

    public void hideLoading() {

    }

    public void showSuccess(String successMsg) {
        ToastUtils.showShort(successMsg);
    }

    public void showFailed(String errorMsg) {
        ToastUtils.showShort(errorMsg);
    }

    public void showNoNet() {
        ToastUtils.showShort(R.string.http_error);
    }

    public void onRetry() {

    }

    public void useNightMode(boolean isNight) {
//        if (isNight) {
//            AppCompatDelegate.setDefaultNightMode(
//                    AppCompatDelegate.MODE_NIGHT_YES);
//        } else {
//            AppCompatDelegate.setDefaultNightMode(
//                    AppCompatDelegate.MODE_NIGHT_NO);
//        }
//        recreate();
    }

    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }

    /**
     * 获取状态栏字体颜色
     */
    @Override
    public boolean statusBarDarkFont() {
        // 返回false表示白色字体，返回true表示黑色字体
        return true;
    }
}
