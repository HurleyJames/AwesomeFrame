package com.hurley.awesomeframe.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.blankj.utilcode.util.Utils;
import com.hurley.awesomeframe.BuildConfig;
import com.kobakei.ratethisapp.RateThisApp;
import com.linkedin.android.shaky.EmailShakeDelegate;
import com.linkedin.android.shaky.Shaky;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;
import me.yokeyword.fragmentation.Fragmentation;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-10 09:18
 *      github  : https://github.com/HurleyJames
 *      desc    : Application基类
 * </pre>
 */
public class App extends Application {

    private static App instance;

    private Shaky shaky;

    @Override
    public void onCreate() {
        super.onCreate();
        initSDK(this);
        // 初始化反馈
        shaky = Shaky.with(this, new EmailShakeDelegate("1401682479@qq.com"));
    }

    /**
     * 初始化第三方框架
     * @param application
     */
    public static void initSDK(Application application) {

        /**
         * 必须在Application的onCreate方法中执行BGASwipeBackHelper.init来初始化滑动返回
         * 第一个参数：应用程序上下文
         * 第二个参数：如果发现滑动返回后立即触摸界面时应用崩溃，则把该界面里比较特殊的View的class添加到该集合中，例如WebView和SurfaceView
         */
        BGASwipeBackHelper.init(application, null);

        // 初始化工具类
        Utils.init(application);

        // 初始化Fragmentation
        Fragmentation.builder()
                // BUBBLE：显示悬浮球 | SHAKE：摇一摇换出悬浮球 | NONE：隐藏悬浮球
                .stackViewMode(Fragmentation.NONE)
                .debug(BuildConfig.DEBUG)
                .install();

        // 初始化评价
        RateThisApp.Config config = new RateThisApp.Config(3, 5);
        RateThisApp.init(config);

    }

    @NonNull
    public Shaky getShaky() {
        return shaky;
    }

}
