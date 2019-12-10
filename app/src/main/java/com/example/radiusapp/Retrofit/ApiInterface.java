package com.example.radiusapp.Retrofit;

import com.example.radiusapp.Model.Main;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("radius-mobile-intern.json")
    Call<Main> getData();
}
