package com.example.lab05;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewArray extends AppCompatActivity {
ListView lstMonHoc;
EditText edtMonHoc;
String[] arrMonHoc= new String[]{"toán","văn" ,"ngoại ngữ"};
ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_array);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addview();
        addEvent();
    }

    private void addEvent() {
        lstMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListViewArray.this,arrMonHoc[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addview() {
        lstMonHoc=findViewById(R.id.lstMonHoc);
        edtMonHoc=findViewById(R.id.edtMonhoc);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(ListViewArray.this, android.R.layout.simple_list_item_1,arrMonHoc);
        lstMonHoc.setAdapter(adapter);


    }
}