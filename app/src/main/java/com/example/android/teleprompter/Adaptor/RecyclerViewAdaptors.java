package com.example.android.teleprompter.Adaptor;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.teleprompter.R;

public class RecyclerViewAdaptors extends RecyclerView.Adapter{


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recyclerview_list_content, parent, false);
        return new documentsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class documentsListViewHolder extends RecyclerView.ViewHolder {


        public documentsListViewHolder(View itemView) {
            super(itemView);
        }
    }


}
