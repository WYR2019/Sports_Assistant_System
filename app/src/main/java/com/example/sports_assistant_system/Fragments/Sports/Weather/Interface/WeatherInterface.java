package com.example.sports_assistant_system.Fragments.Sports.Weather.Interface;

import com.example.sports_assistant_system.Fragments.Sports.Weather.Listener.WeatherListener;

public interface WeatherInterface {
    void getWeather(String cityNumber, WeatherListener listener);

}
