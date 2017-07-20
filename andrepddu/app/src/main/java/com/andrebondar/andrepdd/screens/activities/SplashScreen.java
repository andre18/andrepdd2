package com.andrebondar.andrepdd.screens.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.Utils;
import com.andrebondar.andrepdd.entities.UserEntity;

/**
 * Created by Andre on 01.01.2017.
 */

public class SplashScreen extends Activity{

    private UserEntity userEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userEntity = Utils.loadUserEntity(SplashScreen.this);
                if(userEntity == null) {
                    userEntity = new UserEntity();
                }
                if(userEntity.getId() == -1) {
                    Intent i = new Intent(SplashScreen.this, EnterActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        }, 3*1000);

    }
}
