package com.example.simple.html;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtil {
    
  public static Service get() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://exam-mobile.herokuapp.com/api/final/")
                .build();

        Service service = retrofit.create(Service.class);
        return service;

    }
}
