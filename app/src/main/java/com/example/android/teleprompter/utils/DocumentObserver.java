package com.example.android.teleprompter.utils;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;


public class DocumentObserver extends ContentObserver {
    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public DocumentObserver(Handler handler) {
        super(handler);
    }


    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {


    }
}
