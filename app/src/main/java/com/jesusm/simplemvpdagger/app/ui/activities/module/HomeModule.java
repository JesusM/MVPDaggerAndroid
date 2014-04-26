package com.jesusm.simplemvpdagger.app.ui.activities.module;

import com.jesusm.simplemvpdagger.app.ui.ActivityModule;
import com.jesusm.simplemvpdagger.app.ui.activities.HomeActivity;
import com.jesusm.simplemvpdagger.app.ui.presenters.HomePresenter;
import com.samplemvpdagger.core.data.preferences.StringPreference;
import com.samplemvpdagger.core.data.preferences.annotations.SampleString;

import dagger.Provides;

/**
 * Created by Jesus on 26/04/14.
 */
@dagger.Module(
        addsTo = ActivityModule.class,
        injects = {
                HomeActivity.class
        }, library = true
)
public class HomeModule {

    @Provides
    HomePresenter provideHomePresenter(
            @SampleString
            StringPreference stringPreference) {
        return new HomePresenter(stringPreference);
    }

}
