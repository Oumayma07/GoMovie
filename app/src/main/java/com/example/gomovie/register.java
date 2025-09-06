package com.example.gomovie;

import static android.os.Build.VERSION_CODES.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class register extends AppCompatActivity {
private EditText user,email,psw;
private Button registerBtn;
private DataBaseHelper dbHelper ;
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.activity_register);
        user=findViewById(R.id.user);
        email=findViewById(R.id.email);
        psw=findViewById(R.id.psw);
        dbHelper = new DataBaseHelper(this);
        registerBtn=findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(view -> {

            if (user.getText().toString().isEmpty() || email.getText().toString().isEmpty() || psw.getText().toString().isEmpty()) {
                Toast.makeText(register.this,"Enter your information!", Toast.LENGTH_SHORT).show();
            }

            boolean userCreated = dbHelper.addUser(user.getText().toString(), email.getText().toString(), psw.getText().toString());
            if (userCreated) {
                Toast.makeText(register.this,"Done",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(register.this, LoginActivity.class));
                finish(); // Retour à la page précédente
            } else {
                Toast.makeText(register.this, "Registration failed. Username might already exist.", Toast.LENGTH_SHORT).show();
            }



        });

    }
}