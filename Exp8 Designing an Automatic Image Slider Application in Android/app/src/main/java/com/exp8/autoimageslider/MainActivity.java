package com.exp8.autoimageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Experiment 8: Automatic Image Slider using ViewPager2
 * Slides automatically every 3 seconds in an infinite loop.
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private SliderAdapter sliderAdapter;
    private List<SlideItem> slideItems;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private int currentPage = 0;

    // Auto-slide runnable - advances to next page every 3 seconds
    private final Runnable autoSlideRunnable = new Runnable() {
        @Override
        public void run() {
            if (currentPage == slideItems.size()) currentPage = 0;
            viewPager2.setCurrentItem(currentPage++, true);
            handler.postDelayed(this, 3000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        TextView tvCounter = findViewById(R.id.tvCounter);

        // Initialize slide data
        slideItems = new ArrayList<>();
        slideItems.add(new SlideItem(R.drawable.slide_1, "Android Development", "Build powerful mobile apps"));
        slideItems.add(new SlideItem(R.drawable.slide_2, "Material Design", "Beautiful and intuitive UI"));
        slideItems.add(new SlideItem(R.drawable.slide_3, "ViewPager2", "Smooth page transitions"));
        slideItems.add(new SlideItem(R.drawable.slide_4, "Auto Slider", "Automatic image carousel"));
        slideItems.add(new SlideItem(R.drawable.slide_5, "RecyclerView", "Efficient list rendering"));

        sliderAdapter = new SliderAdapter(slideItems);
        viewPager2.setAdapter(sliderAdapter);

        // Update counter on page change
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPage = position + 1;
                tvCounter.setText((position + 1) + " / " + slideItems.size());
            }
        });

        tvCounter.setText("1 / " + slideItems.size());

        // Start auto-sliding
        handler.postDelayed(autoSlideRunnable, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(autoSlideRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(autoSlideRunnable, 3000);
    }
}
