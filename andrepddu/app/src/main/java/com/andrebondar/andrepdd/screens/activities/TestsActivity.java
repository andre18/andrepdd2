package com.andrebondar.andrepdd.screens.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.screens.fragments.TestHeader;


/**
 * Created by Andre on 24.01.2017.
 */

public class TestsActivity extends AppCompatActivity {

    private final String TAG = TestsActivity.class.getSimpleName();

    private TestHeader testHeader;

    private FragmentTransaction transaction;

    private boolean userChoise;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tests_activity);



        testHeader = new TestHeader();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.tests_activity_layout_for_fragments, testHeader);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        startGetOutTestAlertActivity(TestsActivity.this);
    }

    private void startGetOutTestAlertActivity(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("Attention!");
        builder.setMessage("Are you sure you want to exit test?\nAnswers to questions will be lost.");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                userChoise = true;
                dialog.dismiss();
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
