package com.example.syl.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Shen YunLong on 2016/12/17.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position, 1);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.93f;
    }
}
