package com.dmio.org.tut.activity.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmio.org.tut.R;

public class ComptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    public ComptAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_main_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        itemHolder.bindViewData(position);
    }

    @Override
    public int getItemCount() {
        return Component.ENTRANCE.length;
    }

    final class ItemHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;

        public ItemHolder(View root) {
            super(root);
            tvTitle = (TextView) root.findViewById(R.id.tv_title);
        }

        public void bindViewData(int position) {
            final Class clz = Component.ENTRANCE[position];
            String entry = clz.getSimpleName();
            int index = entry.toLowerCase().lastIndexOf("activity");
            if (index != -1) {
                entry = entry.substring(0, index);
            }
            tvTitle.setText(entry);
            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityCompat.startActivity(mContext, new Intent(mContext, clz), null);
                }
            });
        }
    }
}