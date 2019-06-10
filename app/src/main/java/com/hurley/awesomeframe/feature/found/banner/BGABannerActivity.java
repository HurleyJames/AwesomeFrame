package com.hurley.awesomeframe.feature.found.banner;

import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;

import java.util.Arrays;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-06-10 14:31
 *      github  : https://github.com/HurleyJames
 *      desc    : BGABanner-Android框架页面
 * </pre>
 */
public class BGABannerActivity extends BaseActivity {

    @BindView(R.id.banner_bga)
    BGABanner mBGABanner;

    @Override
    protected int getLayoutId() {
        return R.layout.banner_bga_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_bga_banner;
    }

    @Override
    protected void initView() {
        setBannerData1();
    }

    @Override
    protected void initEventAndData() {
        // 监听 item 的单击事件，在 BGABanner 里已经帮开发者处理了防止重复点击事件
        mBGABanner.setDelegate((BGABanner.Delegate<ImageView, String>) (banner, itemView, model, position) ->
                ToastUtils.showShort("点击了" + position));

        // 跳过按钮与进入按钮
//        mBGABanner.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, R.id.tv_guide_skip, (BGABanner.GuideDelegate) () -> {
//            startActivity(new Intent(this, MainActivity.class));
//            finish();
//        });
    }

    /**
     * 第一种配置BGABanner数据源的方式
     * 通过传入数据模型并结合 Adapter 的方式配置数据源。这种方式主要用于加载网络图片，以及实现少于3页时的无限轮播
     */
    private void setBannerData1() {
        mBGABanner.setAdapter((BGABanner.Adapter<ImageView, String>) (banner, itemView, model, position) -> {
            Glide.with(this)
                    .load(model)
                    .centerCrop()
                    .dontAnimate()
                    .into(itemView);
        });
        mBGABanner.setData(Arrays.asList("https://wanandroid.com/blogimgs/fbed8f14-1043-4a43-a7ee-0651996f7c49.jpeg",
                "https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png",
                "https://www.wanandroid.com/blogimgs/ab17e8f9-6b79-450b-8079-0f2287eb6f0f.png"),
                Arrays.asList("文字1", "文字2", "文字3"));
    }

    /**
     * 第二种配置BGABanner数据源的方式
     * 通过直接传入视图集合的方式配置数据源，主要用于自定义引导页每个页面布局的情况
     */
    private void setBannerData2() {
//        List<View> views = new ArrayList<>();
//        views.add(View.inflate(context, R.layout.layout_guide_one, null));
//        views.add(View.inflate(context, R.layout.layout_guide_two, null));
//        views.add(View.inflate(context, R.layout.layout_guide_three, null));
//        mBGABanner.setData(views);
    }

    /**
     * 第三种配置BGABanner数据源的方式
     * 通过传入图片资源 id 的方式配置数据源，主要用于引导页每一页都是只显示图片的情况
     */
    private void setBannerData3() {
        // Bitmap 的宽高在 maxWidth maxHeight 和 minWidth minHeight 之间
//        BGALocalImageSize localImageSize = new BGALocalImageSize(720, 1280, 320, 640);
        // 设置数据源
//        mBGABanner.setData(localImageSize, ImageView.ScaleType.CENTER_CROP,
//                R.drawable.uoko_guide_background_1,
//                R.drawable.uoko_guide_background_2,
//                R.drawable.uoko_guide_background_3);
    }
}
