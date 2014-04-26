package com.jesusm.simplemvpdagger.app;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;

public class MVPDaggerApp extends Application {
    private ObjectGraph objectGraph;

    public static MVPDaggerApp get(Context context) {
        return (MVPDaggerApp) context.getApplicationContext();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        buildObjectGraphAndInject();
    }


    public void buildObjectGraphAndInject() {
        objectGraph = ObjectGraph.create(Modules.list(this));
        inject(this);
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

    public ObjectGraph getApplicationGraph() {
        return objectGraph;
    }


}
