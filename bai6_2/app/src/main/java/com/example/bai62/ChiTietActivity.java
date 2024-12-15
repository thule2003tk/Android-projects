package com.example.bai62;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bai62.SanPham;

public class ChiTietActivity extends AppCompatActivity {
    EditText edtMa, edtTen, edtGia;
    Button btnXoa, btnThoat;
    Intent intent;
    SanPham sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Sửa thành layout của ChiTietActivity

        // Thiết lập padding theo hệ thống
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addView();
        addEvent();
    }

    private void addEvent() {
        // Xử lý nút "Thoát"
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Đóng Activity và quay lại màn hình chính
            }
        });

        // Xử lý nút "Xóa"
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("SANPHAM", sp); // Truyền sản phẩm cần xóa về MainActivity
                setResult(115, intent);        // Thiết lập kết quả trả về với mã 115
                finish();                      // Đóng Activity
            }
        });
    }

    private void addView() {
        // Ánh xạ các view từ layout
        edtMa = findViewById(R.id.edtProductId);   // Sửa ID khớp với XML
        edtTen = findViewById(R.id.edtProductName);
        edtGia = findViewById(R.id.edtProductPrice);
        btnXoa = findViewById(R.id.btnDelete);
        btnThoat = findViewById(R.id.btnBack);

        // Lấy dữ liệu sản phẩm từ Intent
        intent = getIntent();
        if (intent != null) {
            sp = (SanPham) intent.getSerializableExtra("SANPHAM");
        }

        // Hiển thị thông tin sản phẩm
        if (sp != null) {
            edtMa.setText(sp.getMa());
            edtTen.setText(sp.getTen());
            edtGia.setText(String.valueOf(sp.getGia()));
        }
    }
}
