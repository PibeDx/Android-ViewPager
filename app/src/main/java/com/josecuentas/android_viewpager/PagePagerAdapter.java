package com.josecuentas.android_viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.CardView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcuentas on 30/01/17.
 */

public class PagePagerAdapter extends FragmentPagerAdapter implements PageAdapter{

    private List<PageFragment> mPageFragments;
    private float mElevation;

    public PagePagerAdapter(FragmentManager fm) {
        super(fm);
        mPageFragments = new ArrayList<>();
    }

    @Override public Fragment getItem(int position) {

        return mPageFragments.get(position);
    }

    @Override public int getCount() {
        return mPageFragments.size();
    }

    @Override public float getElevation() {
        return mElevation;
    }

    public void setElevation(float elevation) {
        mElevation = elevation;
    }

    @Override public CardView getCardViewAt(int position) {
        return mPageFragments.get(position).getCardView();
    }

    public void addPage(PageFragment pageFragment) {
        mPageFragments.add(pageFragment);
    }
}
