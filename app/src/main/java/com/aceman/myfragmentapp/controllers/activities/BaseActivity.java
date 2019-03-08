package com.aceman.myfragmentapp.controllers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.aceman.myfragmentapp.R;
import com.aceman.myfragmentapp.controllers.fragments.DetailFragment;
import com.aceman.myfragmentapp.controllers.fragments.MainFragment;

import butterknife.ButterKnife;
import icepick.Icepick;
import icepick.State;

/**
 * Created by Aceman - on 06/03/2019.
 */

public abstract class BaseActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener {
    //  - Declare main fragment
    MainFragment mainFragment;
    //  - Declare detail fragment
    DetailFragment detailFragment;
    // - Icepick Usage
    @State
    int mButtonTag;

    // Force developer implement those methods
    protected abstract BaseActivity newInstance();

    protected abstract Toolbar getToolBar();

    protected abstract int getLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        Icepick.restoreInstanceState(this, savedInstanceState);
        this.configureToolbar();
        this.configureAndShowsFragment();
    }

    public void configureToolbar() {
        //Set the toolbar
        setSupportActionBar(getToolBar());
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        if (getLayout() != R.layout.activity_main)
            ab.setDisplayHomeAsUpEnabled(true);
    }

    public void configureAndShowsFragment() {
        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        switch (getLayout()) {
            case R.layout.activity_main:
                mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);
                detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

                if (mainFragment == null) {
                    // B - Create new main fragment
                    mainFragment = new MainFragment();
                    // C - Add it to FrameLayout container
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.frame_layout_main, mainFragment)
                            .commit();
                }
                //  If frame_layout_detail is detected ( tablet)
                if (detailFragment == null && findViewById(R.id.frame_layout_detail) != null) {
                    detailFragment = new DetailFragment();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.frame_layout_detail, detailFragment)
                            .commit();
                }
                break;
            case R.layout.activity_detail:
                detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);
                //  If frame_layout_detail is detected ( tablet)
                if (detailFragment == null && findViewById(R.id.frame_layout_detail) != null) {
                    detailFragment = new DetailFragment();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.frame_layout_detail, detailFragment)
                            .commit();
                }
                break;
        }
    }

    public void onButtonClicked(View view) {
        // 1 - Retrieve button tag
        int buttonTag = Integer.parseInt(view.getTag().toString());

        // 2 - Check if DetailFragment is visible (Tablet)
        if (detailFragment != null && detailFragment.isVisible()) {
            // 2.1 - TABLET : Update directly TextView
            detailFragment.updateTextView(buttonTag);
        } else {
            // 2.2 - SMARTPHONE : Pass tag to the new intent that will show DetailActivity (and so DetailFragment)
            Intent i = new Intent(this, DetailActivity.class);
            startActivity(i);
        }
    }

    // - Icepick Usage
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    public void updateDetailFragmentTextViewWithIntentTag() {
        // Update DetailFragment's TextView
        detailFragment.updateTextView(mButtonTag);
        // Bonus: title change
        switch (mButtonTag) {
            case 10:
                getSupportActionBar().setTitle("Happy Detail");
                break;
            case 20:
                getSupportActionBar().setTitle("Sad Detail");
                break;
            case 30:
                getSupportActionBar().setTitle("Congrats");
                break;
        }
    }
}
