package com.aceman.myfragmentapp.controllers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.aceman.myfragmentapp.R;

import butterknife.BindView;

/**
 * Created by Aceman - on 06/03/2019.
 */

public class MainActivity extends BaseActivity {

    // - Declare Toolbar
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseActivity newInstance() {
        return new MainActivity();
    }

    @Override
    protected Toolbar getToolBar() {
        return toolbar;
    }

    @Override
    protected int getLayout() {
        return (R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // - Inflate the menu and add it to the Toolbar
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // - Handle actions on menu items
        switch (item.getItemId()) {
            case R.id.menu_activity_main_params:
                startActivity(new Intent(MainActivity.this, ParamsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
