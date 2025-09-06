package com.example.gomovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class forget_pass extends AppCompatActivity {
    private Button pssBtn;
    private EditText user,oldpass,newpass;
    private DataBaseHelper dbHelper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_pass);
        pssBtn=findViewById(R.id.pssBtn);
        user=findViewById(R.id.user);
        oldpass=findViewById(R.id.oldpass);
        newpass=findViewById(R.id.newpass);
        dbHelper = new DataBaseHelper(this);
        pssBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().isEmpty() || oldpass.getText().toString().isEmpty() || newpass.getText().toString().isEmpty()){
                    Toast.makeText(forget_pass.this, "Please fill your username and password", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean isUpdated = dbHelper.updatePassword(
                        user.getText().toString(),
                        oldpass.getText().toString(),
                        newpass.getText().toString()
                );
                if (isUpdated) {
                    Toast.makeText(forget_pass.this, "Mot de passe mis à jour avec succès", Toast.LENGTH_SHORT).show();
                    finish(); // Retour à l'écran précédent
                }
                else {
                    Toast.makeText(forget_pass.this, "Erreur : email ou ancien mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}