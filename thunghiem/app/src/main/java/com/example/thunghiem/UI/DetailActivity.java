package com.example.thunghiem.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thunghiem.MainActivity;
import com.example.thunghiem.Model.BanHang;
import com.example.thunghiem.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.thunghiem.MainActivity.Extra_BRAND;
import static com.example.thunghiem.MainActivity.Extra_CATEGORY;
import static com.example.thunghiem.MainActivity.Extra_CREATOR;
import static com.example.thunghiem.MainActivity.Extra_DESCRIPTION;
import static com.example.thunghiem.MainActivity.Extra_Like;
import static com.example.thunghiem.MainActivity.Extra_Like0;
import static com.example.thunghiem.MainActivity.Extra_RAM;
import static com.example.thunghiem.MainActivity.Extra_SSD;
import static com.example.thunghiem.MainActivity.Extra_URL;


//String imageUri = "http:///192.168.1.2:3001/images/products/";
public class DetailActivity extends AppCompatActivity {
    String imageUri = "http:///10.28.0.68:3001/images/products/";
    Intent intent;

    String image,creatorName,brand,category,description;
    int likeCount,likeCount1,ram,ssd;
    ImageView imageView;
    TextView  textViewCreator,textViewLikes,textViewLikes1,txt_brand,txt_category,txt_description,txt_ram,txt_ssd,txt_quaylai;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        intent = getIntent();
        setTitle("Chi Tiết Sản Phẩm");
        // quay lai trang chu
            txt_quaylai= findViewById(R.id.txtquaylai);
             txt_quaylai.setOnClickListener(view -> {
            intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
//        String

        image = intent.getStringExtra(Extra_URL);
        creatorName = intent .getStringExtra(Extra_CREATOR);
        brand = intent.getStringExtra(Extra_BRAND);
        category = intent .getStringExtra(Extra_CATEGORY);
        description = intent .getStringExtra(Extra_DESCRIPTION);
//        Integer
        likeCount = intent .getIntExtra(Extra_Like, 0);
        likeCount1 = intent .getIntExtra(Extra_Like0, 0);
        ram = intent .getIntExtra(Extra_RAM, 0);
        ssd = intent .getIntExtra(Extra_SSD, 0);

//         ánh xạ
        imageView  = findViewById(R.id.image_view_chitiet);
        textViewCreator = findViewById(R.id.text_view_creator_chitiet);
        textViewLikes = findViewById(R.id.text_view_likes_chitiet);
        textViewLikes1 = findViewById(R.id.text_view_likes1_chitiet);
        txt_brand = findViewById(R.id.text_view_brand_chitiet);
        txt_category = findViewById(R.id.text_view_category_chitiet);
        txt_description = findViewById(R.id.text_view_description_chitiet);
        txt_ram = findViewById(R.id.text_view_ram_chitiet);
        txt_ssd = findViewById(R.id.text_view_ssd_chitiet);
//        đổ dử liệu
        textViewCreator.setText("Tên Sản Phẩm:"+ creatorName);
        textViewLikes.setText("Giá Sản Phẩm:" + likeCount +" ₫");
        textViewLikes1.setText("Giá Bán:" + likeCount1+ " ₫");
        txt_brand.setText("Thương Hiệu: "+brand);
        txt_category.setText("Thể Loại: "+category);
        txt_description.setText("Mô Tả: " +description);
        txt_ram.setText("Bộ Nhớ: "+ram +" GB");
        txt_ssd.setText("Bộ Nhớ Trong: "+ssd +" GB");
        Picasso.with(this).load(imageUri+image).fit().centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView);
    }


}