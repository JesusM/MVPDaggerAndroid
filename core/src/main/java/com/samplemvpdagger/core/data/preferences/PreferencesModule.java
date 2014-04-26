package com.samplemvpdagger.core.data.preferences;


import com.samplemvpdagger.core.data.preferences.annotations.SampleString;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        complete = false,
        library = true
)
public class PreferencesModule {

    @Provides
    @Singleton
    @SampleString
    StringPreference provideSampleString(PreferencesWrapper preferences) {
        return new StringPreference(preferences, "sample_string", "value");
    }


}
