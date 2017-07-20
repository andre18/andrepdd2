package com.andrebondar.andrepdd.screens.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.adapters.TestListViewAdapter;
import com.andrebondar.andrepdd.screens.activities.TestsActivity;
import com.andrebondar.andrepdd.entities.TestRulsEntity;

import java.util.ArrayList;

/**
 * Created by Andre on 23.01.2017.
 */

public class TestListFragment extends Fragment {

    private ListView listView;
    public static int position;

    private ArrayList<TestRulsEntity> testRulsEntities;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.test_list_fragment, null);

        testRulsEntities = new ArrayList<>();
        testRulsEntities.add(new TestRulsEntity(1, "Билет №1"));
        testRulsEntities.add(new TestRulsEntity(1, "Билет №2"));
        testRulsEntities.add(new TestRulsEntity(1, "Билет №3"));
        testRulsEntities.add(new TestRulsEntity(1, "Билет №4"));
        testRulsEntities.add(new TestRulsEntity(1, "Билет №5"));
        testRulsEntities.add(new TestRulsEntity(1, "Билет №6"));
        testRulsEntities.add(new TestRulsEntity(1, "Билет №7"));
        testRulsEntities.add(new TestRulsEntity(1, "Билет №8"));
        testRulsEntities.add(new TestRulsEntity(1, "Билет №9"));
        testRulsEntities.add(new TestRulsEntity(1, "Билет №10"));

        listView = (ListView) v.findViewById(R.id.test_list_fragment_list_view);

        listView.setAdapter(new TestListViewAdapter(TestListFragment.this, testRulsEntities));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TestListFragment.position = position;
                if (position == 0) startActivity(new Intent(v.getContext(), TestsActivity.class));
                if (position == 1) startActivity(new Intent(v.getContext(), TestsActivity.class));
                if (position == 2) startActivity(new Intent(v.getContext(), TestsActivity.class));
                if (position == 3) startActivity(new Intent(v.getContext(), TestsActivity.class));
                if (position == 4) startActivity(new Intent(v.getContext(), TestsActivity.class));
                if (position == 5) startActivity(new Intent(v.getContext(), TestsActivity.class));
                if (position == 6) startActivity(new Intent(v.getContext(), TestsActivity.class));
                if (position == 7) startActivity(new Intent(v.getContext(), TestsActivity.class));
                if (position == 8) startActivity(new Intent(v.getContext(), TestsActivity.class));
                if (position == 9) startActivity(new Intent(v.getContext(), TestsActivity.class));
//                startActivity(new Intent(v.getContext(), TestsActivity.class));
            }
        });

        return v;
    }
}
