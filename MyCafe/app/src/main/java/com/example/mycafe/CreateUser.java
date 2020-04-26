package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateUser extends AppCompatActivity {

    private EditText newUserEmail , newUserUsername , getNewUserPassword , newUserPhone;
    private Button btnCreateUser;
    private TextView userLoginUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        setupUIView();

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){
                    //Update data to the database
                }
            }
        });

        userLoginUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateUser.this,UserLogin.class));
                finish();
            }
        });

    }
    private void setupUIView(){
        newUserEmail = findViewById(R.id.newUserEmail);
        newUserUsername = findViewById(R.id.newUserUsername);
        getNewUserPassword = findViewById(R.id.newUserPassword);
        btnCreateUser = findViewById(R.id.btn_createUser);
        userLoginUI = findViewById(R.id.userLogin_ui);
        newUserPhone = findViewById(R.id.newUserPhoneNumber);
    }
    private boolean validate(){
        Boolean result = false;

        String userEmail = newUserEmail.getText().toString();
        String userName = newUserUsername.getText().toString();
        String userPassword = getNewUserPassword.getText().toString();
        String userPhone = newUserPhone.getText().toString();

        if (userEmail.isEmpty() && userName.isEmpty() && userPassword.isEmpty() && userPhone.isEmpty()){
            Toast.makeText(this, "Please Enter All Details", Toast.LENGTH_SHORT).show();
        }else {
            result = true;
        }
        return result;
    }
}
