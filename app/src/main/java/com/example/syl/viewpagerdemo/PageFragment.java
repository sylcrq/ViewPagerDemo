package com.example.syl.viewpagerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.syl.viewpagerdemo.dummy.DummyContent;
import com.example.syl.viewpagerdemo.dummy.DummyContent.DummyItem;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PageFragment extends Fragment {
    public static final String TAG = PageFragment.class.getSimpleName();

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    public static final String ARG_INDEX = "index";
    private int mIndex = -1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PageFragment() {
    }

    @SuppressWarnings("unused")
    public static PageFragment newInstance(int index, int columnCount) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            mIndex = getArguments().getInt(ARG_INDEX);
        }
        Log.d(TAG, "onCreate" + getPageInfo());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView" + getPageInfo());
        View view = inflater.inflate(R.layout.fragment_page_list, container, false);
        view.setBackgroundColor(ContextCompat.getColor(getContext(), getPageColor()));
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyPageRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated" + getPageInfo());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach" + getPageInfo());
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach" + getPageInfo());
        mListener = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint#" + isVisibleToUser + getPageInfo());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView" + getPageInfo());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart" + getPageInfo());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume" + getPageInfo());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause" + getPageInfo());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop" + getPageInfo());
    }

    private String getPageInfo() {
        return " [index=" + mIndex + "," + this + "]";
    }

    private int getPageColor() {
        switch (mIndex) {
            case 0:
                return R.color.lime;
            case 1:
                return R.color.red;
            case 2:
                return R.color.aqua;
            case 3:
                return R.color.silver;
            default:
                return R.color.white;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(DummyItem item);
    }
}
