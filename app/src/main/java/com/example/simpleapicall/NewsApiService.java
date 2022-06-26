package com.example.simpleapicall;

import com.example.simpleapicall.Models.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=API_KEY
public interface NewsApiService {
    @GET("top-headlines")
    Call<ApiResponse> getHeadline(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("everything")
    Call<ApiResponse> searchNews(@Query("country") String country, @Query("apiKey") String apiKey, @Query("q") String q);
}
