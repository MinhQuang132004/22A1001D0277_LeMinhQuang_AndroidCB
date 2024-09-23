package minhquang.lmq.bai3th3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText txtHoTen,txtChieuCao,txtCanNang,txtBMI,txtChanDoan;
    Button btnChanDoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TinhBMI();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void TinhBMI(){
        txtHoTen = findViewById(R.id.txtHoTen);
        txtChieuCao = findViewById(R.id.txtChieuCao);
        txtCanNang = findViewById(R.id.txtCanNang);
        txtBMI = findViewById(R.id.txtBMI);
        txtChanDoan = findViewById(R.id.txtChanDoan);
        btnChanDoan = findViewById(R.id.btnChanDoan);

        btnChanDoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 float w = Float.parseFloat(txtCanNang.getText().toString());
                 float h = Float.parseFloat(txtChieuCao.getText().toString());
                 float BMI = (float) (w / Math.pow(h,2));
                 String chandoan = "";
                 if (BMI < 18) {
                     chandoan = "Bạn gầy";
                 }
                 else if (BMI <= 24.9){
                     chandoan = "Bạn bình thường";
                 }
                 else if(BMI <= 29.9){
                     chandoan = "Bạn béo phì độ 1";
                 }
                 else if (BMI <= 34.9) {
                     chandoan = "Bạn béo phì độ 2";
                 }
                 else {
                     chandoan = "Bạn béo phì độ 3";
                 }
                DecimalFormat dfc = new DecimalFormat("#.0");
                 txtBMI.setText(dfc.format(BMI));
                 txtChanDoan.setText(chandoan);
            }
        });
    }
}