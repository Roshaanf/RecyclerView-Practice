package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Roshaan on 1/25/2018.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> list;
    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.list=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
