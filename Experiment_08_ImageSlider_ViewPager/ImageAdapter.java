package com.example.imagesliderdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

// ImageAdapter extends PagerAdapter
// PagerAdapter is the base class that supplies pages to ViewPager
public class ImageAdapter extends PagerAdapter {

    Context mContext;

    // Constructor
    public ImageAdapter(Context context) {
        this.mContext = context;
    }

    // -------------------------------------------------------
    // Array of image resource IDs stored in drawable folder
    // R.drawable.image1 = res/drawable/image1.jpg
    // -------------------------------------------------------
    private int[] sliderImageId = new int[]{
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
    };

    // -------------------------------------------------------
    // getCount() — returns TOTAL number of pages/images
    // ViewPager uses this to know how many pages exist
    // -------------------------------------------------------
    @Override
    public int getCount() {
        return sliderImageId.length; // 5 images = 5 pages
    }

    // -------------------------------------------------------
    // isViewFromObject() — checks if a view belongs to object
    // Required by PagerAdapter — always write this exact code
    // -------------------------------------------------------
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (ImageView) object;
    }

    // -------------------------------------------------------
    // instantiateItem() — CREATES a page at given position
    // Called when ViewPager needs to display a new page
    // position = index of image (0, 1, 2, 3, 4)
    // -------------------------------------------------------
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Create a new ImageView for this page
        ImageView imageView = new ImageView(mContext);

        // ScaleType: how image fits the ImageView
        // CENTER_CROP = fill entire view, crop edges if needed
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // Set the image from drawable array using position
        imageView.setImageResource(sliderImageId[position]);

        // Add this ImageView to ViewPager container
        ((ViewPager) container).addView(imageView, 0);

        // Return the ImageView (it becomes the "key" object)
        return imageView;
    }

    // -------------------------------------------------------
    // destroyItem() — REMOVES a page from ViewPager
    // Called when page scrolls too far away (memory cleanup)
    // -------------------------------------------------------
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove the ImageView from ViewPager
        ((ViewPager) container).removeView((ImageView) object);
    }
}
