package com.exp10.imageslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Adapter for Manual Image Slider ViewPager2.
 */
public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {

    private final List<Integer> images;
    private final List<String> captions;

    public SliderAdapter(List<Integer> images, List<String> captions) {
        this.images = images;
        this.captions = captions;
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(images.get(position));
        holder.tvCaption.setText(captions.get(position));
    }

    @Override
    public int getItemCount() { return images.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvCaption;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivSlide);
            tvCaption = itemView.findViewById(R.id.tvCaption);
        }
    }
}
