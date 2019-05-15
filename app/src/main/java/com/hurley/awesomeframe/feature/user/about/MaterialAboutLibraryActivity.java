package com.hurley.awesomeframe.feature.user.about;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.danielstone.materialaboutlibrary.ConvenienceBuilder;
import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutItemOnClickAction;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;
import com.hurley.awesomeframe.R;
import com.mikepenz.iconics.IconicsDrawable;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019-05-14 13:44
 *      github  : https://github.com/HurleyJames
 *      desc    : material-about-library框架页面
 * </pre>
 */
public class MaterialAboutLibraryActivity extends MaterialAboutActivity {

    @NonNull
    @Override
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {
        MaterialAboutCard.Builder appCard = new MaterialAboutCard.Builder();

        // 应用名
        appCard.addItem(new MaterialAboutTitleItem.Builder()
                .text(getString(R.string.app_name))
                .desc(getString(R.string.app_desc))
                .icon(R.mipmap.ic_launcher)
                .build());

        // 版本
        appCard.addItem(ConvenienceBuilder.createVersionActionItem(context,
                new IconicsDrawable(context)
                        .sizeDp(18),
                "Version",
                false));

        appCard.addItem(new MaterialAboutActionItem.Builder()
                .text("Changelog")
                .icon(new IconicsDrawable(context)
                        .sizeDp(18))
                .setOnClickAction(ConvenienceBuilder.createWebViewDialogOnClickAction(context,
                        "Releases", "", true, false))
                .build());

        appCard.addItem(new MaterialAboutActionItem.Builder()
                .text("Licenses")
                .icon(new IconicsDrawable(context)
                        .sizeDp(18))
                .setOnClickAction(() -> {

                })
                .build());

        MaterialAboutCard.Builder authorCard = new MaterialAboutCard.Builder();
        authorCard.title("Author");

        // 作者
        authorCard.addItem(new MaterialAboutActionItem.Builder()
                .text("Hurley")
                .subText("United Kingdom")
                .icon(new IconicsDrawable(context)
                        .sizeDp(18))
                .build());

        // Github
        authorCard.addItem(new MaterialAboutActionItem.Builder()
                .text("Star on GitHub")
                .icon(new IconicsDrawable(context)
                        .sizeDp(18))
                .setOnClickAction(ConvenienceBuilder.createWebsiteOnClickAction(context, Uri.parse("https://github.com/HurleyJames")))
                .build());

        MaterialAboutCard.Builder convenienceCard = new MaterialAboutCard.Builder();
        convenienceCard.title("Convenience");

        convenienceCard.addItem(ConvenienceBuilder.createWebsiteActionItem(context,
                new IconicsDrawable(context)
                        .sizeDp(18),
                "Visit Website",
                true,
                Uri.parse("hurley.fun")));

        convenienceCard.addItem(ConvenienceBuilder.createRateActionItem(context,
                new IconicsDrawable(context)
                        .sizeDp(18),
                "Rate this app",
                null
        ));

        convenienceCard.addItem(ConvenienceBuilder.createEmailItem(context,
                new IconicsDrawable(context)
                        .sizeDp(18),
                "Send an email",
                true,
                "1401682479@qq.com",
                "Question concerning AwesomeFrame"));

        return new MaterialAboutList(appCard.build(), authorCard.build(), convenienceCard.build());
    }

    @Nullable
    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.about);
    }
}
