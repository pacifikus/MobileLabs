package com.example.lab4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {
    private final MainActivity mainActivity;
    private final List<DummyContent.DummyItem> values;

    RAdapter(MainActivity parent, List<DummyContent.DummyItem> items) {
        mainActivity = parent;
        values = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.first, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.idView.setText(values.get(position).id);
        holder.contentView.setText(values.get(position).content);
        holder.itemView.setTag(values.get(position));
        holder.itemView.setOnClickListener(onClickListener);
    }
    @Override
    public int getItemCount() { return values.size(); }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView idView;
        final TextView contentView;

        ViewHolder(View view) {
            super(view);
            idView = view.findViewById(R.id.tv_num);
            contentView = view.findViewById(R.id.tv_text);
        }
    }

    final private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();
            Context context = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("item_id", Integer.parseInt(item.id));
            context.startActivity(intent);
        }
    };
}
