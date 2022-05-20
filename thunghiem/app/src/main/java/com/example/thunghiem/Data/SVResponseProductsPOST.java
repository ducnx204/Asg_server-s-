package com.example.thunghiem.Data;

import com.example.thunghiem.Model.BanHang;

public class SVResponseProductsPOST {
    private BanHang product; // đặt tên giống tên bảng trong database
    private String message;
    private String result;

    public SVResponseProductsPOST() {
    }

    public BanHang getProducts() {
        return product;
    }

    public String getMessage() {
        return message;
    }

    public String getResult() {
        return result;
    }
}
