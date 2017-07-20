package com.andrebondar.andrepdd.screens.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.andrebondar.andrepdd.Constants;
import com.andrebondar.andrepdd.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Andre on 09.03.2017.
 */

public class BookParagraphFragment extends Fragment {

    private WebView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.book_paragraph_fragment, null);

        Bundle bundle = getArguments();
        int position = bundle.getInt(Constants.CURRENT_PARAGRAPH);

        listView = (WebView) v.findViewById(R.id.book_paragraph_fragment_web_view);

        switch (position) {
            case 0:
                listView.loadData(getResources().getString(R.string.paragraph_1_1), "text/html; charset=UTF-8", null);
                break;
            case 1:
                listView.loadData(getResources().getString(R.string.paragraph_2), "text/html; charset=UTF-8", null);
                break;
            case 2:
                listView.loadData(getResources().getString(R.string.paragraph_3), "text/html; charset=UTF-8", null);
                break;
            case 3:
                listView.loadData(getResources().getString(R.string.paragraph_4), "text/html; charset=UTF-8", null);
                break;
            case 4:
                listView.loadData(getResources().getString(R.string.paragraph_5), "text/html; charset=UTF-8", null);
                break;
            case 5:
                listView.loadData(getResources().getString(R.string.paragraph_6), "text/html; charset=UTF-8", null);
                break;
            case 6:
                listView.loadData(getResources().getString(R.string.paragraph_7), "text/html; charset=UTF-8", null);
                break;
            case 7:
                listView.loadData(getResources().getString(R.string.paragraph_8), "text/html; charset=UTF-8", null);
                break;
            case 8:
                listView.loadData(getResources().getString(R.string.paragraph_9), "text/html; charset=UTF-8", null);
                break;
            case 9:
                listView.loadData(getResources().getString(R.string.paragraph_10), "text/html; charset=UTF-8", null);
                break;
            case 10:
                listView.loadData(getResources().getString(R.string.paragraph_11), "text/html; charset=UTF-8", null);
                break;
            case 11:
                listView.loadData(getResources().getString(R.string.paragraph_12), "text/html; charset=UTF-8", null);
                break;
            case 12:
                listView.loadData(getResources().getString(R.string.paragraph_13), "text/html; charset=UTF-8", null);
                break;
            case 13:
                listView.loadData(getResources().getString(R.string.paragraph_14), "text/html; charset=UTF-8", null);
                break;
            case 14:
                listView.loadData(getResources().getString(R.string.paragraph_15), "text/html; charset=UTF-8", null);
                break;
            case 15:
                listView.loadData(getResources().getString(R.string.paragraph_16), "text/html; charset=UTF-8", null);
                break;
            case 16:
                listView.loadData(getResources().getString(R.string.paragraph_17), "text/html; charset=UTF-8", null);
                break;
            case 17:
                listView.loadData(getResources().getString(R.string.paragraph_18), "text/html; charset=UTF-8", null);
                break;
            case 18:
                listView.loadData(getResources().getString(R.string.paragraph_19), "text/html; charset=UTF-8", null);
                break;
            case 19:
                listView.loadData(getResources().getString(R.string.paragraph_20), "text/html; charset=UTF-8", null);
                break;
            case 20:
                listView.loadData(getResources().getString(R.string.paragraph_21), "text/html; charset=UTF-8", null);
                break;
            case 21:
                listView.loadData(getResources().getString(R.string.paragraph_22), "text/html; charset=UTF-8", null);
                break;
            case 22:
                listView.loadData(getResources().getString(R.string.paragraph_23), "text/html; charset=UTF-8", null);
                break;
            case 23:
                listView.loadData(getResources().getString(R.string.paragraph_24), "text/html; charset=UTF-8", null);
                break;
            case 24:
                listView.loadData(getResources().getString(R.string.paragraph_25), "text/html; charset=UTF-8", null);
                break;
            case 25:
                listView.loadData(getResources().getString(R.string.paragraph_26), "text/html; charset=UTF-8", null);
                break;
            case 26:
                listView.loadData(getResources().getString(R.string.paragraph_27), "text/html; charset=UTF-8", null);
                break;
            case 27:
                listView.loadData(getResources().getString(R.string.paragraph_28), "text/html; charset=UTF-8", null);
                break;
            case 28:
                listView.loadData(getResources().getString(R.string.paragraph_29), "text/html; charset=UTF-8", null);
                break;
            case 29:
                listView.loadData(getResources().getString(R.string.paragraph_30), "text/html; charset=UTF-8", null);
                break;
            case 30:
                listView.loadData(getResources().getString(R.string.paragraph_31), "text/html; charset=UTF-8", null);
                break;
            case 31:
                listView.loadData(getResources().getString(R.string.paragraph_32), "text/html; charset=UTF-8", null);
                break;
            case 32:
                listView.loadData(getResources().getString(R.string.paragraph_33), "text/html; charset=UTF-8", null);
                break;
            case 33:
                listView.loadData(getResources().getString(R.string.paragraph_34), "text/html; charset=UTF-8", null);
                break;
        }

        return v;
    }
}