package com.example.gomovie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class action6 extends AppCompatActivity {
    private ImageButton back1;
    private Button res6,time1,time2,time3;
    private VideoView myVideoView;
    public static HashMap<String, Integer> cartDetails = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_action6);
        back1=findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(action6.this, com.example.gomovie.action.class));
            }
        });
        res6=findViewById(R.id.res6);
        res6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart("Underground:");
                openCart();
            }
            private void addToCart(String item) {
                int count = cartDetails.getOrDefault(item, 0);
                cartDetails.put(item, count + 1);
            }
            private void openCart() {
                Intent intent = new Intent(action6.this, cart.class);
                startActivity(intent);}

        });
        time1=findViewById(R.id.time1);
        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time1.setBackgroundColor(getResources().getColor(R.color.gg));
            }
        });
        time2=findViewById(R.id.time2);
        time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time2.setBackgroundColor(getResources().getColor(R.color.gg));
            }
        });
        time3=findViewById(R.id.time3);
        time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time3.setBackgroundColor(getResources().getColor(R.color.gg));
            }
        });
        VideoView videoView = findViewById(R.id.myVideoView);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.underground);

        videoView.setVideoURI(videoUri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}