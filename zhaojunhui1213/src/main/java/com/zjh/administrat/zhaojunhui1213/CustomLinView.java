package com.zjh.administrat.zhaojunhui1213;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class CustomLinView extends ImageView {


    public CustomLinView(Context context) {
        super(context);
    }

    public CustomLinView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
