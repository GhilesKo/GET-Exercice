package com.example.simple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simple.html.RetrofitUtil;
import com.example.simple.html.Service;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText= findViewById(R.id.et);
        Button button = findViewById(R.id.btn);
         TextView tv = findViewById(R.id.tv);


         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 int value = Integer.parseInt(editText.getText().toString());

                 Service service = RetrofitUtil.get();
                 service.nombreRecu(value).enqueue(new Callback<Integer>() {
                     @Override
                     public void onResponse(Call<Integer> call, Response<Integer> response) {
                         if (response.isSuccessful())
                         {
                             Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();

                         }
                         else
                         {
                             try {
                                 Snackbar.make(v,response.errorBody().string(), Snackbar.LENGTH_LONG ).show();
                             } catch (IOException e) {
                                 e.printStackTrace();
                             }


                         }
                     }

                     @Override
                     public void onFailure(Call<Integer> call, Throwable t) {

                                 Toast.makeText(MainActivity.this, getString(R.string.noInternet), Toast.LENGTH_SHORT).show();


                     }
                 });



             }
         });





    }
}