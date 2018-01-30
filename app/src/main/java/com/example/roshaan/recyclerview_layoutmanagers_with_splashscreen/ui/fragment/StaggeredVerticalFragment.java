package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.DataRepository;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter.GridHorizontalAdapter;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter.StaggeredAdapter;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.FragmentStaggeredVerticalBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StaggeredVerticalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class StaggeredVerticalFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    FragmentStaggeredVerticalBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_staggered_vertical,container,false);
        List<ItemModel> data=new ArrayList<>();
        data.add(new ItemModel("null",R.drawable.st));
        data.add(new ItemModel("null",R.drawable.s2));
        data.add(new ItemModel("null",R.drawable.st3));
        data.add(new ItemModel("null",R.drawable.st4));
        data.add(new ItemModel("null",R.drawable.st5));
        data.add(new ItemModel("null",R.drawable.st6));
        data.add(new ItemModel("null",R.drawable.st7));
        data.add(new ItemModel("null",R.drawable.st8));


        StaggeredAdapter adapter=new StaggeredAdapter(data);
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
