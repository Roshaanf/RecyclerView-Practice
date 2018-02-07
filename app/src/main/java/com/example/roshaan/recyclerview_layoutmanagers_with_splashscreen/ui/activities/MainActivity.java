package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.activities;


import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.widget.ImageView;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.GridHorizontalFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.GridVerticalFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.LinearHorizontalFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.LinearVerticalFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter.ViewPagerAdapter;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.ActivityMainBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.MultipleViewTypesFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.StaggeredItemDetailFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.StaggeredVerticalFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LinearHorizontalFragment.OnFragmentInteractionListener,
        LinearVerticalFragment.OnFragmentInteractionListener,
        GridHorizontalFragment.OnFragmentInteractionListener,
        StaggeredVerticalFragment.OnFragmentInteractionListener,
        StaggeredItemDetailFragment.OnFragmentInteractionListener {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LinearVerticalFragment());
        fragments.add(new LinearHorizontalFragment());
        fragments.add(new GridHorizontalFragment());
        fragments.add(new GridVerticalFragment());
        fragments.add(new StaggeredVerticalFragment());
        fragments.add(new MultipleViewTypesFragment());

        //adding tabs titles
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Linear Vertical Fargment"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Linear  Horizontal Fargment"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Grid Horizontal Fargment"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Grid Vertical Fargment"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Staggered Vertical Fargment"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Multiple View types"));


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);

        binding.viewPager.setAdapter(adapter);
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onStaggeredVerticalFragmentInteraction(int i, List<Object> object, Fragment callingFragment) {
        // object index 0 contain image id and index 1 contains image view
        switch (i) {
            case StaggeredVerticalFragment.OnFragmentInteractionListener.ITEM_CLICK:

                String transitionName = null;
                StaggeredItemDetailFragment detailFragment = null;


                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    transitionName = (String) "transition" + ((ImageView) object.get(1)).getTransitionName().trim();

                }

                detailFragment = StaggeredItemDetailFragment.newInstance((Integer) object.get(0), transitionName);


                getSupportFragmentManager()
                        .beginTransaction()
                        .addSharedElement((ImageView) object.get(1), transitionName)
                        .replace(R.id.constraint, detailFragment)
                        .addToBackStack(null)
                        .commit();


        }
    }


}
