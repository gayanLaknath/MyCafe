package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Wallet extends AppCompatActivity {

    ImageView BackToMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        BackToMenu = findViewById(R.id.back);

        BackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToDashboard = new Intent(Wallet.this,Dashboard.class);
                startActivity(intentToDashboard);
                finish();
            }
        });



    }
}
