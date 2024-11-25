package leethu.b2.thu19_b3;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Liên kết các thành phần giao diện
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        textViewResult = findViewById(R.id.textViewResult);

        // Thêm sự kiện cho các nút
        btnAdd.setOnClickListener(v -> performOperation("add"));
        btnSubtract.setOnClickListener(v -> performOperation("subtract"));
        btnMultiply.setOnClickListener(v -> performOperation("multiply"));
        btnDivide.setOnClickListener(v -> performOperation("divide"));
    }

    // Hàm xử lý các phép toán
    private void performOperation(String operation) {
        String aText = editTextA.getText().toString();
        String bText = editTextB.getText().toString();

        // Kiểm tra dữ liệu nhập
        if (TextUtils.isEmpty(aText) || TextUtils.isEmpty(bText)) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ giá trị", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(aText);
        double b = Double.parseDouble(bText);
        double result = 0;

        switch (operation) {
            case "add":
                result = a + b;
                break;
            case "subtract":
                result = a - b;
                break;
            case "multiply":
                result = a * b;
                break;
            case "divide":
                if (b == 0) {
                    Toast.makeText(MainActivity.this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = a / b;
                break;
        }

        // Hiển thị kết quả
        textViewResult.setText("Kết quả: " + result);
    }
}
