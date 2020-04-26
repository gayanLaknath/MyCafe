package com.example.mycafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OtherCanteen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_canteen);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        Menu menu = bottomNav.getMenu();
        MenuItem  menuItem = menu.getItem(1);
        menuItem.setChecked(true);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.bnav_home:
                    Intent intent1 = new Intent(OtherCanteen.this,Dashboard.class);
                    startActivity(intent1);
                    finish();
                    break;
                case R.id.bnav_notification:
                    Intent intent3 = new Intent(OtherCanteen.this,Notification.class);
                    startActivity(intent3);
                    break;

            }
            return true;
        }
    };
}
