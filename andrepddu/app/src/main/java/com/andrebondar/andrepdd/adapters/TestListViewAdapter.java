package com.andrebondar.andrepdd.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.screens.fragments.TestListFragment;
import com.andrebondar.andrepdd.entities.TestRulsEntity;

import java.util.List;

/**
 * Created by Andre on 23.01.2017.
 */

public class TestListViewAdapter extends BaseAdapter {

    private List<TestRulsEntity> testRulsEntities;
    private TestListFragment testListFragment;

    public TestListViewAdapter(TestListFragment testListFragment, List<TestRulsEntity> testRulsEntities) {
        this.testRulsEntities = testRulsEntities;
        this.testListFragment = testListFragment;
    }

    @Override
    public int getCount() {
        return testRulsEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return testRulsEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        HolderView holder;

        if(row == null) {
            LayoutInflater inflater = LayoutInflater.from(testListFragment.getContext());
            row = inflater.inflate(R.layout.item_list_view_test, parent, false);
            holder = new TestListViewAdapter.HolderView();
            holder.imageView = (ImageView) row.findViewById(R.id.item_list_view_test_image_view);
            holder.textView = (TextView) row.findViewById(R.id.item_list_view_test_text_view_name);

            row.setTag(holder);
        } else {
            holder = (TestListViewAdapter.HolderView) convertView.getTag();
        }

        holder.textView.setText(testRulsEntities.get(position).getBilet());

        return row;
    }


    class HolderView {
        ImageView imageView;
        TextView textView;
    }
}
