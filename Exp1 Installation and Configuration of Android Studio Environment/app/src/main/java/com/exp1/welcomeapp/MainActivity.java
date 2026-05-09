package com.exp1.welcomeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ImageView;

/**
 * Experiment 1: Installation and Configuration of Android Studio Environment
 * This activity displays a welcome screen confirming Android Studio is ready.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views
        TextView tvWelcome = findViewById(R.id.tvWelcome);
        TextView tvStatus = findViewById(R.id.tvStatus);
        ImageView ivLogo = findViewById(R.id.ivLogo);

        // Load and apply fade-in animation to welcome text
        Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fadeIn.setDuration(1500);
        tvWelcome.startAnimation(fadeIn);

        // Load and apply slide-up animation to status text
        Animation slideUp = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        slideUp.setDuration(1000);
        tvStatus.startAnimation(slideUp);

        // Apply animation to logo
        Animation logoAnim = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        logoAnim.setDuration(2000);
        ivLogo.startAnimation(logoAnim);
    }
}
