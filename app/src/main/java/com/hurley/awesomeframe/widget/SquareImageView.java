package com.hurley.awesomeframe.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-14 10:35
 *      github  : https://github.com/HurleyJames
 *      desc    : 正方形的ImageView
 * </pre>
 */
public class SquareImageView extends AppCompatImageView {

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(measureWidth(widthMeasureSpec, heightMeasureSpec),
                measureHeight(widthMeasureSpec, heightMeasureSpec));
    }

    /**
     * 测量出正方形的宽度
     *
     * @param widthMeasureSpec  onMeasure中的同名参数
     * @param heightMeasureSpec onMeasure中的同名参数
     * @return 返回用于测量的参数
     */
    public int measureWidth(int widthMeasureSpec, int heightMeasureSpec) {

        int widthSpecMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec);

        int heightSpecMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec);

        // 如果当前宽度不是写死的
        if (widthSpecMode != View.MeasureSpec.EXACTLY) {
            // 如果当前高度不是写死的
            if (heightSpecMode != View.MeasureSpec.EXACTLY) {
                // 对比高度和宽度，返回最大值的那个
                return View.MeasureSpec.makeMeasureSpec(Math.max(widthSpecSize, heightSpecSize), View.MeasureSpec.EXACTLY);
            } else {
                // 如果已经定死了高度，而宽度没有写死，则使用高度代替宽度
                return heightMeasureSpec;
            }
        } else {
            // 宽度和高度已经写死，这里不做任何处理
            return widthMeasureSpec;
        }
    }

    /**
     * 测量出正方形的高度
     *
     * @param widthMeasureSpec  onMeasure中的同名参数
     * @param heightMeasureSpec onMeasure中的同名参数
     * @return 返回用于测量的参数
     */
    public int measureHeight(int widthMeasureSpec, int heightMeasureSpec) {

        int widthSpecMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec);

        int heightSpecMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec);

        // 如果当前高度不是写死的
        if (heightSpecMode != View.MeasureSpec.EXACTLY) {
            // 如果当前宽度不是写死的
            if (widthSpecMode != View.MeasureSpec.EXACTLY) {
                // 对比高度和宽度，返回最大值的那个
                return View.MeasureSpec.makeMeasureSpec(Math.max(widthSpecSize, heightSpecSize), View.MeasureSpec.EXACTLY);
            } else {
                // 如果已经定死了宽度，而高度没有写死，则使用高度代替宽度
                return widthMeasureSpec;
            }
        } else {
            // 宽度和高度已经写死，这里不做任何处理
            return heightMeasureSpec;
        }
    }
}
