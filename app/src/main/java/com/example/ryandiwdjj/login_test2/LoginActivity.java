package com.example.ryandiwdjj.login_test2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private TextView signup;
    private TextView forgot_password;
    private Button login;

    private ProgressDialog progressBar;

    private String email_signup="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        signup = findViewById(R.id.btnSignup);
        forgot_password = findViewById(R.id.btnForgot);
        login = findViewById(R.id.btnLogin);

        getEmail();

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, forgotActivity.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //userLogin();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        }));
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
    }

    private void userLogin() {
        final String check_email = email.getText().toString().trim();
        final String check_password = password.getText().toString().trim();

        if(check_email.isEmpty()) {
            email.setError("Email Required");
            email.requestFocus();
            return;
        }

        if(check_password.isEmpty()) {
            password.setError("Password Required");
            password.requestFocus();
            return;
        }
    }

    private void getEmail() {
        email_signup = getIntent().getStringExtra("email");
        email.setText(email_signup);
    }
}
