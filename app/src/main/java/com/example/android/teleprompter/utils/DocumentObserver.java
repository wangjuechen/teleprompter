package com.example.android.teleprompter.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

import com.example.android.teleprompter.Adaptor.DocumentAdaptor;


public class DocumentObserver extends ContentObserver {

    private DocumentAdaptor mDocumentAdapter;

    private Context mContext;
    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public DocumentObserver(Handler handler, Context context) {
        super(handler);
        this.mContext = context;
    }


    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        mDocumentAdapter = new DocumentAdaptor(mContext);

        mDocumentAdapter.notifyDataSetChanged();

    }
}
