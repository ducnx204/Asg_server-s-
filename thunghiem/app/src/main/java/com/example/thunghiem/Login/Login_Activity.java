package com.example.thunghiem.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thunghiem.MainActivity;
import com.example.thunghiem.R;

public class Login_Activity extends AppCompatActivity {
    EditText Edit_email,Edit_MatKhau;
    Button btn_dangnhap;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Đăng Nhập");
        Edit_email = findViewById(R.id.Edit_email);
        Edit_MatKhau = findViewById(R.id.Edit_matkhau);
        btn_dangnhap = findViewById(R.id.btn_dangnhap);
        btn_dangnhap.setOnClickListener(view -> {
            String Email = Edit_email.getText().toString();
            String MatKhau = Edit_MatKhau.getText().toString();
            if (Email.equals("ducnxpd04647@gmail.com")&&MatKhau.equals("123")){
                Toast.makeText(getApplicationContext(),"Đăng Nhập Thành Công",Toast.LENGTH_SHORT).show();
                intent= new Intent(Login_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(getApplicationContext(),"Đăng Nhập Thất Bại",Toast.LENGTH_SHORT).show();
            }
            return;
        });
    }
}