package com.andrebondar.andrepdd.screens.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.screens.fragments.Test;

/**
 * Created by Andre on 25.01.2017.
 */

public class TestHeader extends Fragment {

    private Button buttonToBegin;
    private FragmentTransaction fragmentTransaction;
    private Test test;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tests_header, null);

        buttonToBegin = (Button) v.findViewById(R.id.tests_header_button_to_begin);
        buttonToBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = new Test();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.tests_activity_layout_for_fragments, test);
                fragmentTransaction.commit();
            }
        });

        return v;
    }
}
