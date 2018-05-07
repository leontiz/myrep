package com.example.ana.newapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private Button button_ok, alert;
    private RatingBar rating;
    private TextView output_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddListenerOnButton();
    }

    public void AddListenerOnButton(){
        pass = (EditText)findViewById(R.id.password);
        button_ok = (Button)findViewById(R.id.button_ok);
        alert = (Button)findViewById(R.id.alert);
        rating = (RatingBar)findViewById(R.id.ratingBar);
        output_text = (TextView)findViewById(R.id.text_field);

        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        output_text.setText("Value: " + String.valueOf(rating));
                    }
                }
        );
        button_ok.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick (View v){
                        button_ok.setText("YEAH!");
                        button_ok.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        Toast.makeText(
                                MainActivity.this, pass.getText(),
                                Toast.LENGTH_LONG
                        ).show();
                        Intent go = new Intent(".SecondActivity");
                        startActivity(go);
                    }
                }
        );

        alert.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick (View v) {
//                        button_cancel.setText("OHH!");
//                        button_cancel.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
//                        Toast.makeText(
//                                MainActivity.this, pass.getText(),
//                                Toast.LENGTH_LONG
//                        ).show();
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Do you want close app?")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }

                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Closing app");
                        alert.show();

                    }
                }
        );
    }
}
