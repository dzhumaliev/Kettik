package com.kg.kettik.fragments.tours;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kg.kettik.R;
import com.kg.kettik.models.ToursModel;

import java.util.ArrayList;

public class ToursAdapter
        extends RecyclerView.Adapter<ToursAdapter.MyViewHolder> {

    ArrayList<ToursModel> list;
    private OnItemClickListener listener;

    public ToursAdapter(OnItemClickListener listener) {
        ArrayList<ToursModel> data = new ArrayList<>();
        list = data;
        this.listener = listener;
    }

    public void addTours(ArrayList<ToursModel> data) {
        list = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_tours, parent, false);
        return new MyViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(list.get(position), listener);
    }

    @Override public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView count;
        TextView date;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);
            count = itemView.findViewById(R.id.tv_count);
//            date = itemView.findViewById(R.id.tv_date);
            img = itemView.findViewById(R.id.img_tours);
        }

        public void onBind(@NonNull ToursModel data, OnItemClickListener listener) {
            itemView.setOnClickListener(view ->
                    listener.onItemClick(data));

            title.setText(data.getTitle());
            count.setText(data.getCount());
//            date.setText(data.getDate());

            Glide.with(itemView.getContext())
                    .load(data.getImage())
                    .centerCrop()
                    .into(img);
        }

    }
}
