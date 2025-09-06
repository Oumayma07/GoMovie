package com.example.gomovie;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

private Button loginBtn;
private TextView forgetpss;
private  TextView register;
private EditText userEdt,passEdt;
private DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        userEdt=findViewById(R.id.userEdt);
        passEdt=findViewById(R.id.passEdt);
        loginBtn=findViewById(R.id.loginBtn);
        dbHelper = new DataBaseHelper(this);
        loginBtn.setOnClickListener(view -> {
            String username = userEdt.getText().toString().trim();
            String psw = passEdt.getText().toString().trim();
            boolean userExists = dbHelper.checkUser(username,psw);
            if (username.isEmpty() || psw.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Enter your username and password", Toast.LENGTH_SHORT).show();
                return;
            }
            if (userExists) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "verify your login!", Toast.LENGTH_SHORT).show();
            }
        });

        forgetpss=findViewById(R.id.forgetpss);
        forgetpss.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, forget_pass.class)));
        register=findViewById(R.id.register);
        register.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, register.class)));
    }
}