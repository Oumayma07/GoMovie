package com.example.gomovie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class cart extends AppCompatActivity {
private ImageButton back1;
private Button btnpay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        back1=findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cart.this, com.example.gomovie.MainActivity.class));
            }
        });
        btnpay=findViewById(R.id.btnpay);
        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cart.this, com.example.gomovie.paiement.class));
            }
        });
        ArrayList<String> displayList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : disney.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item + " - Quantité : " + count);
        }
        ListView listView = findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter);
        for (Map.Entry<String, Integer> entry : action1.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item + " - Quantité : " + count);
        }

        for (Map.Entry<String, Integer> entry : action2.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item + " - Quantité : " + count);
        }
        for (Map.Entry<String, Integer> entry : action3.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item + " - Quantité : " + count);
        }
        for (Map.Entry<String, Integer> entry : action4.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item + " - Quantité : " + count);
        }
        for (Map.Entry<String, Integer> entry : action5.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item + " - Quantité : " + count);
        }
        for (Map.Entry<String, Integer> entry : action6.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item + " - Quantité : " + count);
        }
        ListView listView1 = findViewById(R.id.listview);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter1);
        for (Map.Entry<String, Integer> entry : comedie.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item + " - Quantité : " + count);
        }
        ListView listView2 = findViewById(R.id.listview);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter2);
        for (Map.Entry<String, Integer> entry : drama.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item + " - Quantité : " + count);
        }
        ListView listView3 = findViewById(R.id.listview);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter3);

        Button reserveButton = findViewById(R.id.btnpay);
        reserveButton.setOnClickListener(view -> {
            if(adapter==null || adapter.isEmpty()){
                Toast.makeText(cart.this,"Verify your cart",Toast.LENGTH_SHORT).show();
            }
            else{
            // Générer le code de réservation
            String reservationCode = generateReservationCode();
            // Passer le code à la page de réservation
            Intent intent = new Intent(this, paiement.class);
            intent.putExtra("RESERVATION_CODE", reservationCode);
            startActivity(intent);}
        });


    }

    private String generateReservationCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        // Générer un code de 8 caractères
        for (int i = 0; i < 8; i++) {
            code.append(chars.charAt(random.nextInt(chars.length())));
        }
        return code.toString();
    }

}