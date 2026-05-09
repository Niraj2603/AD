package com.exp3.explicitintent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Experiment 3: Explicit Intent Demo - Second Activity
 * Receives and displays data sent from MainActivity.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Retrieve data passed via explicit intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("USER_NAME");
        String message = intent.getStringExtra("USER_MESSAGE");

        TextView tvName = findViewById(R.id.tvName);
        TextView tvMessage = findViewById(R.id.tvMessage);
        Button btnBack = findViewById(R.id.btnBack);

        tvName.setText("?? " + name);
        tvMessage.setText("?? " + message);

        // Go back to MainActivity
        btnBack.setOnClickListener(v -> finish());
    }
}
