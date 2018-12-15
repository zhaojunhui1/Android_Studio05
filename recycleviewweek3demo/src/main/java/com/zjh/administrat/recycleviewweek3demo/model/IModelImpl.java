package com.zjh.administrat.recycleviewweek3demo.model;

import com.zjh.administrat.recycleviewweek3demo.utils.ICallBack;
import com.zjh.administrat.recycleviewweek3demo.utils.MyCallBack;
import com.zjh.administrat.recycleviewweek3demo.utils.OkHttps;

import java.util.Map;

public class IModelImpl implements IModel {


    @Override
    public void mshowData(String urlStr, Map<String, String> params, Class clazz, final MyCallBack myCallBack) {
         OkHttps.getInstance().getRequest(urlStr, params, clazz, new ICallBack() {
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
