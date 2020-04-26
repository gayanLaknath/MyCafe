package com.example.mycafe;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Dashboard extends AppCompatActivity {


    private ImageView Recipe,Wallet,Direction,Feedback,profile;
    private ImageView QrCode;
    private long backPressTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Recipe =findViewById(R.id.recipeOrder);
        Wallet = findViewById(R.id.walletMange);
        Direction = findViewById(R.id.directionToCanteen);
        Feedback = findViewById(R.id.commentFeedback);
        profile = findViewById(R.id.profile);
        QrCode = findViewById(R.id.qrCodeReader);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        Menu menu = bottomNav.getMenu();
        MenuItem  menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,ProfileManage.class);
                startActivity(intent);
                finish();
            }
        });
        Recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,RecipeAndOrder.class));
            }
        });
        Wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Wallet.class));
            }
        });
        Direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Direction.class));
            }
        });
        Feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Feedback.class));
            }
        });


        QrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Popup.class));
            }
        });


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){

                case R.id.bnav_other:
                    Intent intent1 = new Intent(Dashboard.this,OtherCanteen.class);
                    startActivity(intent1);
                    finish();
                    break;
                case R.id.bnav_notification:
                    Intent intent2 = new Intent(Dashboard.this,Notification.class);
                    startActivity(intent2);
                    finish();
                    break;

            }
            return true;
        }
    };

    @Override
    public void onBackPressed() {


        if (backPressTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast = Toast.makeText(getBaseContext(), "Press Back Again To Exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressTime = System.currentTimeMillis();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

}
