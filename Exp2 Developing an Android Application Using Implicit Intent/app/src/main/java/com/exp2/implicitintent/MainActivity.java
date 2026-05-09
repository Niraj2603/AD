package com.exp2.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Experiment 2: Implicit Intent Demo
 * Demonstrates opening browser, dialer, email, and map using implicit intents.
 */
public class MainActivity extends AppCompatActivity {

    private EditText etUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.etUrl);
        Button btnBrowser = findViewById(R.id.btnBrowser);
        Button btnDial = findViewById(R.id.btnDial);
        Button btnEmail = findViewById(R.id.btnEmail);
        Button btnMap = findViewById(R.id.btnMap);

        // Open URL in browser using implicit intent
        btnBrowser.setOnClickListener(v -> {
            String url = etUrl.getText().toString().trim();
            if (url.isEmpty()) url = "https://www.google.com";
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        });

        // Open dialer using implicit intent
        btnDial.setOnClickListener(v -> {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919999999999"));
            startActivity(dialIntent);
        });

        // Open email client using implicit intent
        btnEmail.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:test@example.com"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello from Android");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "This email was sent via implicit intent.");
            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            } else {
                Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show();
            }
        });

        // Open Google Maps using implicit intent
        btnMap.setOnClickListener(v -> {
            Uri geoUri = Uri.parse("geo:28.6139,77.2090?q=New+Delhi");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                Toast.makeText(this, "No map app found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
