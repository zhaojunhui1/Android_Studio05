package com.zjh.administrat.recycleviewweek3demo.view;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zjh.administrat.recycleviewweek3demo.R;
import com.zjh.administrat.recycleviewweek3demo.adapter.GoodsAdapter;
import com.zjh.administrat.recycleviewweek3demo.bean.GoodsBean;
import com.zjh.administrat.recycleviewweek3demo.presenter.IPresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IView {
    private XRecyclerView xRecyclerView;
    private GoodsBean goodsBean;
    private GoodsAdapter mAdapter;
    private IPresenterImpl iPresenter;
    private int page;
    private int sort;
    private List<GoodsBean.DataBean> dataBean = new ArrayList<>();
    private String urlStr = "http://www.zhaoapi.cn/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取View
        initView();
    }
    //获取view
    private void initView() {
        //跳转网格视图
        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GridActivity.class));
            }
        });
        xRecyclerView = findViewById(R.id.xRecyclerView);
        iPresenter = new IPresenterImpl(this);
        page = 1;
        sort = 0;
        //创建适配器
        mAdapter = new GoodsAdapter(this);
        xRecyclerView.setAdapter(mAdapter);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(linearLayoutManager);
        //刷新加载
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                initData();
            }

            @Override
            public void onLoadMore() {
                initData();
            }
        });
        initData();
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("mPage", String.valueOf(page));
        map.put("mSort", String.valueOf(sort));
        iPresenter.preRuestData(urlStr, map, GoodsBean.class);
    }

    //返回数据
    @Override
    public void viewData(Object data) {
        goodsBean = (GoodsBean) data;
        //Toast.makeText(this, ""+goodsBean.getData(), Toast.LENGTH_SHORT).show();
        if (page == 1){
            mAdapter.setDatas(goodsBean.getData());
        }else {
            mAdapter.addDatas(goodsBean.getData());
        }
        page ++;
        dataBean.addAll(goodsBean.getData());
        xRecyclerView.refreshComplete();
        xRecyclerView.loadMoreComplete();

        //判断分类  //综合
        findViewById(R.id.all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page = 1;
                sort = 0;
                initData();
                mAdapter.setDatas(dataBean);
            }
        });   //销量
        findViewById(R.id.number).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page = 1;
                sort = 1;
                initData();
                mAdapter.setDatas(dataBean);
            }
        });   //价格
        findViewById(R.id.prices).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page = 1;
                sort = 2;
                initData();
                mAdapter.setDatas(dataBean);
            }
        });

        //设置分隔线系统自带
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        //添加分割线
        xRecyclerView.addItemDecoration(divider);
        //点击事件
        mAdapter.setClickLinear(new GoodsAdapter.Click() {
            @Override
            public void OnItemClick(String imageView, String title, String price) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("imageView", imageView);
                intent.putExtra("title", title);
                intent.putExtra("price",price);
                startActivity(intent);
            }

            @Override
            public void OnItemLongClick(View itemView, int i) {
                Toast.makeText(MainActivity.this, "长按", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.onDetch();
    }
}
