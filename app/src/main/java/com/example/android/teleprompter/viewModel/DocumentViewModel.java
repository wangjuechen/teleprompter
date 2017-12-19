package com.example.android.teleprompter.viewModel;


import android.content.Context;
import android.databinding.BaseObservable;

import com.example.android.teleprompter.model.Document;

import java.text.SimpleDateFormat;

public class DocumentViewModel extends BaseObservable {

    private Context mContect;

    private Document mDocument;

    public DocumentViewModel(Context context, Document document){
        this.mContect = context;
        this.mDocument = document;
    }

    public String getDocumentlTitle(){
        return mDocument.title;
    }

    public String getDocumentTime(){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");

        return df.format(mDocument.time);
    }
}
