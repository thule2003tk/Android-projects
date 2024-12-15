package com.example.bai62;
import androidx.annotation.NonNull;
import java.io.Serializable;
public class SanPham implements Serializable {
    private String ma;

    private String ten;
    private int gia;

    public SanPham() {
    }

    public SanPham(String ma, String ten, int
            gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @NonNull
    @Override
    public String toString() {
        return ma + "-" + ten + "-" + gia;
    }
}