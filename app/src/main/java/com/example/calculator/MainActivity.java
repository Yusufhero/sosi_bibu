package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Double first;
    private Double second;
    private String resultToString = "";
    private Boolean isOperationClick = false;
    private String operationSelected;
    private final String DOT = ".";
    private Double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                onClick("1");
                isOperationClick = false;
                break;
            case R.id.btN_two:
                onClick("2");
                isOperationClick = false;
                break;
            case R.id.btn_three:
                onClick("3");
                isOperationClick = false;
                break;
            case R.id.btn_four:
                onClick("4");
                isOperationClick = false;
                break;
            case R.id.btn_five:
                onClick("5");
                isOperationClick = false;
                break;
            case R.id.btn_six:
                onClick("6");
                isOperationClick = false;
                break;
            case R.id.btn_seven:
                onClick("7");
                isOperationClick = false;
                break;
            case R.id.btn_eight:
                onClick("8");
                isOperationClick = false;
                break;
            case R.id.btn_nine:
                onClick("9");
                isOperationClick = false;
                break;
            case R.id.btn_zero:
                onClick("0");
                isOperationClick = false;
                break;
            case R.id.plusMinus:
                PlusMinus();
                break;
            case R.id.btn_clear:
                binding.tvResult.setText("0");
                isOperationClick = true;
                break;
        }
    }
    private void WithoutDot() {
        if (result % 1 == 0) {
            resultToString = String.valueOf(Math.round(result));
        } else {
            resultToString = String.valueOf(result);
        }
    }
    private void PlusMinus() {
        if (binding.tvResult.getText().toString().contains("-")) {
            binding.tvResult.setText
                    ("" + binding.tvResult.getText().toString().replace("-", ""));
        } else {
            binding.tvResult.setText
                    ("-" + binding.tvResult.getText().toString().replace("+", ""));
        }
    }
    private void onClick(String number) {
        if (binding.tvResult.getText().equals("0") || isOperationClick) {
            binding.tvResult.setText(number);
        } else {
            binding.tvResult.append(number);
        }
    }
    private void Point(String number) {
        String numberWithDot = number + DOT;
        number = numberWithDot;
        if (!number.contains(".")) {
            binding.tvResult.setText(numberWithDot);
        } else {
            binding.tvResult.setText(number);
        }
    }
    private void FinishWorkOperation() {
        second = Double.parseDouble(binding.tvResult.getText().toString());
        switch (operationSelected) {
            case "+":
                result = first + second;
                resultToString = String.valueOf(result);
                WithoutDot();
                break;
            case "-":
                result = first - second;
                resultToString = String.valueOf(result);
                WithoutDot();
                break;
            case "*":
                result = first * second;
                resultToString = String.valueOf(result);
                WithoutDot();
                break;
            case "/":
                result = first / second;
                resultToString = String.valueOf(result);
                WithoutDot();
                break;
        }
        binding.tvResult.setText(resultToString);
        isOperationClick = true;
    }
    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_percent :
                first = Double.parseDouble(binding.tvResult.getText().toString());
                first /= 100;
                resultToString = String.valueOf(first);
                binding.tvResult.setText(resultToString);
                break;
            case R.id.btn_plus:
                first = Double.parseDouble(binding.tvResult.getText().toString());
                isOperationClick = true;
                operationSelected = "+";
                break;
            case R.id.btn_multiply:
                first = Double.parseDouble(binding.tvResult.getText().toString());
                isOperationClick = true;
                operationSelected = "*";
                break;
            case R.id.btn_minus:
                operationSelected = "-";
                first = Double.parseDouble(binding.tvResult.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_division:
                operationSelected = "/";
                first = Double.parseDouble(binding.tvResult.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_point:
                Point(binding.tvResult.getText().toString());
                break;
            case R.id.btn_equal:
                FinishWorkOperation();
                isOperationClick = true;
        }
    }
}