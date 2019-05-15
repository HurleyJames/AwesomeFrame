package com.hurley.awesomeframe.feature.found.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.data.local.FrameBean;

import java.util.List;

import io.reactivex.annotations.Nullable;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-11 13:46
 *      github  : https://github.com/HurleyJames
 *      desc    : 框架适配器类
 * </pre>
 */
public class FrameAdapter extends BaseQuickAdapter<FrameBean, BaseViewHolder> {

    public FrameAdapter(int layoutResId, @Nullable List<FrameBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FrameBean item) {
        helper.setText(R.id.tv_frame_name, item.getName())
                .setText(R.id.tv_frame_author, item.getAuthor())
                .setText(R.id.tv_frame_detail, item.getDetail());
    }
}
