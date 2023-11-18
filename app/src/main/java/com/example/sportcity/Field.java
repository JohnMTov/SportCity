package com.example.sportcity;

public class Field {
    private static int count = 0;
    private int id;
    private int img;
    private String title;
    private String address;
    private String openingHours;
    private String phone;
    private String type;
    private String cost;
    private int kindOfSport;
    boolean isFavorite;

    public Field(int img, String title, String address, String openingHours, String phone, String type, String cost, int kindOfSport) {
        this.img = img;
        this.title = title;
        this.address = address;
        this.openingHours = openingHours;
        this.phone = phone;
        this.type = type;
        this.cost = cost;
        this.kindOfSport = kindOfSport;
        this.isFavorite = false;
        this.id = ++count;
    }



    public int getId() {
        return id;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getKindOfSport() {
        return kindOfSport;
    }

    public void setKindOfSport(int kindOfSport) {
        this.kindOfSport = kindOfSport;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
