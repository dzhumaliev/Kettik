package com.kg.kettik.fragments.onBoard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kg.kettik.R;
import com.kg.kettik.models.OnBoardModel;

import java.util.ArrayList;

public class SampleRecyclerAdapter
        extends RecyclerView.Adapter<SampleRecyclerAdapter.MyViewHolder> {

    ArrayList<OnBoardModel> list;

    public SampleRecyclerAdapter() {
        ArrayList<OnBoardModel> data = new ArrayList<>();
        list = data;
    }

    public void createScreen(ArrayList<OnBoardModel> data) {
        list = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_on_board, parent, false);
        return new MyViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView desc;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title_on_board);
            desc = itemView.findViewById(R.id.tv_desc_on_board);
            img = itemView.findViewById(R.id.iv_on_board);
        }

        public void onBind(@NonNull OnBoardModel data) {
            title.setText(data.getTitle());
            desc.setText(data.getDesc());

            Glide.with(itemView.getContext())
                    .load(data.getImage())
                    .centerCrop()
                    .into(img);
        }

    }
}
