package com.hurley.awesomeframe.feature.found.card;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.feature.found.adapter.CardStackAdapter;
import com.vondear.rxtool.RxTool;
import com.vondear.rxui.view.cardstack.RxCardStackView;
import com.vondear.rxui.view.cardstack.tools.RxAdapterAllMoveDownAnimator;
import com.vondear.rxui.view.cardstack.tools.RxAdapterUpDownAnimator;
import com.vondear.rxui.view.cardstack.tools.RxAdapterUpDownStackAnimator;

import java.util.Arrays;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-09-12 23:01
 *      github  : https://github.com/HurleyJames
 *      desc    : 银行卡堆叠组件页面
 * </pre>
 */
public class CardStackActivity extends BaseActivity implements RxCardStackView.ItemExpendListener {

    public static Integer[] TEST_DATAS = new Integer[]{
            R.color.custom_progress_green_header,
            R.color.custom_progress_green_progress,
            R.color.background_content,
            R.color.custom_progress_orange_header,
            R.color.custom_progress_orange_progress,
            R.color.darkslategrey,
            R.color.forestgreen,
            R.color.custom_progress_blue_header,
            R.color.cadetblue,
            R.color.custom_progress_purple_header,
            R.color.mediumaquamarine,
            R.color.mediumseagreen,
            R.color.custom_progress_red_header,
            R.color.custom_progress_red_progress,
            R.color.coral,
            R.color.WARNING_COLOR,
            R.color.aqua,
            R.color.blue_shadow_50,
            R.color.cadetblue,
            R.color.custom_progress_red_progress_half,
            R.color.brown,
            R.color.brown1,
            R.color.brown2,
            R.color.brown3,
            R.color.orange,
            R.color.custom_progress_orange_progress_half
    };

    @BindView(R.id.card_stack_view)
    RxCardStackView mStackView;
    @BindView(R.id.ll_button)
    LinearLayout mLlButton;
    private CardStackAdapter mStackAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.card_stack;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_stack;
    }

    @Override
    protected void initView() {
        mStackView.setItemExpendListener(this);
        mStackAdapter = new CardStackAdapter(this);
        mStackView.setAdapter(mStackAdapter);
    }

    @Override
    protected void initEventAndData() {
        RxTool.delayToDo(200, () -> mStackAdapter.updateData(Arrays.asList(TEST_DATAS)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_card, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_all_down:
                mStackView.setRxAdapterAnimator(new RxAdapterAllMoveDownAnimator(mStackView));
                break;
            case R.id.menu_up_down:
                mStackView.setRxAdapterAnimator(new RxAdapterUpDownAnimator(mStackView));
                break;
            case R.id.menu_up_down_stack:
                mStackView.setRxAdapterAnimator(new RxAdapterUpDownStackAnimator(mStackView));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onPreClick(View view) {
        mStackView.pre();
    }

    public void onNextClick(View view) {
        mStackView.next();
    }

    @Override
    public void onItemExpend(boolean expend) {
        mLlButton.setVisibility(expend ? View.VISIBLE : View.GONE);
    }
}
