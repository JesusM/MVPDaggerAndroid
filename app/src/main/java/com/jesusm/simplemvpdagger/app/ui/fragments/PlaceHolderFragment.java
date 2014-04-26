package com.jesusm.simplemvpdagger.app.ui.fragments;

/**
 * Created by Jesus on 26/04/14.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.jesusm.simplemvpdagger.app.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceHolderFragment extends Fragment {

    @InjectView(R.id.editText)
    EditText stringPrefEdit;

    @InjectView(R.id.textView)
    TextView stringPrefValue;
    private PlaceHolderCallback listener;

    private PlaceHolderFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof PlaceHolderCallback) {
            listener = (PlaceHolderCallback) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listener.onViewCreated();
    }

    public void setString(String stringObtained) {
        stringPrefValue.setText(stringObtained);
    }

    @OnClick(R.id.button1)
    public void sendPrefString() {
        if (listener != null) {
            listener.sendPrefString(stringPrefEdit.getText().toString());
        }
    }

    public static PlaceHolderFragment newInstance() {
        return new PlaceHolderFragment();
    }

    public interface PlaceHolderCallback {
        public void sendPrefString(String newValue);

        void onViewCreated();
    }
}
