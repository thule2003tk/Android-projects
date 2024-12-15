package com.example.bai62;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bai62.SanPham;

public class MainActivity extends AppCompatActivity {
    ListView lvSanpham;
    ArrayAdapter<SanPham> adtSanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

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
        lvSanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Lấy sản phẩm được chọn
                SanPham sp = adtSanPham.getItem(i);

                // Tạo intent và truyền dữ liệu sản phẩm sang ChiTietActivity
                Intent intent = new Intent(MainActivity.this, com.example.bai62.ChiTietActivity.class);
                intent.putExtra("SANPHAM", sp);
                startActivityForResult(intent, 113);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 113 && resultCode == 115) {
            // Lấy sản phẩm đã được cập nhật hoặc xóa
            SanPham sp = (SanPham) data.getSerializableExtra("SANPHAM");

            // Duyệt danh sách để tìm sản phẩm cần xóa
            for (int i = 0; i < adtSanPham.getCount(); i++) {
                if (sp.getMa().equals(adtSanPham.getItem(i).getMa())) {
                    adtSanPham.remove(adtSanPham.getItem(i));
                    break;
                }
            }
        }
    }

    private void addView() {
        lvSanpham = findViewById(R.id.lvSanPham);

        // Khởi tạo adapter cho ListView
        adtSanPham = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        lvSanpham.setAdapter(adtSanPham);

        // Thêm sản phẩm mẫu
        adtSanPham.add(new SanPham("001", "Kem ly", 50000));
        adtSanPham.add(new SanPham("002", "Kem que", 55000));
        adtSanPham.add(new SanPham("003", "Kem ốc quế", 55000));
    }
}
