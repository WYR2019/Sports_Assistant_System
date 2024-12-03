package com.example.sports_assistant_system.Sports.Weather.Model;

import com.example.sports_assistant_system.Sports.Weather.Bean.WeatherResultBean;
import com.example.sports_assistant_system.Sports.Weather.Interface.WeatherInterface;
import com.example.sports_assistant_system.Sports.Weather.Listener.WeatherListener;
import com.example.sports_assistant_system.Sports.Weather.Service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherModel implements WeatherInterface {
    private WeatherService service;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://query.asilu.com/";
    //private static final String BASE_URL = "https://weather.com.cn/";
    public WeatherModel(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Override
    public void getWeather(String cityNumber, WeatherListener listener) {
        service=retrofit.create(WeatherService.class);
        Call<WeatherResultBean> call=service.getResult(cityNumber);
        System.out.println("----+---"+BASE_URL);
        System.out.println("----+城市代码"+cityNumber);
        call.enqueue(new Callback<WeatherResultBean>() {
            @Override
            public void onResponse(Call<WeatherResultBean> call, Response<WeatherResultBean> response) {
                if (response.isSuccessful()&&response.body()!=null){
                    listener.onResponse(response.body());
                    System.out.println("----+成功");
                }
                else {
                    listener.onFail("错误分析");
                    System.out.println("----+错误分析");
                }
            }
            @Override
            public void onFailure(Call<WeatherResultBean> call, Throwable t) {
                listener.onFail(t.toString());
                System.out.println("----+失败="+t.toString());
            }
        });
    }

}
