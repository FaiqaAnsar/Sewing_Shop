package com.example.sewingshopproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FBAdapter extends RecyclerView.Adapter<FBAdapter.MyViewHolder> {

    Context context;
    ArrayList<Feed> list;


    public FBAdapter(Context context, ArrayList<Feed> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public FBAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fbentry, parent, false);
        return new FBAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FBAdapter.MyViewHolder holder, int position) {
        Feed feed = list.get(position);
        holder.name.setText(feed.getName());
        holder.msg.setText(feed.getMsg());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, msg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt1);
            msg = itemView.findViewById(R.id.txt2);
        }
    }
}
