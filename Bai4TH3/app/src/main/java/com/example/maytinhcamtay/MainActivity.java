package com.example.maytinhcamtay;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnAC, btnDel, btnDiv, btnMulti, so7, so8, so9, btnTru, so4, so5, so6, btnCong, so1, so2, so3, btnDauBang, btnDauCham, btnSo0;
    TextView tvKetQua, tvTinhToan;
    private String number = null;
    Double lastNumber = (double) 0;
    Double firstNumber = (double) 0;
    boolean operator=false;
    boolean isEqual=false;
    String status=null;
    String history, result;
    String pattern = "#####";
    DecimalFormat decimalFormat= new DecimalFormat(pattern);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AnhXa();

        btnCong.setOnClickListener(view -> {
            if(isEqual){
                history= tvKetQua.getText().toString();
                result= tvTinhToan.getText().toString();
                tvKetQua.setText(history+"+");
            }else{
                history= tvKetQua.getText().toString();
                result= tvTinhToan.getText().toString();
                tvKetQua.setText(history+result+"+");
            }
            if(operator){
                if(status=="multi"){
                    multi();
                }else{
                    if(status=="div"){
                        div();
                    }else{
                        if(status=="minus"){
                            Minus();
                        }else{
                            Plus();
                        }
                    }
                }
            }
            operator=false;
            number=null;
            status="sum";
            isEqual=false;
        });

        btnTru.setOnClickListener(view -> {
            if(isEqual){
                history= tvKetQua.getText().toString();
                result= tvTinhToan.getText().toString();
                tvKetQua.setText(history+"-");
            }else{
                history= tvKetQua.getText().toString();
                result= tvTinhToan.getText().toString();
                tvKetQua.setText(history+result+"-");
            }
            if(operator){
                if(status=="multi"){
                    multi();
                }else{
                    if(status=="div"){
                        div();
                    }else{
                        if(status=="sum"){
                            Plus();
                        }else{
                            Minus();
                        }
                    }
                }
            }
            operator=false;
            number=null;
            status="minus";
            isEqual=false;
        });
        btnMulti.setOnClickListener(view -> {
            if(isEqual){
                history= tvKetQua.getText().toString();
                result= tvTinhToan.getText().toString();
                tvKetQua.setText(history+"*");
            }else{
                history= tvKetQua.getText().toString();
                result= tvTinhToan.getText().toString();
                tvKetQua.setText(history+result+"*");
            }
            if(operator){
                if(status=="sum"){
                    Plus();
                }else{
                    if(status=="div"){
                        div();
                    }else{
                        if(status=="minus"){
                            Minus();
                        }else{
                            multi();
                        }
                    }
                }
            }
            operator=false;
            number=null;
            status="multi";
            isEqual=false;
        });

        btnDiv.setOnClickListener(view -> {

            if(isEqual){
                history= tvKetQua.getText().toString();
                result= tvTinhToan.getText().toString();
                tvKetQua.setText(history+"/");
            }else{
                history= tvKetQua.getText().toString();
                result= tvTinhToan.getText().toString();
                tvKetQua.setText(history+result+"/");
            }
            if(operator){
                if(status=="multi"){
                    multi();
                }else{
                    if(status=="sum"){
                        Plus();
                    }else{
                        if(status=="minus"){
                            Minus();
                        }else{
                            div();
                        }
                    }
                }
            }
            operator=false;
            number=null;
            status="div";
            isEqual=false;
        });
        btnDauBang.setOnClickListener(view -> {
            history= tvKetQua.getText().toString();
            result= tvTinhToan.getText().toString();
             tvKetQua.setText(history+result);
            if(operator){
                if(status=="multi"){
                    multi();
                }else{
                    if(status=="div"){
                        div();
                    }else{
                        if(status=="minus"){
                            Minus();
                        }else if(status == "sum"){
                            Plus();
                        }else{
                            firstNumber=Double.parseDouble(tvTinhToan.getText().toString());
                        }
                    }
                }
            }
            operator=false;
            isEqual=true;
        });
        btnAC.setOnClickListener(view -> {
            number = null;
            operator=false;
            tvTinhToan.setText("0");
            tvKetQua.setText("");
            firstNumber= (double) 0;
            lastNumber= (double)0 ;
        });

        btnDel.setOnClickListener(view -> {
            number= number.substring(0, number.length()-1);
            tvTinhToan.setText(number);
        });

        btnDauCham.setOnClickListener(view -> {
            if(number == null){
                number= "0.";

            }else{
                number= number+".";
            }
            tvKetQua.setText(number);
        });
    }

    public void AnhXa(){
        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnDiv= findViewById(R.id.btnDiv);
        btnMulti = findViewById(R.id.btnMulti);
        so7 = findViewById(R.id.so7);
        so8 = findViewById(R.id.so8);
        so9 = findViewById(R.id.so9);
        btnTru = findViewById(R.id.btnTru);
        so4 = findViewById(R.id.so4);
        so5 = findViewById(R.id.so5);
        so6 = findViewById(R.id.so6);
        btnCong = findViewById(R.id.btnCong);
        so1 = findViewById(R.id.so1);
        so2 = findViewById(R.id.so2);
        so3 = findViewById(R.id.so3);
        btnDauBang = findViewById(R.id.btnDauBang);
        btnDauCham = findViewById(R.id.btnDauCham);
        btnSo0 = findViewById(R.id.btnSo0);

        tvKetQua = findViewById(R.id.tvKetQua);
        tvTinhToan = findViewById(R.id.tvTinhToan);

        btnSo0.setOnClickListener(view -> numberclick("0"));
        so1.setOnClickListener(view -> numberclick("1"));
        so2.setOnClickListener(view -> numberclick("2"));
        so3.setOnClickListener(view -> numberclick("3"));
        so4.setOnClickListener(view -> numberclick("4"));
        so5.setOnClickListener(view -> numberclick("5"));
        so6.setOnClickListener(view -> numberclick("6"));
        so7.setOnClickListener(view -> numberclick("7"));
        so8.setOnClickListener(view -> numberclick("8"));
        so9.setOnClickListener(view -> numberclick("9"));


    }

    public void numberclick(String view){
        if(number== null){
            number= view;
        }else{
            number = number +view;
        }
        tvTinhToan.setText(number);
        operator=true;
    }

    public void Minus(){
        if(firstNumber==0){
            firstNumber=Double.parseDouble(tvTinhToan.getText().toString());
        }else{
            lastNumber=Double.parseDouble(tvTinhToan.getText().toString());
            firstNumber= firstNumber-lastNumber;
        }
        tvTinhToan.setText(decimalFormat.format(firstNumber));
    }

    public void Plus(){
        lastNumber=Double.parseDouble(tvTinhToan.getText().toString());
        firstNumber= firstNumber+lastNumber;
        tvTinhToan.setText(decimalFormat.format(firstNumber));
    }

    public void multi(){
        lastNumber=Double.parseDouble(tvTinhToan.getText().toString());
        firstNumber= firstNumber*lastNumber;
        tvTinhToan.setText(decimalFormat.format(firstNumber));
    }

    public void div(){
        if(firstNumber == 0){
            lastNumber= Double.parseDouble(tvTinhToan.getText().toString());
            firstNumber = lastNumber;
        }else{
            lastNumber=Double.parseDouble(tvTinhToan.getText().toString());
            firstNumber= firstNumber/lastNumber;
        }
        tvTinhToan.setText(decimalFormat.format(firstNumber));
    }
}