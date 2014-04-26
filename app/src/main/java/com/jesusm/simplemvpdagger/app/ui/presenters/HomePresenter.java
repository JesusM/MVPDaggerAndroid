package com.jesusm.simplemvpdagger.app.ui.presenters;

import com.jesusm.simplemvpdagger.app.ui.activities.views.HomeView;
import com.samplemvpdagger.core.data.preferences.StringPreference;

import javax.inject.Inject;

/**
 * Created by Jesus on 26/04/14.
 */
public class HomePresenter {
    private StringPreference samplestring;


    public static final String TAG = HomePresenter.class.toString();
    private HomeView homeview;


    @Inject
    public HomePresenter(StringPreference samplestring) {
        this.samplestring = samplestring;
    }

    public void init(HomeView view) {
        this.homeview = view;
        getSampleString();
    }

    public void getSampleString(){
        String sample = samplestring.get();
        homeview.onStringObtained(sample);
    }


    public void updatePrefStrign(String newValue) {
        samplestring.set(newValue);
        homeview.onPrefUpdated();
        getSampleString();
    }
}
