package com.example.simple;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.simple.html.RetrofitUtil;
import com.example.simple.html.Service;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testSimple() throws IOException {
        int v = 2;
    Service service = RetrofitUtil.get();
        Call<Integer> call = service.chosenNumber(v);
        Response<Integer> response = call.execute();
        String resultat = String.valueOf(response.body());
        Log.i("RETROFIT", resultat);
    }
}