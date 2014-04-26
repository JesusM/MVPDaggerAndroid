package com.jesusm.simplemvpdagger.app.ui.activities;

import android.os.Bundle;
import android.widget.Toast;

import com.jesusm.simplemvpdagger.app.R;
import com.jesusm.simplemvpdagger.app.ui.activities.module.HomeModule;
import com.jesusm.simplemvpdagger.app.ui.activities.views.HomeView;
import com.jesusm.simplemvpdagger.app.ui.fragments.PlaceHolderFragment;
import com.jesusm.simplemvpdagger.app.ui.presenters.HomePresenter;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


public class HomeActivity extends BaseActivity
        implements HomeView, PlaceHolderFragment.PlaceHolderCallback {


    @Inject
    HomePresenter homePresenter;
    private PlaceHolderFragment placeHolderFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (savedInstanceState == null) {
            placeHolderFragment = PlaceHolderFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, placeHolderFragment)
                    .commit();
        } else {
            placeHolderFragment =
                    (PlaceHolderFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        }

    }


    @Override
    public List<Object> getModules() {
        return Arrays.<Object>asList(new HomeModule());
    }

    @Override
    public void onStringObtained(String string) {
        placeHolderFragment.setString(string);
    }

    @Override
    public void onPrefUpdated() {
        Toast.makeText(getApplicationContext(), "String preference updated!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendPrefString(String newValue) {
        homePresenter.updatePrefStrign(newValue);
    }

    @Override
    public void onViewCreated() {
        homePresenter.init(this);
    }


}
