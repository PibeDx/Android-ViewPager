package com.josecuentas.android_viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by jcuentas on 30/01/17.
 */

public class PagerTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {

    private ViewPager mViewPager;
    private PageAdapter mPageAdapter;
    private float lastOffset;
    private boolean scalingEnabled;

    public PagerTransformer(ViewPager viewPager, PageAdapter pageAdapter) {
        mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(this);
        mPageAdapter = pageAdapter;
    }

    @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int realCurrentPosition;
        int nextPosition;
        float baseElevation = mPageAdapter.getElevation();
        float realOffset;
        boolean goingLeft = lastOffset > positionOffset;

        if (goingLeft) {
            realCurrentPosition = position + 1;
            nextPosition = position;
            realOffset = 1 - positionOffset;
        } else {
            nextPosition = position + 1;
            realCurrentPosition = position;
            realOffset = positionOffset;
        }

        if (nextPosition > mPageAdapter.getCount() - 1
                || realCurrentPosition > mPageAdapter.getCount() - 1) {
            return;
        }

        CardView currentCard = mPageAdapter.getCardViewAt(realCurrentPosition);

        if (currentCard != null) {
            if (scalingEnabled) {
                currentCard.setScaleX((float) (1 + 0.1 * (1 - realOffset)));
                currentCard.setScaleY((float) (1 + 0.1 * (1 - realOffset)));
            }
            currentCard.setCardElevation(
                    (baseElevation + baseElevation * (PageAdapter.MAX_ELEVATION - 1) * (1
                            - realOffset)));
        }

        CardView nextCard = mPageAdapter.getCardViewAt(nextPosition);

        if (nextCard != null) {
            if (scalingEnabled) {
                nextCard.setScaleX((float) (1 + 0.1 * (realOffset)));
                nextCard.setScaleY((float) (1 + 0.1 * (realOffset)));
            }
            nextCard.setCardElevation(
                    (baseElevation + baseElevation * (PageAdapter.MAX_ELEVATION - 1) * (realOffset)));
        }

        lastOffset = positionOffset;
    }

    @Override public void onPageSelected(int position) {

    }

    @Override public void onPageScrollStateChanged(int state) {

    }

    @Override public void transformPage(View page, float position) {

    }

    public void enableScaling(boolean enable) {
        if (scalingEnabled && !enable) {
            CardView currentCard = mPageAdapter.getCardViewAt(mViewPager.getCurrentItem());
            if (currentCard != null) {
                currentCard.animate().scaleY(1);
                currentCard.animate().scaleX(1);
            }
        } else if (!scalingEnabled && enable) {
            CardView currentCard = mPageAdapter.getCardViewAt(mViewPager.getCurrentItem());
            if (currentCard != null) {
                currentCard.animate().scaleY(1.1f);
                currentCard.animate().scaleX(1.1f);
            }
        }

        scalingEnabled = enable;
    }
}
