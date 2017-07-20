package com.andrebondar.andrepdd.screens.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.andrebondar.andrepdd.Constants;
import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.entities.AnswerEntity;
import com.andrebondar.andrepdd.entities.QuestionEntity;

import java.util.ArrayList;

/**
 * Created by Andre on 25.01.2017.
 */

public class Test extends Fragment implements View.OnClickListener {

    private final String TAG = Test.class.getSimpleName();

    private RadioGroup radioGroup;
    private RadioButton radioButtonOne, radioButtonTwo, radioButtonThree, radioButtonFour, radioButtonFive;
    private Button buttonNext;

    private FragmentTransaction transaction;
    private TestResult testResult;

    private TextView question;
    private ImageView imageView;

    private ArrayList<AnswerEntity> answerEntityArrayList;
    public ArrayList<AnswerEntity> answerEntityArrayListTrue;
    private ArrayList<QuestionEntity> questionEntityArrayList;

    private int checked = 0;

    private int currentQuestion;
    private int trueAnsw = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.test, null);

        question = (TextView) v.findViewById(R.id.test_text_view);

        imageView = (ImageView) v.findViewById(R.id.test_image_view);

        buttonNext = (Button) v.findViewById(R.id.test_button_next);

        radioGroup = (RadioGroup) v.findViewById(R.id.test_radio_group);
        radioButtonOne = (RadioButton) v.findViewById(R.id.test_radio_button_one);
        radioButtonTwo = (RadioButton) v.findViewById(R.id.test_radio_button_two);
        radioButtonThree = (RadioButton) v.findViewById(R.id.test_radio_button_three);
        radioButtonFour = (RadioButton) v.findViewById(R.id.test_radio_button_four);
        radioButtonFive = (RadioButton) v.findViewById(R.id.test_radio_button_five);

        //test 1
        currentQuestion = 0;
        if (TestListFragment.position == 0) {
            dataTest1();
            question.setText(R.string.question_1_1);
            imageView.setVisibility(View.INVISIBLE);
            radioButtonOne.setText(R.string.response_options_1_1_1);
            radioButtonTwo.setText(R.string.response_options_1_1_2);
            radioButtonThree.setText(R.string.response_options_1_1_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            Log.v(TAG, "currentQuestion = " + currentQuestion);
        }
        if (TestListFragment.position == 1) {
            dataTest2();
            question.setText(R.string.question_2_1);
            imageView.setVisibility(View.INVISIBLE);
            radioButtonOne.setText(R.string.response_options_2_1_1);
            radioButtonTwo.setText(R.string.response_options_2_1_2);
            radioButtonThree.setText(R.string.response_options_2_1_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
        }
        if (TestListFragment.position == 2) {
            dataTest3();
            question.setText(R.string.question_3_1);
            imageView.setVisibility(View.INVISIBLE);
            radioButtonOne.setText(R.string.response_options_3_1_1);
            radioButtonTwo.setText(R.string.response_options_3_1_2);
            radioButtonThree.setText(R.string.response_options_3_1_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
        }

        if (TestListFragment.position == 3) {
            dataTest4();
            question.setText(R.string.question_4_1);
            imageView.setVisibility(View.INVISIBLE);
            radioButtonOne.setText(R.string.response_options_4_1_1);
            radioButtonTwo.setText(R.string.response_options_4_1_2);
            radioButtonThree.setText(R.string.response_options_4_1_3);
            radioButtonFour.setText(R.string.response_options_4_1_4);
            radioButtonFive.setVisibility(View.GONE);
        }

        if (TestListFragment.position == 4) {
            dataTest5();
            question.setText(R.string.question_5_1);
            imageView.setVisibility(View.INVISIBLE);
            radioButtonOne.setText(R.string.response_options_5_1_1);
            radioButtonTwo.setText(R.string.response_options_5_1_2);
            radioButtonThree.setText(R.string.response_options_5_1_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
        }

        if (TestListFragment.position == 5) {
            dataTest6();
            question.setText(R.string.question_6_1);
            imageView.setVisibility(View.INVISIBLE);
            radioButtonOne.setText(R.string.response_options_6_1_1);
            radioButtonTwo.setText(R.string.response_options_6_1_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
        }

        if (TestListFragment.position == 6) {
            dataTest7();
            question.setText(R.string.question_7_1);
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im7_01);
            radioButtonOne.setText(R.string.response_options_7_1_1);
            radioButtonTwo.setText(R.string.response_options_7_1_2);
            radioButtonThree.setText(R.string.response_options_7_1_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
        }

        if (TestListFragment.position == 7) {
            dataTest8();
            question.setText(R.string.question_8_1);
            imageView.setVisibility(View.INVISIBLE);
            radioButtonOne.setText(R.string.response_options_8_1_1);
            radioButtonTwo.setText(R.string.response_options_8_1_2);
            radioButtonThree.setText(R.string.response_options_8_1_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
        }

        if (TestListFragment.position == 8) {
            dataTest9();
            question.setText(R.string.question_9_1);
            imageView.setVisibility(View.INVISIBLE);
            radioButtonOne.setText(R.string.response_options_9_1_1);
            radioButtonTwo.setText(R.string.response_options_9_1_2);
            radioButtonThree.setText(R.string.response_options_9_1_3);
            radioButtonFour.setText(R.string.response_options_9_1_4);
            radioButtonFive.setVisibility(View.GONE);
        }

        if (TestListFragment.position == 9) {
            dataTest10();
            question.setText(R.string.question_10_1);
            imageView.setVisibility(View.INVISIBLE);
            radioButtonOne.setText(R.string.response_options_10_1_1);
            radioButtonTwo.setText(R.string.response_options_10_1_2);
            radioButtonThree.setText(R.string.response_options_10_1_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
        }

        radioButtonOne.setOnClickListener(this);
        radioButtonTwo.setOnClickListener(this);
        radioButtonThree.setOnClickListener(this);
        radioButtonFour.setOnClickListener(this);
        radioButtonFive.setOnClickListener(this);
        buttonNext.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_radio_button_one:
                checked = 1;
                break;
            case R.id.test_radio_button_two:
                checked = 2;
                break;
            case R.id.test_radio_button_three:
                checked = 3;
                break;
            case R.id.test_radio_button_four:
                checked = 4;
                break;
            case R.id.test_radio_button_five:
                checked = 5;
                break;
            case R.id.test_button_next:
                if (radioButtonOne.isChecked() || radioButtonTwo.isChecked() || radioButtonThree.isChecked() || radioButtonFour.isChecked() || radioButtonFive.isChecked()) {
                    counter(checked);
                    if (TestListFragment.position == 0 && currentQuestion < 19) {
                        firstTestAnswersListener();
                        break;
                    }

                    if (TestListFragment.position == 1 && currentQuestion < 19) {
                        secondTestAnswersListener();
                        break;
                    }

                    if (TestListFragment.position == 2 && currentQuestion < 19) {
                        thirdTestAnswersListener();
                        break;
                    }

                    if (TestListFragment.position == 3 && currentQuestion < 19) {
                        fourthTestAnswersListener();
                        break;
                    }

                    if (TestListFragment.position == 4 && currentQuestion < 19) {
                        fifthTestAnswersListener();
                        break;
                    }

                    if (TestListFragment.position == 5 && currentQuestion < 19) {
                        sixthTestAnswersListener();
                        break;
                    }

                    if (TestListFragment.position == 6 && currentQuestion < 19) {
                        seventhTestAnswersListener();
                        break;
                    }

                    if (TestListFragment.position == 7 && currentQuestion < 19) {
                        eghthTestAnswersListener();
                        break;
                    }

                    if (TestListFragment.position == 8 && currentQuestion < 19) {
                        ninthTestAnswersListener();
                        break;
                    }

                    if (TestListFragment.position == 9 && currentQuestion < 19) {
                        tenthTestAnswersListener();
                        break;
                    }

                    if (currentQuestion == 19) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(Constants.ANSWERS, trueAnsw);
                        testResult = new TestResult();
                        testResult.setArguments(bundle);
                        transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.tests_activity_layout_for_fragments, testResult);
                        transaction.commit();
                    }
                }
                break;
        }
    }

    //проверка - какой вариант ответа был выбран
    private void counter(int i) {
        if (i == questionEntityArrayList.get(currentQuestion).getTrueAnswers().get(currentQuestion).getId()) {
            trueAnsw++;
        }
    }

    //прохождение теста (сетим вопросы и варианты ответов)
    private void firstTestAnswersListener() {
        //test 2
        String strQuestion = question.getText().toString();
        String strResource = getResources().getString(R.string.question_1_1);
        radioGroup.clearCheck();
        if (strQuestion.equals(strResource)) {
            question.setText(R.string.question_1_2);
            radioButtonOne.setText(R.string.response_options_1_2_1);
            radioButtonTwo.setText(R.string.response_options_1_2_2);
            radioButtonThree.setText(R.string.response_options_1_2_3);
            currentQuestion++;
            Log.v(TAG, "currentQuestion = " + currentQuestion);
        }

        //test 3
        strResource = getResources().getString(R.string.question_1_2);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im03);
            question.setText(R.string.question_1_3);
            radioButtonOne.setText(R.string.response_options_1_3_1);
            radioButtonTwo.setText(R.string.response_options_1_3_2);
            radioButtonThree.setText(R.string.response_options_1_3_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_1_3_4);
            currentQuestion++;
            Log.v(TAG, "currentQuestion = " + currentQuestion);
        }

        //test 4
        strResource = getResources().getString(R.string.question_1_3);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_1_4);
            radioButtonOne.setText(null);
            radioButtonTwo.setText(null);
            radioButtonThree.setText(null);
            radioButtonFour.setText(null);
            radioButtonOne.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im04_01), null, null, null);
            radioButtonTwo.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im04_02), null, null, null);
            radioButtonThree.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im04_03), null, null, null);
            radioButtonFour.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im04_04), null, null, null);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im04_05), null, null, null);
            currentQuestion++;
            Log.v(TAG, "currentQuestion = " + currentQuestion);
        }

        //test 5
        strResource = getResources().getString(R.string.question_1_4);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im05);
            question.setText(R.string.question_1_5);
            radioButtonOne.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonTwo.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonThree.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonFour.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonFive.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonOne.setText(R.string.response_options_1_5_1);
            radioButtonTwo.setText(R.string.response_options_1_5_2);
            radioButtonThree.setText(R.string.response_options_1_5_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
            Log.v(TAG, "currentQuestion = " + currentQuestion);
        }

        //test 6
        strResource = getResources().getString(R.string.question_1_5);
        if (strQuestion.equals(strResource)) {
            imageView.setImageResource(R.drawable.im06);
            question.setText(R.string.question_1_6);
            radioButtonOne.setText(R.string.response_options_1_6_1);
            radioButtonTwo.setText(R.string.response_options_1_6_2);
            radioButtonThree.setText(R.string.response_options_1_6_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_1_6_4);
            currentQuestion++;
        }

        //test 7
        strResource = getResources().getString(R.string.question_1_6);
        if (strQuestion.equals(strResource)) {
            imageView.setImageResource(R.drawable.im07);
            question.setText(R.string.question_1_7);
            radioButtonOne.setText(R.string.response_options_1_7_1);
            radioButtonTwo.setText(R.string.response_options_1_7_2);
            radioButtonThree.setText(R.string.response_options_1_7_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 8
        strResource = getResources().getString(R.string.question_1_7);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_1_8);
            radioButtonOne.setText(R.string.response_options_1_8_1);
            radioButtonTwo.setText(R.string.response_options_1_8_2);
            radioButtonThree.setText(R.string.response_options_1_8_3);
            currentQuestion++;
        }

        //test 9
        strResource = getResources().getString(R.string.question_1_8);
        if (strQuestion.equals(strResource)) {
            question.setText(R.string.question_1_9);
            radioButtonOne.setText(R.string.response_options_1_9_1);
            radioButtonTwo.setText(R.string.response_options_1_9_2);
            radioButtonThree.setText(R.string.response_options_1_9_3);
            currentQuestion++;
        }

        //test 10
        strResource = getResources().getString(R.string.question_1_9);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im10);
            question.setText(R.string.question_1_10);
            radioButtonOne.setText(R.string.response_options_1_10_1);
            radioButtonTwo.setText(R.string.response_options_1_10_2);
            radioButtonThree.setText(R.string.response_options_1_10_3);
            currentQuestion++;
        }

        //test 11
        strResource = getResources().getString(R.string.question_1_10);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_1_11);
            radioButtonOne.setText(R.string.response_options_1_11_1);
            radioButtonTwo.setText(R.string.response_options_1_11_2);
            radioButtonThree.setText(R.string.response_options_1_11_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_1_11_4);
            currentQuestion++;
        }

        //test 12
        strResource = getResources().getString(R.string.question_1_11);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im12);
            question.setText(R.string.question_1_12);
            radioButtonOne.setText(R.string.response_options_1_12_1);
            radioButtonTwo.setText(R.string.response_options_1_12_2);
            radioButtonThree.setText(R.string.response_options_1_12_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 13
        strResource = getResources().getString(R.string.question_1_12);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_1_13);
            radioButtonOne.setText(R.string.response_options_1_13_1);
            radioButtonTwo.setText(R.string.response_options_1_13_2);
            radioButtonThree.setText(R.string.response_options_1_13_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_1_13_4);
            currentQuestion++;
        }

        //test 14
        strResource = getResources().getString(R.string.question_1_13);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im14);
            question.setText(R.string.question_1_14);
            radioButtonOne.setText(R.string.response_options_1_14_1);
            radioButtonTwo.setText(R.string.response_options_1_14_2);
            radioButtonThree.setText(R.string.response_options_1_14_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 15
        strResource = getResources().getString(R.string.question_1_14);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_1_15);
            radioButtonOne.setText(R.string.response_options_1_15_1);
            radioButtonTwo.setText(R.string.response_options_1_15_2);
            radioButtonThree.setText(R.string.response_options_1_15_3);
            currentQuestion++;
        }

        //test 16
        strResource = getResources().getString(R.string.question_1_15);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im16);
            question.setText(R.string.question_1_16);
            radioButtonOne.setText(R.string.response_options_1_16_1);
            radioButtonTwo.setText(R.string.response_options_1_16_2);
            radioButtonThree.setText(R.string.response_options_1_16_3);
            currentQuestion++;
        }

        //test 17
        strResource = getResources().getString(R.string.question_1_16);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_1_17);
            radioButtonOne.setText(R.string.response_options_1_17_1);
            radioButtonTwo.setText(R.string.response_options_1_17_2);
            radioButtonThree.setText(R.string.response_options_1_17_3);
            currentQuestion++;
        }

        //test 18
        strResource = getResources().getString(R.string.question_1_17);
        if (strQuestion.equals(strResource)) {
            question.setText(R.string.question_1_18);
            radioButtonOne.setText(R.string.response_options_1_18_1);
            radioButtonTwo.setText(R.string.response_options_1_18_2);
            radioButtonThree.setText(R.string.response_options_1_18_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_1_18_4);
            currentQuestion++;
        }

        //test 19
        strResource = getResources().getString(R.string.question_1_18);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im19);
            question.setText(R.string.question_1_19);
            radioButtonOne.setText(R.string.response_options_1_19_1);
            radioButtonTwo.setText(R.string.response_options_1_19_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 20
        strResource = getResources().getString(R.string.question_1_19);
        if (strQuestion.equals(strResource)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_1_20);
            radioButtonOne.setText(R.string.response_options_1_20_1);
            radioButtonTwo.setText(R.string.response_options_1_20_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_1_20_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_1_20_4);
            currentQuestion++;
        }
    }

    private void secondTestAnswersListener() {
        //test 2
        String s = question.getText().toString();
        String strResours = getResources().getString(R.string.question_2_1);
        radioGroup.clearCheck();
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im2_2);
            question.setText(R.string.question_2_2);
            radioButtonOne.setText(R.string.response_options_2_2_1);
            radioButtonTwo.setText(R.string.response_options_2_2_2);
            radioButtonThree.setText(R.string.response_options_2_2_3);
            currentQuestion++;
            //break;
        }

        //test 3
        strResours = getResources().getString(R.string.question_2_2);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im2_3);
            question.setText(R.string.question_2_3);
            radioButtonOne.setText(R.string.response_options_2_3_1);
            radioButtonTwo.setText(R.string.response_options_2_3_2);
            radioButtonThree.setText(R.string.response_options_2_3_3);
            currentQuestion++;
        }

        //test 4
        strResours = getResources().getString(R.string.question_2_3);
        if (s.equals(strResours)) {
            question.setText(R.string.question_2_4);
            imageView.setImageResource(R.drawable.im2_4);
            question.setText(R.string.question_2_4);
            radioButtonOne.setText(R.string.response_options_2_4_1);
            radioButtonTwo.setText(R.string.response_options_2_4_2);
            radioButtonThree.setText(R.string.response_options_2_4_3);
            currentQuestion++;
        }

        //test 5
        strResours = getResources().getString(R.string.question_2_4);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im2_5);
            question.setText(R.string.question_2_5);
            radioButtonOne.setText(R.string.response_options_2_5_1);
            radioButtonTwo.setText(R.string.response_options_2_5_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 6
        strResours = getResources().getString(R.string.question_2_5);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im2_6);
            question.setText(R.string.question_2_6);
            radioButtonOne.setText(R.string.response_options_2_6_1);
            radioButtonTwo.setText(R.string.response_options_2_6_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_2_6_3);
            currentQuestion++;
        }

        //test 7
        strResours = getResources().getString(R.string.question_2_6);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im2_7);
            question.setText(R.string.question_2_7);
            radioButtonOne.setText(R.string.response_options_2_7_1);
            radioButtonTwo.setText(R.string.response_options_2_7_2);
            radioButtonThree.setText(R.string.response_options_2_7_3);
            currentQuestion++;
        }

        //test 8
        strResours = getResources().getString(R.string.question_2_7);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im2_8);
            question.setText(R.string.question_2_8);
            radioButtonOne.setText(R.string.response_options_2_8_1);
            radioButtonTwo.setText(R.string.response_options_2_8_2);
            radioButtonThree.setText(R.string.response_options_2_8_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_2_8_4);
            currentQuestion++;
        }

        //test 9
        strResours = getResources().getString(R.string.question_2_8);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_2_9);
            radioButtonOne.setText(R.string.response_options_2_9_1);
            radioButtonTwo.setText(R.string.response_options_2_9_2);
            radioButtonThree.setText(R.string.response_options_2_9_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 10
        strResours = getResources().getString(R.string.question_2_9);
        if (s.equals(strResours)) {
            question.setText(R.string.question_2_10);
            radioButtonOne.setText(R.string.response_options_2_10_1);
            radioButtonTwo.setText(R.string.response_options_2_10_2);
            radioButtonThree.setText(R.string.response_options_2_10_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_2_10_4);
            currentQuestion++;
        }

        //test 11
        strResours = getResources().getString(R.string.question_2_10);
        if (s.equals(strResours)) {
            question.setText(R.string.question_2_11);
            radioButtonOne.setText(R.string.response_options_2_11_1);
            radioButtonTwo.setText(R.string.response_options_2_11_2);
            radioButtonThree.setText(R.string.response_options_2_11_3);
            radioButtonFour.setText(R.string.response_options_2_11_4);
            currentQuestion++;
        }

        //test 12
        strResours = getResources().getString(R.string.question_2_11);
        if (s.equals(strResours)) {
            question.setText(R.string.question_2_12);
            radioButtonOne.setText(R.string.response_options_2_12_1);
            radioButtonTwo.setText(R.string.response_options_2_12_2);
            radioButtonThree.setText(R.string.response_options_2_12_3);
            radioButtonFour.setText(R.string.response_options_2_12_4);
            currentQuestion++;
        }

        //test 13
        strResours = getResources().getString(R.string.question_2_12);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_2_13);
            radioButtonOne.setText(R.string.response_options_2_13_1);
            radioButtonTwo.setText(R.string.response_options_2_13_2);
            radioButtonThree.setText(R.string.response_options_2_13_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 14
        strResours = getResources().getString(R.string.question_2_13);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im2_14);
            question.setText(R.string.question_2_14);
            radioButtonOne.setText(R.string.response_options_2_14_1);
            radioButtonTwo.setText(R.string.response_options_2_14_2);
            radioButtonThree.setText(R.string.response_options_2_14_3);
            currentQuestion++;
        }

        //test 15
        strResours = getResources().getString(R.string.question_2_14);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im2_15);
            question.setText(R.string.question_2_15);
            radioButtonOne.setText(R.string.response_options_2_15_1);
            radioButtonTwo.setText(R.string.response_options_2_15_2);
            radioButtonThree.setText(R.string.response_options_2_15_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_2_15_4);
            currentQuestion++;
        }

        //test 16
        strResours = getResources().getString(R.string.question_2_15);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im2_16);
            question.setText(R.string.question_2_16);
            radioButtonOne.setText(R.string.response_options_2_16_1);
            radioButtonTwo.setText(R.string.response_options_2_16_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 17
        strResours = getResources().getString(R.string.question_2_16);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im2_17);
            question.setText(R.string.question_2_17);
            radioButtonOne.setText(R.string.response_options_2_17_1);
            radioButtonTwo.setText(R.string.response_options_2_17_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_2_17_3);
            currentQuestion++;
        }

        //test 18
        strResours = getResources().getString(R.string.question_2_17);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_2_18);
            radioButtonOne.setText(R.string.response_options_2_18_1);
            radioButtonTwo.setText(R.string.response_options_2_18_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 19
        strResours = getResources().getString(R.string.question_2_18);
        if (s.equals(strResours)) {
            question.setText(R.string.question_2_19);
            radioButtonOne.setText(R.string.response_options_2_19_1);
            radioButtonTwo.setText(R.string.response_options_2_19_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_2_19_3);
            currentQuestion++;
        }

        //test 20
        strResours = getResources().getString(R.string.question_2_19);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im2_20);
            question.setText(R.string.question_2_20);
            radioButtonOne.setText(R.string.response_options_2_20_1);
            radioButtonTwo.setText(R.string.response_options_2_20_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }
    }

    private void thirdTestAnswersListener() {
        //test 2
        String s = question.getText().toString();
        String strResours = getResources().getString(R.string.question_3_1);
        radioGroup.clearCheck();
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im3_02);
            question.setText(R.string.question_3_2);
            radioButtonOne.setText(R.string.response_options_3_2_1);
            radioButtonTwo.setText(R.string.response_options_3_2_2);
            radioButtonThree.setText(R.string.response_options_3_2_3);
            currentQuestion++;
            //break;
        }

        //test 3
        strResours = getResources().getString(R.string.question_3_2);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im3_03);
            question.setText(R.string.question_3_3);
            radioButtonOne.setText(R.string.response_options_3_3_1);
            radioButtonTwo.setText(R.string.response_options_3_3_2);
            radioButtonThree.setText(R.string.response_options_3_3_3);
            currentQuestion++;
        }

        //test 4
        strResours = getResources().getString(R.string.question_3_3);
        if (s.equals(strResours)) {
            question.setText(R.string.question_3_4);
            imageView.setImageResource(R.drawable.im3_04);
            question.setText(R.string.question_3_4);
            radioButtonOne.setText(R.string.response_options_3_4_1);
            radioButtonTwo.setText(R.string.response_options_3_4_2);
            radioButtonThree.setText(R.string.response_options_3_4_3);
            currentQuestion++;
        }

        //test 5
        strResours = getResources().getString(R.string.question_3_4);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im3_05);
            question.setText(R.string.question_3_5);
            radioButtonOne.setText(R.string.response_options_3_5_1);
            radioButtonTwo.setText(R.string.response_options_3_5_2);
            radioButtonThree.setText(R.string.response_options_3_5_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 6
        strResours = getResources().getString(R.string.question_3_5);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_3_6);
            radioButtonOne.setText(R.string.response_options_3_6_1);
            radioButtonTwo.setText(R.string.response_options_3_6_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_3_6_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_3_6_4);
            currentQuestion++;
        }

        //test 7
        strResours = getResources().getString(R.string.question_3_6);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im3_07);
            question.setText(R.string.question_3_7);
            radioButtonOne.setText(R.string.response_options_3_7_1);
            radioButtonTwo.setText(R.string.response_options_3_7_2);
            radioButtonThree.setText(R.string.response_options_3_7_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 8
        strResours = getResources().getString(R.string.question_3_7);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_3_8);
            radioButtonOne.setText(R.string.response_options_3_8_1);
            radioButtonTwo.setText(R.string.response_options_3_8_2);
            radioButtonThree.setText(R.string.response_options_3_8_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_3_8_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_3_8_5);
            currentQuestion++;
        }

        //test 9
        strResours = getResources().getString(R.string.question_3_8);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im3_09);
            question.setText(R.string.question_3_9);
            radioButtonOne.setText(R.string.response_options_3_9_1);
            radioButtonTwo.setText(R.string.response_options_3_9_2);
            radioButtonThree.setText(R.string.response_options_3_9_3);
            radioButtonFour.setText(R.string.response_options_3_9_4);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 10
        strResours = getResources().getString(R.string.question_3_9);
        if (s.equals(strResours)) {
            question.setText(R.string.question_3_10);
            radioButtonOne.setText(R.string.response_options_3_10_1);
            radioButtonTwo.setText(R.string.response_options_3_10_2);
            radioButtonThree.setText(R.string.response_options_3_10_3);
            radioButtonFour.setText(R.string.response_options_3_10_4);
            currentQuestion++;
        }

        //test 11
        strResours = getResources().getString(R.string.question_3_10);
        if (s.equals(strResours)) {
            question.setText(R.string.question_3_11);
            radioButtonOne.setText(R.string.response_options_3_11_1);
            radioButtonTwo.setText(R.string.response_options_3_11_2);
            radioButtonThree.setText(R.string.response_options_3_11_3);
            radioButtonFour.setText(R.string.response_options_3_11_4);
            currentQuestion++;
        }

        //test 12
        strResours = getResources().getString(R.string.question_3_11);
        if (s.equals(strResours)) {
            question.setText(R.string.question_3_12);
            radioButtonOne.setText(R.string.response_options_3_12_1);
            radioButtonTwo.setText(R.string.response_options_3_12_2);
            radioButtonThree.setText(R.string.response_options_3_12_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 13
        strResours = getResources().getString(R.string.question_3_12);
        if (s.equals(strResours)) {
            //imageView.setVisibility(View.GONE);
            question.setText(R.string.question_3_13);
            radioButtonOne.setText(R.string.response_options_3_13_1);
            radioButtonTwo.setText(R.string.response_options_3_13_2);
            radioButtonThree.setText(R.string.response_options_3_13_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_3_13_4);
            currentQuestion++;
        }

        //test 14
        strResours = getResources().getString(R.string.question_3_13);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im3_14);
            question.setText(R.string.question_3_14);
            radioButtonOne.setText(R.string.response_options_3_14_1);
            radioButtonTwo.setText(R.string.response_options_3_14_2);
            radioButtonThree.setText(R.string.response_options_3_14_3);
            currentQuestion++;
        }

        //test 15
        strResours = getResources().getString(R.string.question_3_14);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_3_15);
            radioButtonOne.setText(R.string.response_options_3_15_1);
            radioButtonTwo.setText(R.string.response_options_3_15_2);
            radioButtonThree.setText(R.string.response_options_3_15_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 16
        strResours = getResources().getString(R.string.question_3_15);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im3_16);
            question.setText(R.string.question_3_16);
            radioButtonOne.setText(R.string.response_options_3_16_1);
            radioButtonTwo.setText(R.string.response_options_3_16_2);
            radioButtonThree.setText(R.string.response_options_3_16_3);
            //radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 17
        strResours = getResources().getString(R.string.question_3_16);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_3_17);
            radioButtonOne.setText(R.string.response_options_3_17_1);
            radioButtonTwo.setText(R.string.response_options_3_17_2);
            radioButtonThree.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 18
        strResours = getResources().getString(R.string.question_3_17);
        if (s.equals(strResours)) {
            //imageView.setVisibility(View.GONE);
            question.setText(R.string.question_3_18);
            radioButtonOne.setText(R.string.response_options_3_18_1);
            radioButtonTwo.setText(R.string.response_options_3_18_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonTwo.setText(R.string.response_options_3_18_3);
            currentQuestion++;
        }

        //test 19
        strResours = getResources().getString(R.string.question_3_18);
        if (s.equals(strResours)) {
            question.setText(R.string.question_3_19);
            radioButtonOne.setText(R.string.response_options_3_19_1);
            radioButtonTwo.setText(R.string.response_options_3_19_2);
            //radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_3_19_3);
            currentQuestion++;
        }

        //test 20
        strResours = getResources().getString(R.string.question_3_19);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im3_20);
            question.setText(R.string.question_3_20);
            radioButtonOne.setText(R.string.response_options_3_20_1);
            radioButtonTwo.setText(R.string.response_options_3_20_2);
            radioButtonThree.setText(R.string.response_options_3_20_3);
            currentQuestion++;
        }
    }

    private void fourthTestAnswersListener() {
        //test 2
        String s = question.getText().toString();
        String strResours = getResources().getString(R.string.question_4_1);
        radioGroup.clearCheck();
        if (s.equals(strResours)) {
            question.setText(R.string.question_4_2);
            radioButtonOne.setText(R.string.response_options_4_2_1);
            radioButtonTwo.setText(R.string.response_options_4_2_2);
            radioButtonThree.setText(R.string.response_options_4_2_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
            //break;
        }

        //test 3
        strResours = getResources().getString(R.string.question_4_2);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im4_03);
            question.setText(R.string.question_4_3);
            radioButtonOne.setText(R.string.response_options_4_3_1);
            radioButtonTwo.setText(R.string.response_options_4_3_2);
            radioButtonThree.setText(R.string.response_options_4_3_3);
            currentQuestion++;
        }

        //test 4
        strResours = getResources().getString(R.string.question_4_3);
        if (s.equals(strResours)) {
            question.setText(R.string.question_4_4);
            imageView.setImageResource(R.drawable.im4_04);
            question.setText(R.string.question_4_4);
            radioButtonOne.setText(R.string.response_options_4_4_1);
            radioButtonTwo.setText(R.string.response_options_4_4_2);
            radioButtonThree.setText(R.string.response_options_4_4_3);
            currentQuestion++;
        }

        //test 5
        strResours = getResources().getString(R.string.question_4_4);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_4_5);
            radioButtonOne.setText(R.string.response_options_4_5_1);
            radioButtonTwo.setText(R.string.response_options_4_5_2);
            radioButtonThree.setText(R.string.response_options_4_5_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_4_5_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_4_5_5);
            currentQuestion++;
        }

        //test 6
        strResours = getResources().getString(R.string.question_4_5);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_4_6);
            radioButtonOne.setText(R.string.response_options_4_6_1);
            radioButtonTwo.setText(R.string.response_options_4_6_2);
            radioButtonThree.setText(R.string.response_options_4_6_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 7
        strResours = getResources().getString(R.string.question_4_6);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im4_07);
            question.setText(R.string.question_4_7);
            radioButtonOne.setText(R.string.response_options_4_7_1);
            radioButtonTwo.setText(R.string.response_options_4_7_2);
            radioButtonThree.setText(R.string.response_options_4_7_3);
            currentQuestion++;
        }

        //test 8
        strResours = getResources().getString(R.string.question_4_7);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_4_8);
            radioButtonOne.setText(R.string.response_options_4_8_1);
            radioButtonTwo.setText(R.string.response_options_4_8_2);
            radioButtonThree.setText(R.string.response_options_4_8_3);
            currentQuestion++;
        }

        //test 9
        strResours = getResources().getString(R.string.question_4_8);
        if (s.equals(strResours)) {
            question.setText(R.string.question_4_9);
            radioButtonOne.setText(R.string.response_options_4_9_1);
            radioButtonTwo.setText(R.string.response_options_4_9_2);
            radioButtonThree.setText(R.string.response_options_4_9_3);
            radioButtonFour.setText(R.string.response_options_4_9_4);
            currentQuestion++;
        }

        //test 10
        strResours = getResources().getString(R.string.question_4_9);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im4_10);
            question.setText(R.string.question_4_10);
            radioButtonOne.setText(R.string.response_options_4_10_1);
            radioButtonTwo.setText(R.string.response_options_4_10_2);
            radioButtonThree.setText(R.string.response_options_4_10_3);
            radioButtonFour.setText(R.string.response_options_4_10_4);
            currentQuestion++;
        }

        //test 11
        strResours = getResources().getString(R.string.question_4_10);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_4_11);
            radioButtonOne.setText(R.string.response_options_4_11_1);
            radioButtonTwo.setText(R.string.response_options_4_11_2);
            radioButtonThree.setText(R.string.response_options_4_11_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 12
        strResours = getResources().getString(R.string.question_4_11);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im4_12);
            question.setText(R.string.question_4_12);
            radioButtonOne.setText(R.string.response_options_4_12_1);
            radioButtonTwo.setText(R.string.response_options_4_12_2);
            radioButtonThree.setText(R.string.response_options_4_12_3);
            currentQuestion++;
        }

        //test 13
        strResours = getResources().getString(R.string.question_4_12);
        if (s.equals(strResours)) {
            //imageView.setVisibility(View.GONE);
            question.setText(R.string.question_4_13);
            radioButtonOne.setText(R.string.response_options_4_13_1);
            radioButtonTwo.setText(R.string.response_options_4_13_2);
            radioButtonThree.setText(R.string.response_options_4_13_3);
            currentQuestion++;
        }

        //test 14
        strResours = getResources().getString(R.string.question_4_13);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im4_14);
            question.setText(R.string.question_4_14);
            radioButtonOne.setText(R.string.response_options_4_14_1);
            radioButtonTwo.setText(R.string.response_options_4_14_2);
            radioButtonThree.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 15
        strResours = getResources().getString(R.string.question_4_14);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_4_15);
            radioButtonOne.setText(R.string.response_options_4_15_1);
            radioButtonTwo.setText(R.string.response_options_4_15_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_4_15_3);
            //radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 16
        strResours = getResources().getString(R.string.question_4_15);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im4_16);
            question.setText(R.string.question_4_16);
            radioButtonOne.setText(R.string.response_options_4_16_1);
            radioButtonTwo.setText(R.string.response_options_4_16_2);
            radioButtonThree.setText(R.string.response_options_4_16_3);
            //radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 17
        strResours = getResources().getString(R.string.question_4_16);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_4_17);
            radioButtonOne.setText(R.string.response_options_4_17_1);
            radioButtonTwo.setText(R.string.response_options_4_17_2);
            radioButtonThree.setText(R.string.response_options_4_17_3);
            currentQuestion++;
        }

        //test 18
        strResours = getResources().getString(R.string.question_4_17);
        if (s.equals(strResours)) {
            //imageView.setVisibility(View.GONE);
            question.setText(R.string.question_4_18);
            radioButtonOne.setText(R.string.response_options_4_18_1);
            radioButtonTwo.setText(R.string.response_options_4_18_2);
            radioButtonThree.setText(R.string.response_options_4_18_3);
            currentQuestion++;
        }

        //test 19
        strResours = getResources().getString(R.string.question_4_18);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im4_19);
            question.setText(R.string.question_4_19);
            radioButtonOne.setText(R.string.response_options_4_19_1);
            radioButtonTwo.setText(R.string.response_options_4_19_2);
            radioButtonThree.setText(R.string.response_options_4_19_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_4_19_4);
            currentQuestion++;
        }

        //test 20
        strResours = getResources().getString(R.string.question_4_19);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im4_20);
            question.setText(R.string.question_4_20);
            radioButtonOne.setText(R.string.response_options_4_20_1);
            radioButtonTwo.setText(R.string.response_options_4_20_2);
            radioButtonThree.setText(R.string.response_options_4_20_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }
    }

    private void fifthTestAnswersListener() {
        //test 2
        String s = question.getText().toString();
        String strResours = getResources().getString(R.string.question_5_1);
        radioGroup.clearCheck();
        if (s.equals(strResours)) {
            question.setText(R.string.question_5_2);
            radioButtonOne.setText(R.string.response_options_5_2_1);
            radioButtonTwo.setText(R.string.response_options_5_2_2);
            radioButtonThree.setText(R.string.response_options_5_2_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_5_2_4);
            currentQuestion++;
            //break;
        }

        //test 3
        strResours = getResources().getString(R.string.question_5_2);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im5_03);
            question.setText(R.string.question_5_3);
            radioButtonOne.setText(R.string.response_options_5_3_1);
            radioButtonTwo.setText(R.string.response_options_5_3_2);
            radioButtonThree.setText(R.string.response_options_5_3_3);
            radioButtonFour.setText(R.string.response_options_5_3_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_5_3_5);
            currentQuestion++;
        }

        //test 4
        strResours = getResources().getString(R.string.question_5_3);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im5_04);
            question.setText(R.string.question_5_4);
            radioButtonOne.setText(R.string.response_options_5_4_1);
            radioButtonTwo.setText(R.string.response_options_5_4_2);
            radioButtonThree.setText(R.string.response_options_5_4_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 5
        strResours = getResources().getString(R.string.question_5_4);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im5_05);
            question.setText(R.string.question_5_5);
            radioButtonOne.setText(R.string.response_options_5_5_1);
            radioButtonTwo.setText(R.string.response_options_5_5_2);
            radioButtonThree.setText(R.string.response_options_5_5_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_5_5_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_5_5_5);
            currentQuestion++;
        }

        //test 6
        strResours = getResources().getString(R.string.question_5_5);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im5_06);
            question.setText(R.string.question_5_6);
            radioButtonOne.setText(R.string.response_options_5_6_1);
            radioButtonTwo.setText(R.string.response_options_5_6_2);
            radioButtonThree.setText(R.string.response_options_5_6_3);
            currentQuestion++;
        }

        //test 7
        strResours = getResources().getString(R.string.question_5_6);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im5_07);
            question.setText(R.string.question_5_7);
            radioButtonOne.setText(R.string.response_options_5_7_1);
            radioButtonTwo.setText(R.string.response_options_5_7_2);
            radioButtonThree.setText(R.string.response_options_5_7_3);
            currentQuestion++;
        }

        //test 8
        strResours = getResources().getString(R.string.question_5_7);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_5_8);
            radioButtonOne.setText(R.string.response_options_5_8_1);
            radioButtonTwo.setText(R.string.response_options_5_8_2);
            radioButtonThree.setText(R.string.response_options_5_8_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_5_8_4);
            currentQuestion++;
        }

        //test 9
        strResours = getResources().getString(R.string.question_5_8);
        if (s.equals(strResours)) {
            question.setText(R.string.question_5_9);
            radioButtonOne.setText(R.string.response_options_5_9_1);
            radioButtonTwo.setText(R.string.response_options_5_9_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 10
        strResours = getResources().getString(R.string.question_5_9);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_5_10);
            radioButtonOne.setText(R.string.response_options_5_10_1);
            radioButtonTwo.setText(R.string.response_options_5_10_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_5_10_3);
            radioButtonFour.setText(R.string.response_options_5_10_4);
            currentQuestion++;
        }

        //test 11
        strResours = getResources().getString(R.string.question_5_10);
        if (s.equals(strResours)) {
            question.setText(R.string.question_5_11);
            radioButtonOne.setText(R.string.response_options_5_11_1);
            radioButtonTwo.setText(R.string.response_options_5_11_2);
            radioButtonThree.setText(R.string.response_options_5_11_3);
            radioButtonFour.setText(R.string.response_options_5_11_4);
            currentQuestion++;
        }

        //test 12
        strResours = getResources().getString(R.string.question_5_11);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im5_12);
            question.setText(R.string.question_5_12);
            radioButtonOne.setText(R.string.response_options_5_12_1);
            radioButtonTwo.setText(R.string.response_options_5_12_2);
            radioButtonThree.setText(R.string.response_options_5_12_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_5_12_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_5_12_5);
            currentQuestion++;
        }

        //test 13
        strResours = getResources().getString(R.string.question_5_12);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_5_13);
            radioButtonOne.setText(R.string.response_options_5_13_1);
            radioButtonTwo.setText(R.string.response_options_5_13_2);
            radioButtonThree.setText(R.string.response_options_5_13_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 14
        strResours = getResources().getString(R.string.question_5_13);
        if (s.equals(strResours)) {
            question.setText(R.string.question_5_14);
            radioButtonOne.setText(R.string.response_options_5_14_1);
            radioButtonTwo.setText(R.string.response_options_5_14_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_5_14_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_5_14_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_5_14_5);
            currentQuestion++;
        }

        //test 15
        strResours = getResources().getString(R.string.question_5_14);
        if (s.equals(strResours)) {
            question.setText(R.string.question_5_15);
            radioButtonOne.setText(R.string.response_options_5_15_1);
            radioButtonTwo.setText(R.string.response_options_5_15_2);
            radioButtonThree.setText(R.string.response_options_5_15_3);
            radioButtonFour.setText(R.string.response_options_5_15_4);
            radioButtonFive.setText(R.string.response_options_5_15_5);
            //radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 16
        strResours = getResources().getString(R.string.question_5_15);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im5_16);
            question.setText(R.string.question_5_16);
            radioButtonOne.setText(R.string.response_options_5_16_1);
            radioButtonTwo.setText(R.string.response_options_5_16_2);
            radioButtonThree.setText(R.string.response_options_5_16_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);

            currentQuestion++;
        }

        //test 17
        strResours = getResources().getString(R.string.question_5_16);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im5_17);
            question.setText(R.string.question_5_17);
            radioButtonOne.setText(R.string.response_options_5_17_1);
            radioButtonTwo.setText(R.string.response_options_5_17_2);
            radioButtonThree.setText(R.string.response_options_5_17_3);
            currentQuestion++;
        }

        //test 18
        strResours = getResources().getString(R.string.question_5_17);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_5_18);
            radioButtonOne.setText(R.string.response_options_5_18_1);
            radioButtonTwo.setText(R.string.response_options_5_18_2);
            radioButtonThree.setText(R.string.response_options_5_18_3);
            currentQuestion++;
        }

        //test 19
        strResours = getResources().getString(R.string.question_5_18);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im5_19);
            question.setText(R.string.question_5_19);
            radioButtonOne.setText(R.string.response_options_5_19_1);
            radioButtonTwo.setText(R.string.response_options_5_19_2);
            radioButtonThree.setText(R.string.response_options_5_19_3);
            currentQuestion++;
        }

        //test 20
        strResours = getResources().getString(R.string.question_5_19);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im5_20);
            question.setText(R.string.question_5_20);
            radioButtonOne.setText(R.string.response_options_5_20_1);
            radioButtonTwo.setText(R.string.response_options_5_20_2);
            radioButtonThree.setText(R.string.response_options_5_20_3);
            currentQuestion++;
        }
    }

    private void sixthTestAnswersListener() {
        //test 2
        String s = question.getText().toString();
        String strResours = getResources().getString(R.string.question_6_1);
        radioGroup.clearCheck();
        if (s.equals(strResours)) {
            question.setText(R.string.question_6_2);
            radioButtonOne.setText(R.string.response_options_6_2_1);
            radioButtonTwo.setText(R.string.response_options_6_2_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_6_2_3);
            currentQuestion++;
            //break;
        }

        //test 3
        strResours = getResources().getString(R.string.question_6_2);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im6_03);
            question.setText(R.string.question_6_3);
            radioButtonOne.setText(R.string.response_options_6_3_1);
            radioButtonTwo.setText(R.string.response_options_6_3_2);
            radioButtonThree.setText(R.string.response_options_6_3_3);
            currentQuestion++;
        }

        //test 4
        strResours = getResources().getString(R.string.question_6_3);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_6_4);
            radioButtonOne.setText(null);
            radioButtonTwo.setText(null);
            radioButtonThree.setText(null);
            radioButtonFour.setText(null);
            radioButtonFive.setText(null);
            radioButtonOne.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im6_04_01), null, null, null);
            radioButtonTwo.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im6_04_02), null, null, null);
            radioButtonThree.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im6_04_03), null, null, null);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im6_04_04), null, null, null);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im6_04_05), null, null, null);
            currentQuestion++;
        }

        //test 5
        strResours = getResources().getString(R.string.question_6_4);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im6_05);
            question.setText(R.string.question_6_5);
            radioButtonOne.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonTwo.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonThree.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonFour.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonFive.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonOne.setText(R.string.response_options_6_5_1);
            radioButtonTwo.setText(R.string.response_options_6_5_2);
            radioButtonThree.setText(R.string.response_options_6_5_3);
            radioButtonFour.setText(R.string.response_options_6_5_4);
            radioButtonFive.setText(R.string.response_options_6_5_5);
            currentQuestion++;
        }

        //test 6
        strResours = getResources().getString(R.string.question_6_5);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_6_6);
            radioButtonOne.setText(R.string.response_options_6_6_1);
            radioButtonTwo.setText(R.string.response_options_6_6_2);
            radioButtonThree.setText(R.string.response_options_6_6_3);
            radioButtonFour.setText(R.string.response_options_6_6_4);
            radioButtonFive.setText(R.string.response_options_6_6_5);
            currentQuestion++;
        }

        //test 7
        strResours = getResources().getString(R.string.question_6_6);
        if (s.equals(strResours)) {
            question.setText(R.string.question_6_7);
            radioButtonOne.setText(R.string.response_options_6_7_1);
            radioButtonTwo.setText(R.string.response_options_6_7_2);
            radioButtonThree.setText(R.string.response_options_6_7_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 8
        strResours = getResources().getString(R.string.question_6_7);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im6_08);
            question.setText(R.string.question_6_8);
            radioButtonOne.setText(R.string.response_options_6_8_1);
            radioButtonTwo.setText(R.string.response_options_6_8_2);
            radioButtonThree.setText(R.string.response_options_6_8_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_6_8_4);
            currentQuestion++;
        }

        //test 9
        strResours = getResources().getString(R.string.question_6_8);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_6_9);
            radioButtonOne.setText(R.string.response_options_6_9_1);
            radioButtonTwo.setText(R.string.response_options_6_9_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 10
        strResours = getResources().getString(R.string.question_6_9);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_6_10);
            radioButtonOne.setText(R.string.response_options_6_10_1);
            radioButtonTwo.setText(R.string.response_options_6_10_2);
