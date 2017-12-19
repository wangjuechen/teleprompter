package com.example.android.teleprompter.model;

import java.util.Date;

public class Document {
    public Date time;
    public String title;
    public String text;

    public DocumentType documentType;

    public enum DocumentType {

        STORY("story"),

        ASK("ask"),

        JOB("job");

        private String string;

        DocumentType(String string) {
            this.string = string;
        }

        public static DocumentType fromString(String string) {
            if (string != null) {
                for (DocumentType documentType : DocumentType.values()) {
                    if (string.equalsIgnoreCase(documentType.string)) return documentType;
                }
            }
            return null;
        }
    }

    public Document() { }

}
