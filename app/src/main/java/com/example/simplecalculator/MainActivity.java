package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String oldNum="",op="+";
    TextView valInput,valOutput;
    boolean newOp=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valOutput =findViewById(R.id.valOutput);
        valInput = findViewById(R.id.valInput);

    }

    public void number(View view) {
        if (newOp)
            valInput.setText("");
        newOp=false;
        String number = valInput.getText().toString();
        switch (view.getId()) {
            case R.id.zeroBtn:
                number += "0";
                break;
            case R.id.oneBtn:
                number += "1";
                break;
            case R.id.twoBtn:
                number += "2";
                break;
            case R.id.threeBtn:
                number += "3";
                break;
            case R.id.fourBtn:
                number += "4";
                break;
            case R.id.fiveBtn:
                number += '5';
                break;
            case R.id.sixBtn:
                number += '6';
                break;
            case R.id.sevenBtn:
                number += "7";
                break;
            case R.id.eightBtn:
                number += "8";
                break;
            case R.id.nineBtn:
                number += "9";
                break;
            case R.id.pointBtn:
                number +=".";
                break;
        }
        valInput.setText(number);
    }

    public void operator(View view) {
        newOp=true;
        oldNum=valInput.getText().toString();
        switch (view.getId()){
            case R.id.plusBtn: op="+"; break;
            case R.id.minusBtn: op="-"; break;
            case R.id.multiBtn: op="*"; break;
            case R.id.divBtn: op="/"; break;

        }
        valInput.setText(op);
    }

    public void equal(View view) {
        String newNum=valInput.getText().toString();
        double result=0.0;
        switch (op){
            case"+":
                result=Double.parseDouble(oldNum)+Double.parseDouble(newNum);
                break;
            case"-":
                result=Double.parseDouble(oldNum)-Double.parseDouble(newNum);
                break;
            case"*":
                result=Double.parseDouble(oldNum)*Double.parseDouble(newNum);
                break;
            case"/":
                result=Double.parseDouble(oldNum)/Double.parseDouble(newNum);
                break;
        }
        valOutput.setText(result+"");
    }

    public void allClear(View view) {
        valInput.setText("0");
        valOutput.setText("0");
        newOp=true;
    }

    public void clear(View view) {
        valInput.setText("0");
    }
}
