package com.example.thunghiem.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;

import com.example.thunghiem.MainActivity;
import com.example.thunghiem.R;

public class ManHinhChao_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Màn Hình Chào");
        setContentView(R.layout.activity_man_hinh_chao);
        new Handler().postDelayed(() -> {
            Intent intent= new Intent(ManHinhChao_Activity.this, Login_Activity.class);
            startActivity(intent);
            finish();
        },2000);
    }
}