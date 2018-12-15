package com.zjh.administrat.recycleviewweek3demo.model;

import com.zjh.administrat.recycleviewweek3demo.utils.MyCallBack;

import java.util.Map;

public interface IModel {
    void mshowData(String urlStr, Map<String, String> params, Class clazz, MyCallBack myCallBack);
}
