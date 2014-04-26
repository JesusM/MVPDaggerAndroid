package com.jesusm.simplemvpdagger.app.data;

import android.app.Application;
import android.content.SharedPreferences;

import com.samplemvpdagger.core.data.preferences.PreferencesModule;
import com.samplemvpdagger.core.data.preferences.PreferencesWrapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.MODE_PRIVATE;

@Module(
        includes = {PreferencesModule.class},
        complete = false,
        library = true
)
public final class DataModule {


    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application app) {
        return app.getSharedPreferences("mvpdaggersample", MODE_PRIVATE);
    }

    @Provides
    @Singleton
    PreferencesWrapper providePreferencesWrapper(SharedPreferences prefs) {
        return new PreferencesWrapperImpl(prefs);
    }


}
