package com.hurley.awesomeframe.feature.user.rate;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.codemybrainsout.ratingdialog.RatingDialog;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.data.local.FrameBean;
import com.hurley.awesomeframe.feature.found.adapter.FrameAdapter;
import com.kobakei.ratethisapp.RateThisApp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-29 12:07
 *      github  : https://github.com/HurleyJames
 *      desc    : 评价界面
 * </pre>
 */
public class RateActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_rate)
    RecyclerView mRvRate;

    @Override
    protected int getLayoutId() {
        return R.layout.rate_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_rate;
    }

    @Override
    protected void initView() {
        mRvRate.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        List<FrameBean> mList = new ArrayList<>();
        FrameAdapter mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvRate.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                setRate1();
                break;
            case 1:
                setRate2();
                break;
            default:
                break;
        }
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("Android-RateThisApp", "kobakei", "Android library to show \"Rate this app\" dialog"));
        list.add(new FrameBean("smart-app-rate", "codemybrainsout", "An Android library that encourages users to rate the app on the Google Play."));
        return list;
    }

    /**
     * Android-RateThisApp
     */
    private void setRate1() {
        RateThisApp.onCreate(this);
        // 设置样式
        RateThisApp.Config config = new RateThisApp.Config();
        config.setTitle(R.string.rate_title);
        config.setMessage(R.string.rate_message);
        config.setYesButtonText(R.string.rate);
        config.setNoButtonText(R.string.rate_no);
        config.setCancelButtonText(R.string.rate_later);
        // 设置url
        config.setUrl("hurley.fun");
        RateThisApp.init(config);
        RateThisApp.showRateDialog(this);
        // 设置回调
        RateThisApp.setCallback(new RateThisApp.Callback() {
            @Override
            public void onYesClicked() {
                // TODO 跳转至应用市场（酷安）进行评价
            }

            @Override
            public void onNoClicked() {

            }

            @Override
            public void onCancelClicked() {

            }
        });
    }

    /**
     * smart-app-rate
     */
    private void setRate2() {
        final RatingDialog ratingDialog = new RatingDialog.Builder(this)
//                .icon(drawable)
//                .session(7)
//                .threshold(3)
                .title("How was your experience with us?")
                .titleTextColor(R.color.black)
                .positiveButtonText("Not Now")
                .negativeButtonText("Never")
                .positiveButtonTextColor(R.color.white)
                .negativeButtonTextColor(R.color.grey_500)
                .formTitle("Submit Feedback")
                .formHint("Tell us where we can improve")
                .formSubmitText("Submit")
                .formCancelText("Cancel")
                .ratingBarColor(R.color.yellow)
                // 商店地址
                .playstoreUrl("")
                .onThresholdCleared((ratingDialog1, rating, thresholdCleared) -> {
                    //do something
                    ratingDialog1.dismiss();
                })
                .onThresholdFailed((ratingDialog2, rating, thresholdCleared) -> {
                    //do something
                    ratingDialog2.dismiss();
                })
                .onRatingChanged((rating, thresholdCleared) -> {

                })
                .onRatingBarFormSumbit(feedback -> {

                }).build();
        ratingDialog.show();
    }
}
