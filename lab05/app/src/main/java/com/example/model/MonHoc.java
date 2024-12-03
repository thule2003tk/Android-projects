package com.example.model;

import androidx.annotation.NonNull;

public class MonHoc {
    private int MaMH;
    private String tenMH;
    private int sotiet;

    public MonHoc() {
    }

    public MonHoc(int maMH, String tenMH, int sotiet) {
        MaMH = maMH;
        this.tenMH = tenMH;
        this.sotiet = sotiet;
    }

    public int getMaMH() {
        return MaMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public int getSotiet() {
        return sotiet;
    }

    public void setMaMH(int maMH) {
        MaMH = maMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public void setSotiet(int sotiet) {
        this.sotiet = sotiet;
    }

    @NonNull
    @Override
    public String toString() {

        return MaMH + "-" + tenMH + "\n" + sotiet;
    }
}
