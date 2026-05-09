package com.exp3.explicitintent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Experiment 3: Explicit Intent Demo - First Activity
 * Sends user data to SecondActivity using an explicit intent.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.etName);
        EditText etMessage = findViewById(R.id.etMessage);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String message = etMessage.getText().toString().trim();
            if (name.isEmpty()) name = "Guest";
            if (message.isEmpty()) message = "Hello!";

            // Create explicit intent targeting SecondActivity
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("USER_NAME", name);
            intent.putExtra("USER_MESSAGE", message);
            startActivity(intent);
        });
    }
}
