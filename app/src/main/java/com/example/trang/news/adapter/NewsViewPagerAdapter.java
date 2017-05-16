package com.example.trang.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.trang.news.fragment.DanTriFragment;
import com.example.trang.news.fragment.VnexpressFragment;

/**
 * Created by Trang on 5/16/2017.
 */

public class NewsViewPagerAdapter extends FragmentStatePagerAdapter {
    public NewsViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        switch (position) {
            case 0:
                fragment = new VnexpressFragment();
                break;
            case 1:
                fragment = new DanTriFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String titel = "";
        switch (position) {
            case 0:
                titel = "Vnexpress";
                break;
            case 1:
                titel = "Dân Trí";
                break;
        }
        return titel;
    }
}
