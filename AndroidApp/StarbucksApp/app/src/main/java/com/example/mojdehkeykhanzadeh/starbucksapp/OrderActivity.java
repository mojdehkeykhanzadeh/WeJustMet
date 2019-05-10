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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addButton1; // Americano, 1.95
    private Button addButton2; // Mocha 3.15
    private Button addButton3; // Macchiato 4.25
    private Button addButton4; // Frappucino 5.05
    private Button addButton5; // Sandwich 4.75
    private Button addButton6; // Croissant 2.55
    private Button addButton7; // Cookie 3.15

    private Button deleteButton1;
    private Button deleteButton2;
    private Button deleteButton3;
    private Button deleteButton4;
    private Button deleteButton5;
    private Button deleteButton6;
    private Button deleteButton7;

    private Button buttonNewOrder;
    private Button buttonDone;
    private Button buttonAddCard;

    private TextView totalPriceTextView;
    private TextView totalOrderItemsTextView;

    private String total;
    private String totalShare;

    private String totalOrderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order);
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);


        addButton1 = (Button) findViewById(R.id.addButton1);
        addButton2 = (Button) findViewById(R.id.addButton2);
        addButton3 = (Button) findViewById(R.id.addButton3);
        addButton4 = (Button) findViewById(R.id.addButton4);
        addButton5 = (Button) findViewById(R.id.addButton5);
        addButton6 = (Button) findViewById(R.id.addButton6);
        addButton7 = (Button) findViewById(R.id.addButton7);

        deleteButton1 = (Button) findViewById(R.id.deleteButton1);
        deleteButton2 = (Button) findViewById(R.id.deleteButton2);
        deleteButton3 = (Button) findViewById(R.id.deleteButton3);
        deleteButton4 = (Button) findViewById(R.id.deleteButton4);
        deleteButton5 = (Button) findViewById(R.id.deleteButton5);
        deleteButton6 = (Button) findViewById(R.id.deleteButton6);
        deleteButton7 = (Button) findViewById(R.id.deleteButton7);

        buttonDone = (Button) findViewById(R.id.buttonDone);
        buttonNewOrder = (Button) findViewById(R.id.buttonNewOrder);
        buttonAddCard = (Button) findViewById(R.id.buttonAddCard);

        addButton1.setOnClickListener(this);
        addButton2.setOnClickListener(this);
        addButton3.setOnClickListener(this);
        addButton4.setOnClickListener(this);
        addButton5.setOnClickListener(this);
        addButton6.setOnClickListener(this);
        addButton7.setOnClickListener(this);

        deleteButton1.setOnClickListener(this);
        deleteButton2.setOnClickListener(this);
        deleteButton3.setOnClickListener(this);
        deleteButton4.setOnClickListener(this);
        deleteButton5.setOnClickListener(this);
        deleteButton6.setOnClickListener(this);
        deleteButton7.setOnClickListener(this);

        buttonDone.setOnClickListener(this);
        buttonNewOrder.setOnClickListener(this);
        buttonAddCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.addButton1:
                addOrder("Americano", 1.95);
                //getTotalOrder();
                //getTotalPrice();
                break;

            case R.id.addButton2:
                addOrder("Mocha", 3.15);
                //getTotalOrder();
                //getTotalPrice();
                break;

            case R.id.addButton3:
                addOrder("Macchiato", 4.25);
                //getTotalOrder();
                //getTotalPrice();
                break;

            case R.id.addButton4:
                addOrder("Frappucino", 5.15);
                //getTotalOrder();
                //getTotalPrice();
                break;

            case R.id.addButton5:
                addOrder("Sandwich", 4.75);
                //getTotalOrder();
                //getTotalPrice();
                break;

            case R.id.addButton6:
                addOrder("Croissant", 2.55);
                //getTotalOrder();
                //getTotalPrice();
                break;

            case R.id.addButton7:
                addOrder("Cookie", 3.15);
                //getTotalOrder();
                //getTotalPrice();
                break;

            case R.id.buttonDone:
                getTotalOrder();
                getTotalPrice();
                break;

            case R.id.buttonNewOrder:
                clearOrder();
                break;

            case R.id.buttonAddCard:
                Intent intent = new Intent(v.getContext(), AddCardActivity.class);
                startActivity(intent);
                break;

            default:
                break;

        }

    }

    public void addOrder(String item, double price){
        String URL = "http://10.0.2.2:8080/createOrder?name="+item+"&price="+price;
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest objectRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Order Response", response);
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

    public void getTotalPrice(){
        String URL = "http://10.0.2.2:8080/getTotalOrderPrice";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest objectRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Get Response", response);
                        total = new String(response);
                        Log.e("Getting Total", total);
                        totalPriceTextView = (TextView) findViewById(R.id.totalPriceTextView);
                        totalPriceTextView.setText(total);


                        SharedPreferences sp = getSharedPreferences("My Pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("totalShare",total);
                        editor.commit();
                        Log.e("totalShare", total);

                        /*SharedPreferences sp = getSharedPreferences("My Pref", Context.MODE_PRIVATE);
                        totalShare = sp.getString("totalShare",total);
                        Log.e("Total Price ==== !", totalShare);*/

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

    public void getTotalOrder(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://10.0.2.2:8080/getTotalOrderItems";
        StringRequest objectRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Get Response", response);
                        totalOrderItems = new String(response);
                        totalOrderItemsTextView = (TextView) findViewById(R.id.totalOrderItemsTextView);
                        totalOrderItemsTextView.setText(totalOrderItems);
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

    public void clearOrder(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://10.0.2.2:8080/deleteAllOrder";
        StringRequest objectRequest = new StringRequest(Request.Method.DELETE, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Order Cleared", response);
                        Toast toast= Toast.makeText(getApplicationContext(),
                                response, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();
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
}
