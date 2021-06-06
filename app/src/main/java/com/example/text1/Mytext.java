package com.example.text1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Mytext extends TextView {
    public Mytext(Context context) {
        super(context);
    }

    public Mytext(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Mytext(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
