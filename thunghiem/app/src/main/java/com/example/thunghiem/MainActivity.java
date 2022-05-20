package com.example.thunghiem;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.thunghiem.Adapter.BanHang_Adapter;
import com.example.thunghiem.Login.Login_Activity;
import com.example.thunghiem.Model.BanHang;
import com.example.thunghiem.UI.DetailActivity;

import org.json.JSONObject;

import java.util.ArrayList;
//    String url = "http://192.168.1.2:3001/json/list-product";

public class MainActivity extends AppCompatActivity implements BanHang_Adapter.OnItemClickListen {
    // khai báo
    public static final  String Extra_URL = "imageUri";
    public static final String Extra_CREATOR = "name";
    public static final String Extra_BRAND = "brand";
    public static final String Extra_CATEGORY = "category";
    public static final String Extra_DESCRIPTION = "description";
    public static final String Extra_RAM = "ram";
    public static final String Extra_SSD = "ssd";
    public static final String Extra_Like0 = "price0";
    public static final String Extra_Like = "price1";
    private RecyclerView mRecyclerView;
    BanHang_Adapter adapter;
    ArrayList<BanHang>list_BanHang;
    RequestQueue requestQueue;
    JsonArrayRequest jsonArrayRequest;

    String url = "http://10.28.0.68:3001/json/list-product";
    Log log;
    Intent intent;
    ImageView imgage_log_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Sản Phẩm");
        
        // anh xa
        imgage_log_out = findViewById(R.id.imgage_log_out);
        imgage_log_out.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this,Login_Activity.class);
            Toast.makeText(getApplicationContext(),"Đăng Xuất Thành Công",Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        });

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
       RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        list_BanHang = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        getData();
    }
    private void getData() {
        requestQueue = Volley.newRequestQueue(this);
        jsonArrayRequest = new JsonArrayRequest(url, response -> {
            log.i("load...",response.toString());
            String strJson= "";
            // khai bao
            String name,image,brand,category,description;
            int price0,price1,ssd,ram;
            // khai bao
            for (int i= 0;i<response.length();i++){
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    name =jsonObject.getString("name");
                    image = jsonObject.getString("image");
                    price0 =jsonObject.getInt("price0");
                    price1 =jsonObject.getInt("price1");
                    brand = jsonObject.getString("brand");
                    category = jsonObject.getString("category");
                    description = jsonObject.getString("description");
                    ram = jsonObject.getInt("ram");
                    ssd = jsonObject.getInt("ssd");


                    strJson +="name:"+ name+"\n";
                    strJson +="image:"+ image+"\n";
                    strJson +="price0:"+ price0+"\n";
                    strJson +="price1:"+ price1+"\n";
                    strJson += "brand" + brand+"\n";
                    strJson += "category" + category+"\n";
                    strJson += "description" + description+"\n";
                    strJson += "ram" + ram+"\n";
                    strJson += "ssd" + ssd+"\n";
                    log.i("====>>>: ",strJson);

                    list_BanHang.add(new BanHang(name,price0,price1,image,brand,category,description,ram,ssd));

                }catch (Exception ex){

                }
            }
            adapter = new BanHang_Adapter(MainActivity.this,list_BanHang);
            mRecyclerView.setAdapter(adapter);
            adapter.setOnItemCickListener(MainActivity.this);
        }, error -> error.printStackTrace());
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onItemClick(int position) {
        intent = new Intent(this, DetailActivity.class);
        BanHang clickedItem =   list_BanHang.get(position);
        intent.putExtra(Extra_URL,clickedItem.getImage());
        intent.putExtra(Extra_BRAND,clickedItem.getBrand());
        intent.putExtra(Extra_CATEGORY,clickedItem.getCategory());
        intent.putExtra(Extra_DESCRIPTION,clickedItem.getDescription());
        intent.putExtra(Extra_CREATOR,clickedItem.getName());
        intent.putExtra(Extra_Like,clickedItem.getPrice1());
        intent.putExtra(Extra_Like0,clickedItem.getPrice0());
        intent.putExtra(Extra_RAM,clickedItem.getRam());
        intent.putExtra(Extra_SSD,clickedItem.getSsd());
        startActivity(intent);
        finish();
    }

}
