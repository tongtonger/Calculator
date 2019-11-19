package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button changLength;
    private Button changVolume;
    private Button changScale;
    private Button ExchangeRate;
    private Button Data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        changLength = (Button) findViewById(R.id.changLength);
        changVolume = (Button) findViewById(R.id.changVolume);
        changScale = (Button) findViewById(R.id.changScale);
        ExchangeRate = (Button) findViewById(R.id.ExchangeRate);
        Data = (Button) findViewById(R.id.Data);

        changLength.setOnClickListener(this);
        changVolume.setOnClickListener(this);
        changScale.setOnClickListener(this);
        ExchangeRate.setOnClickListener(this);
        Data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.changLength:
                Intent intent1=new Intent(Main2Activity.this,LengthChange_Activity.class);
                startActivity(intent1);
            case R.id.changVolume:
                Intent intent2=new Intent(Main2Activity.this,VolumeChange_Activity.class);
                startActivity(intent2);
            case R.id.changScale:
                Intent intent3=new Intent(Main2Activity.this,ScaleChange_Activity.class);
                startActivity(intent3);
            case  R.id.ExchangeRate:
            case R.id.Data:

        }
    }
}
