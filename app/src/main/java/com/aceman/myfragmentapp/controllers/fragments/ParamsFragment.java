package com.aceman.myfragmentapp.controllers.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aceman.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParamsFragment extends Fragment {


    public ParamsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_params, container, false);
    }

}
