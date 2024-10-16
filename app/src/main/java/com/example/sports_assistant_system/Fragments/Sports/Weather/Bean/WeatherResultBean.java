package com.example.sports_assistant_system.Fragments.Sports.Weather.Bean;

import java.util.List;
public class WeatherResultBean {
    private String city;
    private String date;
    private String update_time;
    private List<WeatherBean> WeatherBean;
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getUpdate_time() {
        return update_time;
    }
    public void setUpdate_time(String update_time){this.update_time = update_time;
    }
    public List<WeatherBean> getWeather() {
        return WeatherBean;
    }
    public void setWeather(List<WeatherBean> WeatherBean) {
        this.WeatherBean = WeatherBean;
    }
}
