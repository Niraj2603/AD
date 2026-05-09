package com.exp4.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;

/**
 * Experiment 4: Fragment Implementation
 * Hosts two fragments and switches between them on button click.
 */
public class MainActivity extends AppCompatActivity {
    private boolean showingFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load default fragment
        if (savedInstanceState == null) {
            loadFragment(new FirstFragment());
        }

        Button btnSwitch = findViewById(R.id.btnSwitch);
        btnSwitch.setOnClickListener(v -> {
            if (showingFirst) {
                loadFragment(new SecondFragment());
                btnSwitch.setText("Show First Fragment");
            } else {
                loadFragment(new FirstFragment());
                btnSwitch.setText("Show Second Fragment");
            }
            showingFirst = !showingFirst;
        });
    }

    private void loadFragment(androidx.fragment.app.Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
}
