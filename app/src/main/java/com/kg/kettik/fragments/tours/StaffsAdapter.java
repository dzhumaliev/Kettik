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
import com.kg.kettik.models.StaffsModel;

import java.util.ArrayList;

public class StaffsAdapter
        extends RecyclerView.Adapter<StaffsAdapter.StaffViewHolder> {

    ArrayList<StaffsModel> list;

    public StaffsAdapter() {
        ArrayList<StaffsModel> data = new ArrayList<>();
        list = data;
    }

    public void addStaff(ArrayList<StaffsModel> data) {
        list = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_staffs, parent, false);
        return new StaffViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull StaffViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override public int getItemCount() {
        return list.size();
    }

    static class StaffViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView img;

        public StaffViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_staffs);
            img = itemView.findViewById(R.id.iv_staffs);
        }

        public void onBind(@NonNull StaffsModel data) {
            name.setText(data.getName());

            Glide.with(itemView.getContext())
                    .load(data.getImg())
                    .centerCrop()
                    .into(img);
        }

    }
}
