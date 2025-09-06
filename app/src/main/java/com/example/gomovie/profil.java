package com.example.gomovie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class profil extends AppCompatActivity {
private ImageButton back;
private TextView textname, textemail;
private DataBaseHelper dbHelper ;
private Button logoutbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profil);
        textname = findViewById(R.id.textname);
        textemail = findViewById(R.id.textemail);
        back = findViewById(R.id.back);
        dbHelper = new DataBaseHelper(this);
        displayUserInfo();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(profil.this, MainActivity.class));
            }
        });

        logoutbtn = findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profil.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Supprime la pile des activités
                startActivity(intent);
                Toast.makeText(profil.this, "LogOut", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void displayUserInfo() {
        Cursor cursor = dbHelper.getUser();
        if (cursor != null && cursor.moveToFirst()) {
            // Ensure column indexes are correct
            int nameColumnIndex = cursor.getColumnIndex(DataBaseHelper.COLUMN_USERNAME);
            int emailColumnIndex = cursor.getColumnIndex(DataBaseHelper.COLUMN_EMAIL);

            // Check that column indexes are valid (not -1)
            if (nameColumnIndex != -1 && emailColumnIndex != -1) {
                String name = cursor.getString(nameColumnIndex);
                String email = cursor.getString(emailColumnIndex);

                textname.setText(name);
                textemail.setText(email);
            } else {
                Log.e("ProfileActivity", "One or more columns are missing.");
            }
        } else {
            Log.e("ProfileActivity", "No data found in the database.");
        }

        if (cursor != null) {
            cursor.close();
        }


    }
}
