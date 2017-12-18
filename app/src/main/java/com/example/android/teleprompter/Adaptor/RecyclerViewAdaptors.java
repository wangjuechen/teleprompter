package com.example.android.teleprompter.Adaptor;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.teleprompter.R;

public class RecyclerViewAdaptors extends RecyclerView.Adapter<RecyclerViewAdaptors.documentsListViewHolder>{

    public RecyclerViewAdaptors(){

    }

    @Override
    public documentsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recyclerview_list_content, parent, false);
        return new documentsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(documentsListViewHolder holder, int position) {
        holder.file_title.setText("Title");
        holder.file_info.setText("Opened at 4th Oct");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class documentsListViewHolder extends RecyclerView.ViewHolder {

        ImageView file_icon;
        TextView file_title;
        TextView file_info;

        public documentsListViewHolder(View itemView) {

            super(itemView);

            View contentView = itemView;
            file_icon = contentView.findViewById(R.id.iv_fileTypeIcon);
            file_title = contentView.findViewById(R.id.tv_fileTitle);
            file_info = contentView.findViewById(R.id.tv_fileInfo);
        }
    }


}
