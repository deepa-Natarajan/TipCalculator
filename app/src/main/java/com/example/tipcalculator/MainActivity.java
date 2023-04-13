package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;


import android.os.Bundle;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TipCalculator tipCalc;
    private NumberFormat money=NumberFormat.getCurrencyInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate(View v){
        EditText billEditText=(EditText) findViewById(R.id.amount_bill);
        EditText tipEditText=(EditText) findViewById(R.id.amount_tip_percent);

        String billString=billEditText.getText().toString();
        String tipString=tipEditText.getText().toString();
        System.out.println(billString);
        System.out.println(tipString);


        TextView tipTextView=(TextView) findViewById(R.id.amount_tip);
        TextView totalTextView=(TextView) findViewById(R.id.amount_total);

        try{
            float billAmount=Float.parseFloat(billString);
            float tipAmount=Float.parseFloat(tipString);
            System.out.println(billAmount);
            System.out.println(tipAmount);

           tipCalc= new TipCalculator(billAmount,tipAmount);
           float tip=tipCalc.tipAmount();
           float bill=tipCalc.billAmount();
            System.out.println(tip);
            System.out.println(bill);


           tipTextView.setText(money.format(tip));
           totalTextView.setText(money.format(bill));


        }catch (NumberFormatException n){

        }



    }



}