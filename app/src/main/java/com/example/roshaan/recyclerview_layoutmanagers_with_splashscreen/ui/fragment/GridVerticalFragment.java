package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.DataRepository;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter.GridHorizontalAdapter;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.FragmentGridVerticalBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GridVerticalFragment extends Fragment {

FragmentGridVerticalBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_grid_vertical,container,false);
        List<ItemModel> data= DataRepository.getItemData();
        GridHorizontalAdapter adapter=new GridHorizontalAdapter(data);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

}
