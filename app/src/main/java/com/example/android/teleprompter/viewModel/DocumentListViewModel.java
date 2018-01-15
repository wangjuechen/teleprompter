//package com.example.android.teleprompter.viewModel;
//
//
//import android.content.Context;
//import android.database.Cursor;
//import android.os.Build;
//import android.support.annotation.RequiresApi;
//import android.view.View;
//
//import com.example.android.teleprompter.ContentProvider.DocumentContract;
//import com.example.android.teleprompter.MainActivity;
//import com.example.android.teleprompter.R;
//import com.example.android.teleprompter.app.AppController;
//import com.example.android.teleprompter.model.Document;
//import com.example.android.teleprompter.model.DocumentResponse;
//import com.example.android.teleprompter.network.UsersService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Observable;
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.CompositeDisposable;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.functions.Consumer;
//
//import android.support.annotation.NonNull;
//
//public class DocumentListViewModel extends Observable {
//
//    private List<Document> mDocumentList;
//
//    public ObservableInt progressBar;
//    public ObservableInt documentRecycler;
//    public ObservableInt documentLabel;
//    public ObservableField<String> messageLabel;
//
//    private Context mContext;
//
//    private CompositeDisposable compositeDisposable = new CompositeDisposable();
//
//    public DocumentListViewModel(@NonNull Context context) {
//        this.mContext = context;
//        this.mDocumentList = new ArrayList<>();
//        progressBar = new ObservableInt(View.GONE);
//        progressBar = new ObservableInt(View.GONE);
//        documentRecycler = new ObservableInt(View.GONE);
//        documentLabel = new ObservableInt(View.VISIBLE);
//        messageLabel = new ObservableField<>(context.getString(R.string.default_message_loading_users));
//    }
//
//    public void reset() {
//        unSubscribeFromObservable();
//        compositeDisposable = null;
//        mContext = null;
//    }
//
//
//    public void initializeViews() {
//        documentLabel.set(View.GONE);
//        documentRecycler.set(View.GONE);
//        progressBar.set(View.VISIBLE);
//        mDocumentList = fetchDocumentList();
//    }
//
//    private List<Document> fetchDocumentList() {
//
////        AppController appController = AppController.create(mContext);
////        UsersService usersService = appController.getUserService();
////
////        Disposable disposable = usersService.fetchUsers()
////                .subscribeOn(appController.subscribeScheduler())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(new Consumer<DocumentResponse>() {
////                    @Override
////                    public void accept(DocumentResponse documentResponse) throws Exception {
////                        updateUserDataList(documentResponse.getDocumentList());
////                        progressBar.set(View.GONE);
////                        documentLabel.set(View.GONE);
////                        documentRecycler.set(View.VISIBLE);
////                    }
////                }, new Consumer<Throwable>() {
////                    @Override
////                    public void accept(Throwable throwable) throws Exception {
////                        messageLabel.set(mContext.getString(R.string.error_message_loading_users));
////                        progressBar.set(View.GONE);
////                        documentLabel.set(View.VISIBLE);
////                        documentRecycler.set(View.GONE);
////                    }
////                });
////
////        compositeDisposable.add(disposable);
//
//        /**
//         * Get document list date from content provider
//         * and store them to Model Document
//         */
//        ArrayList<Document> documentList = new ArrayList<>();
//            Cursor cursor = MainActivity.getmContext().getContentResolver().query(DocumentContract.DocumentEntry.CONTENT_URI, null, null, null, null, null);
//            if (cursor.moveToFirst()) {
//                do {
//                    Document document  = new Document();
//                    document.title = cursor.getString(cursor.getColumnIndex(DocumentContract.DocumentEntry.COLUMN_DOCUMENT_NAME));
//                    document.documentType = cursor.getString(cursor.getColumnIndex(DocumentContract.DocumentEntry.COLUMN_DOCUMENT_TYPE));
//                    document.time = cursor.getString(cursor.getColumnIndex(DocumentContract.DocumentEntry.COLUMN_DOCUMENT_TYPE));
//                    document.text = cursor.getString(cursor.getColumnIndex(DocumentContract.DocumentEntry.COLUMN_DOCUMENT_CONTENT));
//                    documentList.add(document);
//                } while (cursor.moveToNext());
//            } else {
//                return null;
//            }
//            cursor.close();
//
//            return documentList;
//
//
//        //TODO: Here need codes to access Content Provider document list;
//    }
//
//    private void updateUserDataList(List<Document> document) {
//        mDocumentList.addAll(document);
//        setChanged();
//        notifyObservers();
//    }
//
//    public List<Document> getDocumentList() {
//        return mDocumentList;
//    }
//
//    private void unSubscribeFromObservable() {
//        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
//            compositeDisposable.dispose();
//        }
//    }
//
//}
