package com.example.lab05;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.model.MonHoc;
import com.google.android.material.progressindicator.AnimatorDurationScaleProvider;

public class ListViewObject extends AppCompatActivity {
ListView lstMonHoc;
ArrayAdapter<MonHoc> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_object);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
           
        });
        addView();
        addEvent();
    }

    private void addEvent() {
        lstMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonHoc mh=adapter.getItem( position);
                Toast.makeText(ListViewObject.this,mh.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        lstMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               MonHoc mh=adapter.getItem(position);
               adapter.remove(mh);
                return false;
            }
        });
    }

    private void addView() {
        lstMonHoc=findViewById(R.id.lstMonHoc);
        adapter =new ArrayAdapter<>(ListViewObject.this, android.R.layout.simple_list_item_1);
        lstMonHoc.setAdapter(adapter);
        adapter.add(new MonHoc(1,"toán",45));
        adapter.add(new MonHoc(2,"văn",50));
    }
}