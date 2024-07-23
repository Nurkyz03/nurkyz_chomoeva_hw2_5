package com.geeks.nurkyz_chomoeva_hw2_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private Button button;

    private TextView textView;
    private Double first, second, result;
    private String currentOperation;
    private Boolean isOperationOnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        currentOperation = "";
        button = findViewById(R.id.buttonContinue);
        button.setVisibility(View.INVISIBLE);
        button.setOnClickListener(view -> {
            String result = textView.getText().toString();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("RESULT",result);
            startActivity(intent);
            finish();
        });

    }

    public void onNumberClick(View view) {

        String text = ((MaterialButton)view).getText().toString();
        if (text.equals("AC")){
            textView.setText("0");
            first = null;
            second = null;
            result = null;
            currentOperation = "";
        } else if (textView.getText().equals(".")) {
            if (!textView.getText().toString().contains(".")) {
                if (textView.getText().toString().equals("0") || isOperationOnClick) {
                    textView.setText("0.");
                } else {
                    textView.append(".");
                }
            }
        } else if (textView.getText().toString().equals("0") || isOperationOnClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        isOperationOnClick = false;
    }

    public void onOperationClick(View view) {
        isOperationOnClick = true;
        if (view.getId() == R.id.btn_plus) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "+";
        } else if (view.getId() == R.id.btn_min) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "-";
        } else if (view.getId() == R.id.btn_x) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "*";
        } else if (view.getId() == R.id.btn_dil) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "/";
        } else if (view.getId() == R.id.btn_equal) {
            second = Double.valueOf(textView.getText().toString());
            if (currentOperation.equals("+")) {
                result = first + second;
            } else if (currentOperation.equals("-")) {
                result = first - second;
            } else if (currentOperation.equals("*")) {
                result = first * second;
                if (result == 30) {
                    button.setVisibility(View.VISIBLE);
                } else {
                    button.setVisibility(View.INVISIBLE);
                }
            } else if (currentOperation.equals("/")) {
                result = first / second;
            } else if (currentOperation.equals("%")) {
                result = first * (second / 100);
            }

            if (result % 1 == 0) {
                textView.setText(String.valueOf(result.intValue()));
            } else {
                textView.setText(result.toString());
            }
            first = null;
            second = null;
            currentOperation = "";
        } else if (view.getId() == R.id.btn_procent) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "%";
        }

    }
    public void onPlusMinusClick(View view) {
        String currentText = textView.getText().toString();
        if (!currentText.equals("0")) {
            if (currentText.contains(".")) {
                double value = Double.parseDouble(currentText);
                value = - value;
                textView.setText(String.valueOf(value));
            }else {
                int value = Integer.parseInt(currentText);
                value = - value;
                textView.setText(String.valueOf(value));
            }
        }
    }
}