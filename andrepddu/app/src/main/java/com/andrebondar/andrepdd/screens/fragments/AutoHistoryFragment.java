package com.andrebondar.andrepdd.screens.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.adapters.AutoHistoryAdapter;
import com.andrebondar.andrepdd.entities.CardViewEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 11.02.2017.
 */

public class AutoHistoryFragment extends Fragment {

    private CardView cardView;

    private ListView listView;
    private AutoHistoryAdapter mAdapter;

    private FragmentTransaction transaction;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.auto_history_fragment, null);

        ArrayList<CardViewEntity> myDataset = getDataset();

        listView = (ListView) v.findViewById(R.id.auto_history_fragment_recycle_view);

        mAdapter = new AutoHistoryAdapter(AutoHistoryFragment.this, myDataset);
        listView.setAdapter(mAdapter);

        return v;
    }

    public ArrayList<CardViewEntity> getDataset() {

        ArrayList<CardViewEntity> dataset = new ArrayList<>();
        dataset.add(new CardViewEntity(R.drawable.card_view_example, "Принцип работы Twin Spark"));
        dataset.add(new CardViewEntity(R.drawable.history_alter_fuel_1, "Обойдемся без нефти:\nальтернативные виды топлива"));
        dataset.add(new CardViewEntity(R.drawable.history_world_records_1, "Наперегонки с историей:\nмировые рекорды скорости авто"));
        dataset.add(new CardViewEntity(R.drawable.history_rolls_royce_1, "На волнах истории: развитие компании Rolls-Royce"));
        dataset.add(new CardViewEntity(R.drawable.history_hydrogen_engine_1, "Авто на водородном двигателе"));
        dataset.add(new CardViewEntity(R.drawable.history_flying_cars_1, "Технология будущего - летающие машины"));

        return dataset;
    }
}
