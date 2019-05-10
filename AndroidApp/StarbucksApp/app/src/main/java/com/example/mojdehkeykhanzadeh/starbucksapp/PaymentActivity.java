package com.example.mojdehkeykhanzadeh.starbucksapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class PaymentActivity extends AppCompatActivity {
    private String balance;
    private String cardNumber;
    private Button pay;
    private String cardId;
    private String userId;
    private String total;
    private Button orderBtn;
    private Button refreshBal;
    private String nBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        SharedPreferences sp = getSharedPreferences("My Pref", Context.MODE_PRIVATE);
        cardId = sp.getString("cardId","defaultvalue");
        Log.e("card ID ==== !", cardId);
        userId = sp.getString("userId","defaultvalue");
        total = sp.getString("totalShare","defaultvalue");
      /*  Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cardNumber= bundle.getString("card number");*/
        getBalance();
        pay = findViewById(R.id.buttonPay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Add Card Response", Toast.LENGTH_SHORT).show();
                makePayment();
                updateBalance();
//                getBalance();
            }
        });
        orderBtn= findViewById(R.id.buttonOrder);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OrderActivity.class);
                startActivity(intent);
            }
        });
        refreshBal= findViewById(R.id.buttonRefresh);
        refreshBal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBalance();
            }
        });
    }
    public void getBalance() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://10.0.2.2:8080/getBalance?userId="+userId+"&cardNumber="+cardId;
        StringRequest objectRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Get Response", response);
                        balance = new String(response);
                        TextView balanceText = (TextView) findViewById(R.id.balance);
                        balanceText.setText(balance);

                    }
                },
                new Response.ErrorListener()  {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Get Error Response", error.toString());
                    }


                });
        requestQueue.add(objectRequest);

    }
    public void makePayment(){
        int random = (int)(Math.random() * 50 + 1);
        String URL ="http://10.0.2.2:8080/makePayment?id="+random+"&cardNumber=" +cardId+
                "&amount="+total+"&userId="+userId;
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
    public void updateBalance(){
        String URL ="http://10.0.2.2:8080/deductMoney?userId="+userId+"&cardNumber=" +cardId+
                "&amt="+total;
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest objectRequest = new StringRequest(Request.Method.POST , URL,
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
    //


}
