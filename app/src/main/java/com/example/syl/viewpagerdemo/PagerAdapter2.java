package com.example.syl.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Shen YunLong on 2016/12/17.
 */
public class PagerAdapter2 extends FragmentStatePagerAdapter {

    public PagerAdapter2(FragmentManager fm) {
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
}
