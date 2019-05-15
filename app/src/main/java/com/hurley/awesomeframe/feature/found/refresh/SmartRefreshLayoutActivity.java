package com.hurley.awesomeframe.feature.found.refresh;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.header.DropBoxHeader;
import com.scwang.smartrefresh.header.FlyRefreshHeader;
import com.scwang.smartrefresh.header.FunGameBattleCityHeader;
import com.scwang.smartrefresh.header.FunGameHitBlockHeader;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.header.PhoenixHeader;
import com.scwang.smartrefresh.header.StoreHouseHeader;
import com.scwang.smartrefresh.header.TaurusHeader;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-11 21:15
 *      github  : https://github.com/HurleyJames
 *      desc    : SmartRefreshLayout框架页面
 * </pre>
 */
public class SmartRefreshLayoutActivity extends BaseActivity {

    @BindView(R.id.btn_delivery)
    Button mBtnDelivery;
    @BindView(R.id.btn_dropbox)
    Button mBtnDropBox;
    @BindView(R.id.btn_bezier_radar)
    Button mBtnBezierRadar;
    @BindView(R.id.btn_bezier_circle)
    Button mBtnBezierCircle;
    @BindView(R.id.btn_fly)
    Button mBtnFly;
    @BindView(R.id.btn_classics)
    Button mBtnClassics;
    @BindView(R.id.btn_phoenix)
    Button mBtnPhoenix;
    @BindView(R.id.btn_taurus)
    Button mBtnTaurus;
    @BindView(R.id.btn_battle_city)
    Button mBtnBattleCity;
    @BindView(R.id.btn_hit_block)
    Button mBtnHitBlock;
    @BindView(R.id.btn_wave_swipe)
    Button mBtnWave;
    @BindView(R.id.btn_material)
    Button mBtnMaterial;
    @BindView(R.id.btn_store_house)
    Button mBtnStore;
    @BindView(R.id.btn_water_drop)
    Button mBtnWater;
    @BindView(R.id.srl_smart)
    SmartRefreshLayout mSrlSmart;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_smart_refresh;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_smart_refresh;
    }

    @Override
    protected void initView() {
        // 启用下拉刷新功能
        mSrlSmart.setEnableRefresh(true);
        // 启用上拉加载功能
        mSrlSmart.setEnableLoadMore(true);

        mSrlSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mSrlSmart.finishRefresh(2000);
            }
        });
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick({R.id.btn_delivery, R.id.btn_dropbox, R.id.btn_bezier_radar, R.id.btn_bezier_circle, R.id.btn_fly,
            R.id.btn_classics, R.id.btn_phoenix, R.id.btn_taurus, R.id.btn_battle_city, R.id.btn_hit_block,
            R.id.btn_wave_swipe, R.id.btn_material, R.id.btn_store_house, R.id.btn_water_drop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_delivery:
                mSrlSmart.setRefreshHeader(new DeliveryHeader(this));
                break;
            case R.id.btn_dropbox:
                mSrlSmart.setRefreshHeader(new DropBoxHeader(this));
                mSrlSmart.setPrimaryColorsId(R.color.windowBackground, R.color.colorAccent);
                break;
            case R.id.btn_bezier_radar:
                mSrlSmart.setRefreshHeader(new BezierRadarHeader(this));
                mSrlSmart.setPrimaryColorsId(R.color.windowBackground, R.color.colorAccent);
                break;
            case R.id.btn_bezier_circle:
                mSrlSmart.setRefreshHeader(new BezierCircleHeader(this));
                mSrlSmart.setPrimaryColorsId(R.color.colorAccent, android.R.color.white);
                break;
            case R.id.btn_fly:
                // TODO 跳转到FlyRefreshLayout
                mSrlSmart.setRefreshHeader(new FlyRefreshHeader(this));
                break;
            case R.id.btn_classics:
                mSrlSmart.setRefreshHeader(new ClassicsHeader(this));
                break;
            case R.id.btn_phoenix:
                mSrlSmart.setRefreshHeader(new PhoenixHeader(this));
                mSrlSmart.setPrimaryColorsId(R.color.colorAccent, android.R.color.white);
                break;
            case R.id.btn_taurus:
                mSrlSmart.setRefreshHeader(new TaurusHeader(this));
                mSrlSmart.setPrimaryColorsId(R.color.colorAccent, android.R.color.white);
                break;
            case R.id.btn_battle_city:
                mSrlSmart.setRefreshHeader(new FunGameBattleCityHeader(this));
                mSrlSmart.setPrimaryColorsId(R.color.windowBackground);
                break;
            case R.id.btn_hit_block:
                mSrlSmart.setRefreshHeader(new FunGameHitBlockHeader(this));
                mSrlSmart.setPrimaryColorsId(R.color.windowBackground);
                break;
            case R.id.btn_wave_swipe:
                mSrlSmart.setRefreshHeader(new WaveSwipeHeader(this));
                mSrlSmart.setPrimaryColorsId(R.color.colorAccent, android.R.color.white);
                break;
            case R.id.btn_material:
                mSrlSmart.setRefreshHeader(new MaterialHeader(this));
                break;
            case R.id.btn_store_house:
                mSrlSmart.setRefreshHeader(new StoreHouseHeader(this).
                        setTextColor(ContextCompat.getColor(this, R.color.colorAccent)));
                mSrlSmart.setPrimaryColorsId(R.color.windowBackground);
                break;
            case R.id.btn_water_drop:
                mSrlSmart.setRefreshHeader(new WaterDropHeader(this));
                break;
            default:
                break;
        }
        mSrlSmart.autoRefresh();
    }

    private void toast(String text) {
        ToastUtils.setBgColor(ContextCompat.getColor(this, R.color.gray));
        ToastUtils.showShort(text);
    }
}
