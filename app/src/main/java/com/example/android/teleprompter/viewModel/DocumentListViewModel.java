package com.example.android.teleprompter.viewModel;


import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.example.android.teleprompter.R;
import com.example.android.teleprompter.model.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.disposables.CompositeDisposable;
import android.support.annotation.NonNull;

public class DocumentListViewModel extends Observable {

    private List<Document> mDocumentList;

    public ObservableInt progressBar;
    public ObservableInt documentRecycler;
    public ObservableInt documentLabel;
    public ObservableField<String> messageLabel;

    private Context mContext;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public DocumentListViewModel(@NonNull Context context) {
        this.mContext = context;
        this.mDocumentList = new ArrayList<>();
        progressBar = new ObservableInt(View.GONE);
        progressBar = new ObservableInt(View.GONE);
        documentRecycler = new ObservableInt(View.GONE);
        documentLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.default_message_loading_users));
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        mContext = null;
    }


    public void initializeViews() {
        documentLabel.set(View.GONE);
        documentRecycler.set(View.GONE);
        progressBar.set(View.VISIBLE);
    }

    private void fetchDocumentList() {

        /*AppController appController = AppController.create(context);
        UsersService usersService = appController.getUserService();

        Disposable disposable = usersService.fetchUsers(RANDOM_USER_URL)
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserResponse>() {
                    @Override
                    public void accept(UserResponse userResponse) throws Exception {
                        updateUserDataList(userResponse.getPeopleList());
                        progressBar.set(View.GONE);
                        documentLabel.set(View.GONE);
                        documentRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        messageLabel.set(mContext.getString(R.string.error_message_loading_users));
                        progressBar.set(View.GONE);
                        documentLabel.set(View.VISIBLE);
                        documentRecycler.set(View.GONE);
                    }
                });

        compositeDisposable.add(disposable);*/

        //TODO: Here need codes to access Content Provider document list;
    }

    private void updateUserDataList(List<Document> document) {
        mDocumentList.addAll(document);
        setChanged();
        notifyObservers();
    }

    public List<Document> getDocumentList() {
        return mDocumentList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

}
