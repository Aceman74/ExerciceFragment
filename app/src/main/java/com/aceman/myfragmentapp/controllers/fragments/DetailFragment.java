package com.aceman.myfragmentapp.controllers.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aceman.myfragmentapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;
import icepick.State;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends BaseFragment {

    @BindView(R.id.fragment_detail_text_view) TextView textView;
    @State int buttonTag;

    // --------------
    // BASE METHODS
    // --------------

    @Override
    protected BaseFragment newInstance() { return new DetailFragment(); }

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_detail; }

    @Override
    protected void configureDesign() { }

    @Override
    protected void updateDesign() {
        this.updateTextView(this.buttonTag);
    }

    // --------------
    // UPDATE UI
    // --------------

    //Update TextView depending on TAG's button
    public void updateTextView(int tag){

        this.buttonTag = tag;

        switch (tag){
            case 10:
                this.textView.setText("You're a very good person !");
                break;
            case 20:
                this.textView.setText("It's the last season of GoT...");
                break;
            case 30:
                this.textView.setText("If you read this, then you made something similar ! GG");
                break;
            default:
                break;
        }
    }
}