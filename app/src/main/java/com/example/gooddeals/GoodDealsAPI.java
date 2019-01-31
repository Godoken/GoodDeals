package com.example.gooddeals;

import java.util.Collection;
import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;

public interface GoodDealsAPI {

    //@Headers("Content-Type: application/json")
    @GET("v001/deals/")
    Call<Collection<Deal>> getAllDeals();
}
