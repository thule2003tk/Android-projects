package leethu.thu19_b1;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFahrenheit, editTextCelsius;
    private Button btnToCelsius, btnToFahrenheit, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Liên kết các thành phần giao diện
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        editTextCelsius = findViewById(R.id.editTextCelsius);
        btnToCelsius = findViewById(R.id.btnToCelsius);
        btnToFahrenheit = findViewById(R.id.btnToFahrenheit);
        btnClear = findViewById(R.id.btnClear);

        // Chuyển từ Fahrenheit sang Celsius
        btnToCelsius.setOnClickListener(v -> convertToCelsius());

        // Chuyển từ Celsius sang Fahrenheit
        btnToFahrenheit.setOnClickListener(v -> convertToFahrenheit());

        // Xóa dữ liệu
        btnClear.setOnClickListener(v -> clearData());
    }

    // Chuyển từ Fahrenheit sang Celsius
    private void convertToCelsius() {
        String fahrenheitText = editTextFahrenheit.getText().toString();

        if (TextUtils.isEmpty(fahrenheitText)) {
            Toast.makeText(MainActivity.this, "Please enter Fahrenheit value", Toast.LENGTH_SHORT).show();
            return;
        }

        double fahrenheit = Double.parseDouble(fahrenheitText);
        double celsius = (fahrenheit - 32) * 5 / 9;
        editTextCelsius.setText(String.format("%.2f", celsius));
    }

    // Chuyển từ Celsius sang Fahrenheit
    private void convertToFahrenheit() {
        String celsiusText = editTextCelsius.getText().toString();

        if (TextUtils.isEmpty(celsiusText)) {
            Toast.makeText(MainActivity.this, "Please enter Celsius value", Toast.LENGTH_SHORT).show();
            return;
        }

        double celsius = Double.parseDouble(celsiusText);
        double fahrenheit = (celsius * 9 / 5) + 32;
        editTextFahrenheit.setText(String.format("%.2f", fahrenheit));
    }

    // Xóa dữ liệu trên các EditText
    private void clearData() {
        editTextFahrenheit.setText("");
        editTextCelsius.setText("");
    }
}
