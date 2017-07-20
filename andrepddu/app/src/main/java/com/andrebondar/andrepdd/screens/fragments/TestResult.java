package com.andrebondar.andrepdd.screens.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.andrebondar.andrepdd.Constants;
import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.screens.fragments.Test;
import com.andrebondar.andrepdd.screens.fragments.TestHeader;

/**
 * Created by Andre on 26.01.2017.
 */

public class TestResult extends Fragment implements View.OnClickListener{

    private Button buttonRepeat, buttonCancel;
    private TextView textViewCongratulation, textViewRight, textViewWrong;

    private TestHeader testHeader;
    private FragmentTransaction transaction;

    private int trueAnsw, falseAnsw;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.test_result, null);

        textViewCongratulation = (TextView) v.findViewById(R.id.test_result_string);
        textViewRight = (TextView) v.findViewById(R.id.test_result_quantity_set_right);
        textViewWrong = (TextView) v.findViewById(R.id.test_result_quantity_set_wrong);

        Bundle bundle = getArguments();
        trueAnsw = bundle.getInt(Constants.ANSWERS);
        falseAnsw = 20 - trueAnsw;
        String strTrue = "" + trueAnsw;
        String strFalse = "" + falseAnsw;
        String exactly = "Exactly!";
        String youLose = "You lose";
        if (falseAnsw < 3) {
            textViewCongratulation.setText(exactly);
            textViewCongratulation.setTextColor(getResources().getColor(R.color.colorTextResultRight));
        } else {
            textViewCongratulation.setText(youLose);
            textViewCongratulation.setTextColor(getResources().getColor(R.color.colorTextResultWrong));
        }
        textViewRight.setText(strTrue);
        textViewWrong.setText(strFalse);

        buttonCancel = (Button) v.findViewById(R.id.test_result_button_cancel);
        buttonRepeat = (Button) v.findViewById(R.id.test_result_button_repeat);
        buttonRepeat.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_result_button_cancel:
                getActivity().finish();
                break;
            case R.id.test_result_button_repeat:
                testHeader = new TestHeader();
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.tests_activity, testHeader);
                transaction.commit();
                break;
        }
    }
}
