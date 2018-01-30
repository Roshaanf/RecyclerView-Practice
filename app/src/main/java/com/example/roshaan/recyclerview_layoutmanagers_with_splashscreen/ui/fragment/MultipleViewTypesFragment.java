package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter.MultipleViewTypesAdapter;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.FragmentMultipleViewTypesBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.StaggeredItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MultipleViewTypesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MultipleViewTypesFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    FragmentMultipleViewTypesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_multiple_view_types,container,false);

        // setting data
        List<Object> list=new ArrayList<>();
        list.add(new ItemModel("ALi",R.drawable.cargo_truck_icon));
        list.add(new ItemModel("Salman",R.drawable.curbside_icon));
        list.add(new StaggeredItem(R.drawable.st));
        list.add(new ItemModel("John",R.drawable.helper_icon));
        list.add(new StaggeredItem(R.drawable.s2));
        list.add(new ItemModel("Cena",R.drawable.image_2));
        list.add(new StaggeredItem(R.drawable.st3));
        list.add(new ItemModel("Osama",R.drawable.delivery_icon));

        MultipleViewTypesAdapter adapter=new MultipleViewTypesAdapter(list);
        //linear vertical adapter
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return binding.getRoot();
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
