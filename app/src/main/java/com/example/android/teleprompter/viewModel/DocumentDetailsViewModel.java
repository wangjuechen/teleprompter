package com.example.android.teleprompter.viewModel;


import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.android.teleprompter.R;
import com.example.android.teleprompter.model.Document;

import com.squareup.picasso.Picasso;

public class DocumentDetailsViewModel extends BaseObservable {

    private Context mContect;

    private Document mDocument;

    public DocumentDetailsViewModel(Context context, Document document){
        this.mContect = context;
        this.mDocument = document;
    }

    public String getDocumentlTitle(){
        return mDocument.title;
    }

    public String getDocumentLastOpenTime(){
        //SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");

        //return df.format(mDocument.time);
        return mDocument.time;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String fileType){

//        int imageId = 0;
//        switch (fileType) {
//            //TODO: need determine which type this file is
//        }

        Picasso.with(view.getContext())
                .load(R.drawable.ic_pdf)
                .into(view);

    }

    public String getDocumentTypeImage() { return mDocument.documentType ;}

    public String getDocumentText(){

        return mDocument.text;

    }

    public void setDocument(Document document){
        this.mDocument = document;
        notifyChange();
    }

}
