package leethu.b2.la05_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import leethu.b2.la05_2.R;

public class MainActivity extends AppCompatActivity {

    private EditText etEmployeeID, etEmployeeName, etEmployeePhone;
    private Button btnAdd;
    private ListView lvEmployees;

    private ArrayList<String> employeeList; // Danh sách nhân viên
    private ArrayAdapter<String> employeeAdapter; // Adapter để hiển thị danh sách

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ giao diện
        etEmployeeID = findViewById(R.id.etEmployeeID);
        etEmployeeName = findViewById(R.id.etEmployeeName);
        etEmployeePhone = findViewById(R.id.etEmployeePhone);
        btnAdd = findViewById(R.id.btnAdd);
        lvEmployees = findViewById(R.id.lvEmployees);

        // Khởi tạo danh sách nhân viên và adapter
        employeeList = new ArrayList<>();
        employeeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employeeList);
        lvEmployees.setAdapter(employeeAdapter);

        // Xử lý sự kiện nút Thêm nhân viên
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etEmployeeID.getText().toString().trim();
                String name = etEmployeeName.getText().toString().trim();
                String phone = etEmployeePhone.getText().toString().trim();

                if (id.isEmpty() || name.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Thêm nhân viên vào danh sách
                String employee = id + " - " + name + " - " + phone;
                employeeList.add(employee);
                employeeAdapter.notifyDataSetChanged();

                // Xóa dữ liệu trên EditText sau khi thêm
                etEmployeeID.setText("");
                etEmployeeName.setText("");
                etEmployeePhone.setText("");

                Toast.makeText(MainActivity.this, "Đã thêm nhân viên!", Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý sự kiện khi click vào một nhân viên trong ListView
        lvEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy thông tin nhân viên được chọn
                String employee = employeeList.get(position);
                String[] parts = employee.split(" - ");

                // Hiển thị thông tin nhân viên lên EditText
                if (parts.length == 3) {
                    etEmployeeID.setText(parts[0]);
                    etEmployeeName.setText(parts[1]);
                    etEmployeePhone.setText(parts[2]);
                }
            }
        });

        // Xử lý sự kiện long click để xóa nhân viên
        lvEmployees.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Xóa nhân viên khỏi danh sách
                employeeList.remove(position);
                employeeAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Đã xóa nhân viên!", Toast.LENGTH_SHORT).show();
                return true; // Để chỉ rằng sự kiện long click đã được xử lý
            }
        });
    }
}
