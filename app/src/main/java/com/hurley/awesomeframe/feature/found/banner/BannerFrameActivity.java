package com.hurley.awesomeframe.feature.found.banner;

import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.util.ImageLoaderUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.drakeet.support.about.provided.GlideImageLoader;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-06-10 09:57
 *      github  : https://github.com/HurleyJames
 *      desc    : banner框架页面
 * </pre>
 */
public class BannerFrameActivity extends BaseActivity {

    @BindView(R.id.banner)
    Banner mBanner;

    @Override
    protected int getLayoutId() {
        return R.layout.banner_frame_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_banner_frame;
    }

    @Override
    protected void initView() {
        // 设置图片加载器
        mBanner.setImageLoader(new ImageLoaderUtils());
    }

    @Override
    protected void initEventAndData() {
        setBannerStyle();
        // banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    private void setBannerStyle() {
        // 设置图片集合
        List<String> paths = new ArrayList<>();
        paths.add("https://wanandroid.com/blogimgs/fbed8f14-1043-4a43-a7ee-0651996f7c49.jpeg");
        paths.add("https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png");
        paths.add("https://www.wanandroid.com/blogimgs/ab17e8f9-6b79-450b-8079-0f2287eb6f0f.png");
        paths.add("https://www.wanandroid.com/blogimgs/fb0ea461-e00a-482b-814f-4faca5761427.png");
        paths.add("https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png");
        mBanner.setImages(paths);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        // mBanner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
    }


}