//            radioButtonThree.setVisibility(View.VISIBLE);
//            radioButtonFour.setVisibility(View.VISIBLE);
//            radioButtonThree.setText(R.string.response_options_5_10_3);
//            radioButtonFour.setText(R.string.response_options_5_10_4);
            currentQuestion++;
        }

        //test 11
        strResours = getResources().getString(R.string.question_6_10);
        if (s.equals(strResours)) {
            question.setText(R.string.question_6_11);
            radioButtonOne.setText(R.string.response_options_6_11_1);
            radioButtonTwo.setText(R.string.response_options_6_11_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_6_11_3);
            currentQuestion++;
        }

        //test 12
        strResours = getResources().getString(R.string.question_6_11);
        if (s.equals(strResours)) {
//            imageView.setVisibility(View.VISIBLE);
//            imageView.setImageResource(R.drawable.im5_12);
            question.setText(R.string.question_6_12);
            radioButtonOne.setText(R.string.response_options_6_12_1);
            radioButtonTwo.setText(R.string.response_options_6_12_2);
            radioButtonThree.setText(R.string.response_options_6_12_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_6_12_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_6_12_5);
            currentQuestion++;
        }

        //test 13
        strResours = getResources().getString(R.string.question_6_12);
        if (s.equals(strResours)) {
//            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_6_13);
            radioButtonOne.setText(R.string.response_options_6_13_1);
            radioButtonTwo.setText(R.string.response_options_6_13_2);
            radioButtonThree.setText(R.string.response_options_6_13_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 14
        strResours = getResources().getString(R.string.question_6_13);
        if (s.equals(strResours)) {
            question.setText(R.string.question_6_14);
            radioButtonOne.setText(R.string.response_options_6_14_1);
            radioButtonTwo.setText(R.string.response_options_6_14_2);
            radioButtonThree.setText(R.string.response_options_6_14_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_6_14_4);
            currentQuestion++;
        }

        //test 15
        strResours = getResources().getString(R.string.question_6_14);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im6_15);
            question.setText(R.string.question_6_15);
            radioButtonOne.setText(R.string.response_options_6_15_1);
            radioButtonTwo.setText(R.string.response_options_6_15_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 16
        strResours = getResources().getString(R.string.question_6_15);
        if (s.equals(strResours)) {
//            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im6_16);
            question.setText(R.string.question_6_16);
            radioButtonOne.setText(R.string.response_options_6_16_1);
            radioButtonTwo.setText(R.string.response_options_6_16_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_6_16_3);
            currentQuestion++;
        }

        //test 17
        strResours = getResources().getString(R.string.question_6_16);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_6_17);
            radioButtonOne.setText(R.string.response_options_6_17_1);
            radioButtonTwo.setText(R.string.response_options_6_17_2);
            radioButtonThree.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 18
        strResours = getResources().getString(R.string.question_6_17);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_6_18);
            radioButtonOne.setText(R.string.response_options_6_18_1);
            radioButtonTwo.setText(R.string.response_options_6_18_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_6_18_3);
            currentQuestion++;
        }

        //test 19
        strResours = getResources().getString(R.string.question_6_18);
        if (s.equals(strResours)) {
            question.setText(R.string.question_6_19);
            radioButtonOne.setText(R.string.response_options_6_19_1);
            radioButtonTwo.setText(R.string.response_options_6_19_2);
            radioButtonThree.setText(R.string.response_options_6_19_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_6_19_4);
            currentQuestion++;
        }

        //test 20
        strResours = getResources().getString(R.string.question_6_19);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im6_20);
            question.setText(R.string.question_6_20);
            radioButtonOne.setText(R.string.response_options_6_20_1);
            radioButtonTwo.setText(R.string.response_options_6_20_2);
            radioButtonThree.setText(R.string.response_options_6_20_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }
    }

    private void seventhTestAnswersListener() {
        //test 2
        String s = question.getText().toString();
        String strResours = getResources().getString(R.string.question_7_1);
        radioGroup.clearCheck();
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_7_2);
            radioButtonOne.setText(R.string.response_options_7_2_1);
            radioButtonTwo.setText(R.string.response_options_7_2_2);
            radioButtonThree.setText(R.string.response_options_7_2_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_7_2_4);
            currentQuestion++;
            //break;
        }

        //test 3
        strResours = getResources().getString(R.string.question_7_2);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im7_03);
            question.setText(R.string.question_7_3);
            radioButtonOne.setText(R.string.response_options_7_3_1);
            radioButtonTwo.setText(R.string.response_options_7_3_2);
            radioButtonThree.setText(R.string.response_options_7_3_3);
            radioButtonFour.setText(R.string.response_options_7_3_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_7_3_5);
            currentQuestion++;
        }

        //test 4
        strResours = getResources().getString(R.string.question_7_3);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_7_4);
            radioButtonOne.setText(null);
            radioButtonTwo.setText(null);
            radioButtonThree.setText(null);
            radioButtonFive.setText(null);
            radioButtonOne.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im7_04_01), null, null, null);
            radioButtonTwo.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im7_04_02), null, null, null);
            radioButtonThree.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im7_04_03), null, null, null);
            radioButtonFour.setText(R.string.response_options_7_4_4);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 5
        strResours = getResources().getString(R.string.question_7_4);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im7_05);
            question.setText(R.string.question_7_5);
            radioButtonOne.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonTwo.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonThree.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonOne.setText(R.string.response_options_7_5_1);
            radioButtonTwo.setText(R.string.response_options_7_5_2);
            radioButtonThree.setText(R.string.response_options_7_5_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 6
        strResours = getResources().getString(R.string.question_7_5);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im7_06);
            question.setText(R.string.question_7_6);
            radioButtonOne.setText(R.string.response_options_7_6_1);
            radioButtonTwo.setText(R.string.response_options_7_6_2);
            radioButtonThree.setText(R.string.response_options_7_6_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_7_6_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_7_6_5);
            currentQuestion++;
        }

        //test 7
        strResours = getResources().getString(R.string.question_7_6);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im7_07);
            question.setText(R.string.question_7_7);
            radioButtonOne.setText(R.string.response_options_7_7_1);
            radioButtonTwo.setText(R.string.response_options_7_7_2);
            radioButtonThree.setText(R.string.response_options_7_7_3);
            radioButtonFour.setText(R.string.response_options_7_7_4);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 8
        strResours = getResources().getString(R.string.question_7_7);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_7_8);
            radioButtonOne.setText(R.string.response_options_7_8_1);
            radioButtonTwo.setText(R.string.response_options_7_8_2);
            radioButtonThree.setText(R.string.response_options_7_8_3);
            radioButtonFour.setText(R.string.response_options_7_8_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_7_8_5);
            currentQuestion++;
        }

        //test 9
        strResours = getResources().getString(R.string.question_7_8);
        if (s.equals(strResours)) {
            question.setText(R.string.question_7_9);
            radioButtonOne.setText(R.string.response_options_7_9_1);
            radioButtonTwo.setText(R.string.response_options_7_9_2);
            radioButtonThree.setText(R.string.response_options_7_9_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 10
        strResours = getResources().getString(R.string.question_7_9);
        if (s.equals(strResours)) {
//            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_7_10);
            radioButtonOne.setText(R.string.response_options_7_10_1);
            radioButtonTwo.setText(R.string.response_options_7_10_2);
            radioButtonThree.setText(R.string.response_options_7_10_3);
            currentQuestion++;
        }

        //test 11
        strResours = getResources().getString(R.string.question_7_10);
        if (s.equals(strResours)) {
            question.setText(R.string.question_7_11);
            radioButtonOne.setText(R.string.response_options_7_11_1);
            radioButtonTwo.setText(R.string.response_options_7_11_2);
            radioButtonThree.setText(R.string.response_options_7_11_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_7_11_4);
            currentQuestion++;
        }

        //test 12
        strResours = getResources().getString(R.string.question_7_11);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im7_12);
            question.setText(R.string.question_7_12);
            radioButtonOne.setText(R.string.response_options_7_12_1);
            radioButtonTwo.setText(R.string.response_options_7_12_2);
            radioButtonThree.setText(R.string.response_options_7_12_3);
            radioButtonFour.setText(R.string.response_options_7_12_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_7_12_5);
            currentQuestion++;
        }

        //test 13
        strResours = getResources().getString(R.string.question_7_12);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_7_13);
            radioButtonOne.setText(R.string.response_options_7_13_1);
            radioButtonTwo.setText(R.string.response_options_7_13_2);
            radioButtonThree.setText(R.string.response_options_7_13_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 14
        strResours = getResources().getString(R.string.question_7_13);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im7_14);
            question.setText(R.string.question_7_14);
            radioButtonOne.setText(R.string.response_options_7_14_1);
            radioButtonTwo.setText(R.string.response_options_7_14_2);
            radioButtonThree.setText(R.string.response_options_7_14_3);
            currentQuestion++;
        }

        //test 15
        strResours = getResources().getString(R.string.question_7_14);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_7_15);
            radioButtonOne.setText(R.string.response_options_7_15_1);
            radioButtonTwo.setText(R.string.response_options_7_15_2);
            radioButtonThree.setText(R.string.response_options_7_15_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_7_15_4);
            currentQuestion++;
        }

        //test 16
        strResours = getResources().getString(R.string.question_7_15);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im7_16);
            question.setText(R.string.question_7_16);
            radioButtonOne.setText(R.string.response_options_7_16_1);
            radioButtonTwo.setText(R.string.response_options_7_16_2);
            radioButtonThree.setText(R.string.response_options_7_16_3);
            radioButtonFour.setVisibility(View.GONE);
