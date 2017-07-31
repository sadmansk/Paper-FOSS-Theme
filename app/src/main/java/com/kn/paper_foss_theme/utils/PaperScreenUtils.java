package com.kn.paper_foss_theme.utils;

import android.content.Context;

public class PaperScreenUtils {

    public static boolean isPortrait(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels < context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int width(Context context) {
        return PaperScreenUtils.isPortrait(context) ? context.getResources().getDisplayMetrics().widthPixels : context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int height(Context context) {
        return PaperScreenUtils.isPortrait(context) ? context.getResources().getDisplayMetrics().heightPixels : context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float densityScale(Context context) {
        return (context.getResources().getDisplayMetrics().density);
    }
}
