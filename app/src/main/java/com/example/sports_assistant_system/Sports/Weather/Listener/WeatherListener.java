package com.example.sports_assistant_system.Sports.Weather.Listener;


import com.example.sports_assistant_system.Sports.Weather.Bean.WeatherResultBean;

public interface WeatherListener {
    public void onResponse(WeatherResultBean weather);
    public void onFail(String msg);
}