//            radioButtonFive.setVisibility(View.GONE);

            currentQuestion++;
        }

        //test 17
        strResours = getResources().getString(R.string.question_7_16);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im7_17);
            question.setText(R.string.question_7_17);
            radioButtonOne.setText(R.string.response_options_7_17_1);
            radioButtonTwo.setText(R.string.response_options_7_17_2);
            radioButtonThree.setText(R.string.response_options_7_17_3);
            currentQuestion++;
        }

        //test 18
        strResours = getResources().getString(R.string.question_7_17);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_7_18);
            radioButtonOne.setText(R.string.response_options_7_18_1);
            radioButtonTwo.setText(R.string.response_options_7_18_2);
            radioButtonThree.setText(R.string.response_options_7_18_3);
            currentQuestion++;
        }

        //test 19
        strResours = getResources().getString(R.string.question_7_18);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im7_19);
            question.setText(R.string.question_7_19);
            radioButtonOne.setText(R.string.response_options_7_19_1);
            radioButtonTwo.setText(R.string.response_options_7_19_2);
            radioButtonThree.setText(R.string.response_options_7_19_3);
            currentQuestion++;
        }

        //test 20
        strResours = getResources().getString(R.string.question_7_19);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_7_20);
            radioButtonOne.setText(R.string.response_options_7_20_1);
            radioButtonTwo.setText(R.string.response_options_7_20_2);
            radioButtonThree.setText(R.string.response_options_7_20_3);
            currentQuestion++;
        }
    }

    private void eghthTestAnswersListener() {
        //test 2
        String s = question.getText().toString();
        String strResours = getResources().getString(R.string.question_8_1);
        radioGroup.clearCheck();
        if (s.equals(strResours)) {
            question.setText(R.string.question_8_2);
            radioButtonOne.setText(R.string.response_options_8_2_1);
            radioButtonTwo.setText(R.string.response_options_8_2_2);
            radioButtonThree.setText(R.string.response_options_8_2_3);
            currentQuestion++;
            //break;
        }

        //test 3
        strResours = getResources().getString(R.string.question_8_2);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im8_03);
            question.setText(R.string.question_8_3);
            radioButtonOne.setText(R.string.response_options_8_3_1);
            radioButtonTwo.setText(R.string.response_options_8_3_2);
            radioButtonThree.setText(R.string.response_options_8_3_3);
            currentQuestion++;
        }

        //test 4
        strResours = getResources().getString(R.string.question_8_3);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im8_04);
            question.setText(R.string.question_8_4);
            radioButtonOne.setText(R.string.response_options_8_4_1);
            radioButtonTwo.setText(R.string.response_options_8_4_2);
            radioButtonThree.setText(R.string.response_options_8_4_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_8_4_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_8_4_5);
            currentQuestion++;
        }

        //test 5
        strResours = getResources().getString(R.string.question_8_4);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im8_05);
            question.setText(R.string.question_8_5);
            radioButtonOne.setText(R.string.response_options_8_5_1);
            radioButtonTwo.setText(R.string.response_options_8_5_2);
            radioButtonThree.setText(R.string.response_options_8_5_3);
            radioButtonFour.setText(R.string.response_options_8_5_4);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 6
        strResours = getResources().getString(R.string.question_8_5);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im8_06);
            question.setText(R.string.question_8_6);
            radioButtonOne.setText(R.string.response_options_8_6_1);
            radioButtonTwo.setText(R.string.response_options_8_6_2);
            radioButtonThree.setText(R.string.response_options_8_6_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 7
        strResours = getResources().getString(R.string.question_8_6);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im8_07);
            question.setText(R.string.question_8_7);
            radioButtonOne.setText(R.string.response_options_8_7_1);
            radioButtonTwo.setText(R.string.response_options_8_7_2);
            radioButtonThree.setText(R.string.response_options_8_7_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_8_7_4);
            currentQuestion++;
        }

        //test 8
        strResours = getResources().getString(R.string.question_8_7);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im8_08);
            question.setText(R.string.question_8_8);
            radioButtonOne.setText(R.string.response_options_8_8_1);
            radioButtonTwo.setText(R.string.response_options_8_8_2);
            radioButtonThree.setText(R.string.response_options_8_8_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 9
        strResours = getResources().getString(R.string.question_8_8);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_8_9);
            radioButtonOne.setText(R.string.response_options_8_9_1);
            radioButtonTwo.setText(R.string.response_options_8_9_2);
            radioButtonThree.setText(R.string.response_options_8_9_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_8_9_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_8_9_5);
            currentQuestion++;
        }

        //test 10
        strResours = getResources().getString(R.string.question_8_9);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im8_10);
            question.setText(R.string.question_8_10);
            radioButtonOne.setText(R.string.response_options_8_10_1);
            radioButtonTwo.setText(R.string.response_options_8_10_2);
            radioButtonThree.setText(R.string.response_options_8_10_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 11
        strResours = getResources().getString(R.string.question_8_10);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im8_11);
            question.setText(R.string.question_8_11);
            radioButtonOne.setText(R.string.response_options_8_11_1);
            radioButtonTwo.setText(R.string.response_options_8_11_2);
            radioButtonThree.setText(R.string.response_options_8_11_3);
            currentQuestion++;
        }

        //test 12
        strResours = getResources().getString(R.string.question_8_11);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im8_12);
            question.setText(R.string.question_8_12);
            radioButtonOne.setText(R.string.response_options_8_12_1);
            radioButtonTwo.setText(R.string.response_options_8_12_2);
            radioButtonThree.setText(R.string.response_options_8_12_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_8_12_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_8_12_5);
            currentQuestion++;
        }

        //test 13
        strResours = getResources().getString(R.string.question_8_12);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_8_13);
            radioButtonOne.setText(R.string.response_options_8_13_1);
            radioButtonTwo.setText(R.string.response_options_8_13_2);
            radioButtonThree.setText(R.string.response_options_8_13_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 14
        strResours = getResources().getString(R.string.question_8_13);
        if (s.equals(strResours)) {
            question.setText(R.string.question_8_14);
            radioButtonOne.setText(R.string.response_options_8_14_1);
            radioButtonTwo.setText(R.string.response_options_8_14_2);
            radioButtonThree.setText(R.string.response_options_8_14_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_8_14_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_8_14_5);
            currentQuestion++;
        }

        //test 15
        strResours = getResources().getString(R.string.question_8_14);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im8_15);
            question.setText(R.string.question_8_15);
            radioButtonOne.setText(R.string.response_options_8_15_1);
            radioButtonTwo.setText(R.string.response_options_8_15_2);
            radioButtonThree.setText(R.string.response_options_8_15_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            //radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 16
        strResours = getResources().getString(R.string.question_8_15);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im8_16);
            question.setText(R.string.question_8_16);
            radioButtonOne.setText(R.string.response_options_8_16_1);
            radioButtonTwo.setText(R.string.response_options_8_16_2);
            radioButtonThree.setText(R.string.response_options_8_16_3);
