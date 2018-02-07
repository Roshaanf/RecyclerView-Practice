package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.FragmentStaggeredItemDetailBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StaggeredItemDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class StaggeredItemDetailFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    FragmentStaggeredItemDetailBinding binding;
    public static final String IMAGE_ID="com.imageid";
    public static final String TRANSITION_NAME="com.transitionid";

    public static StaggeredItemDetailFragment newInstance(int imageId,String transitionName) {

        Bundle args = new Bundle();
        args.putInt(StaggeredItemDetailFragment.IMAGE_ID,imageId);
        args.putString(StaggeredItemDetailFragment.TRANSITION_NAME,transitionName);
        StaggeredItemDetailFragment fragment = new StaggeredItemDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //settng transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_staggered_item_detail,container,false);

        binding.imageView.setImageResource(getArguments()
                .getInt(StaggeredItemDetailFragment.IMAGE_ID));

        //setting transition name
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.imageView.setTransitionName( getArguments()
            .getString(StaggeredItemDetailFragment.TRANSITION_NAME).trim());
            System.out.println("MainActivityMe "+binding.imageView.getTransitionName());
        }

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
