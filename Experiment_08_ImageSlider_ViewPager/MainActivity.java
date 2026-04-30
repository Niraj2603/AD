package com.example.imagesliderdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 1: Link ViewPager from XML
        viewPager = findViewById(R.id.viewPager);

        // Step 2: Create ImageAdapter (our custom PagerAdapter)
        imageAdapter = new ImageAdapter(this);

        // Step 3: Set adapter to ViewPager
        // This connects the image data to the swipeable ViewPager
        viewPager.setAdapter(imageAdapter);
    }
}
