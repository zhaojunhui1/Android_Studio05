package com.zjh.administrat.recycleviewweek3demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zjh.administrat.recycleviewweek3demo.R;
import com.zjh.administrat.recycleviewweek3demo.bean.GoodsBean;

import java.util.ArrayList;
import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GoodsBean.DataBean> mData;
    private Context mContext;

    public GoodsAdapter(Context mContext) {
        this.mContext = mContext;
        mData = new ArrayList<>();
    }

    public void setDatas(List<GoodsBean.DataBean> data) {
        mData.clear();
        if (data != null) {
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void addDatas(List<GoodsBean.DataBean> data) {
        if (data != null) {
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.linear_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder mHolder = (ViewHolder) viewHolder;
        mHolder.textView1.setText(mData.get(i).getTitle());
        mHolder.textView2.setText(mData.get(i).getPrice() + "");
        //截取图片集
        String str = "";
        int length = mData.get(i).getImages().length();
        for (int j = 0; j < length; j++) {
            if (mData.get(i).getImages().substring(j, j + 1).equals("|")) {
                str = mData.get(i).getImages().substring(j + 1, length).trim();
            }
        }
        Glide.with(mContext).load(str).into(mHolder.imageView);
        //点击点击---------------
        mHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClick != null){
                    mClick.OnItemClick(mData.get(i).getImages(), mData.get(i).getTitle(), mData.get(i).getPrice()+"");
                }
            }
        });
        //长按长按-------------
        mHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mClick != null) {
                    mClick.OnItemLongClick(v, i);
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView1, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }

    }

    //定义个接口回调点击事件
    //成员变量
    Click mClick;
    //set方法
    public void setClickLinear(Click click) {
        mClick = click;
    }
    //定义一个接口
    public interface Click {
        void OnItemClick(String imageView, String title, String price);

        void OnItemLongClick(View itemView, int i);
    }


}
