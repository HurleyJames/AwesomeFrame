package com.hurley.awesomeframe.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.hjq.bar.TitleBar;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.trello.rxlifecycle2.LifecycleTransformer;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 12:02
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public abstract class BaseFragment<A extends BaseActivity> extends AbstractUIFragment<A>{

    /**
     * ButterKnife 注解
     */
    private Unbinder unBinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        unBinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initFragment() {
        super.initFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
    }

    @Nullable
    public TitleBar getTitleBar() {
        if (getTitleId() > 0 && findViewById(getTitleId()) instanceof TitleBar) {
            return findViewById(getTitleId());
        }
        return null;
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
        ToastUtils.showShort(R.string.http_retry);
    }

    public void useNightMode(boolean isNight) {

    }

    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }

}
