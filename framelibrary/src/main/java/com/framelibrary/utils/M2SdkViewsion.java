package com.framelibrary.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/**
 * @2Do:
 * @Author M2
 * @Version v 1.0
 * @Date [2016/3/22 0022]
 */
public class M2SdkViewsion {
    
    /**
     * October 2008: The original, first, version of Android. Yay!
     */
    public static final int BASE = 1;
    
    /**
     * February 2009: First Android update, officially called 1.1.
     */
    public static final int BASE_1_1 = 2;
    
    /**
     * May 2009: Android 1.5.
     */
    public static final int CUPCAKE = 3;
    
    /**
     * September 2009: Android 1.6.
     *
     */
    public static final int DONUT = 4;
    
    /**
     * November 2009: Android 2.0
     */
    public static final int ECLAIR = 5;
    
    /**
     * December 2009: Android 2.0.1
     */
    public static final int ECLAIR_0_1 = 6;
    
    /**
     * January 2010: Android 2.1
     */
    public static final int ECLAIR_MR1 = 7;
    
    /**
     * June 2010: Android 2.2
     */
    public static final int FROYO = 8;
    
    /**
     * November 2010: Android 2.3
     */
    public static final int GINGERBREAD = 9;
    
    /**
     * February 2011: Android 2.3.3.
     */
    public static final int GINGERBREAD_MR1 = 10;
    
    /**
     * February 2011: Android 3.0.
     */
    public static final int HONEYCOMB = 11;
    
    /**
     * May 2011: Android 3.1.
     */
    public static final int HONEYCOMB_MR1 = 12;
    
    /**
     * June 2011: Android 3.2.
     */
    public static final int HONEYCOMB_MR2 = 13;
    
    /**
     * October 2011: Android 4.0.
     */
    public static final int ICE_CREAM_SANDWICH = 14;
    
    /**
     * December 2011: Android 4.0.3.
     */
    public static final int ICE_CREAM_SANDWICH_MR1 = 15;
    
    /**
     * June 2012: Android 4.1.
     */
    public static final int JELLY_BEAN = 16;
    
    /**
     * November 2012: Android 4.2, Moar jelly beans!
     */
    public static final int JELLY_BEAN_MR1 = 17;
    
    /**
     * July 2013: Android 4.3, the revenge of the beans.
     */
    public static final int JELLY_BEAN_MR2 = 18;
    
    /**
     * October 2013: Android 4.4, KitKat, another tasty treat.
     */
    public static final int KITKAT = 19;
    
    /**
     * Android 4.4W: KitKat for watches, snacks on the run.
     */
    public static final int KITKAT_WATCH = 20;
    
    /**
     * Temporary until we completely switch to {@link #LOLLIPOP}.
     */
    public static final int L = 21;
    
    /**
     * Lollipop. A flat one with beautiful shadows. But still tasty.
     */
    public static final int LOLLIPOP = 21;
    
    /**
     * March 2015:Android 5.1 LMY29F.
     */
    public static final int LMY29F = 22;
    
    /**
     * Marshmallow 2015:Android 6.0 MRA58K.
     */
    public static final int Marshmallow = 23;
    
    /**
     * October 2008: The original, first, version of Android. Yay!
     */
    public static final int API_1 = 1;
    
    /**
     * February 2009: First Android update, officially called 1.1.
     */
    public static final int API_2 = 2;
    
    /**
     * May 2009: Android 1.5.
     */
    public static final int API_3 = 3;
    
    /**
     * September 2009: Android 1.6.
     */
    public static final int API_4 = 4;
    
    /**
     * November 2009: Android 2.0
     */
    public static final int API_5 = 5;
    
    /**
     * December 2009: Android 2.0.1
     */
    public static final int API_6 = 6;
    
    /**
     * January 2010: Android 2.1
     */
    public static final int API_7 = 7;
    
    /**
     * June 2010: Android 2.2
     */
    public static final int API_8 = 8;
    
    /**
     * November 2010: Android 2.3
     */
    public static final int API_9 = 9;
    
    /**
     * February 2011: Android 2.3.3.
     */
    public static final int API_10 = 10;
    
    /**
     * February 2011: Android 3.0.
     */
    public static final int API_11 = 11;
    
    /**
     * May 2011: Android 3.1.
     */
    public static final int API_12 = 12;
    
    /**
     * June 2011: Android 3.2.
     */
    public static final int API_13 = 13;
    
    /**
     * October 2011: Android 4.0.
     */
    public static final int API_14 = 14;
    
    /**
     * December 2011: Android 4.0.3.
     */
    public static final int API_15 = 15;
    
    /**
     * June 2012: Android 4.1.
     */
    public static final int API_16 = 16;
    
    /**
     * November 2012: Android 4.2, Moar jelly beans!
     */
    public static final int API_17 = 17;
    
    /**
     * July 2013: Android 4.3, the revenge of the beans.
     */
    public static final int API_18 = 18;
    
    /**
     * October 2013: Android 4.4, KitKat, another tasty treat.
     */
    public static final int API_19 = 19;
    
    /**
     * Android 4.4W: KitKat for watches, snacks on the run.
     */
    public static final int API_20 = 20;
    
    /**
     * Temporary until we completely switch to {@link #LOLLIPOP}.
     */
    public static final int API_21 = 21;
    
    /**
     * Android 5.1: {@link #LMY29F}.
     */
    public static final int API_22 = 22;
    
    /**
     * Android 6.0: i{@lnk #MRA58K}.
     */
    public static final int API_23 = 23;
    
    /** API = 9 */
    public static final int API_2_3 = 9;
    
    /** API = 11 */
    public static final int API_3_0 = 11;
    
    /** API = 14 */
    public static final int API_4_0 = 14;
    
    /** API = 16 */
    public static final int API_4_1 = 16;
    
    /** API = 17 */
    public static final int API_4_2 = 17;
    
    /** API = 18 */
    public static final int API_4_3 = 18;
    
    /** API = 19 */
    public static final int API_4_4 = 19;
    
    /** API = 21 */
    public static final int API_5_0 = 21;
    
    /** API = 22 */
    public static final int API_5_1 = 22;
    
    /** API = 23 */
    public static final int API_6_0 = 23;
    
    public static boolean AFTER_ICE_CREAM = afterIceCream();
    
    private static boolean afterIceCream() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }
    
    /**
     * 5.0之后的SDK 
     */
    public static final boolean AFTER_LOLLIPOP = afterLollipop();
    
    private static boolean afterLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
    
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setElevation(View view, float elevation) {
        if (AFTER_LOLLIPOP) {
            view.setElevation(elevation);
        }
    }
}
