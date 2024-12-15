package leethu.b2.lab06;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.Adapter.SanPhamAdapter;
import com.example.model.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvSanPham;
    SanPhamAdapter sanPhamAdapter;
    List<SanPham> sanPhamList;

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
        // Sự kiện sẽ được thêm ở đây nếu cần
    }

    private void addView() {
        // Ánh xạ ListView
        lvSanPham = findViewById(R.id.lstSanPham);

        // Khởi tạo danh sách sản phẩm
        sanPhamList = new ArrayList<>();
        fakeData();

        // Khởi tạo Adapter
        sanPhamAdapter = new SanPhamAdapter(MainActivity.this, R.layout.item);

        // Gán Adapter cho ListView
        lvSanPham.setAdapter(sanPhamAdapter);
    }

    private void fakeData() {
        // Thêm dữ liệu giả lập vào danh sách sản phẩm
        sanPhamList.add(new SanPham(1, "ads", 150, R.drawable.ads2));
        sanPhamList.add(new SanPham(2, "dầu gội", 200, R.drawable.daugoi));
        sanPhamList.add(new SanPham(3, "dầu xả", 300, R.drawable.dauxa));
    }
}