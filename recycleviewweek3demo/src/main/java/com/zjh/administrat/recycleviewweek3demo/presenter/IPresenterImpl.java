package com.zjh.administrat.recycleviewweek3demo.presenter;

import com.zjh.administrat.recycleviewweek3demo.model.IModelImpl;
import com.zjh.administrat.recycleviewweek3demo.utils.MyCallBack;
import com.zjh.administrat.recycleviewweek3demo.view.IView;

import java.util.Map;

public class IPresenterImpl implements IPresenter{
    private IView iView;
    private IModelImpl iModel;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        iModel = new IModelImpl();
    }

    @Override
    public void preRuestData(String urlStr, Map<String, String> params, Class clazz) {
        iModel.mshowData(urlStr, params, clazz, new MyCallBack() {
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
