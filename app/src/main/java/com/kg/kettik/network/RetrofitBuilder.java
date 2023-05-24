package com.kg.kettik.network;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitBuilder {
    public static RetrofitService instance;
    private static OkHttpClient client;


    public static RetrofitService getInstance() {
        if (instance == null) {
            instance = buildRetrofit();

        }
        return instance;
    }

    private static RetrofitService buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build()
                .create(RetrofitService.class);

    }

    private static OkHttpClient getClient() {
        if (client == null) {
            client = okhttpBuilder();
        }
        return client;
    }

    private static OkHttpClient okhttpBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}
