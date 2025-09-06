package com.example.gomovie;

import static android.provider.SimPhonebookContract.SimRecords.PHONE_NUMBER;
import static android.util.Patterns.EMAIL_ADDRESS;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class explorer extends AppCompatActivity {
    private static final String PHONE_NUMBER = "tel:+96485767";
    private static final String EMAIL_ADDRESS = "example@example.com";
    private TextView email,site,num;
    private ImageButton back1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_explorer);
        back1 = findViewById(R.id.back1);
        email=findViewById(R.id.email);
        site=findViewById(R.id.site);
        num=findViewById(R.id.num);

        back1.setOnClickListener(view -> startActivity(new Intent(explorer.this, MainActivity.class)));
        email.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + EMAIL_ADDRESS));
            startActivity(Intent.createChooser(emailIntent, "Envoyer un Email"));
        });
        site.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.android.com"));
            startActivity(browserIntent);
        });
        num.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse(PHONE_NUMBER));
            startActivity(callIntent);
        });


        }

}
