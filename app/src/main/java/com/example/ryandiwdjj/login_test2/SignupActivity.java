package com.example.ryandiwdjj.login_test2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class SignupActivity extends AppCompatActivity {
    private EditText email;
    private EditText name;
    private EditText password;
    private EditText verif_password;
    private ImageView upload_image;
    private Button signup;

    FirebaseUser currentUser;

    String profileImageUrl;

    private static final int CHOOSE_IMAGE = 101;

    Uri uriProfileImage;

    private ProgressDialog progressDiag;
    private ProgressBar progressBar;

    private static final int SELECT_PICTURE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.signup_email);
        name = findViewById(R.id.signup_name);
        password = findViewById(R.id.signup_password);
        verif_password = findViewById(R.id.verif_password);
        //upload_image = findViewById(R.id.btn_upload);
        signup = findViewById(R.id.btn_activity_signup);
        progressBar = findViewById(R.id.progressBar);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test", "success click");
                registerUser();

            }
        });

        /**upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageChooser();
                //uploadImageToFirebase(); //procedure to upload image to firebase
                //saveUserInformation();
            }
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uriProfileImage = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uriProfileImage);
                upload_image.setImageBitmap(bitmap);

                Log.d("coba", "1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Profile Image"), CHOOSE_IMAGE);
    }

    private void registerUser() {
        final String check_name = name.getText().toString().trim();
        final String check_email = email.getText().toString().trim();
        final String check_password = password.getText().toString().trim();
        String check_verif = verif_password.getText().toString().trim();

        if (check_email.isEmpty()) {
            email.setError("Email Required");
            email.requestFocus();
            return;
        }

        if (check_name.isEmpty()) {
            name.setError("Name Required");
            name.requestFocus();
            return;
        }

        if (check_password.isEmpty()) {
            password.setError("Password Required");
            password.requestFocus();
            return;
        }

        if (check_verif.isEmpty()) {
            verif_password.setError("Verification Password Required");
            verif_password.requestFocus();
            return;
        }

        if (!check_password.equals(check_verif)) {
            verif_password.setError("Those password didn't match. Try again.");
            verif_password.requestFocus();
            return;
        }


    }
}