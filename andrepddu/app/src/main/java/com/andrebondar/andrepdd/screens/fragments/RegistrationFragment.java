package com.andrebondar.andrepdd.screens.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.andrebondar.andrepdd.Constants;
import com.andrebondar.andrepdd.screens.activities.MainActivity;
import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.Utils;
import com.andrebondar.andrepdd.entities.UserEntity;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

/**
 * Created by Andre on 16.01.2017.
 */

public class RegistrationFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private final String TAG = RegistrationFragment.class.getSimpleName();

    private String gender;

    private UserEntity userEntity;

    private EditText textViewName, textViewPassword, textConfirmPassword;
    private RadioButton radioButtonMale, radioButtonFemale;
    private Button buttonCheckIn;

    //facebook
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
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
                    userEntity = new UserEntity();
                    userEntity.setId(0);
                    userEntity.setName(name);
//                    userEntity.setPassword(password);
//                    userEntity.setDescription(gender);
                    Utils.saveUserEntity(context, userEntity);
                    Log.v(TAG, userEntity.toString());
                    startRegistrationToast(context);
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
        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.registration_fragment, null);

        callbackManager = CallbackManager.Factory.create();

        textViewName = (EditText) v.findViewById(R.id.registration_fragment_edit_text_name);
        textViewPassword = (EditText) v.findViewById(R.id.registration_fragment_edit_text_password);
        textConfirmPassword = (EditText) v.findViewById(R.id.registration_fragment_edit_text_password_repeat);

        radioButtonMale = (RadioButton) v.findViewById(R.id.registration_fragment_radio_button_male);
        radioButtonFemale = (RadioButton) v.findViewById(R.id.registration_fragment_radio_button_female);
        buttonCheckIn = (Button) v.findViewById(R.id.registration_fragment_button_check_in);

        //Facebook
        loginButton = (LoginButton) v.findViewById(R.id.facebook_login_button);
        loginButton.setReadPermissions("public_profile");
        loginButton.setFragment(this);
        loginButton.setOnClickListener(this);

        radioButtonMale.setOnClickListener(this);
        radioButtonFemale.setOnClickListener(this);
        buttonCheckIn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.registration_fragment_radio_button_male:
                radioButtonFemale.setChecked(false);
                gender = "male";
                break;
            case R.id.registration_fragment_radio_button_female:
                radioButtonMale.setChecked(false);
                gender = "female";
                break;
            case R.id.registration_fragment_button_check_in:
                String stringName = textViewName.getText().toString();
                String stringPassword = textViewPassword.getText().toString();
                String stringConfirmPassword = textConfirmPassword.getText().toString();
                Log.v(TAG, "stringName=" + stringName + ", stringPassword=" + stringPassword);
//                Log.v(TAG, "stringName=" + textViewName + ", stringPassword=" + textViewPassword);
                if(stringName.isEmpty() || stringPassword.isEmpty() || stringConfirmPassword.isEmpty()){
                    startRegistrationFieldToast(v.getContext());
                    break;
                }
