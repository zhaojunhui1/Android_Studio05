package com.zjh.administrat.zhaojunhui1213;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CustomLinView> list;
    private ValueAnimator animator;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomLinView image1 = findViewById(R.id.image1);
        CustomLinView image2 = findViewById(R.id.image2);
        CustomLinView image3 = findViewById(R.id.image3);
        CustomLinView image4 = findViewById(R.id.image4);
        CustomLinView image5 = findViewById(R.id.image5);
        CustomLinView image6 = findViewById(R.id.image6);
        //把图片放入集合中
        list = new ArrayList<>();
        list.add(image1);
        list.add(image2);
        list.add(image3);
        list.add(image4);
        list.add(image5);
        list.add(image6);
        getdata(i);
    }

    private void getdata(final int i) {
        //属性动画 渐变色 从绿到黄
        animator = ValueAnimator.ofInt(Color.parseColor("#ffcc66"), Color.parseColor("#ffcc33"));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int color = (int) animation.getAnimatedValue();
                //这里是个view，设置背景色
                list.get(i).setBackgroundColor(color);
            }
        });
        //持续时间
        animator.setDuration(1500);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
        //当下标为最后一个时停止运行
        if (i == 5) {
            return;
        }
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //当第一个图片完成动画时开启下一个动画
                getdata(i + 1);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }
}
