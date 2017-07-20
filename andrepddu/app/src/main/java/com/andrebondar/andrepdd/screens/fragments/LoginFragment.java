package com.andrebondar.andrepdd.screens.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.andrebondar.andrepdd.Constants;
import com.andrebondar.andrepdd.screens.activities.EnterActivity;
import com.andrebondar.andrepdd.screens.activities.MainActivity;
import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.Utils;
import com.andrebondar.andrepdd.entities.UserEntity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Andre on 16.01.2017.
 */

public class LoginFragment extends Fragment implements View.OnClickListener {

    private final String TAG = LoginFragment.class.getSimpleName();
    private String userName, userPassword;

    private View view;

    private TextView textLogin, textPassword;
    private Button loginEnterButton, loginRegistrationButton;

    private UserEntity userEntity;

    private RegistrationFragment registrationFragment;
    private LoginFragment loginFragment;
    private FragmentTransaction transaction;

    private EnterActivity enterActivity;
    private Context context;

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    /*
    Using LayoutInflater we got our LoginFragment's layout
     */

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        enterActivity = (EnterActivity) context;
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    String name = user.getDisplayName();
                    String email = user.getEmail();
                    Uri photoUrl = user.getPhotoUrl();
                    userEntity = Utils.loadUserEntity(context);
                    if(userEntity == null) userEntity = new UserEntity(-1, null, null, null);
                    userEntity = new UserEntity(-1, null, null, null);
                    userEntity.setId(0);
                    userEntity.setName(name);
//                    userEntity.setPassword(password);
//                    userEntity.setDescription(gender);
                    Utils.saveUserEntity(context, userEntity);
                    Log.v(TAG, userEntity.toString());
                    startSuccessToast(context);
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    Log.d(TAG, "onAuthStateChanged:signed_in: " + user.getUid());
                } else {
                    //TODO
                    Log.d(TAG, "onAuthStateChanged:signed_out: ");
                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.login_fragment, null); //We are parsing received layout

        registrationFragment = new RegistrationFragment();
        loginFragment = new LoginFragment();

        textLogin = (TextView) view.findViewById(R.id.login_fragment_text_login);
        textPassword = (TextView) view.findViewById(R.id.login_fragment_text_password);

        loginEnterButton = (Button) view.findViewById(R.id.login_fragment_button_enter);
        loginEnterButton.setOnClickListener(this);

        loginRegistrationButton = (Button) view.findViewById(R.id.login_fragment_button_registration);
        loginRegistrationButton.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        transaction = getFragmentManager().beginTransaction();
        switch(v.getId()) {
            case R.id.login_fragment_button_enter:
                userName = textLogin.getText().toString();
                userPassword = textPassword.getText().toString();

                userEntity = Utils.loadUserEntity(v.getContext());
//                if(userEntity == null) {
//                    Log.v(TAG, "input");
//                    userEntity = new UserEntity(-1, null, null, null);
//                    startAlertDialog(v.getContext());
//                    break;
//                }
//
                if(userName.isEmpty() || userPassword.isEmpty()) {
                    startAlertDialog(v.getContext());
                    if(userName.isEmpty()) startLoginToast(v.getContext());
                    if(userPassword.isEmpty()) startPasswordToast(v.getContext());
                    break;
                }

//                Log.v(TAG, userEntity.toString());
//                if(userName.equals(userEntity.getName()) && userPassword.equals(userEntity.getPassword())) {
//
//                    Intent intent = new Intent(context, MainActivity.class);
//                    //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
//                    enterActivity.finish();
//                    break;
//                } else {
//                    startAlertDialog(v.getContext());
//                }
                if (hasConnection(context)) {
                    signIn(userName, userPassword);
                } else {
                    connectionFaildToast(context);
                }

                break;
            case R.id.login_fragment_button_registration:
                transaction.replace(R.id.enter_activity_layout_for_fragments, registrationFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }
    }

    private void signIn(String email, final String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "signInWithEmail:onComplete: " + task.isSuccessful());
                if (!task.isSuccessful()) {
                    Log.w(TAG, "signInWithEmail:failed", task.getException());
                    Toast.makeText(context, "Authentication failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public static boolean hasConnection(final Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private void startAlertDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle(Constants.LOGIN_ACTIVITY_TEXT_TITLE);
        builder.setMessage(Constants.LOGIN_ACTIVITY_TEXT_MESSAGE);
        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void startSuccessToast(Context context) {
        Toast.makeText(context, Constants.LOGIN_ACTIVITY_TEXT_SUCCESS, Toast.LENGTH_LONG).show();
    }

    private void connectionFaildToast(Context context) {
        Toast.makeText(context, Constants.LOGIN_ACTIVITY_TEXT_CONNECTION_FAILD, Toast.LENGTH_LONG).show();
    }

    private void startLoginToast(Context context) {
        Toast.makeText(context, Constants.LOGIN_ACTIVITY_TEXT_TOAST_NAME, Toast.LENGTH_LONG).show();
    }

    private void startPasswordToast(Context context) {
        Toast.makeText(context, Constants.LOGIN_ACTIVITY_TEXT_TOAST_PASSWORD, Toast.LENGTH_LONG).show();
    }

    public TextView getTextLogin() {
        return textLogin;
    }
}
