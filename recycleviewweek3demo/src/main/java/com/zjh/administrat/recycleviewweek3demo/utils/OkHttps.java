package com.zjh.administrat.recycleviewweek3demo.utils;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttps {
    private static volatile OkHttps instance;
    private OkHttpClient client;
    private Handler handler = new Handler(Looper.getMainLooper());

    public static OkHttps getInstance(){
        if (instance == null){
            synchronized (OkHttps.class){
                instance = new OkHttps();
            }
        }
        return instance;
    }


    public OkHttps() {
        //日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }
    public void getRequest(String urlStr, Map<String, String> params, final Class clazz, final ICallBack iCallBack){
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()){
            builder.add(entry.getKey(), entry.getValue());
        }
        FormBody build = builder.build();
        Request request = new Request.Builder()
                .url(urlStr)
                .post(build)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.Fails(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final Object fromJson = gson.fromJson(string, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.success(fromJson);
                    }
                });

            }
        });


    }


}
