package com.example.ana.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int performFirstNum(){
        EditText field_number = (EditText)findViewById(R.id.FirstNum);
        int number = Integer.parseInt(field_number.getText().toString());
        return number;
    }

    public int performSecondNum(){
        EditText field_number = (EditText)findViewById(R.id.SecondNum);
        int number = Integer.parseInt(field_number.getText().toString());
        return number;
    }

    public void showResult(int result){
        TextView outputResult = (TextView)findViewById(R.id.result);
        outputResult.setText(Integer.toString(result));
    }

    public void onButtonClickPlus(View v){
        int result = performFirstNum() + performSecondNum();
        showResult(result);
    }

    public void onButtonClickMinus(View v){
        int result = performFirstNum() - performSecondNum();
        showResult(result);
    }

    public void onButtonClickMulti(View v){
        int result = performFirstNum() * performSecondNum();
        showResult(result);
    }

    public void onButtonClickDivide(View v){
        int result = performFirstNum() / performSecondNum();
        showResult(result);
    }
}
