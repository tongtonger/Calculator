package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VolumeChange_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_change);
        final EditText text_kg = (EditText)findViewById(R.id.text_kg);
        final EditText text_bang = (EditText)findViewById(R.id.text_bang);
        final EditText text_dan = (EditText)findViewById(R.id.text_dan);
        Button button_kg = (Button)findViewById(R.id.button_kg);
        Button button_bang = (Button)findViewById(R.id.button_bang);
        Button button_dan = (Button)findViewById(R.id.button_dan);
        button_kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!text_kg.getText().toString().equals("")) {
                    double value = Double.valueOf(text_kg.getText().toString());
                    text_bang.setText(String.valueOf(value /1000));
                    text_dan.setText(String.valueOf(value /1000000));
                }
            }
        });
        button_bang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!text_bang.getText().toString().equals("")) {
                    double value = Double.valueOf(text_bang.getText().toString());
                    text_kg.setText(String.valueOf(value * 1000));
                    text_dan.setText(String.valueOf(value / 1000));
                }
            }
        });
        button_dan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!text_dan.getText().toString().equals("")) {
                    double value = Double.valueOf(text_dan.getText().toString());
                    text_kg.setText(String.valueOf(value * 1000000));
                    text_bang.setText(String.valueOf(value * 1000));
                }
            }
        });
    }
}
