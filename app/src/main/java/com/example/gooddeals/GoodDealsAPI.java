package com.example.gooddeals;

import java.util.Collection;
import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;

public interface GoodDealsAPI {

    @GET("v001/deals/")
    Call<Collection<Deal>> getAllDeals();

    //@GET("v001/deals/login")
    @HTTP(method = "GET", path = "v001/deals/login/", hasBody = true)
    Call<User> login(@Body UserInfo userInfo);

    //@POST("v001/deals/")
    @HTTP(method = "POST", path = "v001/deals/", hasBody = true)
    Call<Deal> createDeal(@Body Deal deal);

    //@GET("v001/deals/execute/{id}/")
    @HTTP(method = "GET", path = "v001/deals/execute/{id}/", hasBody = true)
    Call<User> executeDeal(String id, User m_user);

    //@DELETE("v001/deals/{id}/")
    @HTTP(method = "DELETE", path = "v001/deals/{id}/", hasBody = true)
    Call<Deal> deleteDeal(String id);
}