//                if(gender == null) {
//                    startGenderDialog(v.getContext());
//                    break;
//                }
//                userEntity = Utils.loadUserEntity(v.getContext());
//                if(userEntity == null) userEntity = new UserEntity(-1, null, null, null);
//                Log.v(TAG, "userEntity.getName=" + userEntity.getName() + ", userEntity.getPassword=" + userEntity.getPassword());
//                if(userEntity.getId() == -1) {
//                    if (stringPassword.equals(stringConfirmPassword)) {
//                        Log.v(TAG, "userEntity.getName=" + userEntity.getName() + ", userEntity.getPassword=" + userEntity.getPassword());
//                        userEntity = new UserEntity();
//                        userEntity.setId(0);
//                        userEntity.setName(stringName);
//                        userEntity.setPassword(stringPassword);
//                        userEntity.setDescription(gender);
//                        Utils.saveUserEntity(v.getContext(), userEntity);
//                        Log.v(TAG, userEntity.toString());
//                        startRegistrationToast(v.getContext());
//                        Intent intent = new Intent(v.getContext(), MainActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
//                        break;
//                    } else {
//                        startResultCompareToast(v.getContext());
//                        break;
//                    }
//                }
                if (stringPassword.equals(stringConfirmPassword)) {
                    createAccount(stringName, stringPassword);
                    break;
                } else {
                    startResultCompareToast(v.getContext());
                    break;
                }
            case R.id.facebook_login_button:
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    private ProfileTracker profileTracker;
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        if (Profile.getCurrentProfile() == null) {

                            profileTracker = new ProfileTracker() {
                                @Override
                                protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                                    startFacebookLoginToastSuccess(context);
                                    String name = currentProfile.getName();
                                    String userId = currentProfile.getId();

                                    userEntity = new UserEntity();
                                    userEntity.setId(0);
                                    userEntity.setFbId(userId);
                                    userEntity.setName(name);
                                    userEntity.setDescription(gender);
                                    Utils.saveUserEntity(context, userEntity);

                                    Intent intent = new Intent(context, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    profileTracker.stopTracking();
                                }
                            };
                        } else {
                            startFacebookLoginToastSuccess(context);
                            String name = Profile.getCurrentProfile().getName();
                            String userId = Profile.getCurrentProfile().getId();

                            userEntity = new UserEntity();
                            userEntity.setId(0);
                            userEntity.setFbId(userId);
                            userEntity.setName(name);
                            userEntity.setDescription(gender);
                            Utils.saveUserEntity(context, userEntity);

                            Intent intent = new Intent(context, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancel() {
                        startFacebookLoginToastCancel(context);
                    }

                    @Override
                    public void onError(FacebookException error) {
                        error.printStackTrace();
                        startFacebookLoginToastError(context);
                    }
                });
                break;
        }
    }

    private void createAccount(final String email, final String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "createUserWithEmail:onComplete: " + task.isSuccessful());
                Log.v(TAG, "email=" + email + ", password=" + password);
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                if (user != null) {
//                    String name = user.getDisplayName();
//                    String email = user.getEmail();
//                    Uri photoUrl = user.getPhotoUrl();
//                    userEntity = Utils.loadUserEntity(context);
//                    if(userEntity == null) userEntity = new UserEntity(-1, null, null, null);
//                    userEntity = new UserEntity();
//                    userEntity.setId(0);
//                    userEntity.setName(name);
//                    userEntity.setPassword(password);
////                    userEntity.setDescription(gender);
//                    Utils.saveUserEntity(context, userEntity);
//                    Log.v(TAG, userEntity.toString());
//                    startRegistrationToast(context);
//                    Intent intent = new Intent(context, MainActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
//                }
                if (!task.isSuccessful()) {
                    Log.w(TAG, "createUserWithEmail:failure: ", task.getException());
                    Toast.makeText(context, "Authentication failed", Toast.LENGTH_LONG).show();
                }
            }
        });
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

    private void startFacebookLoginToastSuccess(Context context) {
        Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();
    }

    private void startFacebookLoginToastCancel(Context context) {
        Toast.makeText(context, "Cancel", Toast.LENGTH_LONG).show();
    }

    private void startFacebookLoginToastError(Context context) {
        Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
    }

    private void startFacebookLoginToastFatalError(Context context) {
        Toast.makeText(context, "Fatal error", Toast.LENGTH_LONG).show();
    }

    private void startRegistrationFieldToast(Context context) {
        Toast.makeText(context, Constants.REGISTRATION_FRAGMENT_EMPTY_FIELDS_MESSAGE, Toast.LENGTH_LONG).show();
    }

    private void startRegistrationToast(Context context) {
        Toast.makeText(context, "Registration", Toast.LENGTH_LONG).show();
    }

    private void startResultCompareToast(Context context) {
        Toast.makeText(context, Constants.REGISTRATION_FRAGMENT_RESULT_COMPARE_MESSAGE, Toast.LENGTH_LONG).show();
    }

    private void startGenderDialog (Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle(Constants.REGISTRATION_ACTVITY_TEXT_TITLE);
        builder.setMessage(Constants.REGISTRATION_ACTIVITY_TEXT_MESSAGE);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
