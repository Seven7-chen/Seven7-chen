package com.example.text1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private ProgressBar pro;
    private ProgressBar pro2;
    private NotificationManager manager;
    private  Notification notification;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


       if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("seven","测试通知",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }
      notification=new NotificationCompat.Builder(this,"seven")
               .setContentTitle("小文通知")
               .setContentText("小文爱小怡")
               .setSmallIcon(R.drawable.a5)
               .build();


        Button btn=findViewById(R.id.tv_two);
        et=findViewById(R.id.et);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=et.getText().toString();
                Log.e("Se","输入的内容为"+text);

                Uri uri = Uri.parse("https://www.baidu.com");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });

        Button btn2=findViewById(R.id.tv_three);
        pro=findViewById(R.id.pro);
        pro2=findViewById(R.id.pro2);

        Button btn3=findViewById(R.id.tv_four);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pro.getVisibility()==View.GONE){
                    pro.setVisibility(View.VISIBLE);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pro.getVisibility()==View.VISIBLE){
                    pro.setVisibility(View.GONE);
                }
            }
        });
    }



    public void load(View view) {
        int progress=pro2.getProgress();
        progress+=10;
        pro2.setProgress(progress);
    }

    public void sendNotification(View view) {
            manager.notify(1,notification);
    }

    public void cacelNotification(View view) {

    }

    public void alert(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.a8)
                .setTitle("我是小文对话框")
                .setMessage("今天肥猪怡胖了几斤？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"小文知道啦",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"小怡不承认",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                        startActivity(intent);
                    }
                })
                .setNeutralButton("中间", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent);
                    }
                })
                .create()
                .show();


    }

    public void hand(View view) {



    }

    public void go(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity5.class);
        startActivity(intent);
    }

    public void gogo(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity6.class);
        startActivity(intent);


    }
}