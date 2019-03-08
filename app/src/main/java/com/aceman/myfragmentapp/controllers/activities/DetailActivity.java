package com.aceman.myfragmentapp.controllers.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.aceman.myfragmentapp.R;

import butterknife.BindView;

/**
 * Created by Aceman - on 06/03/2019.
 */

public class DetailActivity extends BaseActivity {

    // - Declare Toolbar
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseActivity newInstance() {
        return new DetailActivity();
    }

    @Override
    protected Toolbar getToolBar() {
        return toolbar;
    }

    @Override
    protected int getLayout() {
        return (R.layout.activity_detail);
    }

    @Override
    public void onResume() {
        super.onResume();
        // - Call update method here because we are sure that DetailFragment is visible
        this.updateDetailFragmentTextViewWithIntentTag();
    }
}

