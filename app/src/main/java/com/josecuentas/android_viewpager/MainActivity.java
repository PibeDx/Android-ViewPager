package com.josecuentas.android_viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ELEVATION_DP = 2;
    private List<Page> mPageList;
    private ViewPager mVpaContainer;
    private PagePagerAdapter mAdapterViewPager;
    private PagerTransformer mPagerTranformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectView();
        setupAdapter();
        dummy();
        populate();
    }

    private void injectView() {
        mVpaContainer = (ViewPager) findViewById(R.id.vpaContainer);
    }

    private void setupAdapter() {
        mAdapterViewPager = new PagePagerAdapter(getSupportFragmentManager());
        mAdapterViewPager.setElevation(UIUtils.transformDpToPixels(ELEVATION_DP, this));
        mPagerTranformer = new PagerTransformer(mVpaContainer, mAdapterViewPager);
        mVpaContainer.setAdapter(mAdapterViewPager);
    }

    private void populate() {
        showPages(mPageList);
    }

    private void dummy() {
        mPageList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int nuPage= i + 1;
            Page page = new Page(   "title " + nuPage,
                                    "message " + nuPage);
            mPageList.add(page);
        }
    }

    private void showPages(List<Page> pageList){
        for (Page page : pageList) {
            Bundle args = new Bundle();
            args.putSerializable(Page.BUNDLE, page);
            PageFragment pageFragment = PageFragment.newInstance(args);
            mAdapterViewPager.addPage(pageFragment);
            mAdapterViewPager.notifyDataSetChanged();
        }
        mVpaContainer.setPageTransformer(false, mPagerTranformer);
        mPagerTranformer.enableScaling(true);
    }
}
