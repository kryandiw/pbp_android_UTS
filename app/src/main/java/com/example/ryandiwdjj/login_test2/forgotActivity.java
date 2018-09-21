package com.example.ryandiwdjj.login_test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forgotActivity extends AppCompatActivity {
    private EditText email;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        email = findViewById(R.id.forgot_email);
        reset = findViewById(R.id.btn_activity_forgot);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reset procedure
            }
        });
    }
}
