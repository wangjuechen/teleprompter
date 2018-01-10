package com.example.android.teleprompter.model;

import com.google.gson.annotations.SerializedName;

import org.w3c.dom.DocumentType;

import java.io.Serializable;
import java.util.Date;

public class Document implements Serializable{

    @SerializedName("time") public Date time;

    @SerializedName("title") public String title;

    @SerializedName("text") public String text;

    @SerializedName("documentType") public String documentType;

//    public DocumentType documentType;

//    public enum DocumentType {
//
//        STORY("story"),
//
//        ASK("ask"),
//
//        JOB("job");
//
//        private String string;
//
//        DocumentType(String string) {
//            this.string = string;
//        }
//
//        public static DocumentType fromString(String string) {
//            if (string != null) {
//                for (DocumentType documentType : DocumentType.values()) {
//                    if (string.equalsIgnoreCase(documentType.string)) return documentType;
//                }
//            }
//            return null;
//        }
//    }

//    public Document() { }


}
