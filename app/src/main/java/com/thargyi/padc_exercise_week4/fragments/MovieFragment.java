package com.thargyi.padc_exercise_week4.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thargyi.padc_exercise_week4.R;

/**
 * Created by Dell on 29-Jun-16.
 */
public class MovieFragment extends Fragment {
    public MovieFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_movie, container, false);
        return view;
    }
}
