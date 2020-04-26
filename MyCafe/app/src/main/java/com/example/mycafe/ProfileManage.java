package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProfileManage extends AppCompatActivity {

    ImageView BackToMenu;
    private Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_manage);

        BackToMenu = findViewById(R.id.back);
        btnLogout = findViewById(R.id.logout_btn);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileManage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        BackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToDashboard = new Intent(ProfileManage.this,Dashboard.class);
                startActivity(intentToDashboard);
                finish();
            }
        });
    }
}
