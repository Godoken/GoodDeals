package com.example.gooddeals;

import java.util.Collection;
import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;

public interface GoodDealsAPI {

    //@Headers("Content-Type: application/json")
    @GET("v001/deals/")
    Call<Collection<Deal>> getAllDeals();

    //@GET("v001/deals/login")
    @HTTP(method = "GET", path = "v001/deals/login", hasBody = true)
    Call<User> login(@Body UserInfo userInfo);


}
