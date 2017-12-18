package com.example.android.teleprompter;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.teleprompter.Adaptor.RecyclerViewAdaptors;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private RecyclerView mRecyclerView_List;

    private TextView mTextView_listSubtitle;

    private final String BUNDLE_RECYCLE_LAYOUT = "recycler_view_bundle";

    private RecyclerViewAdaptors mAdaptor;

    private final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdaptor = new RecyclerViewAdaptors();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView_List = root.findViewById(R.id.rv_list);

        mTextView_listSubtitle = root.findViewById(R.id.tv_list_subtitle);

        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView_List.setLayoutManager(mLinearLayoutManager);

        mRecyclerView_List.setAdapter(mAdaptor);

        mTextView_listSubtitle.setText("Today");

        return root;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState != null){
            Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLE_LAYOUT);
            mRecyclerView_List.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_RECYCLE_LAYOUT, mRecyclerView_List.getLayoutManager().onSaveInstanceState());
    }
}
