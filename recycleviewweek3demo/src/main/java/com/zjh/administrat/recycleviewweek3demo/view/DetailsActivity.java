package com.zjh.administrat.recycleviewweek3demo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zjh.administrat.recycleviewweek3demo.R;
import com.zjh.administrat.recycleviewweek3demo.bean.GoodsBean;
import com.zjh.administrat.recycleviewweek3demo.presenter.IPresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity implements IView {
    private ImageView imageView;
    private TextView title, price;
    private GoodsBean goodsBean;
    private IPresenterImpl iPresenter;
    private String urlStr = "http://www.zhaoapi.cn/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA";
    private Intent intent;
    private String images;
    private String title1;
    private String price1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        //传值
        intent = getIntent();
        images = intent.getStringExtra("imageView");
        title1 = intent.getStringExtra("title");
        price1 = intent.getStringExtra("price");
    }

    private void initView() {
        imageView = findViewById(R.id.imageView);
        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        iPresenter = new IPresenterImpl(this);

        Map map = new HashMap<>();
        map.put("mPage", "1");
        iPresenter.preRuestData(urlStr, map, GoodsBean.class);
    }

    //获取数据
    @Override
    public void viewData(Object data) {
        goodsBean = (GoodsBean) data;
            //截取图片集
            String str = "";
            int length = images.length();
            for (int j = 0; j < length; j++) {
                if (images.substring(j, j + 1).equals("|")) {
                    str = images.substring(j + 1, length).trim();
                }
            }
            Glide.with(DetailsActivity.this).load(str).into(imageView);
            title.setText(title1);
            price.setText(price1);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.onDetch();
    }
}

