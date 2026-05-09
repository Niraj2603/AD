package com.exp10.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

/**
 * Experiment 10: Manual Image Slider
 * Users navigate slides using PREVIOUS and NEXT buttons.
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<Integer> images;
    private List<String> captions;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        Button btnPrev = findViewById(R.id.btnPrev);
        Button btnNext = findViewById(R.id.btnNext);
        TextView tvIndex = findViewById(R.id.tvIndex);
        TextView tvCaptionMain = findViewById(R.id.tvCaptionMain);

        // Image resources and captions
        images = Arrays.asList(
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img5, R.drawable.img6
        );
        captions = Arrays.asList(
            "Nature ??", "Ocean ??", "Mountains ??",
            "Sunset ??", "City Lights ??", "Galaxy ?"
        );

        SliderAdapter adapter = new SliderAdapter(images, captions);
        viewPager2.setAdapter(adapter);

        // Sync state when user swipes manually
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                currentIndex = position;
                updateUI(tvIndex, tvCaptionMain, btnPrev, btnNext);
            }
        });

        // PREVIOUS button
        btnPrev.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                viewPager2.setCurrentItem(currentIndex, true);
                updateUI(tvIndex, tvCaptionMain, btnPrev, btnNext);
            }
        });

        // NEXT button
        btnNext.setOnClickListener(v -> {
            if (currentIndex < images.size() - 1) {
                currentIndex++;
                viewPager2.setCurrentItem(currentIndex, true);
                updateUI(tvIndex, tvCaptionMain, btnPrev, btnNext);
            }
        });

        // Initial UI state
        updateUI(tvIndex, tvCaptionMain, btnPrev, btnNext);
    }

    private void updateUI(TextView tvIndex, TextView tvCaption, Button btnPrev, Button btnNext) {
        tvIndex.setText((currentIndex + 1) + " / " + images.size());
        tvCaption.setText(captions.get(currentIndex));
        btnPrev.setEnabled(currentIndex > 0);
        btnNext.setEnabled(currentIndex < images.size() - 1);
        btnPrev.setAlpha(currentIndex > 0 ? 1.0f : 0.4f);
        btnNext.setAlpha(currentIndex < images.size() - 1 ? 1.0f : 0.4f);
    }
}
