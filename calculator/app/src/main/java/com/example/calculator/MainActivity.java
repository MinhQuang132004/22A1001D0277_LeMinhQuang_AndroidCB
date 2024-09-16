package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etName1, etName2;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ketQua();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void ketQua(){
        etName1 = findViewById(R.id.etName1);
        etName2 = findViewById(R.id.etName2);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(etName1.getText().toString());
                int y = Integer.parseInt(etName2.getText().toString());
                int result = x + y;
                txtKetQua.setText(String.valueOf(result));
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(etName1.getText().toString());
                int y = Integer.parseInt(etName2.getText().toString());
                int result = x-y;
                txtKetQua.setText(String.valueOf(result));
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(etName1.getText().toString());
                int y = Integer.parseInt(etName2.getText().toString());
                int result = x*y;
                txtKetQua.setText(String.valueOf(result));
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(etName1.getText().toString());
                int y = Integer.parseInt(etName2.getText().toString());
                int result = x/y;
                txtKetQua.setText(String.valueOf(result));
            }
        });
    }
}