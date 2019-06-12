package com.hurley.awesomeframe.feature.found.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hurley.awesomeframe.R;

import java.util.List;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-06-12 19:54
 *      github  : https://github.com/HurleyJames
 *      desc    : SwipeStack适配器类
 * </pre>
 */
public class SwipeStackAdapter extends BaseAdapter {

    private List<String> mData;
    private Context mContext;

    public SwipeStackAdapter(Context context, List<String> data) {
        super();
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 采用最简单的TextView说明
        TextView textView = new TextView(mContext);
        textView.setText(mData.get(position));
        return textView;
    }
}
