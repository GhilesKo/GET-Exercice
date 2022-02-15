package com.example.simple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.simple.html.RetrofitUtil;
import com.example.simple.html.Service;

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
                String etNombre = editText.getText().toString();
                int nombre = Integer.parseInt(etNombre);
                Service service = RetrofitUtil.get();
                Call<Integer> call = service.chosenNumber(nombre);
                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (response.isSuccessful())
                        {
                            tv.setText(response.body().toString());
                            Log.i("number", String.valueOf(response.body()));

                        }


                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {

                        Log.i("Erreur",t.getMessage());
                    }
                });

            }
        });

    }
}