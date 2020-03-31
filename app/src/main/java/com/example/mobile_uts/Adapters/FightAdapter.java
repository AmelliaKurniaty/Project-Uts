package com.example.mobile_uts.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_uts.Models.Fight;
import com.example.mobile_uts.R;

import java.util.List;

public class FightAdapter extends RecyclerView.Adapter<FightAdapter.ViewHolder> {
    private List<Fight> items;
    private OnItemFightListener listener;

    public FightAdapter(List<Fight> items, OnItemFightListener listener) {
        this.items = items;
        this.listener = listener;
    }

    public interface OnItemFightListener {
        void onFightClicked(int index, Fight item);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_drawing, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FightAdapter.ViewHolder holder, int position) {
        Fight item = items.get(position);
        holder.bind(position, item);
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name1, name2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name1 = itemView.findViewById(R.id.nama1);
            name2 = itemView.findViewById(R.id.nama2);
        }

        public void bind(final int index, final Fight item) {
            name1.setText(item.getNama1());
            name1.setTextColor(Color.parseColor("#DD1212"));
            name2.setText(item.getNama2());
            name2.setTextColor(Color.parseColor("#20AD26"));
        }

    }
}
