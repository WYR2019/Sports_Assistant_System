package com.example.sports_assistant_system.Sports.Weather.Service;

import com.example.sports_assistant_system.Sports.Weather.Bean.WeatherResultBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("weather/baidu")
    Call<WeatherResultBean> getResult(@Query("city")String cityNumber);
}
