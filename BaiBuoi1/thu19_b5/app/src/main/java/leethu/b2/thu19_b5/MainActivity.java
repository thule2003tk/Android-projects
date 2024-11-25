package leethu.b2.thu19_b5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class phuc5 extends AppCompatActivity {

    private EditText edtTen, edtMSSV, edtTuoi;
    private RadioGroup rgGioiTinh;
    private CheckBox cbDaBong, cbChoiGame;
    private Button btnLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thu19_b5);

        // Ánh xạ View
        edtTen = findViewById(R.id.edtTen);
        edtMSSV = findViewById(R.id.edtMSSV);
        edtTuoi = findViewById(R.id.edtTuoi);
        rgGioiTinh = findViewById(R.id.rgGioiTinh);
        cbDaBong = findViewById(R.id.cbDaBong);
        cbChoiGame = findViewById(R.id.cbChoiGame);
        btnLuu = findViewById(R.id.btnLuu);

        // Xử lý sự kiện nhấn nút Lưu
        btnLuu.setOnClickListener(v -> {
            String ten = edtTen.getText().toString();
            String mssv = edtMSSV.getText().toString();
            String tuoi = edtTuoi.getText().toString();

            // Lấy giới tính
            int selectedGenderId = rgGioiTinh.getCheckedRadioButtonId();
            String gioiTinh = selectedGenderId == R.id.rbNam ? "Nam" : "Nữ";

            // Lấy sở thích
            StringBuilder soThich = new StringBuilder();
            if (cbDaBong.isChecked()) soThich.append("Đá bóng ");
            if (cbChoiGame.isChecked()) soThich.append("Chơi game ");

            // Hiển thị thông tin
            Toast.makeText(this,
                    "Tên: " + ten +
                            "\nMSSV: " + mssv +
                            "\nTuổi: " + tuoi +
                            "\nGiới tính: " + gioiTinh +
                            "\nSở thích: " + soThich,
                    Toast.LENGTH_LONG).show();
        });
    }
}

