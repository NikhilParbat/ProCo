package com.example.proco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class ForgetPasswordActivity extends AppCompatActivity {

    private Button mForgotPasswordButton;
    private EditText mEmail;
    private FirebaseAuth mAuth;
    private int flag;
    private String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+", email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        mAuth = FirebaseAuth.getInstance();
        flag = 0;
        mForgotPasswordButton = (Button) findViewById(R.id.resetPasswordButton);
        mEmail = (EditText) findViewById(R.id.resetPasswordEmail);

        mForgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmail.getText().toString();
                if (email.equals("")) {
                    Toast.makeText(ForgetPasswordActivity.this, "Email is empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Below code checks if email is valid or not;
                if (!email.matches(emailPattern)) {
                    Toast.makeText(ForgetPasswordActivity.this, "Incorrect email, Enter valid email Id", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                        flag = 1;
                        mAuth.sendPasswordResetEmail(mEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgetPasswordActivity.this, "Password Reset Email Has Been Sent To Your Email Successfully", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(ForgetPasswordActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                if (flag == 0) {
                    Toast.makeText(ForgetPasswordActivity.this, "Email address not found.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent btnClicked = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
        startActivity(btnClicked);
        super.onBackPressed();
        finish();
        return;
    }
}