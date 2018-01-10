package com.example.android.teleprompter.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DocumentResponse {
    @SerializedName("results") private List<Document> documentList;

    public List<Document> getDocumentList () { return documentList;}

    public void setDocumentList(List<Document> mDocumentList) { this.documentList = mDocumentList ;}
}
