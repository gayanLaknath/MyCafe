package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CanteenBeforeLog extends AppCompatActivity {
    private ImageView directionToCanteen;
    private Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_before_log);

        directionToCanteen = findViewById(R.id.directionToCanteen);
        signIn =findViewById(R.id.btnSign_in);

        directionToCanteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CanteenBeforeLog.this,Direction.class));
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CanteenBeforeLog.this,UserLogin.class));
            }
        });
    }
}
