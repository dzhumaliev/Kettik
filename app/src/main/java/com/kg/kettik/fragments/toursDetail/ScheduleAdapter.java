package com.kg.kettik.fragments.toursDetail;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kg.kettik.R;

import java.util.ArrayList;

public class ScheduleAdapter
        extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {

    ArrayList<String> list;

    public ScheduleAdapter() {
        ArrayList<String> data = new ArrayList<>();
        list = data;
    }

    public void addSchedule(ArrayList<String> data) {
        list = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_schedule, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);

        }

        public void onBind(@NonNull String data) {
            Log.e("TAG", "onBind: " + data);
            title.setText(data);
        }

    }
}
