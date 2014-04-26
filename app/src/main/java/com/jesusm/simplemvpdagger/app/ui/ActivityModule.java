package com.jesusm.simplemvpdagger.app.ui;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.jesusm.simplemvpdagger.app.MVPDaggerModule;

import dagger.Module;
import dagger.Provides;

@Module(
        addsTo = MVPDaggerModule.class,
        injects = {
                //Here inject simple classes (that no need a presenter)
//                HomeActivity.class,
        },
        library = true
)
public class ActivityModule {

    private ActionBarActivity activity;

    public ActivityModule(ActionBarActivity activity) {
        this.activity = activity;
    }

    @Provides
    public ActionBar provideActionBar() {
        return activity.getSupportActionBar();
    }

    @Provides
    public Context provideContext() {
        return activity;
    }

    @Provides
    ActionBarActivity provideActivity() {
        return activity;
    }
}
