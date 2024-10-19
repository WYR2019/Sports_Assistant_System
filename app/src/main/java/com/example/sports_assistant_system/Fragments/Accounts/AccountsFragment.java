package com.example.sports_assistant_system.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.sports_assistant_system.Login.LoginActivity;
import com.example.sports_assistant_system.R;

public class AccountsFragment extends Fragment implements View.OnClickListener{

    private Button btQuit;
    private RelativeLayout rlSetting;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accounts, container, false);
    }






    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_quit){
            Intent Intent_quit = new Intent(getActivity(), LoginActivity.class);
            startActivity(Intent_quit);
        }else if (v.getId()==R.id.btn_setting){
            Intent Intent_setting = new Intent(getActivity(), SettingActivity.class);
            startActivity(Intent_setting);
        }
    }

    public void Init(View view){
        btQuit = view.findViewById(R.id.btn_quit);
        btQuit.setOnClickListener(this);
        rlSetting = view.findViewById(R.id.btn_setting);
        rlSetting.setOnClickListener(this);
    }
}