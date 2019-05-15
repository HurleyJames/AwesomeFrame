package com.hurley.awesomeframe.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 09:21
 *      github  : https://github.com/HurleyJames
 *      desc    : Contract基类
 * </pre>
 */
public interface BaseContract {

    interface BasePresenter<T extends BaseContract.BaseView> {

        /**
         * 绑定视图
         *
         * @param view
         */
        void attachView(T view);

        /**
         * 解绑视图
         */
        void detachView();
    }

    interface BaseView {

        /**
         * 显示加载
         */
        void showLoading();

        /**
         * 隐藏加载
         */
        void hideLoading();

        /**
         * 显示请求成功
         *
         * @param message
         */
        void showSuccess(String message);

        /**
         * 显示失败
         *
         * @param message
         */
        void showFailed(String message);

        /**
         * 显示当前网络不可用
         */
        void showNoNet();

        /**
         * 重试
         */
        void onRetry();

        /**
         * 设置夜间模式
         *
         * @param isNight
         */
        void useNightMode(boolean isNight);

        /**
         * 绑定生命周期
         *
         * @param <T>
         * @return
         */
        <T> LifecycleTransformer<T> bindToLife();

    }
}
