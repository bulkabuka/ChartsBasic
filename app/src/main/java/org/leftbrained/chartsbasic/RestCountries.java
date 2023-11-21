package org.leftbrained.chartsbasic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestCountries {
    @GET("all")
    Call<List<Country>> getAllCountries(@Query("Authorization") String token);
}
