package com.example.ryandiwdjj.login_test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import org.w3c.dom.Text;

public class TestActivity extends AppCompatActivity {
    private TextView testNama;
    private TextView testEmail;
    private ImageView testImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        testNama = findViewById(R.id.testNama);
        testEmail = findViewById(R.id.testEmail);
        testImage = findViewById(R.id.testImage);

       testNama.setText(getIntent().getStringExtra("nama"));
       testEmail.setText(getIntent().getStringExtra("email"));
    }
}
