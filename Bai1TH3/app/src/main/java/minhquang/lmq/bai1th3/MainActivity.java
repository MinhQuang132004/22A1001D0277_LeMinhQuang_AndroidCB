package minhquang.lmq.bai1th3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtSoA, txtSoB, txtKetQua;
    Button btnTong, btnHieu, btnTich, btnThuong, btnUoc, btnThoat;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initControl() {
        txtSoA = findViewById(R.id.txtSoA);
        txtSoB = findViewById(R.id.txtSoB);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnUoc = findViewById(R.id.btnUoc);
        btnThoat = findViewById(R.id.btnThoat);

        btnTong.setOnClickListener(view -> calculate('+'));
        btnHieu.setOnClickListener(view -> calculate('-'));
        btnTich.setOnClickListener(view -> calculate('*'));
        btnThuong.setOnClickListener(view -> calculate('/'));
        btnUoc.setOnClickListener(view -> calculateUCLN());

        btnThoat.setOnClickListener(v -> finish());
    }

    private void calculate(char operation) {
        try {
            int x = Integer.parseInt(txtSoA.getText().toString());
            int y = Integer.parseInt(txtSoB.getText().toString());
            int result = 0;
            switch (operation) {
                case '+':
                    result = x + y;
                    break;
                case '-':
                    result = x - y;
                    break;
                case '*':
                    result = x * y;
                    break;
                case '/':
                    if (y == 0) {
                        Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = x / y;
                    break;
            }
            txtKetQua.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }

    private void calculateUCLN() {
        try {
            int x = Integer.parseInt(txtSoA.getText().toString());
            int y = Integer.parseInt(txtSoB.getText().toString());
            int ucln = timUCLN(x, y);
            txtKetQua.setText(String.valueOf(ucln));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }

    public int timUCLN(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
