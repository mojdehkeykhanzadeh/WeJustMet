package com.example.mojdehkeykhanzadeh.starbucksapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {
    private EditText email;
    private EditText password;
    private EditText firstName;
    private EditText lastName;
    private EditText userId;

    private Button buttonRegister;
    private Button buttonOrder;

    String emailText;
    String passwordText;
    String firstNameText;
    String lastNameText;
    String userIdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        buttonOrder = findViewById(R.id.buttonOrder);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(this);
        buttonOrder.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonRegister:
                addUser();
                break;
            case R.id.buttonOrder:
                Intent intent = new Intent(v.getContext(), OrderActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }


    public void addUser(){
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        firstName = findViewById(R.id.editTextFirstName);
        lastName = findViewById(R.id.editTextLastName);
        userId = findViewById(R.id.editTextUserId);

        emailText=email.getText().toString();
        passwordText=password.getText().toString();
        firstNameText=firstName.getText().toString();
        lastNameText=lastName.getText().toString();
        userIdText=userId.getText().toString();//12345

        SharedPreferences sp = getSharedPreferences("My Pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userId",userIdText);
        editor.commit();
        int random = (int)(Math.random() * 50 + 1);


        String URL = "http://ec2-3-83-145-196.compute-1.amazonaws.com:8080/createUser?Id="+random+"&email="+emailText+"&password="+passwordText+"&firstName="+firstNameText+"&lastName="+lastNameText+"&userId="+userIdText;
        //http://localhost:8080/createUser?email=ss@ji.com&password=1234&firstName=Ko&lastName=Polk&userId=12345
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest objectRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Response", response);
                        Toast toast= Toast.makeText(getApplicationContext(),
                                response, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }) {

        };
        requestQueue.add(objectRequest);

    }

}

