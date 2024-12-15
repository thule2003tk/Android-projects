package com.example;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.DanhMuc;
import com.example.R;
import com.example.SanPham;

public class MainActivity extends AppCompatActivity {
    Spinner spnDanhMuc;
    ArrayAdapter<DanhMuc> danhMucAdapter;
    ArrayAdapter<SanPham> sanPhamAdapter;
    EditText edtMaSP, edtTenSP, edtGia;
    ListView lvSanPham;
    Button btnThem;
    DanhMuc selectedDanhMuc = null;

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
        addView();
        addEvent();
    }

    private void addEvent() {
        // Logic xử lý sự kiện;
    }

    private void addView() {
        // Ánh xạ các thành phần giao diện
        spnDanhMuc = findViewById(R.id.spnSanPham);
        danhMucAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item);
        danhMucAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDanhMuc.setAdapter(danhMucAdapter);

        lvSanPham = findViewById(R.id.lvSanPham);
        sanPhamAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        lvSanPham.setAdapter(sanPhamAdapter);

        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGia = findViewById(R.id.edtGiaSP); // ID phải khớp với layout XML
        btnThem = findViewById(R.id.btnThem);
        danhMucAdapter.add(new DanhMuc("1","bear"));
        danhMucAdapter.add(new DanhMuc("2","nuoc ngot"));
        danhMucAdapter.add(new DanhMuc("3","Ruou"));
        danhMucAdapter.add(new DanhMuc("4","Thuoc la"));
    }
}