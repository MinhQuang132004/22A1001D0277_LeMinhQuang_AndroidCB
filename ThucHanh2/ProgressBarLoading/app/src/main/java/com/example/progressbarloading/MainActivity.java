package com.example.progressbarloading;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewHinhAnh;
    ConstraintLayout layout;
    ProgressBar pgrBar;
    boolean flag = true;

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
    }

    private int[] imgID = {
            R.drawable.ccc,
            R.drawable.chimcanhcut,
            R.drawable.hinhanh
    };
    private int[] layoutID = {
            R.color.blue,
            R.color.silver,
            R.color.lightblue
    };

    private void AnhXa() {
        layout = findViewById(R.id.main);
        imgViewHinhAnh = (ImageView) findViewById(R.id.imgViewHinhAnh);
        imgViewHinhAnh.setImageResource(imgID[new Random().nextInt(imgID.length)]);
        layout.setBackgroundResource(layoutID[new Random().nextInt(layoutID.length)]);

    }
}


