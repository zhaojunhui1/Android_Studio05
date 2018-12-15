package com.zjh.administrat.week3firstnewsdemo.presenter;

import android.graphics.Paint;

import com.zjh.administrat.week3firstnewsdemo.model.IModelImpl;
import com.zjh.administrat.week3firstnewsdemo.utils.MyCallBack;
import com.zjh.administrat.week3firstnewsdemo.view.IView;

import java.util.Map;

public class IPresentrImpl implements IPresenter {
    private IView iView;
    private IModelImpl iModel;

    public IPresentrImpl(IView iView) {
        this.iView = iView;
        iModel = new IModelImpl();
    }

    @Override
    public void pRequestData(String urlStr, Class clazz) {
        iModel.mRequestData(urlStr, clazz, new MyCallBack() {
            @Override
            public void OnSuccess(Object data) {
                iView.viewData(data);
            }
        });
    }

    public void onDetch(){
        if (iView != null){
            iView = null;
        }
        if (iModel != null){
            iModel = null;
        }
    }

}
