package com.hurley.awesomeframe.feature.found.pick;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-11 19:47
 *      github  : https://github.com/HurleyJames
 *      desc    : CityPicker框架页面
 * </pre>
 */
public class CityPickerActivity extends BaseActivity {

    @BindView(R.id.btn_city)
    Button mBtnCity;

    List<HotCity> hotCities = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.pick_city_picker_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_city_pick;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {
        // code为城市代码
        hotCities.add(new HotCity("北京", "北京", "101010100"));
        hotCities.add(new HotCity("上海", "上海", "101020100"));
        hotCities.add(new HotCity("广州", "广东", "101280101"));
        hotCities.add(new HotCity("深圳", "广东", "101280601"));
        hotCities.add(new HotCity("杭州", "浙江", "101210101"));
    }

    @OnClick({R.id.btn_city})
    public void onClick(View view) {
        CityPicker.from(this)
                // 启用动画效果
                .enableAnimation(true)
                // 设置定位城市
                .setLocatedCity(new LocatedCity("杭州", "浙江", "101210101"))
                // 设置热门城市
                .setHotCities(hotCities)
                .setOnPickListener(new OnPickListener() {
                    @Override
                    public void onPick(int position, City data) {
                        toast(data.getName());
                    }

                    @Override
                    public void onLocate() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                CityPicker.from(getActivity()).locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);
                            }
                        }, 3000);
                    }
                    @Override
                    public void onCancel() {

                    }
                }).show();
    }

    private void toast(String text) {
        ToastUtils.setBgColor(ContextCompat.getColor(this, R.color.gray));
        ToastUtils.showShort(text);
    }
}
