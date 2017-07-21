package com.andrebondar.andrepdd.screens.activities;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.screens.fragments.RegistrationFragment;
import com.andrebondar.andrepdd.screens.fragments.LoginFragment;
import com.facebook.CallbackManager;

/**
 * Created by Andre on 16.01.2017.
 */

public class EnterActivity extends AppCompatActivity {

    private LoginFragment loginFragment;
    private FragmentTransaction transaction;

    private static final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_activity);

        loginFragment = new LoginFragment();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.enter_activity_layout_for_fragments, loginFragment);
        transaction.commit();
    }
}
