package com.example.mojdehkeykhanzadeh.starbucksapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.buttonDummy);
        Button btn2 = (Button) findViewById(R.id.buttonRegister);
        btn1.setOnClickListener(this);
        /*btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddCardActivity.class);
                startActivity(intent);
            }
        });*/
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonDummy:
                Intent intent = new Intent(v.getContext(), AddCardActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonRegister:
                Intent intent2 = new Intent(v.getContext(), RegisterUser.class);
                startActivity(intent2);
                break;
            default:
                break;
        }

    }
}

