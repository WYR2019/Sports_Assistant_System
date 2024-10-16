package com.example.sports_assistant_system.Fragments.Sports;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.sports_assistant_system.Fragments.Sports.Weather.Bean.WeatherResultBean;
import com.example.sports_assistant_system.Fragments.Sports.Weather.Listener.WeatherListener;
import com.example.sports_assistant_system.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SportsFragment} factory method to
 * create an instance of this fragment.
 */
public class SportsFragment extends Fragment implements WeatherListener{
    public TextView tvCity,tvTemp,tvWind;
    public Button btnRunning;
    public AMapLocationClient aMapLocationClient = null;

    public AMapLocationClientOption aMapLocationClientOption = null;

    //声明定位回调监听器
    public AMapLocationListener aMapLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            try {
                aMapLocationClient = new AMapLocationClient(getContext());
                aMapLocationClient.setLocationListener(aMapLocationListener);
                aMapLocationClientOption = new AMapLocationClientOption();
                aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                aMapLocationClientOption.setOnceLocation(true);
                aMapLocationClientOption.setOnceLocationLatest(true);
                aMapLocationClientOption.setNeedAddress(true);
                aMapLocationClient.setLocationOption(aMapLocationClientOption);
                aMapLocationClient.startLocation();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sports, container, false);
        Init(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

    }

    @Override
    public void onResponse(WeatherResultBean weather) {

    }

    @Override
    public void onFail(String msg) {

    }

    public void Init(View view) {
        tvCity = view.findViewById(R.id.tv_city_sports_fragment);
        tvTemp = view.findViewById(R.id.tv_temp_sports_fragment);
        tvWind = view.findViewById(R.id.tv_wind_sports_fragment);
    }

}