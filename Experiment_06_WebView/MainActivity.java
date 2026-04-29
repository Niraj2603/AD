package com.example.webviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText etUrl;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link views from XML
        webView = findViewById(R.id.webView);
        etUrl   = findViewById(R.id.etUrl);
        btnGo   = findViewById(R.id.btnGo);

        // -------------------------------------------------------
        // VERY IMPORTANT: WebViewClient
        // Without this, clicking any link opens CHROME (external)
        // With this, ALL links open INSIDE our WebView
        // -------------------------------------------------------
        webView.setWebViewClient(new WebViewClient());

        // Enable JavaScript (needed for most modern websites)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load default URL when app starts
        webView.loadUrl("https://www.google.com");

        // GO button click → load URL from EditText
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etUrl.getText().toString().trim();

                // Add https:// if user forgot to type it
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "https://" + url;
                }

                // Load the URL in WebView
                webView.loadUrl(url);
            }
        });
    }

    // -------------------------------------------------------
    // Handle Back Button Press
    // If WebView can go back → go back in web history
    // If no history → exit app normally
    // -------------------------------------------------------
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack(); // Go back in browser history
        } else {
            super.onBackPressed(); // Exit app
        }
    }
}