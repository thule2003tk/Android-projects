package leethu.b2.thu_b2;

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

    private EditText editTextName, editTextHeight, editTextWeight;
    private TextView textViewBMI, textViewDiagnosis;
    private Button buttonCalculateBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Liên kết các thành phần giao diện
        editTextName = findViewById(R.id.editTextName);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);
        textViewBMI = findViewById(R.id.textViewBMI);
        textViewDiagnosis = findViewById(R.id.textViewDiagnosis);

        // Xử lý sự kiện nút Tính BMI
        buttonCalculateBMI.setOnClickListener(v -> calculateBMI());
    }

    private void calculateBMI() {
        String name = editTextName.getText().toString().trim();
        String heightText = editTextHeight.getText().toString();
        String weightText = editTextWeight.getText().toString();

        // Kiểm tra dữ liệu nhập vào
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(heightText) || TextUtils.isEmpty(weightText)) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double height = Double.parseDouble(heightText);
            double weight = Double.parseDouble(weightText);

            if (height <= 0 || weight <= 0) {
                Toast.makeText(MainActivity.this, "Chiều cao và cân nặng phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tính BMI
            double bmi = weight / (height * height);
            textViewBMI.setText(String.format("BMI = %.2f", bmi));

            // Chẩn đoán
            String diagnosis = "";
            if (bmi < 18) {
                diagnosis = "Người gầy";
            } else if (bmi >= 18 && bmi < 25) {
                diagnosis = "Người bình thường";
            } else if (bmi >= 25 && bmi < 30) {
                diagnosis = "Người béo phì độ I";
            } else if (bmi >= 30 && bmi < 35) {
                diagnosis = "Người béo phì độ II";
            } else {
                diagnosis = "Người béo phì độ III";
            }

            textViewDiagnosis.setText("Chẩn đoán: " + diagnosis);

        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Dữ liệu không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
