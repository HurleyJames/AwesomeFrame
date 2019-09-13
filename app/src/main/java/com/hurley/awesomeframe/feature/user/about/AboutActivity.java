package com.hurley.awesomeframe.feature.user.about;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.data.local.FrameBean;
import com.hurley.awesomeframe.feature.found.adapter.FrameAdapter;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-14 13:34
 *      github  : https://github.com/HurleyJames
 *      desc    : 关于界面
 * </pre>
 */
public class AboutActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_about)
    RecyclerView mRvAbout;

    @Override
    protected int getLayoutId() {
        return R.layout.about_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_about;
    }

    @Override
    protected void initView() {
        mRvAbout.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEventAndData() {
        List<FrameBean> mList = new ArrayList<>();
        FrameAdapter mAdapter = new FrameAdapter(R.layout.frame_recycle_item, mList);
        mRvAbout.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNewData(setListData(mList));
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                startActivity(AboutPageActivity.class);
                break;
            case 1:
                startActivity(MaterialAboutLibraryActivity.class);
                break;
            case 2:
                new LibsBuilder()
                        .withAutoDetect(false)
                        .withActivityStyle(Libs.ActivityStyle.LIGHT)
                        .withActivityTitle(getString(R.string.about))
                        .withAboutAppName(getString(R.string.app_name))
                        .withAboutDescription(getString(R.string.app_desc))
                        .withAboutIconShown(true)
                        .withAboutVersionShown(true)
                        .start(this);
                break;
            default:
                break;
        }
    }

    private List<FrameBean> setListData(List<FrameBean> list) {
        list.add(new FrameBean("about-page", "PureWriter", "A nice about page library based on MultiType"));
        list.add(new FrameBean("material-about-library", "daniel-stoneuk", "Makes it easy to create beautiful about screens for your apps"));
        list.add(new FrameBean("AboutLibraries", "mikepenz", "AboutLibraries is a library to offer some information of libraries."));
        return list;
    }
}
