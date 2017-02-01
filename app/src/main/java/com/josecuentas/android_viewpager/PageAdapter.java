package com.josecuentas.android_viewpager;

import android.support.v7.widget.CardView;

/**
 * Created by jcuentas on 30/01/17.
 */

public interface PageAdapter {

    int MAX_ELEVATION = 8;

    float getElevation();

    CardView getCardViewAt(int position);

    int getCount();

}
