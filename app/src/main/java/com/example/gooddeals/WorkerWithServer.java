package com.example.gooddeals;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collection;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;


class WorkerWithServer  {

    Gson gson;
    Retrofit retrofit;
    GoodDealsAPI goodDealsAPI;
    Collection<Deal> dealList;

    private DealsCallback callback;
    private UserCallback userCallback;

    final String BASE_URL = "http://192.168.43.220:8081/api/";

    public void start(final DealsCallback callback){

        this.callback = callback;

        gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        goodDealsAPI = retrofit.create(GoodDealsAPI.class);

        Call<Collection<Deal>> call = goodDealsAPI.getAllDeals();
        call.enqueue(new Callback<Collection<Deal>>() {
            @Override
            public void onResponse(Call<Collection<Deal>> call, Response<Collection<Deal>> response) {

                //int k = 0;
                //String s = "";

                if(response.isSuccessful()) {
                    Collection<Deal> dealList = response.body();
                    callback.onSuccess(dealList);
                } else {
                    callback.onFailure(new RuntimeException());
                    //k = response.code();
                    //s = response.message();
                }

            }

            @Override
            public void onFailure(Call<Collection<Deal>> call, Throwable t) {
                callback.onFailure(t);
                t.printStackTrace();

            }
        });

    }

    //public void setDealList(Collection<Deal> dealList){
        //this.dealList = dealList;
    //}

    //public Collection<Deal> getDealList(){
        //return this.dealList;
    //}

    public void loginUser(WorkerWithServer.UserCallback callback, UserInfo userInfo) {

        this.userCallback = callback;

        gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        goodDealsAPI = retrofit.create(GoodDealsAPI.class);

        Call<User> call = goodDealsAPI.login(userInfo);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.isSuccessful()) {
                    User user = response.body();
                    userCallback.onSuccess(user);
                } else {
                    userCallback.onFailure(new RuntimeException());
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                userCallback.onFailure(t);
                t.printStackTrace();

            }
        });


    }

    public interface DealsCallback{
        void onSuccess(Collection<Deal> dealList);
        void onFailure(Throwable throwable);
    }
    public interface UserCallback{
        void onSuccess(User user);
        void onFailure(Throwable throwable);
    }
}
