package com.hurley.awesomeframe.widget;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.AttributeSet;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 14:50
 *      github  : https://github.com/HurleyJames
 *      desc    : 支持监听渐变的CollapsingToolbarLayout
 * </pre>
 */
public final class ChangeCollapsingToolbarLayout extends CollapsingToolbarLayout {

    /**
     * 渐变监听
     */
    private OnScrimsListener mListener;
    /**
     * 当前渐变状态
     */
    private boolean isScrimsShown;

    public ChangeCollapsingToolbarLayout(Context context) {
        super(context);
    }

    public ChangeCollapsingToolbarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChangeCollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setScrimsShown(boolean shown, boolean animate) {
        super.setScrimsShown(shown, true);
        // 判断渐变状态是否改变了
        if (isScrimsShown != shown) {
            // 如果是就记录并且回调监听器
            isScrimsShown = shown;
            if (mListener != null) {
                mListener.onScrimsStateChange(isScrimsShown);
            }
        }
    }

    /**
     * 获取当前的渐变状态
     */
    public boolean isScrimsShown() {
        return isScrimsShown;
    }

    /**
     * 设置CollapsingToolbarLayout渐变监听
     */
    public void setOnScrimsListener(OnScrimsListener l) {
        mListener = l;
    }

    /**
     * CollapsingToolbarLayout渐变监听器
     */
    public interface OnScrimsListener {

        /**
         * 渐变状态变化
         *
         * @param shown 渐变开关
         */
        void onScrimsStateChange(boolean shown);
    }
}