https://claude.ai/share/616ca33f-64f5-4e72-a1e1-1fc96ff40c54

# Android Studio Setup & Running the Experiment

This guide explains how to open and run the Android experiment project in Android Studio.

---

# Step-by-Step Setup Guide

## Step 1: Open Android Studio

* Double-click **Android Studio** on your desktop.

---

## Step 2: Close Any Open Project

If a project is already open:

1. Click **File** (top menu)
2. Select **Close Project**
3. The **Welcome Screen** will appear

---

## Step 3: Open the Experiment Folder

1. On the **Welcome Screen**, click **Open**
2. A file browser will open
3. Navigate to the location where you downloaded the GitHub repository
4. Select the experiment folder
   Example:

   ```text
   exp2
   ```
5. Click **OK**

---

## Step 4: Wait for Gradle Sync

After opening the project:

* Android Studio will start **Gradle Sync**
* You will see a loading/progress bar at the bottom
* **Do NOT click anything while syncing**
* Wait until the process completes

When the loading stops, Gradle Sync is complete ✅

---

## Step 5: Set Up Emulator (If Not Already Created)

### Create a Virtual Android Device

1. In the top toolbar, click the **device dropdown**

   * It may show:

     ```text
     No Device
     ```

2. Open:

   * **Device Manager** or
   * **AVD Manager**

3. Click:

   ```text
   Create Device
   ```

4. Select:

   ```text
   Pixel 4
   ```

5. Click **Next**

6. Select:

   ```text
   API 30
   ```

7. If API 30 is not installed:

   * Click **Download**
   * Wait for installation

8. Click:

   ```text
   Next → Finish
   ```

Your emulator will now appear in the device dropdown ✅

---

## Step 6: Run the Application

1. Click the green **Run ▶️** button in the top toolbar
2. Select your emulator
3. Click **OK**
4. Wait for 1–3 minutes

The application will launch on the emulator ✅

---

# Quick Run Steps

```text
1. Open the exp folder in Android Studio
2. Wait for Gradle Sync
3. Click Run ▶️
```

---

# Bonus: Create a Virtual Phone (Emulator)

After installing Android Studio:

1. Open Android Studio

2. On the Welcome Screen:

   ```text
   More Actions → Virtual Device Manager
   ```

3. Click:

   ```text
   Create Device (+ icon)
   ```

4. Select:

   ```text
   Pixel 4
   ```

5. Click **Next**

6. Select:

   ```text
   API 30
   ```

7. Click **Download** and wait for installation

8. Click:

   ```text
   Next → Finish
   ```

Your virtual Android phone is now ready ✅

---

# Tip for Low-End / Weak Laptops

If your laptop has only **4 GB RAM**, using an emulator may be slow.

Instead, use a **real Android phone**.

## Run the App Using Your Phone

### Step 1: Connect Your Phone

* Connect your Android phone using a USB cable

---

### Step 2: Enable Developer Options

On your phone:

```text
Settings → About Phone → Tap "Build Number" 7 times
```

Developer Options will be enabled.

---

### Step 3: Enable USB Debugging

1. Open:

   ```text
   Settings → Developer Options
   ```

2. Enable:

   ```text
   USB Debugging
   ```

---

### Step 4: Run the App

* Android Studio will automatically detect your phone
* Click **Run ▶️**
* Select your phone
* The app will run directly on your device ✅

### Advantages

* No emulator needed
* Uses much less RAM
* Faster on low-end laptops

---
