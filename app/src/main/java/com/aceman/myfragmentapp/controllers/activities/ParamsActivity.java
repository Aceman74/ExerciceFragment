package com.aceman.myfragmentapp.controllers.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.aceman.myfragmentapp.R;
import com.aceman.myfragmentapp.controllers.fragments.DetailFragment;
import com.aceman.myfragmentapp.controllers.fragments.MainFragment;
import com.aceman.myfragmentapp.controllers.fragments.ParamsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aceman - on 06/03/2019.
 */

public class ParamsActivity extends AppCompatActivity {

     ParamsFragment paramsFragment;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_params);
        ButterKnife.bind(this);
        this.configureAndShowParamsFragment();
        this.configureToolbar();
    }
    private void configureAndShowParamsFragment(){
        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container

        paramsFragment = (ParamsFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_params);
        if (paramsFragment == null) {
            // B - Create new main fragment
            paramsFragment = new ParamsFragment();
            // C - Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_params, paramsFragment)
                    .commit();
        }
    }
    private void configureToolbar(){
        //Set the toolbar
        setSupportActionBar(toolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }
}
