package com.zjh.administrat.week3firstnewsdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zjh.administrat.week3firstnewsdemo.R;
import com.zjh.administrat.week3firstnewsdemo.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NewsBean.DataBean> mData;
    private Context mContext;

    public NewsAdapter(Context mContext) {
        this.mContext = mContext;
        mData = new ArrayList<>();
    }

    public void setDatas(List<NewsBean.DataBean> data) {
        if (data != null){
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
         ViewHolder mHolder = (ViewHolder) viewHolder;
         mHolder.textView1.setText(mData.get(i).getTitle());
         mHolder.textView2.setText(mData.get(i).getDate());
         Glide.with(mContext).load(mData.get(i).getThumbnail_pic_s()).into(mHolder.imageView);

         //点击
        mHolder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClick != null) {
                    mClick.OnClick(i);
                }
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
        public ImageView del;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            del = itemView.findViewById(R.id.del);
        }
    }
    //删除
    public void removeData(int i) {
        mData.remove(i);
        notifyDataSetChanged();
    }

    //成员变量
    Click mClick;
    //set方法
    public void setClickListener(Click click){
        mClick = click;
    }
    //接口
    public interface Click{
        void OnClick(int i);
    }

}
