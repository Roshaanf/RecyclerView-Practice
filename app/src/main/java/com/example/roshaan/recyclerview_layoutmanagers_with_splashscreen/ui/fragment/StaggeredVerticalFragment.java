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
import android.widget.ImageView;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.DataRepository;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter.GridHorizontalAdapter;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter.StaggeredAdapter;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.FragmentStaggeredVerticalBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.listeners.Callback;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.StaggeredItem;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.StaggeredItem;

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

    public static StaggeredVerticalFragment newInstance() {

        Bundle args = new Bundle();

        StaggeredVerticalFragment fragment = new StaggeredVerticalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_staggered_vertical,container,false);
        List<StaggeredItem> data=DataRepository.getStaggeredData();


        StaggeredAdapter adapter=new StaggeredAdapter(data, new Callback() {

            @Override
            public void invoke(List<Object> object) {
                mListener.onStaggeredVerticalFragmentInteraction(OnFragmentInteractionListener.ITEM_CLICK,object,StaggeredVerticalFragment.this);
            }
        });
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
        System.out.println("Activity1 onDetach");
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        int ITEM_CLICK=0;
        void onStaggeredVerticalFragmentInteraction(int i,List<Object> object,Fragment fragment);
    }




    @Override
    public void onStart() {
        super.onStart();
        System.out.println("Actvity1 onstart");
    }



    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Actvity1 onstop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Actvity1 ondestroy");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Actvity1 onpause");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Actvity1 onresume");
    }
}
