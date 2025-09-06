package com.example.gomovie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class paiement extends AppCompatActivity {
    private ImageButton back1;
    private Button save;
    private EditText name,email,tel,adress;
    private DataBaseHelper dbHelper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_paiement);
        TextView codeTextView = findViewById(R.id.tot);
        String reservationCode = getIntent().getStringExtra("RESERVATION_CODE");
        codeTextView.setText("Reservation code : " + reservationCode);
        back1=findViewById(R.id.back1);
        back1.setOnClickListener(view -> startActivity(new Intent(paiement.this, MainActivity.class)));
        save=findViewById(R.id.save);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        tel=findViewById(R.id.tel);
        adress=findViewById(R.id.adress);
        dbHelper = new DataBaseHelper(this);
        save.setOnClickListener(view -> {
            if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || tel.getText().toString().isEmpty() || adress.getText().toString().isEmpty()) {
                Toast.makeText(paiement.this,"Enter your information!", Toast.LENGTH_SHORT).show();
            }
            boolean filmCreated = dbHelper.addFilm(name.getText().toString(), email.getText().toString(), tel.getText().toString() , adress.getText().toString());
            if (filmCreated) {
                Toast.makeText(paiement.this,"Reservation Done",Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(paiement.this, "Reservation failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}