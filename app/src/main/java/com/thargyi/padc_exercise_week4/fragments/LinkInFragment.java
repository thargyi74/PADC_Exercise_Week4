package com.thargyi.padc_exercise_week4.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thargyi.padc_exercise_week4.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class LinkInFragment extends Fragment {

    public LinkInFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_linkin, container, false);
    }
}
