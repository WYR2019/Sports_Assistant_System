package com.example.sports_assistant_system.Fragments.Accounts;

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

    private Button btnQuit;
    private RelativeLayout rlSettings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accounts, container, false);
        Init(view);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_quit){
            Intent Intent_quit = new Intent(getActivity(), LoginActivity.class);
            startActivity(Intent_quit);
        }else if (v.getId()==R.id.btn_setting){
            Intent Intent_setting = new Intent(getActivity(), SettingsActivity.class);
            startActivity(Intent_setting);
        }
    }

    public void Init(View view){
        btnQuit = view.findViewById(R.id.btn_quit);
        btnQuit.setOnClickListener(this);
        rlSettings = view.findViewById(R.id.btn_setting);
        rlSettings.setOnClickListener(this);
    }
}