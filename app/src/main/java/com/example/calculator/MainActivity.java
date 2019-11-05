package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_point;//小数点
    private Button btn_clear;//清空按钮
    private Button btn_del;//回退一格按钮
    private Button btn_add;//+按钮
    private Button btn_sub;//-按钮
    private Button btn_multply;//*按钮
    private Button btn_divide;//÷号按钮
    private Button btn_equal;//=按钮

    private EditText editText;

    boolean clear_flag;//清空标识

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = (Button) findViewById(R.id.num0);
        btn_1 = (Button) findViewById(R.id.num1);
        btn_2 = (Button) findViewById(R.id.num1);
        btn_3 = (Button) findViewById(R.id.num1);
        btn_4 = (Button) findViewById(R.id.num4);
        btn_5 = (Button) findViewById(R.id.num5);
        btn_6 = (Button) findViewById(R.id.num6);
        btn_7 = (Button) findViewById(R.id.num7);
        btn_8 = (Button) findViewById(R.id.num8);
        btn_9 = (Button) findViewById(R.id.num9);
        btn_point = (Button) findViewById(R.id.point);
        btn_clear = (Button) findViewById(R.id.clear);
        btn_del = (Button) findViewById(R.id.delete);
        btn_add = (Button) findViewById(R.id.add);
        btn_sub = (Button) findViewById(R.id.charjian);
        btn_multply = (Button) findViewById(R.id.cheng);
        btn_divide = (Button) findViewById(R.id.chu);
        btn_equal = (Button) findViewById(R.id.eq);
        editText = (EditText) findViewById(R.id.input);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_multply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = editText.getText().toString();
        switch (v.getId()) {
            case R.id.num0:
            case R.id.num1:
            case R.id.num2:
            case R.id.num3:
            case R.id.num4:
            case R.id.num5:
            case R.id.num6:
            case R.id.num7:
            case R.id.num8:
            case R.id.num9:
            case R.id.point:
                if(clear_flag){
                    clear_flag = false;
                    editText.setText("");
                }
                editText.setText(input + ((Button)v).getText());
                break;
            case R.id.add:
            case R.id.charjian:
            case R.id.cheng:
            case R.id.chu:
                if(clear_flag){
                    clear_flag = false;
                    input = "";
                    editText.setText("");
                }
                editText.setText(input + " " + ((Button)v).getText() + " ");
                break;
        }
    }
}
