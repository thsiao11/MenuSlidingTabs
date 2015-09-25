package com.zeeh.android.testslidingmenu.inner.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zeeh.android.testslidingmenu.R;

public class Tab1Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab1fragment, container, false);
        TextView testText = (TextView) view.findViewById(R.id.other_txt);
        testText.setText("Just Testing"+getClass().getSimpleName());
        return view;
    }
}
