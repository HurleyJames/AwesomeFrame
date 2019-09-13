package com.hurley.awesomeframe.feature.user.about;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.hurley.awesomeframe.BuildConfig;
import com.hurley.awesomeframe.R;

import me.drakeet.multitype.Items;
import me.drakeet.support.about.AbsAboutActivity;
import me.drakeet.support.about.Card;
import me.drakeet.support.about.Category;
import me.drakeet.support.about.Contributor;
import me.drakeet.support.about.License;

import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_NO;
import static android.support.v7.app.AppCompatDelegate.MODE_NIGHT_YES;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-14 13:43
 *      github  : https://github.com/HurleyJames
 *      desc    : about-page框架页面
 * </pre>
 */
public class AboutPageActivity extends AbsAboutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onCreateHeader(@NonNull ImageView icon, @NonNull TextView slogan, @NonNull TextView version) {
        icon.setImageResource(R.mipmap.ic_logo);
        slogan.setText(getString(R.string.app_name));
        version.setText("v" + BuildConfig.VERSION_NAME);
    }

    @Override
    protected void onItemsCreated(@NonNull Items items) {
        items.add(new Category("介绍与帮助"));
        items.add(new Card(getString(R.string.app_desc)));

        items.add(new Category("开发者"));
        items.add(new Contributor(R.mipmap.ic_logo, "Hurley", "Junior", "hurley.fun"));

        items.add(new Category("开源协议"));
        items.add(new License("about-page", "drakeet", License.APACHE_2, "https://github.com/drakeet/about-page"));
        items.add(new License("MultiType", "drakeet", License.APACHE_2, "https://github.com/drakeet/MultiType"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        MenuItem dayNight = menu.findItem(R.id.menu_night_mode);
        dayNight.setChecked(AppCompatDelegate.getDefaultNightMode() == MODE_NIGHT_YES);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_night_mode) {
            menuItem.setChecked(!menuItem.isChecked());
            if (menuItem.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
            }
            getDelegate().applyDayNight();
        } else if (menuItem.getItemId() == android.R.id.home) {
            // 如果点击返回键，返回上一页面
            this.finish();
        }
        return true;
    }
}
