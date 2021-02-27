package com.pf.tutorial;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/country/all")
    Call<List<Country>> getCountries();
}
