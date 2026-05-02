# Experiment 01 — Install & Configure Android Studio

## Aim
To Download, Install, and Configure Android Studio on Windows platform.

## Theory Summary
- Android Studio = Official IDE by Google (based on IntelliJ IDEA)
- Build Tool = Gradle → produces APK
- Min Requirements: 3GB RAM, 2GB Disk

## Android Architecture (4 Layers - Bottom to Top)
1. **Linux Kernel** — Drivers (Camera, WiFi, Audio)
2. **Libraries + Android Runtime** — SQLite, WebKit, Dalvik VM
3. **Application Framework** — Activity Manager, Window Manager
4. **Applications** — Home, Contacts, Browser

## Key Files in Every Android Project
| File | Purpose |
|------|---------|
| `AndroidManifest.xml` | App configuration, permissions |
| `MainActivity.java` | Main Java logic |
| `activity_main.xml` | UI layout |
| `build.gradle` | Build configuration |

## Default Hello World Code

### MainActivity.java
```java
package com.example.myfirstapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

### activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        android:layout_centerInParent="true"/>
</RelativeLayout>
```

## Key Viva Points
- `extends AppCompatActivity` → class IS an Activity
- `onCreate()` → first method called (like main())
- `setContentView()` → links Java to XML layout
- `R.layout.activity_main` → auto-generated resource reference
- APK = Android Package Kit (installable file)
- AVD = Android Virtual Device (Emulator)
- HAXM = Hardware Accelerated Execution Manager
