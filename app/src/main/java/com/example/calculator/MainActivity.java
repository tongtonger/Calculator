package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
    private Button btn_sin;
    private Button btn_cos;
    private Button btn_tan;
    private Button btn_lg;
    private Button btn_ln;
    private Button btn_function;//=按钮
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_0 = (Button) findViewById(R.id.num0);
        btn_1 = (Button) findViewById(R.id.num1);
        btn_2 = (Button) findViewById(R.id.num2);
        btn_3 = (Button) findViewById(R.id.num3);
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
        btn_function=(Button) findViewById(R.id.function);
        btn_sin=(Button) findViewById(R.id.sin);
        btn_cos=(Button) findViewById(R.id.cos);
        btn_tan=(Button) findViewById(R.id.tan);
        btn_lg=(Button) findViewById(R.id.log);
        btn_ln=(Button) findViewById(R.id.ln);

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
        btn_function.setOnClickListener(this);
        btn_sin.setOnClickListener(this);
        btn_cos.setOnClickListener(this);
        btn_tan.setOnClickListener(this);
        btn_lg.setOnClickListener(this);
        btn_ln.setOnClickListener(this);

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
            case R.id.add:
            case R.id.charjian:
            case R.id.cheng:
            case R.id.chu:
            case R.id.cos:
            case R.id.tan:
            case R.id.log:
            case R.id.ln:
                editText.setText(input + ((Button)v).getText());
                break;
            case R.id.clear:
                editText.setText("");
                break;
            case R.id.delete:
                if(input != null || !input.equals("")) {
                    editText.setText(input.substring(0, input.length() - 1));
                }
                break;
            case R.id.eq:
                editText.setText(getResult());
                break;
            case R.id.function:
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

        }
    }

    public String getResult() {
        Expression expression=new Expression();

        StringBuffer postfix=expression.toPostfix(editText.getText().toString());//传入中缀表达式并得到后缀表达式
        String result=expression.ToValue(postfix);//得到计算结果result
        return  result;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.help_item:
                Toast.makeText(this,"This is help",Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit_item:
                Toast.makeText(this,"This is exit",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
