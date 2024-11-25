package leethu.b2.thu19_b4;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private RadioGroup radioGroupEducation;
    private CheckBox checkBoxC, checkBoxJava, checkBoxJavascript;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Liên kết các thành phần giao diện
        editTextName = findViewById(R.id.editTextName);
        radioGroupEducation = findViewById(R.id.radioGroupEducation);
        checkBoxC = findViewById(R.id.checkBoxC);
        checkBoxJava = findViewById(R.id.checkBoxJava);
        checkBoxJavascript = findViewById(R.id.checkBoxJavascript);
        buttonSave = findViewById(R.id.buttonSave);

        // Xử lý sự kiện khi nhấn nút "Lưu dữ liệu"
        buttonSave.setOnClickListener(v -> saveData());
    }

    // Hàm lưu dữ liệu
    private void saveData() {
        String name = editTextName.getText().toString().trim();
        int selectedEducationId = radioGroupEducation.getCheckedRadioButtonId();
        RadioButton selectedEducation = findViewById(selectedEducationId);
        String education = selectedEducation != null ? selectedEducation.getText().toString() : "";

        // Kiểm tra dữ liệu nhập vào
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập họ tên", Toast.LENGTH_SHORT).show();
            return;
        }

        if (education.isEmpty()) {
            Toast.makeText(MainActivity.this, "Vui lòng chọn hệ học", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder languages = new StringBuilder();
        if (checkBoxC.isChecked()) languages.append("Lập trình C ");
        if (checkBoxJava.isChecked()) languages.append("Java ");
        if (checkBoxJavascript.isChecked()) languages.append("Javascript ");

        if (languages.length() == 0) {
            Toast.makeText(MainActivity.this, "Vui lòng chọn ít nhất một ngôn ngữ", Toast.LENGTH_SHORT).show();
            return;
        }

        // Hiển thị thông tin đã lưu
        String result = "Tên: " + name + "\n"
                + "Hệ học: " + education + "\n"
                + "Ngôn ngữ thích học: " + languages;

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
    }
}
