package com.example.mycafe;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONObject;

import java.net.URL;

public class UserLogin extends AppCompatActivity {

    private EditText userEmail,userPassword;
    private Button login;
    private TextView createNewUser;
    SignInButton googleBtn;
    FirebaseAuth mAuth;
    private String username;
    private String password;
    private String baseUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        userEmail = findViewById(R.id.login_usernameOrEmail_input);
        userPassword = findViewById(R.id.login_password_input);
        login = findViewById(R.id.login_btn);
        googleBtn = findViewById(R.id.googleBtn);
        //createNewUser = findViewById(R.id.createUser);

        baseUrl = "http://localhost:8088/api/auth/signin";
//        RequestQueue requestQueue= Volley.newRequestQueue(this);
//
//        JsonObjectRequest objectRequest = new JsonObjectRequest(
//                Request.Method.GET,
//                URL,
//                null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.e("Rest Response",response.toString());
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("Rest Responce",error.toString());
//                    }
//                }
//        );
//            requestQueue.add(objectRequest);

        //In side On create method




























        //End
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ValidateLogin(userEmail.getText().toString(),userPassword.getText().toString());
                try {

                    username = userEmail.getText().toString();
                    password = userPassword.getText().toString();

                    ApiAuthenticationClient apiAuthenticationClient =
                            new ApiAuthenticationClient(
                                    baseUrl
                                    , username
                                    , password
                            );

                    AsyncTask<Void, Void, String> execute = new ExecuteNetworkOperation(apiAuthenticationClient);
                    execute.execute();
                } catch (Exception ex) {
                }
            }
        });
//        createNewUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(UserLogin.this,CreateUser.class));
//            }
//        });
    }


        //Out side On create method

    // Configure Google Sign In




























        //End
    private void ValidateLogin (String user_email , String user_password){
        if(user_email.isEmpty()){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }else if (user_password.isEmpty()){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }else{
            UserValidate(userEmail.getText().toString(),userPassword.getText().toString());
        }
    }

    private void UserValidate(String user_email , String user_password){
        if (user_email.equals("SC9930") && user_password.equals("gayan95")){
            Intent intentToDashboard = new Intent(UserLogin.this,Dashboard.class);
            startActivity(intentToDashboard);
            System.exit(1);
        }
        else if (user_email.equals("027") && user_password.equals("12345678")){
            Intent intentToDashboard = new Intent(UserLogin.this,Dashboard.class);
            startActivity(intentToDashboard);
            System.exit(1);
        }
        else if (user_email.equals("SC") && user_password.equals("amila95")){
            Intent intentToDashboard = new Intent(UserLogin.this,Dashboard.class);
            startActivity(intentToDashboard);
            System.exit(1);
        }
        else {
            Toast.makeText(this, "Invalid Log", Toast.LENGTH_SHORT).show();
        }
    }
        public class ExecuteNetworkOperation extends AsyncTask<Void, Void, String> {

            private ApiAuthenticationClient apiAuthenticationClient;
            private String isValidCredentials;

            /**
             * Overload the constructor to pass objects to this class.
             */
            public ExecuteNetworkOperation(ApiAuthenticationClient apiAuthenticationClient) {
                this.apiAuthenticationClient = apiAuthenticationClient;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                // Display the progress bar.
                findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
            }

            @Override
            protected String doInBackground(Void... params) {
                try {
                    isValidCredentials = apiAuthenticationClient.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                // Hide the progress bar.
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);

                // Login Success
                if (isValidCredentials.equals("true")) {
                    goToSecondActivity();
                }
                // Login Failure
                else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                }
            }
        }

    /**
     * Open a new activity window.
     */
    private void goToSecondActivity() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("password", password);
        bundle.putString("baseUrl", baseUrl);

        Intent intent = new Intent(this, Dashboard.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

