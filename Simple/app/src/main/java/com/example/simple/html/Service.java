package com.example.simple.html;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    @GET("1/{nombre}")
    Call<Integer> nombreRecu(@Path("nombre") int valeur);

}
