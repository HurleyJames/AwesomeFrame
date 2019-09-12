package com.hurley.awesomeframe.feature.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.hurley.awesomeframe.R;

import site.gemus.openingstartanimation.OpeningStartAnimation;
import site.gemus.openingstartanimation.RedYellowBlueDrawStrategy;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-09-12 13:36
 *      github  : https://github.com/HurleyJames
 *      desc    : 启动页面
 * </pre>
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        ImmersionBar.with(this)
                .fullScreen(true)
                .hideBar(BarHide.FLAG_HIDE_STATUS_BAR)
                .transparentNavigationBar()
                .init();

        OpeningStartAnimation openingStartAnimation = new OpeningStartAnimation.Builder(this)
                .setDrawStategy(new RedYellowBlueDrawStrategy())
                .setAppStatement(getString(R.string.app_name))
                .create();
        openingStartAnimation.show(this);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            this.startActivity(intent);
            finish();
        }, 1500);

    }
}
