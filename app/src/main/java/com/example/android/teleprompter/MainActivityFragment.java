package com.example.android.teleprompter;

import android.database.Cursor;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.database.MatrixCursor;
import android.os.Bundle;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.teleprompter.Adaptor.DocumentAdaptor;
import com.example.android.teleprompter.ContentProvider.DocumentContract;


import com.example.android.teleprompter.model.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{

    //private FragmentMainBinding documentlistFragmentListBinding;

    private List<Document> mDocumentList;

    private TextView mTextView_listSubtitle;

    private static final String TAG = "MainActivityFragment";

    private RecyclerView mDocument_list_rv;

    private final String BUNDLE_RECYCLE_LAYOUT = "recycler_view_bundle";

    private LinearLayoutManager mLinearLayoutManager;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDocumentList = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        //initDataBind();

        //setUpObserver(mDocumentListViewModel);

        //TODO: need to query document from content provider to save to array list;

        mDocument_list_rv = root.findViewById(R.id.rv_list);

        setUpListOfDocumentListView(mDocument_list_rv);

        //fillDocumentListElements();




        mTextView_listSubtitle = root.findViewById(R.id.tv_list_subtitle);

        mTextView_listSubtitle.setText("Today");

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    //    private void initDataBind() {
//
//        //documentlistFragmentListBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_main);
//        mDocumentListViewModel = new DocumentListViewModel(getActivity());
//        //documentlistFragmentListBinding.setViewModel(mDocumentListViewModel);
//    }

    private void setUpListOfDocumentListView(RecyclerView documentList) {
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DocumentAdaptor Adaptor = new DocumentAdaptor(getContext(), null);
        documentList.setAdapter(Adaptor);
        documentList.setLayoutManager(mLinearLayoutManager);

    }

//    private void fillDocumentListElements() {
//        int size = 1000;
//        ContentValues[] cvArray = new ContentValues[size];
//        for (int i = 0; i < cvArray.length; i++) {
//            ContentValues cv = new ContentValues();
//            cv.put(TableItems.TEXT, ("text " + i));
//            cvArray[i] = cv;
//        }
//
//        getActivity().getContentResolver().bulkInsert(DocumentContract.DocumentEntry.CONTENT_URI, cvArray);
//    }

//    public void setUpObserver(Observable observerable) {
//        observerable.addObserver(this);
//    }

    @Override
    public void onResume() {
        super.onResume();
//        mDocumentObserver = new DocumentObserver(new Handler(), getActivity());
//
//        //Register the ContentObserver
//        getActivity().getContentResolver().registerContentObserver(DocumentContract.DocumentEntry.CONTENT_URI,
//                true, mDocumentObserver);
//

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //mDocumentListViewModel.reset();

        //Unregister the ContentObserver
        //getActivity().getContentResolver().unregisterContentObserver(mDocumentObserver);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLE_LAYOUT);
            mDocument_list_rv.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_RECYCLE_LAYOUT, mDocument_list_rv.getLayoutManager().onSaveInstanceState());
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case 0:
                return new CursorLoader(getActivity(), DocumentContract.DocumentEntry.CONTENT_URI, null, null, null, null);
            default:
                throw new IllegalArgumentException("no id handled!");
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        switch (loader.getId()) {
            case 0:
                Log.d(TAG, "onLoadFinished: loading MORE");

                Cursor cursor = ((DocumentAdaptor) mDocument_list_rv.getAdapter()).getCursor();

                //fill all exisitng in adapter
                MatrixCursor mx = new MatrixCursor(DocumentContract.DocumentEntry.Columns);
                fillMx(cursor, mx);

                //fill with additional result
                fillMx(data, mx);

                ((DocumentAdaptor) mDocument_list_rv.getAdapter()).swapCursor(mx);

//                handlerToWait.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        loadingMore = false;
//                    }
//                }, 2000);

                break;
            default:
                throw new IllegalArgumentException("no loader id handled!");
        }
    }
    //private Handler handlerToWait = new Handler();

    private void fillMx(Cursor data, MatrixCursor mx) {
        if (data == null)
            return;

        data.moveToPosition(-1);
        while (data.moveToNext()) {
            mx.addRow(new Object[]{
                    data.getString(data.getColumnIndex(DocumentContract.DocumentEntry._ID)),
                    data.getString(data.getColumnIndex(DocumentContract.DocumentEntry.COLUMN_DOCUMENT_NAME)),
                    data.getString(data.getColumnIndex(DocumentContract.DocumentEntry.COLUMN_DOCUMENT_TYPE)),
                    data.getString(data.getColumnIndex(DocumentContract.DocumentEntry.COLUMN_DOCUMENT_LASTOPENTIME)),
                    data.getString(data.getColumnIndex(DocumentContract.DocumentEntry.COLUMN_DOCUMENT_CONTENT))
            });
        }
    }


//    /**
//     * This paragraph code belongs to Observer class,
//     * which real-time update adapter
//     */
//    @Override
//    public void update(java.util.Observable o, Object arg) {
//        if (o instanceof DocumentListViewModel) {
//
//            DocumentAdaptor documentAdapter = (DocumentAdaptor) documentlistFragmentListBinding.rvList.getAdapter();
//            DocumentListViewModel documentListViewModel = (DocumentListViewModel) o;
//            documentAdapter.setDocumentList(documentListViewModel.getDocumentList());
//        }
//    }
}
