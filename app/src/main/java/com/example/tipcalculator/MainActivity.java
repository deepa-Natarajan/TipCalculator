package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;


import android.os.Bundle;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TipCalculator tipCalc;
    private EditText billEditText, tipEditText;
    private NumberFormat money = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipCalc = new TipCalculator(0.17f, 100.0f);

        billEditText = (EditText) findViewById(R.id.amount_bill);
        tipEditText = (EditText) findViewById(R.id.amount_tip_percent);
        TextChangeHandler tch=new TextChangeHandler();
        billEditText.addTextChangedListener(tch);
        tipEditText.addTextChangedListener(tch);

    }

    public void calculate() {

        String billString = billEditText.getText().toString();
        String tipString = tipEditText.getText().toString();


        TextView tipTextView = (TextView) findViewById(R.id.amount_tip);
        TextView totalTextView = (TextView) findViewById(R.id.amount_total);

        try {
            float billAmount = Float.parseFloat(billString);
            float tipAmount = Float.parseFloat(tipString);
            //System.out.println(billAmount);
            //System.out.println(tipAmount);

            tipCalc.setTip(tipAmount *0.01f);
            tipCalc.setBill(billAmount);
            float tip = tipCalc.tipAmount();
            float bill = tipCalc.billAmount();
            // System.out.println(tip);
            //System.out.println(bill);


            tipTextView.setText(money.format(tip));
            totalTextView.setText(money.format(bill));


        } catch (NumberFormatException n) {

        }


    }

    private class TextChangeHandler implements TextWatcher {

        @Override
        public void afterTextChanged(Editable editable) {
            calculate();

        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

    }

}