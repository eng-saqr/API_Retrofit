package com.example.api_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API_InterFace {

    @GET("posts/{id}")
    public Call<Post> getpost(@Path("id") int id) ;
}
