package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LengthChange_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_change);
        final EditText text_mi = (EditText)findViewById(R.id.text_mi);
        final EditText text_chi = (EditText)findViewById(R.id.text_chi);
        final EditText text_zhang = (EditText)findViewById(R.id.text_zhang);
        Button button_mi = (Button)findViewById(R.id.button_mi);
        Button button_chi = (Button)findViewById(R.id.button_chi);
        Button button_zhang = (Button)findViewById(R.id.button_zhang);
        button_mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!text_mi.getText().toString().equals("")) {
                    double value = Double.valueOf(text_mi.getText().toString());
                    text_chi.setText(String.valueOf(value * 3.2808399));
                    text_zhang.setText(String.valueOf(value * 0.30003));
                }
            }
        });
        button_chi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!text_chi.getText().toString().equals("")) {
                    double value = Double.valueOf(text_chi.getText().toString());
                    text_mi.setText(String.valueOf(value / 3.2808399));
                    text_zhang.setText(String.valueOf(value / 3.2808399 * 0.30003));
                }
            }
        });
        button_zhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!text_zhang.getText().toString().equals("")) {
                    double value = Double.valueOf(text_zhang.getText().toString());
                    text_mi.setText(String.valueOf(value / 0.30003));
                    text_chi.setText(String.valueOf(value * 3.2808399 / 0.30003));
                }
            }
        });
    }
}
