package com.hurley.awesomeframe.feature.found.pick;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.data.local.pick.CityBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-11 14:07
 *      github  : https://github.com/HurleyJames
 *      desc    : Android-PickerView框架页面
 * </pre>
 */
public class AndroidPickViewActivity extends BaseActivity {

    @BindView(R.id.btn_time)
    Button mBtnTime;
    @BindView(R.id.btn_option)
    Button mBtnOption;
    @BindView(R.id.btn_city)
    Button mBtnCity;
    @BindView(R.id.btn_lunar)
    Button mBtnLunar;

    private TimePickerView mTimePicker, mLunarTimePicker;
    private OptionsPickerView mOptionsPicker;

    private ArrayList<CityBean> options1;
    private ArrayList<ArrayList<String>> options2;
    private ArrayList<ArrayList<ArrayList<String>>> options3;

    @Override
    protected int getLayoutId() {
        return R.layout.android_pick_view_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_android_pick_view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {
        setOptionData();

        initTimePicker();
        initLunarPicker();
        initOptionPicker();
    }

    @OnClick({R.id.btn_time, R.id.btn_lunar, R.id.btn_option, R.id.btn_city})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_time:
                if (mTimePicker != null) {
                    mTimePicker.show();
                }
                break;
            case R.id.btn_lunar:
                if (mLunarTimePicker != null) {
                    //设置为农历模式
                    mLunarTimePicker.setLunarCalendar(true);
                    mLunarTimePicker.show();
                }
                break;
            case R.id.btn_option:
                if (mOptionsPicker != null) {
                    mOptionsPicker.show();
                }
                break;
            case R.id.btn_city:

                break;
            default:
                break;
        }
    }

    /**
     * 初始化时间选择器
     */
    private void initTimePicker() {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(1900,1,1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2100,1,1);

        // 时间选择器，自定义
        mTimePicker = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                ToastUtils.showShort(TimeUtils.date2String(date, format));
            }
        }).setTitleText("时间选择器")
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .build();
    }

    /**
     * 初始化农历选择器
     */
    private void initLunarPicker() {
        // 系统当前时间
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(1990, 1, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2100, 1, 1);

        // 时间选择器，自定义
        mLunarTimePicker = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                ToastUtils.showShort(TimeUtils.date2String(date));
            }
        }).setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setType(new boolean[]{true, true, true, false, false, false})
                .build();
    }

    /**
     * 初始化选项选择器
     */
    private void initOptionPicker() {
        mOptionsPicker = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int option1, int option2, int option3, View v) {
                String option = options1.get(option1).getPickerViewText() + options2.get(option1).get(option2) + options3.get(option1).get(option2).get(option3);
                ToastUtils.showShort(option);
            }
        }).setTitleText("选项选择器")
                .setSelectOptions(0, 0, 0)
                .isRestoreItem(true)
                .build();
        mOptionsPicker.setPicker(options1, options2, options3);
    }

    /**
     * 设置选项选择器的数据
     */
    private void setOptionData() {
        options1 = new ArrayList<>();
        options2 = new ArrayList<>();
        options3 = new ArrayList<>();

        // 1级选择器
        options1.add(new CityBean(0, "上海市", "描述部分", "其他数据"));
        options1.add(new CityBean(1, "浙江省", "描述部分", "其他数据"));

        // 2级选择器
        ArrayList<String> options2Item1 = new ArrayList<>();
        options2Item1.add("静安区");
        options2Item1.add("徐汇区");
        options2Item1.add("宝山区");
        ArrayList<String> options2Item2 = new ArrayList<>();
        options2Item2.add("杭州市");
        options2Item2.add("绍兴市");
        options2Item2.add("衢州市");
        options2.add(options2Item1);
        options2.add(options2Item2);

        ArrayList<ArrayList<String>> options3Item1 = new ArrayList<>();
        ArrayList<String> options3Item1Item1 = new ArrayList<>();
        options3Item1Item1.add("静安寺");
        options3Item1Item1.add("南京西路");
        ArrayList<String> options3Item1Item2 = new ArrayList<>();
        options3Item1Item2.add("徐家汇");
        ArrayList<String> options3Item1Item3 = new ArrayList<>();
        options3Item1Item3.add("上海大学");
        options3Item1.add(options3Item1Item1);
        options3Item1.add(options3Item1Item2);
        options3Item1.add(options3Item1Item3);
        ArrayList<ArrayList<String>> options3Item2 = new ArrayList<>();
        ArrayList<String> options3Item2Item1 = new ArrayList<>();
        options3Item2Item1.add("上城区");
        options3Item2Item1.add("下城区");
        ArrayList<String> options3Item2Item2 = new ArrayList<>();
        options3Item2Item2.add("诸暨市");
        options3Item2Item2.add("柯桥区");
        ArrayList<String> options3Item2Item3 = new ArrayList<>();
        options3Item2Item3.add("衢江区");
        options3Item2Item3.add("江山市");
        options3Item2.add(options3Item2Item1);
        options3Item2.add(options3Item2Item2);
        options3Item2.add(options3Item2Item3);
        options3.add(options3Item1);
        options3.add(options3Item2);
    }
}
