package com.hurley.awesomeframe.feature.user.setting;

import android.view.View;
import android.widget.Button;

import com.hurley.awesomeframe.R;
import com.hurley.awesomeframe.base.activity.BaseActivity;
import com.hurley.awesomeframe.widget.SettingBar;
import com.hurley.awesomeframe.widget.SwitchButton;
import com.kongzue.dialog.v3.BottomMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-14 13:16
 *      github  : https://github.com/HurleyJames
 *      desc    : 设置界面
 * </pre>
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.sb_auto_cache)
    SettingBar mSbAutoCache;
    @BindView(R.id.btn_auto_cache)
    SwitchButton mBtnAutoCache;
    @BindView(R.id.sb_clear_cache)
    SettingBar mSbClearCache;
    @BindView(R.id.sb_language)
    SettingBar mSbLanguage;
    @BindView(R.id.sb_night)
    SettingBar mSbNight;
    @BindView(R.id.btn_night)
    SwitchButton mBtnNight;
    @BindView(R.id.sb_theme)
    SettingBar mSbTheme;
    @BindView(R.id.sb_auto_update)
    SettingBar mSbAutoUpdate;
    @BindView(R.id.btn_auto_update)
    SwitchButton mBtnAutoUpdate;

    /**
     * 语言种类
     */
    List<String> languageList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.setting_activity;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_setting;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {
        languageList.add(getString(R.string.language_auto));
        languageList.add(getString(R.string.language_simplified));
        languageList.add(getString(R.string.language_traditional));
        languageList.add(getString(R.string.language_english));
    }

    @OnClick({R.id.sb_auto_cache, R.id.sb_clear_cache, R.id.sb_auto_update,  R.id.sb_language, R.id.sb_night, R.id.sb_theme})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sb_auto_cache:
                break;
            case R.id.sb_clear_cache:
                break;
            case R.id.sb_auto_update:
                break;
            case R.id.sb_language:
                //多语言
                BottomMenu.show(this, languageList, (text, index) -> {
                    mSbLanguage.setRightText(text);
                    //TODO 切换语言
                    //TODO 首选项储存选择
                });
                break;
            case R.id.sb_night:
                break;
            case R.id.sb_theme:
                break;
            default:
                break;
        }
    }
}
