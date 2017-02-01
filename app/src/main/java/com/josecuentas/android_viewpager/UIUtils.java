package com.josecuentas.android_viewpager;

import android.content.Context;

public class UIUtils {

  public static float transformDpToPixels(int dp, Context context) {
    return dp * (context.getResources().getDisplayMetrics().density);
  }
}
