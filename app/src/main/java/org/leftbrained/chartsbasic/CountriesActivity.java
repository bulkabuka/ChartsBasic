package org.leftbrained.chartsbasic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        String API_KEY = "Bearer x8d6GZgGrhDAeT1mslRMv2UXyt5MQvA8JUwnXkWt";
        /*RestCountries restCountries = new Retrofit.Builder()
                .baseUrl("https://restcountries.com/v3.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestCountries.class);
        // Call the API
        Call<List<Country>> response = restCountries.getAllCountries();
        response.enqueue(
                new Callback<List<Country>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Country>> call, @NonNull Response<List<Country>> response) {
                        List<Country> countries = response.body();
                        assert countries != null;
                        for (Country country : countries) {
                            System.out.println(country.name.common);
                            System.out.println(country.population);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Country>> call, @NonNull Throwable t) {
                        System.out.println("Error: " + t.getMessage());
                    }
                });
                */
        // Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://countryapi.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // Create an instance of our Country API interface.
        RestCountries countryApi = retrofit.create(RestCountries.class);
        // Call the API
        Call<List<Country>> response = countryApi.getAllCountries(API_KEY);
        response.enqueue(
                new Callback<List<Country>>() {
                    @Override
                    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                        List<Country> countries = response.body();
                        assert countries != null;
                        for (Country country : countries) {
                            System.out.println(country.name);
                            System.out.println(country.population);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Country>> call, Throwable t) {
                        System.out.println("Error: " + t.getMessage());
                    }
                }
        );
    }
}