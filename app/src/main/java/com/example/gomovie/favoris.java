package com.example.gomovie;

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

public class favoris extends AppCompatActivity {
ImageButton back1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favoris);
        back1=findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(favoris.this, com.example.gomovie.MainActivity.class));
            }
        });
        ArrayList<String> displayList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : disney.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item );
        }
        ListView listView = findViewById(R.id.favorite);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter);
        for (Map.Entry<String, Integer> entry : action.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item);
        }
        ListView listView1 = findViewById(R.id.favorite);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter1);
        for (Map.Entry<String, Integer> entry : comedie.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item);
        }
        ListView listView2 = findViewById(R.id.favorite);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter2);
        for (Map.Entry<String, Integer> entry : drama.cartDetails.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            displayList.add(item);
        }
        ListView listView3 = findViewById(R.id.favorite);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter3);


    }
}