package com.andrebondar.andrepdd.adapters;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrebondar.andrepdd.Constants;
import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.entities.CardViewEntity;
import com.andrebondar.andrepdd.screens.fragments.AutoHistoryArticle;
import com.andrebondar.andrepdd.screens.fragments.AutoHistoryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 03.03.2017.
 */

public class AutoHistoryAdapter extends BaseAdapter {

    private List<CardViewEntity> mDataset;
    private AutoHistoryFragment autoHistoryFragment;

    private FragmentTransaction transaction;

    public AutoHistoryAdapter(AutoHistoryFragment autoHistoryFragment, ArrayList<CardViewEntity> mDataset) {
        this.mDataset = mDataset;
        this.autoHistoryFragment = autoHistoryFragment;
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        ViewHolder viewHolder;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(autoHistoryFragment.getContext());

            v = inflater.inflate(R.layout.auto_history_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mImageView = (ImageView) v.findViewById(R.id.auto_history_item_image);
            viewHolder.mTextView = (TextView) v.findViewById(R.id.auto_history_item_text);

            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        viewHolder.mImageView.setImageResource(mDataset.get(position).getImage());
        viewHolder.mTextView.setText(mDataset.get(position).getTitle());
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AutoHistoryArticle autoHistoryArticle = new AutoHistoryArticle();
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.CURRENT_CARD_VIEW, position);
                autoHistoryArticle.setArguments(bundle);
                transaction = autoHistoryFragment.getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main, autoHistoryArticle);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }

    public static class ViewHolder {

        public ImageView mImageView;
        public TextView mTextView;

//        public ViewHolder(View itemView) {
//            super(itemView);
//            mTextView = (TextView) itemView.findViewById(R.id.auto_history_item_text);
//        }
    }
}
