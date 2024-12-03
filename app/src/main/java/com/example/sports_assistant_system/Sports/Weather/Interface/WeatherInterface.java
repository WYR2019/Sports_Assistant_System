package com.example.sports_assistant_system.Sports.Weather.Interface;

import com.example.sports_assistant_system.Sports.Weather.Listener.WeatherListener;

public interface WeatherInterface {
    void getWeather(String cityNumber, WeatherListener listener);

}
