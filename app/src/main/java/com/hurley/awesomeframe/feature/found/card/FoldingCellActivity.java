package com.hurley.awesomeframe.feature.found.card;

import android.view.View;
import android.widget.Button;

import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.ramotion.foldingcell.FoldingCell;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-06-12 17:54
 *      github  : https://github.com/HurleyJames
 *      desc    : folding-cell-android框架页面
 * </pre>
 */
public class FoldingCellActivity extends BaseActivity {

    @BindView(R.id.folding_cell)
    FoldingCell mFoldingCell;
    @BindView(R.id.btn_instant)
    Button mBtnInstant;
    @BindView(R.id.btn_animation)
    Button mBtnAnimation;

    @Override
    protected int getLayoutId() {
        return R.layout.card_folding_cell_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_folding_cell;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick({R.id.btn_instant, R.id.btn_animation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_instant:
                mFoldingCell.toggle(true);
                break;
            case R.id.btn_animation:
                mFoldingCell.toggle(false);
                break;
            default:
                break;
        }
    }
}
