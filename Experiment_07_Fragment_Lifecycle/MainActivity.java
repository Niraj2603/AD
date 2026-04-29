package com.example.fragmentlifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "FragmentDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity: onCreate() → Loading Fragment...");

        // Load MyFragment into FrameLayout container
        // Check savedInstanceState to avoid duplicate fragments on rotation
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new MyFragment())
                    .commit();
        }

        Log.d(TAG, "MainActivity: Fragment transaction committed!");
    }
}