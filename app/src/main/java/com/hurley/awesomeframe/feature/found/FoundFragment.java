package com.hurley.awesomeframe.feature.found;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.fragment.BaseFragment;
import com.hurley.awesomeframe.feature.found.banner.BannerActivity;
import com.hurley.awesomeframe.feature.found.card.CardActivity;
import com.hurley.awesomeframe.feature.found.dialog.DialogActivity;
import com.hurley.awesomeframe.feature.found.list.ListActivity;
import com.hurley.awesomeframe.feature.found.navigation.NavigationActivity;
import com.hurley.awesomeframe.feature.found.pick.PickActivity;
import com.hurley.awesomeframe.feature.found.popup.PopupActivity;
import com.hurley.awesomeframe.feature.found.refresh.RefreshActivity;
import com.hurley.awesomeframe.feature.found.tab.TabActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 14:54
 *      github  : https://github.com/HurleyJames
 *      desc    : 发现页面
 * </pre>
 */
public class FoundFragment extends BaseFragment {

    @BindView(R.id.rl_navigation)
    RelativeLayout mRlNavigation;
    @BindView(R.id.rl_list)
    RelativeLayout mRlList;
    @BindView(R.id.rl_card)
    RelativeLayout mRlCard;
    @BindView(R.id.rl_dialog)
    RelativeLayout mRlDialog;
    @BindView(R.id.rl_tab)
    RelativeLayout mRlTab;
    @BindView(R.id.rl_pick)
    RelativeLayout mRlPick;
    @BindView(R.id.rl_refresh)
    RelativeLayout mRlRefresh;
    @BindView(R.id.rl_banner)
    RelativeLayout mRlBanner;
    @BindView(R.id.rl_popup)
    RelativeLayout mRlPopup;

    public static FoundFragment newInstance() {
        Bundle args = new Bundle();
        FoundFragment fragment = new FoundFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.found_fragment;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_found;
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

    @OnClick({R.id.rl_navigation, R.id.rl_list, R.id.rl_card, R.id.rl_dialog,
            R.id.rl_tab, R.id.rl_pick, R.id.rl_refresh, R.id.rl_popup, R.id.rl_banner})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_navigation:
                startActivity(NavigationActivity.class);
                break;
            case R.id.rl_list:
                startActivity(ListActivity.class);
                break;
            case R.id.rl_card:
                startActivity(CardActivity.class);
                break;
            case R.id.rl_dialog:
                startActivity(DialogActivity.class);
                break;
            case R.id.rl_tab:
                startActivity(TabActivity.class);
                break;
            case R.id.rl_pick:
                startActivity(PickActivity.class);
                break;
            case R.id.rl_refresh:
                startActivity(RefreshActivity.class);
                break;
            case R.id.rl_banner:
                startActivity(BannerActivity.class);
                break;
            case R.id.rl_popup:
                startActivity(PopupActivity.class);
                break;
            default:
                break;
        }
    }
}
