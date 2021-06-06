package com.example.text1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private List<Bean> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        for(int i=0;i<100;i++){
            Bean bean=new Bean();
            bean.setName("学冬哥哥"+i);
            data.add(bean);
        }
        ListView listView=findViewById(R.id.lv);
        listView.setAdapter(new MyAdapter(data,this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity2.this,"你点击了第"+i+"项",Toast.LENGTH_SHORT).show();
            }
        });
    }
}