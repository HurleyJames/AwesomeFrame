package com.hurley.awesomeframe.feature.user;

import android.os.Bundle;
import android.view.View;

import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.fragment.BaseFragment;
import com.hurley.awesomeframe.feature.user.about.AboutActivity;
import com.hurley.awesomeframe.feature.user.donate.DonateActivity;
import com.hurley.awesomeframe.feature.user.feedback.FeedbackActivity;
import com.hurley.awesomeframe.feature.user.rate.RateActivity;
import com.hurley.awesomeframe.feature.user.setting.SettingActivity;
import com.hurley.awesomeframe.feature.user.share.ShareActivity;
import com.hurley.awesomeframe.widget.SettingBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 14:50
 *      github  : https://github.com/HurleyJames
 *      desc    : 用户页面
 * </pre>
 */
public class UserFragment extends BaseFragment {

    @BindView(R.id.sb_setting)
    SettingBar mSbSetting;
    @BindView(R.id.sb_rate)
    SettingBar mSbRate;
    @BindView(R.id.sb_donate)
    SettingBar mSbDonate;
    @BindView(R.id.sb_about)
    SettingBar mSbAbout;
    @BindView(R.id.sb_feedback)
    SettingBar mSbFeedback;
    @BindView(R.id.sb_share)
    SettingBar mSbShare;

    public static UserFragment newInstance() {
        Bundle args = new Bundle();
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_fragment;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_user;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    @OnClick({R.id.sb_feedback, R.id.sb_donate, R.id.sb_share, R.id.sb_rate, R.id.sb_about, R.id.sb_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sb_about:
                startActivity(AboutActivity.class);
                break;
            case R.id.sb_setting:
                startActivity(SettingActivity.class);
                break;
            case R.id.sb_feedback:
                startActivity(FeedbackActivity.class);
                break;
            case R.id.sb_share:
                startActivity(ShareActivity.class);
                break;
            case R.id.sb_rate:
                startActivity(RateActivity.class);
                break;
            case R.id.sb_donate:
                startActivity(DonateActivity.class);
                break;
            default:
                break;
        }
    }
}
