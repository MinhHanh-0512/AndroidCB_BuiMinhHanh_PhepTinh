package com.example.maytinh;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.editT1);
        number2 = findViewById(R.id.editT2);
        result = findViewById(R.id.txt_kq);

        findViewById(R.id.bt_Tong).setOnClickListener(v -> calculate("+"));
        findViewById(R.id.bt_Hieu).setOnClickListener(v -> calculate("-"));
        findViewById(R.id.bt_Tich).setOnClickListener(v -> calculate("*"));
        findViewById(R.id.bt_Thuong).setOnClickListener(v -> calculate("/"));
        findViewById(R.id.bt_ucln).setOnClickListener(v -> calculateGCD());

        findViewById(R.id.bt_out).setOnClickListener(v -> finish());
    }
    private void calculate(String operation) {
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double resultValue;

        switch (operation) {
            case "+":
                resultValue = num1 + num2;
                break;
            case "-":
                resultValue = num1 - num2;
                break;
            case "*":
                resultValue = num1 * num2;
                break;
            case "/":
                resultValue = num2 != 0 ? num1 / num2 : 0; // Kiểm tra chia cho 0
                break;
            default:
                resultValue = 0;
        }

        result.setText("Kết quả: " + resultValue);
    }

    private void calculateGCD() {
        int num1 = Integer.parseInt(number1.getText().toString());
        int num2 = Integer.parseInt(number2.getText().toString());
        int gcdValue = gcd(num1, num2);

        result.setText("Ước chung lớn nhất: " + gcdValue);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}