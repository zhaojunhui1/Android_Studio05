package com.zjh.administrat.week3firstnewsdemo.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zjh.administrat.week3firstnewsdemo.R;
import com.zjh.administrat.week3firstnewsdemo.adapter.NewsAdapter;
import com.zjh.administrat.week3firstnewsdemo.bean.NewsBean;
import com.zjh.administrat.week3firstnewsdemo.presenter.IPresentrImpl;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IView{

    private RecyclerView recyclerView;
    private IPresentrImpl iPresentr;
    private NewsAdapter mAdapter;
    private NewsBean newsBean;
    private ImageView like;
    private String urlStr = "http://www.xieast.com/api/news/news.php";
    boolean p=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();       //实例化view
        recyclerManage(); //布局管理器
        animation();   //动画
    }
    //动画
    private void animation() {
        like = findViewById(R.id.like);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //X轴平移
                ObjectAnimator translationX = ObjectAnimator.ofFloat(like, "translationX", 0,-450,0);
                //Y轴平移
                ObjectAnimator translationY = ObjectAnimator.ofFloat(like, "translationY", 0,700,0);
                //透明度
                ObjectAnimator alpha = ObjectAnimator.ofFloat(like, "alpha", 1f, 0f, 1f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(2000);
                //同时进行
                animatorSet.playTogether(translationX, translationY, alpha);
                animatorSet.start();

                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        if (p){
                            like.setImageResource(R.drawable.black);
                            p=false;
                        }else {
                            like.setImageResource(R.drawable.white);
                            p=true;
                        }

                    }
                });
            }
        });
    }

    private void recyclerManage() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        //分割xian
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    // 资源id
    private void initView() {
        recyclerView = findViewById(R.id.recycleView);
        iPresentr = new IPresentrImpl(this);
        mAdapter = new NewsAdapter(this);
        recyclerView.setAdapter(mAdapter);

        iPresentr.pRequestData(urlStr, NewsBean.class);
    }

    //获取数据
    @Override
    public void viewData(Object data) {
        newsBean = (NewsBean) data;
        mAdapter.setDatas(newsBean.getData());

        mAdapter.setClickListener(new NewsAdapter.Click() {
            @Override
            public void OnClick(int i) {
                mAdapter.removeData(i);
            }
        });

    }


}
