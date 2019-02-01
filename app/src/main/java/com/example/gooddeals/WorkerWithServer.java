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
    private DealCallback dealCallback;

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

                if(response.isSuccessful()) {
                    Collection<Deal> dealList = response.body();
                    callback.onSuccess(dealList);
                } else {
                    callback.onFailure(new RuntimeException());
                }

            }

            @Override
            public void onFailure(Call<Collection<Deal>> call, Throwable t) {
                callback.onFailure(t);
                t.printStackTrace();

            }
        });

    }

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

    public void addDeal(WorkerWithServer.DealCallback callback, Deal deal) {

        this.dealCallback = callback;

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

        Call<Deal> call = goodDealsAPI.createDeal(deal);
        call.enqueue(new Callback<Deal>() {
            @Override
            public void onResponse(Call<Deal> call, Response<Deal> response) {

                if(response.isSuccessful()) {
                    Deal deal = response.body();
                    dealCallback.onSuccess(deal);
                } else {
                    dealCallback.onFailure(new RuntimeException());
                }

            }

            @Override
            public void onFailure(Call<Deal> call, Throwable t) {
                dealCallback.onFailure(t);
                t.printStackTrace();

            }
        });


    }

    public void executeDeal(final UserCallback userCallback, String id, User m_user) {

        this.userCallback = userCallback;

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

        Call<User> call = goodDealsAPI.executeDeal(id, m_user);
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

    public void deleteDeal(final DealCallback dealCallback, String id) {

        this.dealCallback = dealCallback;

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

        Call<Deal> call = goodDealsAPI.deleteDeal(id);
        call.enqueue(new Callback<Deal>() {
            @Override
            public void onResponse(Call<Deal> call, Response<Deal> response) {

                if(response.isSuccessful()) {
                    Deal deal = response.body();
                    dealCallback.onSuccess(deal);
                } else {
                    dealCallback.onFailure(new RuntimeException());
                }

            }

            @Override
            public void onFailure(Call<Deal> call, Throwable t) {
                dealCallback.onFailure(t);
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
    public interface DealCallback{
        void onSuccess(Deal deal);
        void onFailure(Throwable throwable);
    }
}
