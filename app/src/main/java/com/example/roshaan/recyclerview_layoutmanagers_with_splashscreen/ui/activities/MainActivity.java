package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.activities;


import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.GridHorizontalFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.GridVerticalFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.LinearHorizontalFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.LinearVerticalFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter.ViewPagerAdapter;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.ActivityMainBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.MultipleViewTypesFragment;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.ui.fragment.StaggeredVerticalFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LinearHorizontalFragment.OnFragmentInteractionListener,
        LinearVerticalFragment.OnFragmentInteractionListener,
        GridHorizontalFragment.OnFragmentInteractionListener,
StaggeredVerticalFragment.OnFragmentInteractionListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<Fragment> fragments=new ArrayList<>();
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


        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);

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
}
