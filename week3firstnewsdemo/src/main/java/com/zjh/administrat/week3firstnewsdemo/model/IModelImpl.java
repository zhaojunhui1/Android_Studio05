package com.zjh.administrat.week3firstnewsdemo.model;

import com.zjh.administrat.week3firstnewsdemo.utils.ICallBack;
import com.zjh.administrat.week3firstnewsdemo.utils.MyCallBack;
import com.zjh.administrat.week3firstnewsdemo.utils.OkHttps;

import java.util.Map;

public class IModelImpl implements IModel {


    @Override
    public void mRequestData(String urlStr, Class clazz, final MyCallBack myCallBack) {
        OkHttps.getInstance().doGet(urlStr, clazz, new ICallBack() {
            @Override
            public void success(Object object) {
                myCallBack.OnSuccess(object);
            }

            @Override
            public void Fails(Exception e) {

            }
        });
    }


}
