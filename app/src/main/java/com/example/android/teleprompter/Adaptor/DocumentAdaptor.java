package com.example.android.teleprompter.Adaptor;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.teleprompter.R;
import com.example.android.teleprompter.databinding.ItemDocumentBinding;
import com.example.android.teleprompter.model.Document;
import com.example.android.teleprompter.viewModel.DocumentDetailsViewModel;

import java.util.Collections;
import java.util.List;

public class DocumentAdaptor extends RecyclerView.Adapter<DocumentAdaptor.documentsListViewHolder> {

    private List<Document> mDocumentList;

    private Context mContext;

    public DocumentAdaptor(Context context, List<Document> documentList) {

        mDocumentList = documentList;

        mContext = context;
    }

    @Override
    public documentsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemDocumentBinding view = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_document, parent, false);
        return new documentsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(documentsListViewHolder holder, int position) {
        //RecyclerviewListContentBinding contentBinding = holder.mListContentBinding;
        holder.bindDocument(mDocumentList.get(position));
        //contentBinding.setViewModel(new DocumentDetailsViewModel(mContext,mDocumentList.get(position)));
    }

    @Override
    public int getItemCount() {
        return mDocumentList.size();
    }

    public void setDocumentList(List<Document> documentList){
        this.mDocumentList = documentList;
        notifyDataSetChanged();
    }

    public static class documentsListViewHolder extends RecyclerView.ViewHolder {

        private ItemDocumentBinding mListContentBinding;


        public documentsListViewHolder(ItemDocumentBinding binding) {

            super(binding.listContentCondtraintLayout);

            this.mListContentBinding = binding;

        }

        public void bindDocument(Document document) {
            if (mListContentBinding.getViewModel() == null) {
                mListContentBinding.setViewModel(new DocumentDetailsViewModel(itemView.getContext(), document));
            } else {
                mListContentBinding.getViewModel().setDocument(document);
            }
        }
    }


}
