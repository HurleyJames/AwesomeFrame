package com.hurley.awesomeframe.feature.found.card;

import com.blankj.utilcode.util.ToastUtils;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.feature.found.adapter.SwipeStackAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import link.fls.swipestack.SwipeStack;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-06-12 19:48
 *      github  : https://github.com/HurleyJames
 *      desc    : SwipeStack框架页面
 * </pre>
 */
public class SwipeStackActivity extends BaseActivity implements SwipeStack.SwipeStackListener{

    @BindView(R.id.swipeStack)
    SwipeStack mSwipeStack;

    private ArrayList<String> mData;
    private SwipeStackAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.card_swipe_stack_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_swipe_stack;
    }

    @Override
    protected void initView() {
        mData = new ArrayList<>();
        mData.add("测试1");
        mData.add("测试2");
        mData.add("测试3");
        mAdapter = new SwipeStackAdapter(getApplicationContext(), mData);
        mSwipeStack.setAdapter(mAdapter);
        mSwipeStack.setListener(this);
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void onViewSwipedToLeft(int position) {
        String swipedElement = mAdapter.getItem(position);
        ToastUtils.showShort(swipedElement + "左");
    }

    @Override
    public void onViewSwipedToRight(int position) {
        String swipedElement = mAdapter.getItem(position);
        ToastUtils.showShort(swipedElement + "右");
    }

    @Override
    public void onStackEmpty() {
        ToastUtils.showShort( "空");
    }
}
