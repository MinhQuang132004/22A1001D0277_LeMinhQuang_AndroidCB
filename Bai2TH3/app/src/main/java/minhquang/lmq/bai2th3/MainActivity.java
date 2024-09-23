package minhquang.lmq.bai2th3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCF,btnFC,btnClear;
    TextView txtF,txtC;
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

    private void initControl(){
        txtC = findViewById(R.id.txtC);
        txtF = findViewById(R.id.txtF);
        btnCF = findViewById(R.id.btnCF);
        btnFC = findViewById(R.id.btnFC);
        btnClear = findViewById(R.id.btnCLear);
        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = Float.parseFloat(txtC.getText().toString());
                float F = x*9/5 + 32;
                txtF.setText((String.valueOf(F)));
            }
        });

        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float y = Float.parseFloat(txtF.getText().toString());
                float C = (y-32)*5/9;
                txtC.setText((String.valueOf(C)));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtF.setText("");
                txtC.setText("");
            }
        });
    }
}