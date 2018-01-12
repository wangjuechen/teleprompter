package com.example.android.teleprompter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.teleprompter.Adaptor.DocumentAdaptor;
import com.example.android.teleprompter.ContentProvider.DocumentContract;
import com.example.android.teleprompter.databinding.FragmentMainBinding;
import com.example.android.teleprompter.model.Document;
import com.example.android.teleprompter.utils.DocumentObserver;
import com.example.android.teleprompter.viewModel.DocumentListViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    //private FragmentMainBinding documentlistFragmentListBinding;

    private List<Document> mDocumentList;

    private DocumentListViewModel mDocumentListViewModel;

    private TextView mTextView_listSubtitle;

    private RecyclerView mDocument_list_rv;

    private final String BUNDLE_RECYCLE_LAYOUT = "recycler_view_bundle";

    private DocumentObserver mDocumentObserver;

    private final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());

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
        View root = inflater.inflate(R.layout.activity_main, container, false);

        //initDataBind();

        //setUpObserver(mDocumentListViewModel);

        //TODO: need to query document from content provider to save to array list;

        mDocument_list_rv = root.findViewById(R.id.rv_list);

        setUpListOfDocumentListView(mDocument_list_rv);

        mDocumentListViewModel.initializeViews();

        mTextView_listSubtitle = root.findViewById(R.id.tv_list_subtitle);

        mTextView_listSubtitle.setText("Today");

        return root;
    }

//    private void initDataBind() {
//
//        //documentlistFragmentListBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_main);
//        mDocumentListViewModel = new DocumentListViewModel(getActivity());
//        //documentlistFragmentListBinding.setViewModel(mDocumentListViewModel);
//    }

    private void setUpListOfDocumentListView(RecyclerView documentList) {

        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DocumentAdaptor Adaptor = new DocumentAdaptor(getContext(), mDocumentList);
        documentList.setAdapter(Adaptor);
        documentList.setLayoutManager(mLinearLayoutManager);

    }

//    public void setUpObserver(Observable observerable) {
//        observerable.addObserver(this);
//    }

    @Override
    public void onResume() {
        super.onResume();
        mDocumentObserver = new DocumentObserver(new Handler(), getActivity());

        //Register the ContentObserver
        getActivity().getContentResolver().registerContentObserver(DocumentContract.DocumentEntry.CONTENT_URI,
                true, mDocumentObserver);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //mDocumentListViewModel.reset();

        //Unregister the ContentObserver
        getActivity().getContentResolver().unregisterContentObserver(mDocumentObserver);
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