//            radioButtonFour.setVisibility(View.GONE);
//            radioButtonFive.setVisibility(View.GONE);

            currentQuestion++;
        }

        //test 17
        strResours = getResources().getString(R.string.question_8_16);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_8_17);
            radioButtonOne.setText(R.string.response_options_8_17_1);
            radioButtonTwo.setText(R.string.response_options_8_17_2);
            radioButtonThree.setText(R.string.response_options_8_17_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_8_17_4);
            currentQuestion++;
        }

        //test 18
        strResours = getResources().getString(R.string.question_8_17);
        if (s.equals(strResours)) {
            question.setText(R.string.question_8_18);
            radioButtonOne.setText(R.string.response_options_8_18_1);
            radioButtonTwo.setText(R.string.response_options_8_18_2);
            radioButtonThree.setText(R.string.response_options_8_18_3);
            radioButtonFour.setText(R.string.response_options_8_18_4);
            currentQuestion++;
        }

        //test 19
        strResours = getResources().getString(R.string.question_8_18);
        if (s.equals(strResours)) {
            question.setText(R.string.question_8_19);
            radioButtonOne.setText(R.string.response_options_8_19_1);
            radioButtonTwo.setText(R.string.response_options_8_19_2);
            radioButtonThree.setText(R.string.response_options_8_19_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 20
        strResours = getResources().getString(R.string.question_8_19);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im8_20);
            question.setText(R.string.question_8_20);
            radioButtonOne.setText(R.string.response_options_8_20_1);
            radioButtonTwo.setText(R.string.response_options_8_20_2);
            radioButtonThree.setVisibility(View.GONE);
            currentQuestion++;
        }
    }

    private void ninthTestAnswersListener() {
        //test 2
        String s = question.getText().toString();
        String strResours = getResources().getString(R.string.question_9_1);
        radioGroup.clearCheck();
        if (s.equals(strResours)) {
            question.setText(R.string.question_9_2);
            radioButtonOne.setText(R.string.response_options_9_2_1);
            radioButtonTwo.setText(R.string.response_options_9_2_2);
            radioButtonThree.setText(R.string.response_options_9_2_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
            //break;
        }

        //test 3
        strResours = getResources().getString(R.string.question_9_2);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im9_03);
            question.setText(R.string.question_9_3);
            radioButtonOne.setText(R.string.response_options_9_3_1);
            radioButtonTwo.setText(R.string.response_options_9_3_2);
            radioButtonThree.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 4
        strResours = getResources().getString(R.string.question_9_3);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_9_4);
            radioButtonOne.setText(null);
            radioButtonTwo.setText(null);
            radioButtonThree.setText(null);
            radioButtonFour.setText(null);
            radioButtonFive.setText(null);
            radioButtonOne.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im9_04_01), null, null, null);
            radioButtonTwo.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im9_04_02), null, null, null);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im9_04_03), null, null, null);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im9_04_04), null, null, null);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im9_04_05), null, null, null);
            currentQuestion++;
        }

        //test 5
        strResours = getResources().getString(R.string.question_9_4);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im9_05);
            question.setText(R.string.question_9_5);
            radioButtonOne.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonTwo.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonThree.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonFour.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonFive.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            radioButtonOne.setText(R.string.response_options_9_5_1);
            radioButtonTwo.setText(R.string.response_options_9_5_2);
            radioButtonThree.setText(R.string.response_options_9_5_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 6
        strResours = getResources().getString(R.string.question_9_5);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im9_06);
            question.setText(R.string.question_9_6);
            radioButtonOne.setText(R.string.response_options_9_6_1);
            radioButtonTwo.setText(R.string.response_options_9_6_2);
            radioButtonThree.setText(R.string.response_options_9_6_3);
            currentQuestion++;
        }

        //test 7
        strResours = getResources().getString(R.string.question_9_6);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im9_07);
            question.setText(R.string.question_9_7);
            radioButtonOne.setText(R.string.response_options_9_7_1);
            radioButtonTwo.setText(R.string.response_options_9_7_2);
            radioButtonThree.setText(R.string.response_options_9_7_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_9_7_4);
            currentQuestion++;
        }

        //test 8
        strResours = getResources().getString(R.string.question_9_7);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_9_8);
            radioButtonOne.setText(R.string.response_options_9_8_1);
            radioButtonTwo.setText(R.string.response_options_9_8_2);
            radioButtonThree.setText(R.string.response_options_9_8_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 9
        strResours = getResources().getString(R.string.question_9_8);
        if (s.equals(strResours)) {
            question.setText(R.string.question_9_9);
            radioButtonOne.setText(R.string.response_options_9_9_1);
            radioButtonTwo.setText(R.string.response_options_9_9_2);
            radioButtonThree.setText(R.string.response_options_9_9_3);
//            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 10
        strResours = getResources().getString(R.string.question_9_9);
        if (s.equals(strResours)) {
//            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_9_10);
            radioButtonOne.setText(R.string.response_options_9_10_1);
            radioButtonTwo.setText(R.string.response_options_9_10_2);
            radioButtonThree.setText(R.string.response_options_9_10_3);
            currentQuestion++;
        }

        //test 11
        strResours = getResources().getString(R.string.question_9_10);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im9_11);
            question.setText(R.string.question_9_11);
            radioButtonOne.setText(R.string.response_options_9_11_1);
            radioButtonTwo.setText(R.string.response_options_9_11_2);
            radioButtonThree.setText(R.string.response_options_9_11_3);
            currentQuestion++;
        }

        //test 12
        strResours = getResources().getString(R.string.question_9_11);
        if (s.equals(strResours)) {
//            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im9_12);
            question.setText(R.string.question_9_12);
            radioButtonOne.setText(R.string.response_options_9_12_1);
            radioButtonTwo.setText(R.string.response_options_9_12_2);
            radioButtonThree.setText(R.string.response_options_9_12_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_9_12_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_9_12_5);
            currentQuestion++;
        }

        //test 13
        strResours = getResources().getString(R.string.question_9_12);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im9_13);
            question.setText(R.string.question_9_13);
            radioButtonOne.setText(R.string.response_options_9_13_1);
            radioButtonTwo.setText(R.string.response_options_9_13_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 14
        strResours = getResources().getString(R.string.question_9_13);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im9_14);
            question.setText(R.string.question_9_14);
            radioButtonOne.setText(R.string.response_options_9_14_1);
            radioButtonTwo.setText(R.string.response_options_9_14_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_9_14_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_9_14_4);
            currentQuestion++;
        }

        //test 15
        strResours = getResources().getString(R.string.question_9_14);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im9_15);
            question.setText(R.string.question_9_15);
            radioButtonOne.setText(R.string.response_options_9_15_1);
            radioButtonTwo.setText(R.string.response_options_9_15_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            //radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 16
        strResours = getResources().getString(R.string.question_9_15);
        if (s.equals(strResours)) {
//            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im9_16);
            question.setText(R.string.question_9_16);
            radioButtonOne.setText(R.string.response_options_9_16_1);
            radioButtonTwo.setText(R.string.response_options_9_16_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_9_16_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);

            currentQuestion++;
        }

        //test 17
        strResours = getResources().getString(R.string.question_9_16);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im9_17);
            question.setText(R.string.question_9_17);
            radioButtonOne.setText(R.string.response_options_9_17_1);
            radioButtonTwo.setText(R.string.response_options_9_17_2);
            radioButtonThree.setText(R.string.response_options_9_17_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_9_17_4);
            currentQuestion++;
        }

        //test 18
        strResours = getResources().getString(R.string.question_9_17);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_9_18);
            radioButtonOne.setText(R.string.response_options_9_18_1);
            radioButtonTwo.setText(R.string.response_options_9_18_2);
            radioButtonThree.setText(R.string.response_options_9_18_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 19
        strResours = getResources().getString(R.string.question_9_18);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im9_19);
            question.setText(R.string.question_9_19);
            radioButtonOne.setText(R.string.response_options_9_19_1);
            radioButtonTwo.setText(R.string.response_options_9_19_2);
            radioButtonThree.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 20
        strResours = getResources().getString(R.string.question_9_19);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_9_20);
            radioButtonOne.setText(R.string.response_options_9_20_1);
            radioButtonTwo.setText(R.string.response_options_9_20_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_9_20_3);
            currentQuestion++;
        }
    }

    private void tenthTestAnswersListener() {
        //test 2
        String s = question.getText().toString();
        String strResours = getResources().getString(R.string.question_10_1);
        radioGroup.clearCheck();
        if (s.equals(strResours)) {
            question.setText(R.string.question_10_2);
            radioButtonOne.setText(R.string.response_options_10_2_1);
            radioButtonTwo.setText(R.string.response_options_10_2_2);
            radioButtonThree.setText(R.string.response_options_10_2_3);
            currentQuestion++;
            //break;
        }

        //test 3
        strResours = getResources().getString(R.string.question_10_2);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im10_03);
            question.setText(R.string.question_10_3);
            radioButtonOne.setText(R.string.response_options_10_3_1);
            radioButtonTwo.setText(R.string.response_options_10_3_2);
            radioButtonThree.setText(R.string.response_options_10_3_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_10_3_4);
            currentQuestion++;
        }

        //test 4
        strResours = getResources().getString(R.string.question_10_3);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im10_04);
            question.setText(R.string.question_10_4);
            radioButtonOne.setText(R.string.response_options_10_4_1);
            radioButtonTwo.setText(R.string.response_options_10_4_2);
            radioButtonThree.setText(R.string.response_options_10_4_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 5
        strResours = getResources().getString(R.string.question_10_4);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im10_05);
            question.setText(R.string.question_10_5);
            radioButtonOne.setText(R.string.response_options_10_5_1);
            radioButtonTwo.setText(R.string.response_options_10_5_2);
            radioButtonThree.setText(R.string.response_options_10_5_3);
            currentQuestion++;
        }

        //test 6
        strResours = getResources().getString(R.string.question_10_5);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_10_6);
            radioButtonOne.setText(R.string.response_options_10_6_1);
            radioButtonTwo.setText(R.string.response_options_10_6_2);
            radioButtonThree.setText(R.string.response_options_10_6_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_10_6_4);
            currentQuestion++;
        }

        //test 7
        strResours = getResources().getString(R.string.question_10_6);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im10_07);
            question.setText(R.string.question_10_7);
            radioButtonOne.setText(R.string.response_options_10_7_1);
            radioButtonTwo.setText(R.string.response_options_10_7_2);
            radioButtonThree.setText(R.string.response_options_10_7_3);
            radioButtonFour.setText(R.string.response_options_10_7_4);
            currentQuestion++;
        }

        //test 8
        strResours = getResources().getString(R.string.question_10_7);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im10_08);
            question.setText(R.string.question_10_8);
            radioButtonOne.setText(R.string.response_options_10_8_1);
            radioButtonTwo.setText(R.string.response_options_10_8_2);
            radioButtonThree.setText(R.string.response_options_10_8_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 9
        strResours = getResources().getString(R.string.question_10_8);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_10_9);
            radioButtonOne.setText(R.string.response_options_10_9_1);
            radioButtonTwo.setText(R.string.response_options_10_9_2);
            radioButtonThree.setText(R.string.response_options_10_9_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_10_9_4);
            currentQuestion++;
        }

        //test 10
        strResours = getResources().getString(R.string.question_10_9);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im10_10);
            question.setText(R.string.question_10_10);
            radioButtonOne.setText(R.string.response_options_10_10_1);
            radioButtonTwo.setText(R.string.response_options_10_10_2);
            radioButtonThree.setText(R.string.response_options_10_10_3);
            radioButtonFour.setText(R.string.response_options_10_10_4);
            currentQuestion++;
        }

        //test 11
        strResours = getResources().getString(R.string.question_10_10);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_10_11);
            radioButtonOne.setText(R.string.response_options_10_11_1);
            radioButtonTwo.setText(R.string.response_options_10_11_2);
            radioButtonThree.setText(R.string.response_options_10_11_3);
            radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 12
        strResours = getResources().getString(R.string.question_10_11);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im10_12);
            question.setText(R.string.question_10_12);
            radioButtonOne.setText(R.string.response_options_10_12_1);
            radioButtonTwo.setText(R.string.response_options_10_12_2);
            radioButtonThree.setText(R.string.response_options_10_12_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_10_12_4);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFive.setText(R.string.response_options_10_12_5);
            currentQuestion++;
        }

        //test 13
        strResours = getResources().getString(R.string.question_10_12);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_10_13);
            radioButtonOne.setText(R.string.response_options_10_13_1);
            radioButtonTwo.setText(R.string.response_options_10_13_2);
            radioButtonThree.setText(R.string.response_options_10_13_3);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 14
        strResours = getResources().getString(R.string.question_10_13);
        if (s.equals(strResours)) {
            question.setText(R.string.question_10_14);
            radioButtonOne.setText(R.string.response_options_10_14_1);
            radioButtonTwo.setText(R.string.response_options_10_14_2);
            radioButtonThree.setText(R.string.response_options_10_14_3);
            currentQuestion++;
        }

        //test 15
        strResours = getResources().getString(R.string.question_10_14);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im10_15);
            question.setText(R.string.question_10_15);
            radioButtonOne.setText(R.string.response_options_10_15_1);
            radioButtonTwo.setText(R.string.response_options_10_15_2);
            radioButtonThree.setText(R.string.response_options_10_15_3);
            radioButtonFour.setVisibility(View.VISIBLE);
            radioButtonFive.setVisibility(View.VISIBLE);
            radioButtonFour.setText(R.string.response_options_10_15_4);
            radioButtonFive.setText(R.string.response_options_10_15_5);
            //radioButtonFour.setVisibility(View.GONE);
            currentQuestion++;
        }

        //test 16
        strResours = getResources().getString(R.string.question_10_15);
        if (s.equals(strResours)) {
//            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im10_16);
            question.setText(R.string.question_10_16);
            radioButtonOne.setText(R.string.response_options_10_16_1);
            radioButtonTwo.setText(R.string.response_options_10_16_2);
            radioButtonThree.setVisibility(View.GONE);
            radioButtonFour.setVisibility(View.GONE);
            radioButtonFive.setVisibility(View.GONE);

            currentQuestion++;
        }

        //test 17
        strResours = getResources().getString(R.string.question_10_16);
        if (s.equals(strResours)) {
            imageView.setImageResource(R.drawable.im10_17);
            question.setText(R.string.question_10_17);
            radioButtonOne.setText(R.string.response_options_10_17_1);
            radioButtonTwo.setText(R.string.response_options_10_17_2);
            currentQuestion++;
        }

        //test 18
        strResours = getResources().getString(R.string.question_10_17);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.GONE);
            question.setText(R.string.question_10_18);
            radioButtonOne.setText(R.string.response_options_10_18_1);
            radioButtonTwo.setText(R.string.response_options_10_18_2);
            radioButtonThree.setVisibility(View.VISIBLE);
            radioButtonThree.setText(R.string.response_options_10_18_3);
            currentQuestion++;
        }

        //test 19
        strResours = getResources().getString(R.string.question_10_18);
        if (s.equals(strResours)) {
            question.setText(R.string.question_10_19);
            radioButtonOne.setText(R.string.response_options_10_19_1);
            radioButtonTwo.setText(R.string.response_options_10_19_2);
            radioButtonThree.setText(R.string.response_options_10_19_3);
            currentQuestion++;
        }

        //test 20
        strResours = getResources().getString(R.string.question_10_19);
        if (s.equals(strResours)) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.im10_20);
            question.setText(R.string.question_10_20);
            radioButtonOne.setText(R.string.response_options_10_20_1);
            radioButtonTwo.setText(R.string.response_options_10_20_2);
            radioButtonThree.setVisibility(View.GONE);
            currentQuestion++;
        }
    }

    //заполнение данными QuestionEntity
    private void dataTest1() {
        answerEntityArrayList = new ArrayList<>();
        answerEntityArrayList.add(new AnswerEntity(0, getResources().getString(R.string.response_options_1_1_1)));
        answerEntityArrayList.add(new AnswerEntity(1, getResources().getString(R.string.response_options_1_1_2)));
        answerEntityArrayList.add(new AnswerEntity(2, getResources().getString(R.string.response_options_1_1_3)));
        answerEntityArrayList.add(new AnswerEntity(3, getResources().getString(R.string.response_options_1_2_1)));
        answerEntityArrayList.add(new AnswerEntity(4, getResources().getString(R.string.response_options_1_2_2)));
        answerEntityArrayList.add(new AnswerEntity(5, getResources().getString(R.string.response_options_1_2_3)));
        answerEntityArrayList.add(new AnswerEntity(6, getResources().getString(R.string.response_options_1_3_1)));
        answerEntityArrayList.add(new AnswerEntity(7, getResources().getString(R.string.response_options_1_3_2)));
        answerEntityArrayList.add(new AnswerEntity(8, getResources().getString(R.string.response_options_1_3_3)));
        answerEntityArrayList.add(new AnswerEntity(9, getResources().getString(R.string.response_options_1_5_1)));
        answerEntityArrayList.add(new AnswerEntity(10, getResources().getString(R.string.response_options_1_5_2)));
        answerEntityArrayList.add(new AnswerEntity(11, getResources().getString(R.string.response_options_1_5_3)));
        answerEntityArrayList.add(new AnswerEntity(12, getResources().getString(R.string.response_options_1_6_1)));
        answerEntityArrayList.add(new AnswerEntity(13, getResources().getString(R.string.response_options_1_6_2)));
        answerEntityArrayList.add(new AnswerEntity(14, getResources().getString(R.string.response_options_1_6_3)));
        answerEntityArrayList.add(new AnswerEntity(15, getResources().getString(R.string.response_options_1_6_4)));
        answerEntityArrayList.add(new AnswerEntity(16, "С момента вынесения постановления о лишении права управления."));
        answerEntityArrayList.add(new AnswerEntity(17, "С момента, когда водитель официально уведомлён о лишении права управления."));
        answerEntityArrayList.add(new AnswerEntity(18, "С момента совершения административного правонарушения."));
        answerEntityArrayList.add(new AnswerEntity(19, "В один ряд по обочине, держась как можно правее, а при её отсутствии, — по краю проезжей части дороги навстречу движению транспортных средств. При этом следует быть осторожным и не мешать другим участникам дорожного движения."));
        answerEntityArrayList.add(new AnswerEntity(20, "В один ряд по обочине, держась как можно правее, а при её отсутствии, — по краю проезжей части дороги по ходу движения."));
        answerEntityArrayList.add(new AnswerEntity(21, "В обоих случаях правильно."));
        answerEntityArrayList.add(new AnswerEntity(22, "Обязательное направление движения грузовых автомобилей, разрешённая максимальная масса которых более 3,5 т."));
        answerEntityArrayList.add(new AnswerEntity(23, "Рекомендуемое направление движения для грузовых автомобилей и самоходных машин."));
        answerEntityArrayList.add(new AnswerEntity(24, "Направление движения только для грузовых автомобилей."));
        answerEntityArrayList.add(new AnswerEntity(25, "Направление движения для грузовых автомобилей, осуществляющих междугородные перевозки."));
        answerEntityArrayList.add(new AnswerEntity(26, "А и Б."));
        answerEntityArrayList.add(new AnswerEntity(27, "А."));
        answerEntityArrayList.add(new AnswerEntity(28, "Б."));
        answerEntityArrayList.add(new AnswerEntity(29, "С предупреждающим знаком «Пересечение равнозначных дорог»."));
        answerEntityArrayList.add(new AnswerEntity(30, "Со знаком «Уступить дорогу»"));
        answerEntityArrayList.add(new AnswerEntity(31, "Со знаком «Проезд без остановки запрещён»."));
        answerEntityArrayList.add(new AnswerEntity(32, "Со всеми перечисленными знаками."));
        answerEntityArrayList.add(new AnswerEntity(33, "Только легковым и грузовым автомобилям с разрешённой максимальной массой до 3,5 т."));
        answerEntityArrayList.add(new AnswerEntity(34, "Только легковым автомобилям и мотоциклам."));
        answerEntityArrayList.add(new AnswerEntity(35, "Автомобилям, микроавтобусам, автобусам и мотоциклам."));
        answerEntityArrayList.add(new AnswerEntity(36, "Обязательным является выполнение требований горизонтальной дорожной разметки, выполненной только белым цветом."));
        answerEntityArrayList.add(new AnswerEntity(37, "Всегда."));
        answerEntityArrayList.add(new AnswerEntity(38, "Обязательным является выполнение требований горизонтальной дорожной разметки, выполненной только желтым цветом."));
        answerEntityArrayList.add(new AnswerEntity(39, "Немедленно после завершения манёвра."));
        answerEntityArrayList.add(new AnswerEntity(40, getResources().getString(R.string.response_options_1_9_2)));
        answerEntityArrayList.add(new AnswerEntity(41, getResources().getString(R.string.response_options_1_9_3)));
        answerEntityArrayList.add(new AnswerEntity(42, getResources().getString(R.string.response_options_1_10_1)));
        answerEntityArrayList.add(new AnswerEntity(43, getResources().getString(R.string.response_options_1_10_2)));
        answerEntityArrayList.add(new AnswerEntity(44, getResources().getString(R.string.response_options_1_10_3)));
        answerEntityArrayList.add(new AnswerEntity(45, getResources().getString(R.string.response_options_1_11_1)));
        answerEntityArrayList.add(new AnswerEntity(46, getResources().getString(R.string.response_options_1_11_2)));
        answerEntityArrayList.add(new AnswerEntity(47, getResources().getString(R.string.response_options_1_11_3)));
        answerEntityArrayList.add(new AnswerEntity(48, getResources().getString(R.string.response_options_1_11_4)));
        answerEntityArrayList.add(new AnswerEntity(49, getResources().getString(R.string.response_options_1_12_1)));
        answerEntityArrayList.add(new AnswerEntity(50, getResources().getString(R.string.response_options_1_12_2)));
        answerEntityArrayList.add(new AnswerEntity(51, getResources().getString(R.string.response_options_1_12_3)));
        answerEntityArrayList.add(new AnswerEntity(52, getResources().getString(R.string.response_options_1_13_1)));
        answerEntityArrayList.add(new AnswerEntity(53, getResources().getString(R.string.response_options_1_13_2)));
        answerEntityArrayList.add(new AnswerEntity(54, getResources().getString(R.string.response_options_1_13_3)));
        answerEntityArrayList.add(new AnswerEntity(55, getResources().getString(R.string.response_options_1_13_4)));
        answerEntityArrayList.add(new AnswerEntity(56, getResources().getString(R.string.response_options_1_14_1)));
        answerEntityArrayList.add(new AnswerEntity(57, getResources().getString(R.string.response_options_1_14_2)));
        answerEntityArrayList.add(new AnswerEntity(58, getResources().getString(R.string.response_options_1_14_3)));
        answerEntityArrayList.add(new AnswerEntity(59, getResources().getString(R.string.response_options_1_15_1)));
        answerEntityArrayList.add(new AnswerEntity(60, getResources().getString(R.string.response_options_1_15_2)));
        answerEntityArrayList.add(new AnswerEntity(61, getResources().getString(R.string.response_options_1_15_3)));
        answerEntityArrayList.add(new AnswerEntity(62, getResources().getString(R.string.response_options_1_16_1)));
        answerEntityArrayList.add(new AnswerEntity(63, getResources().getString(R.string.response_options_1_16_2)));
        answerEntityArrayList.add(new AnswerEntity(64, getResources().getString(R.string.response_options_1_16_3)));
        answerEntityArrayList.add(new AnswerEntity(65, getResources().getString(R.string.response_options_1_17_1)));
        answerEntityArrayList.add(new AnswerEntity(66, getResources().getString(R.string.response_options_1_17_2)));
        answerEntityArrayList.add(new AnswerEntity(67, getResources().getString(R.string.response_options_1_17_3)));
        answerEntityArrayList.add(new AnswerEntity(68, getResources().getString(R.string.response_options_1_18_1)));
        answerEntityArrayList.add(new AnswerEntity(69, getResources().getString(R.string.response_options_1_18_2)));
        answerEntityArrayList.add(new AnswerEntity(70, getResources().getString(R.string.response_options_1_18_3)));
        answerEntityArrayList.add(new AnswerEntity(71, getResources().getString(R.string.response_options_1_18_4)));
        answerEntityArrayList.add(new AnswerEntity(72, getResources().getString(R.string.response_options_1_19_1)));
        answerEntityArrayList.add(new AnswerEntity(73, getResources().getString(R.string.response_options_1_19_2)));
        answerEntityArrayList.add(new AnswerEntity(74, getResources().getString(R.string.response_options_1_20_1)));
        answerEntityArrayList.add(new AnswerEntity(75, getResources().getString(R.string.response_options_1_20_2)));
        answerEntityArrayList.add(new AnswerEntity(76, getResources().getString(R.string.response_options_1_20_3)));
        answerEntityArrayList.add(new AnswerEntity(77, getResources().getString(R.string.response_options_1_20_4)));


        answerEntityArrayListTrue = new ArrayList<>();
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_1_1_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_1_2_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_1_3_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, "1"));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_1_5_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_1_6_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_1_7_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_1_8_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_1_9_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_1_10_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_1_11_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_1_12_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_1_13_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_1_14_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_1_15_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_1_16_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_1_17_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_1_18_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_1_19_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_1_20_2)));

        questionEntityArrayList = new ArrayList<>();
        questionEntityArrayList.add(new QuestionEntity(0, getResources().getString(R.string.question_1_1), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(1, getResources().getString(R.string.question_1_2), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(2, getResources().getString(R.string.question_1_3), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(3, getResources().getString(R.string.question_1_4), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(4, getResources().getString(R.string.question_1_5), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(5, getResources().getString(R.string.question_1_6), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(6, getResources().getString(R.string.question_1_7), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(7, getResources().getString(R.string.question_1_8), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(8, getResources().getString(R.string.question_1_9), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(9, getResources().getString(R.string.question_1_10), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(10, getResources().getString(R.string.question_1_11), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(11, getResources().getString(R.string.question_1_12), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(12, getResources().getString(R.string.question_1_13), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(13, getResources().getString(R.string.question_1_14), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(14, getResources().getString(R.string.question_1_15), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(15, getResources().getString(R.string.question_1_16), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(16, getResources().getString(R.string.question_1_17), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(17, getResources().getString(R.string.question_1_18), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(18, getResources().getString(R.string.question_1_19), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(19, getResources().getString(R.string.question_1_20), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
    }

    private void dataTest2() {
        answerEntityArrayList = new ArrayList<>();
        answerEntityArrayList.add(new AnswerEntity(0, getResources().getString(R.string.response_options_2_1_1)));
        answerEntityArrayList.add(new AnswerEntity(1, getResources().getString(R.string.response_options_2_1_2)));
        answerEntityArrayList.add(new AnswerEntity(2, getResources().getString(R.string.response_options_2_1_3)));
        answerEntityArrayList.add(new AnswerEntity(3, getResources().getString(R.string.response_options_2_2_1)));
        answerEntityArrayList.add(new AnswerEntity(4, getResources().getString(R.string.response_options_2_2_2)));
        answerEntityArrayList.add(new AnswerEntity(5, getResources().getString(R.string.response_options_2_2_3)));
        answerEntityArrayList.add(new AnswerEntity(6, getResources().getString(R.string.response_options_2_3_1)));
        answerEntityArrayList.add(new AnswerEntity(7, getResources().getString(R.string.response_options_2_3_2)));
        answerEntityArrayList.add(new AnswerEntity(8, getResources().getString(R.string.response_options_2_3_3)));
        answerEntityArrayList.add(new AnswerEntity(9, getResources().getString(R.string.response_options_2_4_1)));
        answerEntityArrayList.add(new AnswerEntity(10, getResources().getString(R.string.response_options_2_4_2)));
        answerEntityArrayList.add(new AnswerEntity(11, getResources().getString(R.string.response_options_2_4_3)));
        answerEntityArrayList.add(new AnswerEntity(12, getResources().getString(R.string.response_options_2_5_1)));
        answerEntityArrayList.add(new AnswerEntity(13, getResources().getString(R.string.response_options_2_5_2)));
        answerEntityArrayList.add(new AnswerEntity(14, getResources().getString(R.string.response_options_2_6_1)));
        answerEntityArrayList.add(new AnswerEntity(15, getResources().getString(R.string.response_options_2_6_2)));
        answerEntityArrayList.add(new AnswerEntity(16, getResources().getString(R.string.response_options_2_6_3)));
        answerEntityArrayList.add(new AnswerEntity(17, getResources().getString(R.string.response_options_2_7_1)));
        answerEntityArrayList.add(new AnswerEntity(18, getResources().getString(R.string.response_options_2_7_2)));
        answerEntityArrayList.add(new AnswerEntity(19, getResources().getString(R.string.response_options_2_7_3)));
        answerEntityArrayList.add(new AnswerEntity(20, getResources().getString(R.string.response_options_2_8_1)));
        answerEntityArrayList.add(new AnswerEntity(21, getResources().getString(R.string.response_options_2_8_2)));
        answerEntityArrayList.add(new AnswerEntity(22, getResources().getString(R.string.response_options_2_8_3)));
        answerEntityArrayList.add(new AnswerEntity(23, getResources().getString(R.string.response_options_2_8_4)));
        answerEntityArrayList.add(new AnswerEntity(24, getResources().getString(R.string.response_options_2_9_1)));
        answerEntityArrayList.add(new AnswerEntity(25, getResources().getString(R.string.response_options_2_9_2)));
        answerEntityArrayList.add(new AnswerEntity(26, getResources().getString(R.string.response_options_2_9_3)));
        answerEntityArrayList.add(new AnswerEntity(27, getResources().getString(R.string.response_options_2_10_1)));
        answerEntityArrayList.add(new AnswerEntity(28, getResources().getString(R.string.response_options_2_10_2)));
        answerEntityArrayList.add(new AnswerEntity(29, getResources().getString(R.string.response_options_2_10_3)));
        answerEntityArrayList.add(new AnswerEntity(30, getResources().getString(R.string.response_options_2_10_4)));
        answerEntityArrayList.add(new AnswerEntity(31, getResources().getString(R.string.response_options_2_11_1)));
        answerEntityArrayList.add(new AnswerEntity(32, getResources().getString(R.string.response_options_2_11_2)));
        answerEntityArrayList.add(new AnswerEntity(33, getResources().getString(R.string.response_options_2_11_3)));
        answerEntityArrayList.add(new AnswerEntity(34, getResources().getString(R.string.response_options_2_11_4)));
        answerEntityArrayList.add(new AnswerEntity(35, getResources().getString(R.string.response_options_2_12_1)));
        answerEntityArrayList.add(new AnswerEntity(36, getResources().getString(R.string.response_options_2_12_2)));
        answerEntityArrayList.add(new AnswerEntity(37, getResources().getString(R.string.response_options_2_12_3)));
        answerEntityArrayList.add(new AnswerEntity(38, getResources().getString(R.string.response_options_2_12_4)));
        answerEntityArrayList.add(new AnswerEntity(39, getResources().getString(R.string.response_options_2_13_1)));
        answerEntityArrayList.add(new AnswerEntity(40, getResources().getString(R.string.response_options_2_13_2)));
        answerEntityArrayList.add(new AnswerEntity(41, getResources().getString(R.string.response_options_2_13_3)));
        answerEntityArrayList.add(new AnswerEntity(42, getResources().getString(R.string.response_options_2_14_1)));
        answerEntityArrayList.add(new AnswerEntity(43, getResources().getString(R.string.response_options_2_14_2)));
        answerEntityArrayList.add(new AnswerEntity(44, getResources().getString(R.string.response_options_2_14_3)));
        answerEntityArrayList.add(new AnswerEntity(45, getResources().getString(R.string.response_options_2_15_1)));
        answerEntityArrayList.add(new AnswerEntity(46, getResources().getString(R.string.response_options_2_15_2)));
        answerEntityArrayList.add(new AnswerEntity(47, getResources().getString(R.string.response_options_2_15_3)));
        answerEntityArrayList.add(new AnswerEntity(48, getResources().getString(R.string.response_options_2_15_4)));
        answerEntityArrayList.add(new AnswerEntity(49, getResources().getString(R.string.response_options_2_16_1)));
        answerEntityArrayList.add(new AnswerEntity(50, getResources().getString(R.string.response_options_2_16_2)));
        answerEntityArrayList.add(new AnswerEntity(51, getResources().getString(R.string.response_options_2_17_1)));
        answerEntityArrayList.add(new AnswerEntity(52, getResources().getString(R.string.response_options_2_17_2)));
        answerEntityArrayList.add(new AnswerEntity(53, getResources().getString(R.string.response_options_2_17_3)));
        answerEntityArrayList.add(new AnswerEntity(54, getResources().getString(R.string.response_options_2_18_1)));
        answerEntityArrayList.add(new AnswerEntity(55, getResources().getString(R.string.response_options_2_18_2)));
        answerEntityArrayList.add(new AnswerEntity(56, getResources().getString(R.string.response_options_2_19_1)));
        answerEntityArrayList.add(new AnswerEntity(57, getResources().getString(R.string.response_options_2_19_2)));
        answerEntityArrayList.add(new AnswerEntity(58, getResources().getString(R.string.response_options_2_19_3)));
        answerEntityArrayList.add(new AnswerEntity(59, getResources().getString(R.string.response_options_2_20_1)));
        answerEntityArrayList.add(new AnswerEntity(60, getResources().getString(R.string.response_options_2_20_2)));

        answerEntityArrayListTrue = new ArrayList<>();
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_2_1_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_2_2_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_2_3_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_2_4_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_2_5_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_2_6_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_2_7_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_2_8_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_2_9_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_2_10_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_2_11_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_2_12_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_2_13_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_2_14_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_2_15_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_2_16_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_2_17_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_2_18_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_2_19_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_2_20_1)));

        questionEntityArrayList = new ArrayList<>();
        questionEntityArrayList.add(new QuestionEntity(0, getResources().getString(R.string.question_2_1), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(1, getResources().getString(R.string.question_2_2), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(2, getResources().getString(R.string.question_2_3), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(3, getResources().getString(R.string.question_2_4), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(4, getResources().getString(R.string.question_2_5), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(5, getResources().getString(R.string.question_2_6), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(6, getResources().getString(R.string.question_2_7), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(7, getResources().getString(R.string.question_2_8), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(8, getResources().getString(R.string.question_2_9), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(9, getResources().getString(R.string.question_2_10), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(10, getResources().getString(R.string.question_2_11), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(11, getResources().getString(R.string.question_2_12), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(12, getResources().getString(R.string.question_2_13), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(13, getResources().getString(R.string.question_2_14), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(14, getResources().getString(R.string.question_2_15), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(15, getResources().getString(R.string.question_2_16), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(16, getResources().getString(R.string.question_2_17), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(17, getResources().getString(R.string.question_2_18), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(18, getResources().getString(R.string.question_2_19), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(19, getResources().getString(R.string.question_2_20), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
    }

    private void dataTest3() {
        answerEntityArrayList = new ArrayList<>();
        answerEntityArrayList.add(new AnswerEntity(0, getResources().getString(R.string.response_options_3_1_1)));
        answerEntityArrayList.add(new AnswerEntity(1, getResources().getString(R.string.response_options_3_1_2)));
        answerEntityArrayList.add(new AnswerEntity(2, getResources().getString(R.string.response_options_3_1_3)));
        answerEntityArrayList.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_2_1)));
        answerEntityArrayList.add(new AnswerEntity(4, getResources().getString(R.string.response_options_3_2_2)));
        answerEntityArrayList.add(new AnswerEntity(5, getResources().getString(R.string.response_options_3_2_3)));
        answerEntityArrayList.add(new AnswerEntity(6, getResources().getString(R.string.response_options_3_3_1)));
        answerEntityArrayList.add(new AnswerEntity(7, getResources().getString(R.string.response_options_3_3_2)));
        answerEntityArrayList.add(new AnswerEntity(8, getResources().getString(R.string.response_options_3_3_3)));
        answerEntityArrayList.add(new AnswerEntity(9, getResources().getString(R.string.response_options_3_4_1)));
        answerEntityArrayList.add(new AnswerEntity(10, getResources().getString(R.string.response_options_3_4_2)));
        answerEntityArrayList.add(new AnswerEntity(11, getResources().getString(R.string.response_options_3_4_3)));
        answerEntityArrayList.add(new AnswerEntity(12, getResources().getString(R.string.response_options_3_5_1)));
        answerEntityArrayList.add(new AnswerEntity(13, getResources().getString(R.string.response_options_3_5_2)));
        answerEntityArrayList.add(new AnswerEntity(14, getResources().getString(R.string.response_options_3_5_3)));
        answerEntityArrayList.add(new AnswerEntity(15, getResources().getString(R.string.response_options_3_6_1)));
        answerEntityArrayList.add(new AnswerEntity(16, getResources().getString(R.string.response_options_3_6_2)));
        answerEntityArrayList.add(new AnswerEntity(17, getResources().getString(R.string.response_options_3_6_3)));
        answerEntityArrayList.add(new AnswerEntity(18, getResources().getString(R.string.response_options_3_6_4)));
        answerEntityArrayList.add(new AnswerEntity(19, getResources().getString(R.string.response_options_3_7_1)));
        answerEntityArrayList.add(new AnswerEntity(20, getResources().getString(R.string.response_options_3_7_2)));
        answerEntityArrayList.add(new AnswerEntity(21, getResources().getString(R.string.response_options_3_7_3)));
        answerEntityArrayList.add(new AnswerEntity(22, getResources().getString(R.string.response_options_3_8_1)));
        answerEntityArrayList.add(new AnswerEntity(23, getResources().getString(R.string.response_options_3_8_2)));
        answerEntityArrayList.add(new AnswerEntity(24, getResources().getString(R.string.response_options_3_8_3)));
        answerEntityArrayList.add(new AnswerEntity(25, getResources().getString(R.string.response_options_3_8_4)));
        answerEntityArrayList.add(new AnswerEntity(26, getResources().getString(R.string.response_options_3_8_5)));
        answerEntityArrayList.add(new AnswerEntity(27, getResources().getString(R.string.response_options_3_9_1)));
        answerEntityArrayList.add(new AnswerEntity(28, getResources().getString(R.string.response_options_3_9_2)));
        answerEntityArrayList.add(new AnswerEntity(29, getResources().getString(R.string.response_options_3_9_3)));
        answerEntityArrayList.add(new AnswerEntity(30, getResources().getString(R.string.response_options_3_9_4)));
        answerEntityArrayList.add(new AnswerEntity(31, getResources().getString(R.string.response_options_3_10_1)));
        answerEntityArrayList.add(new AnswerEntity(32, getResources().getString(R.string.response_options_3_10_2)));
        answerEntityArrayList.add(new AnswerEntity(33, getResources().getString(R.string.response_options_3_10_3)));
        answerEntityArrayList.add(new AnswerEntity(34, getResources().getString(R.string.response_options_3_10_4)));
        answerEntityArrayList.add(new AnswerEntity(35, getResources().getString(R.string.response_options_3_11_1)));
        answerEntityArrayList.add(new AnswerEntity(36, getResources().getString(R.string.response_options_3_11_2)));
        answerEntityArrayList.add(new AnswerEntity(37, getResources().getString(R.string.response_options_3_11_3)));
        answerEntityArrayList.add(new AnswerEntity(38, getResources().getString(R.string.response_options_3_11_4)));
        answerEntityArrayList.add(new AnswerEntity(39, getResources().getString(R.string.response_options_3_12_1)));
        answerEntityArrayList.add(new AnswerEntity(40, getResources().getString(R.string.response_options_3_12_2)));
        answerEntityArrayList.add(new AnswerEntity(41, getResources().getString(R.string.response_options_3_12_3)));
        answerEntityArrayList.add(new AnswerEntity(42, getResources().getString(R.string.response_options_3_13_1)));
        answerEntityArrayList.add(new AnswerEntity(43, getResources().getString(R.string.response_options_3_13_2)));
        answerEntityArrayList.add(new AnswerEntity(44, getResources().getString(R.string.response_options_3_13_3)));
        answerEntityArrayList.add(new AnswerEntity(45, getResources().getString(R.string.response_options_3_13_4)));
        answerEntityArrayList.add(new AnswerEntity(46, getResources().getString(R.string.response_options_3_14_1)));
        answerEntityArrayList.add(new AnswerEntity(47, getResources().getString(R.string.response_options_3_14_2)));
        answerEntityArrayList.add(new AnswerEntity(48, getResources().getString(R.string.response_options_3_14_3)));
        answerEntityArrayList.add(new AnswerEntity(49, getResources().getString(R.string.response_options_3_15_1)));
        answerEntityArrayList.add(new AnswerEntity(50, getResources().getString(R.string.response_options_3_15_2)));
        answerEntityArrayList.add(new AnswerEntity(51, getResources().getString(R.string.response_options_3_15_3)));
        answerEntityArrayList.add(new AnswerEntity(52, getResources().getString(R.string.response_options_3_16_1)));
        answerEntityArrayList.add(new AnswerEntity(53, getResources().getString(R.string.response_options_3_16_2)));
        answerEntityArrayList.add(new AnswerEntity(54, getResources().getString(R.string.response_options_3_16_3)));
        answerEntityArrayList.add(new AnswerEntity(55, getResources().getString(R.string.response_options_3_17_1)));
        answerEntityArrayList.add(new AnswerEntity(56, getResources().getString(R.string.response_options_3_17_2)));
        answerEntityArrayList.add(new AnswerEntity(57, getResources().getString(R.string.response_options_3_18_1)));
        answerEntityArrayList.add(new AnswerEntity(58, getResources().getString(R.string.response_options_3_18_2)));
        answerEntityArrayList.add(new AnswerEntity(59, getResources().getString(R.string.response_options_3_18_3)));
        answerEntityArrayList.add(new AnswerEntity(60, getResources().getString(R.string.response_options_3_19_1)));
        answerEntityArrayList.add(new AnswerEntity(61, getResources().getString(R.string.response_options_3_19_2)));
        answerEntityArrayList.add(new AnswerEntity(62, getResources().getString(R.string.response_options_3_19_3)));
        answerEntityArrayList.add(new AnswerEntity(63, getResources().getString(R.string.response_options_3_20_1)));
        answerEntityArrayList.add(new AnswerEntity(64, getResources().getString(R.string.response_options_3_20_2)));
        answerEntityArrayList.add(new AnswerEntity(65, getResources().getString(R.string.response_options_3_20_3)));


        answerEntityArrayListTrue = new ArrayList<>();
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_1_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_2_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_3_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_4_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_5_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_6_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_3_7_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_3_8_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_3_9_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_3_10_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_3_11_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_12_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_3_13_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_14_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_3_15_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_16_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_3_17_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_3_18_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_3_19_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_3_20_3)));

        questionEntityArrayList = new ArrayList<>();
        questionEntityArrayList.add(new QuestionEntity(0, getResources().getString(R.string.question_3_1), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(1, getResources().getString(R.string.question_3_2), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(2, getResources().getString(R.string.question_3_3), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(3, getResources().getString(R.string.question_3_4), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(4, getResources().getString(R.string.question_3_5), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(5, getResources().getString(R.string.question_3_6), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(6, getResources().getString(R.string.question_3_7), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(7, getResources().getString(R.string.question_3_8), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(8, getResources().getString(R.string.question_3_9), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(9, getResources().getString(R.string.question_3_10), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(10, getResources().getString(R.string.question_3_11), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(11, getResources().getString(R.string.question_3_12), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(12, getResources().getString(R.string.question_3_13), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(13, getResources().getString(R.string.question_3_14), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(14, getResources().getString(R.string.question_3_15), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(15, getResources().getString(R.string.question_3_16), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(16, getResources().getString(R.string.question_3_17), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(17, getResources().getString(R.string.question_3_18), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(18, getResources().getString(R.string.question_3_19), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(19, getResources().getString(R.string.question_3_20), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
    }

    private void dataTest4() {
        int i = 0;
        answerEntityArrayList = new ArrayList<>();
        answerEntityArrayList.add(new AnswerEntity(i, getResources().getString(R.string.response_options_4_1_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_1_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_1_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_1_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_2_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_2_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_2_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_3_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_3_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_3_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_4_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_4_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_4_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_5_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_5_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_5_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_5_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_5_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_6_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_6_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_6_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_7_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_7_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_7_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_8_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_8_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_8_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_9_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_9_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_9_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_9_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_10_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_10_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_10_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_10_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_11_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_11_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_11_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_12_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_12_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_12_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_12_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_13_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_13_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_13_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_14_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_14_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_15_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_15_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_15_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_16_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_16_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_16_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_17_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_17_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_17_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_18_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_18_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_18_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_19_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_19_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_19_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_19_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_20_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_20_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_4_20_3)));


        answerEntityArrayListTrue = new ArrayList<>();
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_4_1_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_4_2_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_4_3_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_4_4_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_4_5_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_4_6_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_4_7_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_4_8_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_4_9_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_4_10_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_4_11_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_4_12_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_4_13_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_4_14_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_4_15_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_4_16_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_4_17_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_4_18_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_4_19_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_4_20_1)));

        questionEntityArrayList = new ArrayList<>();
        questionEntityArrayList.add(new QuestionEntity(0, getResources().getString(R.string.question_4_1), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(1, getResources().getString(R.string.question_4_2), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(2, getResources().getString(R.string.question_4_3), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(3, getResources().getString(R.string.question_4_4), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(4, getResources().getString(R.string.question_4_5), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(5, getResources().getString(R.string.question_4_6), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(6, getResources().getString(R.string.question_4_7), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(7, getResources().getString(R.string.question_4_8), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(8, getResources().getString(R.string.question_4_9), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(9, getResources().getString(R.string.question_4_10), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(10, getResources().getString(R.string.question_4_11), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(11, getResources().getString(R.string.question_4_12), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(12, getResources().getString(R.string.question_4_13), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(13, getResources().getString(R.string.question_4_14), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(14, getResources().getString(R.string.question_4_15), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(15, getResources().getString(R.string.question_4_16), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(16, getResources().getString(R.string.question_4_17), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(17, getResources().getString(R.string.question_4_18), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(18, getResources().getString(R.string.question_4_19), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(19, getResources().getString(R.string.question_4_20), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
    }

    private void dataTest5() {
        int i = 0;
        answerEntityArrayList = new ArrayList<>();
        answerEntityArrayList.add(new AnswerEntity(i, getResources().getString(R.string.response_options_5_1_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_1_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_1_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_2_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_2_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_2_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_2_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_3_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_3_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_3_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_3_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_3_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_4_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_4_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_4_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_5_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_5_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_5_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_5_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_5_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_6_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_6_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_6_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_7_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_7_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_7_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_8_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_8_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_8_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_8_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_9_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_9_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_10_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_10_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_10_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_10_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_11_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_11_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_11_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_11_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_12_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_12_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_12_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_12_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_12_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_13_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_13_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_13_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_14_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_14_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_14_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_14_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_14_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_15_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_15_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_15_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_15_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_15_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_16_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_16_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_16_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_17_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_17_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_17_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_18_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_18_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_18_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_19_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_19_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_19_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_20_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_20_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_5_20_3)));


        answerEntityArrayListTrue = new ArrayList<>();
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_5_1_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_5_2_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_5_3_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_5_4_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_5_5_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_5_6_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_5_7_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_5_8_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_5_9_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_5_10_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_5_11_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_5_12_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_5_13_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(5, getResources().getString(R.string.response_options_5_14_5)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_5_15_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_5_16_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_5_17_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_5_18_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_5_19_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_5_20_1)));

        questionEntityArrayList = new ArrayList<>();
        questionEntityArrayList.add(new QuestionEntity(0, getResources().getString(R.string.question_5_1), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(1, getResources().getString(R.string.question_5_2), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(2, getResources().getString(R.string.question_5_3), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(3, getResources().getString(R.string.question_5_4), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(4, getResources().getString(R.string.question_5_5), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(5, getResources().getString(R.string.question_5_6), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(6, getResources().getString(R.string.question_5_7), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(7, getResources().getString(R.string.question_5_8), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(8, getResources().getString(R.string.question_5_9), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(9, getResources().getString(R.string.question_5_10), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(10, getResources().getString(R.string.question_5_11), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(11, getResources().getString(R.string.question_5_12), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(12, getResources().getString(R.string.question_5_13), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(13, getResources().getString(R.string.question_5_14), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(14, getResources().getString(R.string.question_5_15), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(15, getResources().getString(R.string.question_5_16), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(16, getResources().getString(R.string.question_5_17), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(17, getResources().getString(R.string.question_5_18), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(18, getResources().getString(R.string.question_5_19), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(19, getResources().getString(R.string.question_5_20), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
    }

    private void dataTest6() {
        int i = 0;
        answerEntityArrayList = new ArrayList<>();
        answerEntityArrayList.add(new AnswerEntity(i, getResources().getString(R.string.response_options_6_1_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_1_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_2_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_2_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_2_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_3_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_3_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_3_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_5_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_5_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_5_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_5_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_5_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_6_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_6_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_6_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_6_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_6_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_7_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_7_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_7_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_8_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_8_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_8_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_8_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_9_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_9_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_10_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_10_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_11_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_11_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_11_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_12_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_12_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_12_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_12_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_12_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_13_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_13_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_13_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_14_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_14_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_14_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_14_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_15_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_15_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_16_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_16_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_16_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_17_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_17_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_18_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_18_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_18_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_19_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_19_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_19_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_19_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_20_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_20_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_6_20_3)));


        answerEntityArrayListTrue = new ArrayList<>();
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_6_1_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_6_2_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_6_3_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, "3"));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_6_5_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_6_6_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_6_7_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_6_8_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_6_9_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_6_10_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_6_11_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_6_12_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_6_13_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_6_14_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_6_15_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_6_16_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_6_17_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_6_18_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_6_19_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_6_20_2)));

        questionEntityArrayList = new ArrayList<>();
        questionEntityArrayList.add(new QuestionEntity(0, getResources().getString(R.string.question_6_1), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(1, getResources().getString(R.string.question_6_2), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(2, getResources().getString(R.string.question_6_3), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(3, getResources().getString(R.string.question_6_4), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(4, getResources().getString(R.string.question_6_5), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(5, getResources().getString(R.string.question_6_6), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(6, getResources().getString(R.string.question_6_7), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(7, getResources().getString(R.string.question_6_8), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(8, getResources().getString(R.string.question_6_9), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(9, getResources().getString(R.string.question_6_10), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(10, getResources().getString(R.string.question_6_11), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(11, getResources().getString(R.string.question_6_12), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(12, getResources().getString(R.string.question_6_13), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(13, getResources().getString(R.string.question_6_14), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(14, getResources().getString(R.string.question_6_15), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(15, getResources().getString(R.string.question_6_16), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(16, getResources().getString(R.string.question_6_17), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(17, getResources().getString(R.string.question_6_18), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(18, getResources().getString(R.string.question_6_19), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(19, getResources().getString(R.string.question_6_20), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
    }

    private void dataTest7() {
        int i = 0;
        answerEntityArrayList = new ArrayList<>();
        answerEntityArrayList.add(new AnswerEntity(i, getResources().getString(R.string.response_options_7_1_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_1_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_1_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_2_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_2_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_2_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_2_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_3_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_3_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_3_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_3_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_3_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_4_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_4_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_4_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_4_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_5_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_5_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_5_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_6_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_6_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_6_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_6_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_6_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_7_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_7_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_7_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_7_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_8_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_8_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_8_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_8_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_8_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_9_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_9_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_9_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_10_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_10_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_10_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_11_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_11_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_11_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_11_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_12_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_12_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_12_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_12_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_12_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_13_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_13_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_13_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_14_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_14_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_14_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_15_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_15_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_15_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_15_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_16_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_16_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_16_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_17_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_17_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_17_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_18_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_18_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_18_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_19_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_19_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_19_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_20_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_20_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_7_20_3)));


        answerEntityArrayListTrue = new ArrayList<>();
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_7_1_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_7_2_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_7_3_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_7_4_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_7_5_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_7_6_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_7_7_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_7_8_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_7_9_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_7_10_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_7_11_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_7_12_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_7_13_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_7_14_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_7_15_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_7_16_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_7_17_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_7_18_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_7_19_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_7_20_3)));

        questionEntityArrayList = new ArrayList<>();
        questionEntityArrayList.add(new QuestionEntity(0, getResources().getString(R.string.question_7_1), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(1, getResources().getString(R.string.question_7_2), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(2, getResources().getString(R.string.question_7_3), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(3, getResources().getString(R.string.question_7_4), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(4, getResources().getString(R.string.question_7_5), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(5, getResources().getString(R.string.question_7_6), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(6, getResources().getString(R.string.question_7_7), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(7, getResources().getString(R.string.question_7_8), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(8, getResources().getString(R.string.question_7_9), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(9, getResources().getString(R.string.question_7_10), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(10, getResources().getString(R.string.question_7_11), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(11, getResources().getString(R.string.question_7_12), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(12, getResources().getString(R.string.question_7_13), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(13, getResources().getString(R.string.question_7_14), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(14, getResources().getString(R.string.question_7_15), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(15, getResources().getString(R.string.question_7_16), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(16, getResources().getString(R.string.question_7_17), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(17, getResources().getString(R.string.question_7_18), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(18, getResources().getString(R.string.question_7_19), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(19, getResources().getString(R.string.question_7_20), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
    }

    private void dataTest8() {
        int i = 0;
        answerEntityArrayList = new ArrayList<>();
        answerEntityArrayList.add(new AnswerEntity(i, getResources().getString(R.string.response_options_8_1_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_1_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_1_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_2_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_2_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_2_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_3_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_3_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_3_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_4_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_4_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_4_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_4_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_4_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_5_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_5_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_5_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_5_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_6_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_6_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_6_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_7_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_7_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_7_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_7_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_8_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_8_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_8_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_9_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_9_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_9_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_9_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_9_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_10_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_10_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_10_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_11_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_11_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_11_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_12_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_12_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_12_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_12_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_12_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_13_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_13_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_13_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_14_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_14_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_14_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_14_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_14_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_15_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_15_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_15_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_16_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_16_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_16_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_17_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_17_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_17_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_17_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_18_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_18_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_18_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_18_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_19_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_19_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_19_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_20_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_8_20_2)));


        answerEntityArrayListTrue = new ArrayList<>();
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_8_1_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_8_2_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_8_3_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_8_4_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_8_5_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_8_6_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_8_7_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_8_8_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_8_9_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_8_10_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_8_11_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_8_12_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_8_13_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_8_14_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_8_15_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_8_16_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_8_17_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_8_18_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_8_19_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_8_20_1)));

        questionEntityArrayList = new ArrayList<>();
        questionEntityArrayList.add(new QuestionEntity(0, getResources().getString(R.string.question_8_1), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(1, getResources().getString(R.string.question_8_2), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(2, getResources().getString(R.string.question_8_3), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(3, getResources().getString(R.string.question_8_4), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(4, getResources().getString(R.string.question_8_5), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(5, getResources().getString(R.string.question_8_6), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(6, getResources().getString(R.string.question_8_7), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(7, getResources().getString(R.string.question_8_8), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(8, getResources().getString(R.string.question_8_9), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(9, getResources().getString(R.string.question_8_10), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(10, getResources().getString(R.string.question_8_11), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(11, getResources().getString(R.string.question_8_12), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(12, getResources().getString(R.string.question_8_13), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(13, getResources().getString(R.string.question_8_14), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(14, getResources().getString(R.string.question_8_15), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(15, getResources().getString(R.string.question_8_16), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(16, getResources().getString(R.string.question_8_17), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(17, getResources().getString(R.string.question_8_18), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(18, getResources().getString(R.string.question_8_19), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(19, getResources().getString(R.string.question_8_20), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
    }

    private void dataTest9() {
        int i = 0;
        answerEntityArrayList = new ArrayList<>();
        answerEntityArrayList.add(new AnswerEntity(i, getResources().getString(R.string.response_options_9_1_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_1_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_1_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_1_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_2_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_2_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_2_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_3_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_3_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_5_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_5_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_5_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_6_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_6_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_6_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_7_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_7_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_7_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_7_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_8_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_8_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_8_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_9_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_9_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_9_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_10_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_10_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_10_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_11_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_11_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_11_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_12_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_12_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_12_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_12_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_12_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_13_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_13_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_14_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_14_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_14_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_14_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_15_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_15_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_16_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_16_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_16_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_17_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_17_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_17_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_17_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_18_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_18_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_18_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_19_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_19_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_20_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_20_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_9_20_3)));


        answerEntityArrayListTrue = new ArrayList<>();
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_9_1_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_9_2_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_9_3_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(5, "5"));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_9_5_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_9_6_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_9_7_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_9_8_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_9_9_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_9_10_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_9_11_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_9_12_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_9_13_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_9_14_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_9_15_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_9_16_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_9_17_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_9_18_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_9_19_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_9_20_2)));

        questionEntityArrayList = new ArrayList<>();
        questionEntityArrayList.add(new QuestionEntity(0, getResources().getString(R.string.question_9_1), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(1, getResources().getString(R.string.question_9_2), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(2, getResources().getString(R.string.question_9_3), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(3, getResources().getString(R.string.question_9_4), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(4, getResources().getString(R.string.question_9_5), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(5, getResources().getString(R.string.question_9_6), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(6, getResources().getString(R.string.question_9_7), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(7, getResources().getString(R.string.question_9_8), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(8, getResources().getString(R.string.question_9_9), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(9, getResources().getString(R.string.question_9_10), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(10, getResources().getString(R.string.question_9_11), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(11, getResources().getString(R.string.question_9_12), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(12, getResources().getString(R.string.question_9_13), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(13, getResources().getString(R.string.question_9_14), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(14, getResources().getString(R.string.question_9_15), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(15, getResources().getString(R.string.question_9_16), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(16, getResources().getString(R.string.question_9_17), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(17, getResources().getString(R.string.question_9_18), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(18, getResources().getString(R.string.question_9_19), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(19, getResources().getString(R.string.question_9_20), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
    }

    private void dataTest10() {
        int i = 0;
        answerEntityArrayList = new ArrayList<>();
        answerEntityArrayList.add(new AnswerEntity(i, getResources().getString(R.string.response_options_10_1_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_1_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_1_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_2_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_2_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_2_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_3_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_3_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_3_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_3_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_4_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_4_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_4_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_5_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_5_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_5_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_6_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_6_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_6_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_6_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_7_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_7_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_7_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_7_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_8_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_8_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_8_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_9_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_9_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_9_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_9_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_10_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_10_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_10_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_10_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_11_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_11_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_11_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_12_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_12_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_12_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_12_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_12_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_13_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_13_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_13_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_14_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_14_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_14_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_15_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_15_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_15_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_15_4)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_15_5)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_16_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_16_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_17_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_17_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_18_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_18_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_18_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_19_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_19_2)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_19_3)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_20_1)));
        answerEntityArrayList.add(new AnswerEntity(++i, getResources().getString(R.string.response_options_10_20_2)));


        answerEntityArrayListTrue = new ArrayList<>();
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_10_1_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_10_2_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_10_3_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_10_4_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_10_5_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_10_6_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(4, getResources().getString(R.string.response_options_10_7_4)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_10_8_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_10_9_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_10_10_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_10_11_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_10_12_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_10_13_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_10_14_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_10_15_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_10_16_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_10_17_2)));
        answerEntityArrayListTrue.add(new AnswerEntity(3, getResources().getString(R.string.response_options_10_18_3)));
        answerEntityArrayListTrue.add(new AnswerEntity(1, getResources().getString(R.string.response_options_10_19_1)));
        answerEntityArrayListTrue.add(new AnswerEntity(2, getResources().getString(R.string.response_options_10_20_2)));

        questionEntityArrayList = new ArrayList<>();
        questionEntityArrayList.add(new QuestionEntity(0, getResources().getString(R.string.question_10_1), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(1, getResources().getString(R.string.question_10_2), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(2, getResources().getString(R.string.question_10_3), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(3, getResources().getString(R.string.question_10_4), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(4, getResources().getString(R.string.question_10_5), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(5, getResources().getString(R.string.question_10_6), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(6, getResources().getString(R.string.question_10_7), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(7, getResources().getString(R.string.question_10_8), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(8, getResources().getString(R.string.question_10_9), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(9, getResources().getString(R.string.question_10_10), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(10, getResources().getString(R.string.question_10_11), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(11, getResources().getString(R.string.question_10_12), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(12, getResources().getString(R.string.question_10_13), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(13, getResources().getString(R.string.question_10_14), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(14, getResources().getString(R.string.question_10_15), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(15, getResources().getString(R.string.question_10_16), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(16, getResources().getString(R.string.question_10_17), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(17, getResources().getString(R.string.question_10_18), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(18, getResources().getString(R.string.question_10_19), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
        questionEntityArrayList.add(new QuestionEntity(19, getResources().getString(R.string.question_10_20), "", answerEntityArrayList, answerEntityArrayListTrue, 0));
    }

}