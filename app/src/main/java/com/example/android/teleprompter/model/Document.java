package com.example.android.teleprompter.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Document implements Serializable {

    @SerializedName("time") public String time;

    @SerializedName("title") public String title;

    @SerializedName("text") public String text;

    @SerializedName("documentType") public String documentType;

}
