package com.example.simple.html;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    @GET("exos/long/double/{valeur}")
    Call<Integer> chosenNumber(@Path("valeur") int valeur);

}
