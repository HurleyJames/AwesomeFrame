package com.hurley.awesomeframe.base;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 09:22
 *      github  : https://github.com/HurleyJames
 *      desc    : Presenter基类
 * </pre>
 */
public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }

}
