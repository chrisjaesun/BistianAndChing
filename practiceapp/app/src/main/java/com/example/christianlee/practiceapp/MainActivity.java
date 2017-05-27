package com.example.christianlee.practiceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import static android.R.attr.button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String text = "Bing Sucks";

    public void BingReallySucks(View view) {
        text = text + "!";
        ((android.widget.Button)findViewById(R.id.bingbutton)).setText(text);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int screen_w = dm.widthPixels;
        int screen_h = dm.heightPixels;

        int resId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            screen_h -= getResources().getDimensionPixelSize(resId);
        }

        TypedValue typedValue = new TypedValue();
        if(getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true)){
            screen_h -= getResources().getDimensionPixelSize(typedValue.resourceId);
        }
        int x = (int) (Math.random() * screen_w);
        int y = (int) (Math.random() * screen_h);
        if (x + view.getWidth() > screen_w) {
            x = screen_w - view.getWidth();
        }
        if (y + view.getWidth() > screen_h) {
            y = screen_h - view.getWidth();
        }
        view.setY(y);
        view.setX(x);
        view.setBackgroundColor((int) (Math.random() * Integer.MAX_VALUE));
    }
}
