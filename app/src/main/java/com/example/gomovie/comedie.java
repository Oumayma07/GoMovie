package com.example.gomovie;

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

public class comedie extends AppCompatActivity {
    private ImageButton res1,res2,res3,res4,res5,res6;
    private ImageButton back1,fav1,fav2,fav3,fav4,fav5,fav6;
    public static HashMap<String, Integer> cartDetails = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_comedie);
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
                startActivity(new Intent(comedie.this, com.example.gomovie.MainActivity.class));
            }
        });
        res1=findViewById(R.id.res1);
        res1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film Litte Man:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(comedie.this, comedy1.class);
                startActivity(intent);}

        });
        res2=findViewById(R.id.res2);
        res2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film The DC Over:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(comedie.this, comedy2.class);
                startActivity(intent);}

        });
        res3=findViewById(R.id.res3);
        res3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film The Man From Toronto:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(comedie.this, comedy3.class);
                startActivity(intent);}

        });
        res4=findViewById(R.id.res4);
        res4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film Night School:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(comedie.this, comedy4.class);
                startActivity(intent);}

        });
        res5=findViewById(R.id.res5);
        res5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film HangOver:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(comedie.this, comedy5.class);
                startActivity(intent);}

        });
        res6=findViewById(R.id.res6);
        res6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Film HotDog:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(comedie.this, comedy6.class);
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