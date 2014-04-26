package com.jesusm.simplemvpdagger.app.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.jesusm.simplemvpdagger.app.MVPDaggerApp;
import com.jesusm.simplemvpdagger.app.ui.ActivityModule;

import java.util.ArrayList;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Jesus on 26/04/14.
 */
public class BaseActivity extends ActionBarActivity {

    private ObjectGraph activityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MVPDaggerApp application = (MVPDaggerApp) getApplication();
        injectModules(application);

    }

    private void injectModules(MVPDaggerApp application) {
        activityGraph = application.getApplicationGraph().plus(getCombinedModules().toArray());
        activityGraph.inject(this);
    }

    public List<Object> getModules() {
        return new ArrayList<Object>();
    }

    private List<Object> getCombinedModules() {
        List<Object> modules = new ArrayList<Object>(getModules());
        modules.add(new ActivityModule(this));
        return modules;
    }
}
