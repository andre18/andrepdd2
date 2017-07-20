package com.andrebondar.andrepdd.screens.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.Utils;
import com.andrebondar.andrepdd.entities.UserEntity;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Andre on 22.01.2017.
 */

public class AppSettings extends AppCompatActivity implements View.OnClickListener {

    private UserEntity userEntity;

    private Button buttonExit;
    private TextView textViewNik, textViewGender;

    private CallbackManager callbackManager;
    private Context context;

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_settings);

        mAuth = FirebaseAuth.getInstance();

        context = this;
//        callbackManager = CallbackManager.Factory.create();

        userEntity = Utils.loadUserEntity(this);

        textViewGender = (TextView) findViewById(R.id.app_settings_text_view_user_gender);
        textViewNik = (TextView) findViewById(R.id.app_settings_text_view_nik);

        textViewNik.setText(userEntity.getName());
        textViewGender.setText(userEntity.getDescription());

        buttonExit = (Button) findViewById(R.id.app_settings_button);
        buttonExit.setOnClickListener(this);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_settings_button:
                LoginManager.getInstance().logOut();
                mAuth.signOut();
                userEntity.clear();
                Utils.saveUserEntity(this, userEntity);
                Intent intent = new Intent(AppSettings.this, EnterActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);      //он закроет все активности, которые "выше" вызванной
                Log.v("AppSettings", userEntity.toString());
                startActivity(intent);
                break;
        }
    }
}
