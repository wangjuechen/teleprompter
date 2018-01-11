package com.example.android.teleprompter.viewModel;


import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.android.teleprompter.R;
import com.example.android.teleprompter.model.Document;
import com.squareup.picasso.Picasso;

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

    public String getDocumentLastOpenTime(){
        //SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");

        //return df.format(mDocument.time);
        return mDocument.time;
    }

    @BindingAdapter({"bind:fileTypeImage"})
    public static void getDocumentTypeImage(ImageView view, String fileType){

        int imageId;
        switch (fileType.substring(fileType.length()-3, 3)) {
            //TODO: need determine which type this file is
        }

        Picasso.with(view.getContext())
                .load(R.drawable.ic_pdf)
                .into(view);

    }

    public String determineFileType(){




        return mDocument.documentType;
    }

    public String getDocumentText(){

        return mDocument.text;

    }

    public void setDocument(Document document){
        this.mDocument = document;
        notifyChange();
    }

}
