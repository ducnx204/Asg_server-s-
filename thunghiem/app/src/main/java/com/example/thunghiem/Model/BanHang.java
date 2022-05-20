package com.example.thunghiem.Model;

public class BanHang {
    private int _id, price0,price1,ram,ssd;
    private String name,brand,category,image,description;

    public BanHang(String name, int price0, int price1, String image,String brand, String category,String description,int ram,int ssd) {
        this.name = name;
        this.price0 = price0;
        this.price1 = price1;
        this.image = image;
        this.brand = brand;
        this.ram = ram;
        this.ssd =ssd;
        this.category = category;
        this.description = description;
    }

    public BanHang(int _id,int ram ,int ssd,int price0, int price1, String name, String brand, String category, String image, String description) {
        this._id = _id;
        this.price0 = price0;
        this.price1 = price1;
        this.ram = ram;
        this.ssd =ssd;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.image = image;
        this.description = description;
    }


    public int getRam() {
        return ram;
    }

    public int getSsd() {
        return ssd;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getPrice0() {
        return price0;
    }

    public void setPrice0(int price0) {
        this.price0 = price0;
    }

    public int getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BanHang{" +
                "_id=" + _id +
                ", price0=" + price0 +
                ", price1=" + price1 +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
