package com.hurley.awesomeframe.feature.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.BaseFragmentAdapter;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.base.fragment.BaseFragment;
import com.hurley.awesomeframe.feature.found.FoundFragment;
import com.hurley.awesomeframe.feature.index.IndexFragment;
import com.hurley.awesomeframe.feature.user.UserFragment;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 10:12
 *      github  : https://github.com/HurleyJames
 *      desc    : 主页界面
 * </pre>
 */
public class MainActivity extends BaseActivity
        implements ViewPager.OnPageChangeListener, BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.vp_main_pager)
    ViewPager mVpMain;
    @BindView(R.id.bnv_main)
    BottomNavigationView mBnvMain;

    private BaseFragmentAdapter<BaseFragment> mPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    protected int getTitleId() {
        return 0;
    }

    @Override
    protected void initView() {
        mVpMain.addOnPageChangeListener(this);

        // 不使用图标默认变色
        mBnvMain.setItemIconTintList(null);
        mBnvMain.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initEventAndData() {
        mPagerAdapter = new BaseFragmentAdapter<>(this);
        mPagerAdapter.addFragment(IndexFragment.newInstance());
        mPagerAdapter.addFragment(FoundFragment.newInstance());
        mPagerAdapter.addFragment(UserFragment.newInstance());

        mVpMain.setAdapter(mPagerAdapter);

        //限制页面数量
        mVpMain.setOffscreenPageLimit(mPagerAdapter.getCount());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            // 如果切换的是相邻之间的 Item 就显示切换动画，如果不是则不要动画
            case R.id.menu_main_index:
                mVpMain.setCurrentItem(0, mVpMain.getCurrentItem() == 1);
                return true;
            case R.id.menu_main_found:
                mVpMain.setCurrentItem(1, mVpMain.getCurrentItem() == 0 || mVpMain.getCurrentItem() == 2);
                return true;
            case R.id.menu_main_user:
                mVpMain.setCurrentItem(2, mVpMain.getCurrentItem() == 1);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mBnvMain.setSelectedItemId(R.id.menu_main_index);
                break;
            case 1:
                mBnvMain.setSelectedItemId(R.id.menu_main_found);
                break;
            case 2:
                mBnvMain.setSelectedItemId(R.id.menu_main_user);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 回调当前 Fragment 的 onKeyDown 方法
        if (mPagerAdapter.getCurrentFragment().onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        mVpMain.removeOnPageChangeListener(this);
        mVpMain.setAdapter(null);
        mBnvMain.setOnNavigationItemSelectedListener(null);
        super.onDestroy();
    }

    @Override
    public boolean isSupportSwipeBack() {
        // 不使用侧滑功能
        return false;
    }
}
