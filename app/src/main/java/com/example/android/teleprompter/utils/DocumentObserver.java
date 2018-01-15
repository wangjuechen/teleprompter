//package com.example.android.teleprompter.utils;
//
//import android.content.Context;
//import android.database.ContentObserver;
//import android.net.Uri;
//import android.os.Handler;
//
//import com.example.android.teleprompter.Adaptor.DocumentAdaptor;
//import com.example.android.teleprompter.model.Document;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class DocumentObserver extends ContentObserver {
//
//    private List<Document> mDocumentList;
//
//    private DocumentAdaptor mDocumentAdapter;
//
//    private Context mContext;
//    /**
//     * Creates a content observer.
//     *
//     * @param handler The handler to run {@link #onChange} on, or null if none.
//     */
//    public DocumentObserver(Handler handler, Context context) {
//        super(handler);
//        this.mContext = context;
//        mDocumentList = new ArrayList<>();
//    }
//
//
//    @Override
//    public void onChange(boolean selfChange) {
//        super.onChange(selfChange);
//    }
//
//    @Override
//    public void onChange(boolean selfChange, Uri uri) {
//
//        mDocumentAdapter.notifyDataSetChanged();
//    }
//}
