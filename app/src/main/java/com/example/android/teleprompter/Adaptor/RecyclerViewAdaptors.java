package com.example.android.teleprompter.Adaptor;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.teleprompter.R;
import com.example.android.teleprompter.model.Document;
import com.example.android.teleprompter.databinding.RecyclerviewListContentBinding;
import com.example.android.teleprompter.viewModel.DocumentViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdaptors extends RecyclerView.Adapter<RecyclerViewAdaptors.documentsListViewHolder>{

    private List<Document> mDocumentList;

    private Context mContext;

    public RecyclerViewAdaptors(Context context){

        mDocumentList = new ArrayList<>();

        mContext = context;
    }

    @Override
    public documentsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerviewListContentBinding view = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.recyclerview_list_content, parent, false);
        return new documentsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(documentsListViewHolder holder, int position) {
        RecyclerviewListContentBinding contentBinding = holder.mListContentBinding;

        contentBinding.setViewModel(new DocumentViewModel(mContext,mDocumentList.get(position)));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class documentsListViewHolder extends RecyclerView.ViewHolder {

        private RecyclerviewListContentBinding mListContentBinding;


        public documentsListViewHolder(RecyclerviewListContentBinding binding) {

            super(binding.listContentCondtraintLayout);

            mListContentBinding = binding;


            ;
        }
    }


}
