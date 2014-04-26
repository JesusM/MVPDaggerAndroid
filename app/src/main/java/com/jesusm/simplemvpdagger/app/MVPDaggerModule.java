package com.jesusm.simplemvpdagger.app;

import android.app.Application;

import com.jesusm.simplemvpdagger.app.data.DataModule;
import com.jesusm.simplemvpdagger.app.ui.UIModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                DataModule.class,
                UIModule.class },
        injects = {
                MVPDaggerApp.class },
        library = true
)
public final class MVPDaggerModule {

    private final MVPDaggerApp MVPDaggerApp;

    public MVPDaggerModule(MVPDaggerApp MVPDaggerApp) {
        this.MVPDaggerApp = MVPDaggerApp;
    }

    @Provides
    @Singleton Application provideApplication() {
        return MVPDaggerApp;
    }

}
