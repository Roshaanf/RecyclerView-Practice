package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.DataRepository;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter.GridHorizontalAdapter;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.FragmentGridHorizontalBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.GridHorizontalItemBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GridHorizontalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class GridHorizontalFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    FragmentGridHorizontalBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_grid_horizontal,container,false);

        List<ItemModel> list= DataRepository.getItemData();
        GridHorizontalAdapter adapter=new GridHorizontalAdapter(list);
        //vertical span
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false));
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
