package com.example.gomovie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class disney extends AppCompatActivity {
    private ImageButton res1,res2,res3,res4,res5,res6;
    private ImageButton back1,fav1,fav2,fav3,fav4,fav5,fav6;
    public static HashMap<String, Integer> cartDetails = new HashMap<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_disney);
        fav1=findViewById(R.id.fav1);
        fav2=findViewById(R.id.fav2);
        fav3=findViewById(R.id.fav3);
        fav4=findViewById(R.id.fav4);
        fav5=findViewById(R.id.fav5);
        fav6=findViewById(R.id.fav6);
        fav1.setOnClickListener(v -> toggleFavorite(fav1));
        fav2.setOnClickListener(v -> toggleFavorite(fav2));
        fav3.setOnClickListener(v -> toggleFavorite(fav3));
        fav4.setOnClickListener(v -> toggleFavorite(fav4));
        fav5.setOnClickListener(v -> toggleFavorite(fav5));
        fav6.setOnClickListener(v -> toggleFavorite(fav6));
        back1=findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(disney.this, com.example.gomovie.MainActivity.class));
            }
        });

        res1=findViewById(R.id.res1);
        res1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film SOUL:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(disney.this, disney1.class);
                startActivity(intent);}

        });
        res2=findViewById(R.id.res2);
        res2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film Encanto:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(disney.this, disney2.class);
                startActivity(intent);}

        });
        res3=findViewById(R.id.res3);
        res3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film COCO:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(disney.this, disney3.class);
                startActivity(intent);}

        });
        res4=findViewById(R.id.res4);
        res4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film Barbie:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(disney.this, disney4.class);
                startActivity(intent);}

        });
        res5=findViewById(R.id.res5);
        res5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film Cendrillon:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(disney.this, disney5.class);
                startActivity(intent);}

        });
        res6=findViewById(R.id.res6);
        res6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film Roi Lion:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(disney.this, disney6.class);
                startActivity(intent);}

        });
    }

    private void toggleFavorite(ImageButton favoriteIcon) {
        if (favoriteIcon.getColorFilter() != null) {
            // Si l'icône a une couleur, réinitialiser
            favoriteIcon.clearColorFilter();
        } else {
            // Appliquer une couleur rouge
            favoriteIcon.setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_IN);

        }
    }

}