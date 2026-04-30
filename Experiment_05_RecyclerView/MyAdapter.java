package com.example.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// Adapter extends RecyclerView.Adapter with our ViewHolder
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<String> nameList;

    // Constructor — receives context and data list
    public MyAdapter(Context context, List<String> nameList) {
        this.context = context;
        this.nameList = nameList;
    }

    // -------------------------------------------------------
    // STEP A: onCreateViewHolder
    // Called when RecyclerView needs a NEW ViewHolder
    // It INFLATES (creates) the item layout
    // -------------------------------------------------------
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate item_view.xml to create one list item view
        View view = LayoutInflater.from(context)
                    .inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    // -------------------------------------------------------
    // STEP B: onBindViewHolder
    // Called to FILL data into each ViewHolder
    // position = which item (0, 1, 2...)
    // -------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Get the name for this position
        String name = nameList.get(position);

        // Set data into the ViewHolder's views
        holder.tvName.setText(name);
        holder.tvRollNo.setText(String.valueOf(position + 1)); // Roll: 1, 2, 3...

        // Click listener on each item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked: " + name,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    // -------------------------------------------------------
    // STEP C: getItemCount
    // Returns TOTAL number of items in list
    // RecyclerView uses this to know how many items exist
    // -------------------------------------------------------
    @Override
    public int getItemCount() {
        return nameList.size();
    }

    // -------------------------------------------------------
    // ViewHolder — holds references to views of ONE item
    // Avoids calling findViewById() repeatedly (saves memory)
    // -------------------------------------------------------
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvRollNo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find views ONCE and store them — this is the whole point!
            tvName = itemView.findViewById(R.id.tvName);
            tvRollNo = itemView.findViewById(R.id.tvRollNo);
        }
    }
}
