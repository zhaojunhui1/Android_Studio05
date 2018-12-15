package com.zjh.administrat.week3firstnewsdemo.model;

import com.zjh.administrat.week3firstnewsdemo.utils.MyCallBack;

import java.util.Map;

public interface IModel {
    void mRequestData(String urlStr, Class clazz, MyCallBack myCallBack);
}
