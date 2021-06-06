package com.example.text1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.lang.annotation.Annotation;

public class MainActivity3 extends AppCompatActivity {
    private  boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        RelativeLayout relativelayout=findViewById(R.id.rl);
       AnimationDrawable amin= (AnimationDrawable) relativelayout.getBackground();
        relativelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag){
                    amin.start();
                    flag=false;
                }else{
                    amin.stop();
                    flag=true;
                }
            }
        });
    }
}