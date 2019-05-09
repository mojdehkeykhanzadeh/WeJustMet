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

public class AddCardActivity extends AppCompatActivity {
    private EditText cardIdText;
    private EditText cardCodeText;
    private EditText amountText;
    private Button submitBtn;
     String cardId;
     String cardCode;
    private String amount;
    private Button btn2;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        SharedPreferences sp = getSharedPreferences("My Pref", Context.MODE_PRIVATE);
        userId = sp.getString("userId","defaultvalue");
        submitBtn = findViewById(R.id.submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Add Card Response", Toast.LENGTH_SHORT).show();
                addCard();
            }
        });
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaymentActivity.class);
//                intent.putExtra("card number", cardId);
                startActivity(intent);
            }
        });

    }
    public void addCard(){
        cardIdText = findViewById(R.id.cardId);
        cardCodeText = findViewById(R.id.cardCode);
        amountText = findViewById(R.id.amount);
        cardId = cardIdText.getText().toString();
        cardCode = cardCodeText.getText().toString();
        amount= amountText.getText().toString();
        SharedPreferences sp = getSharedPreferences("My Pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("cardId",cardId);
        editor.commit();
        int random = (int)(Math.random() * 50 + 1);
        String URL = "http://10.0.2.2:8080/createCard?id="+random+"&cardNumber="+cardId+"&cardCode="
                +cardCode+"&userId="+userId+"&amount="+amount;
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
