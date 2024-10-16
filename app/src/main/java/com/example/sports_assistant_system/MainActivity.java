package com.example.sports_assistant_system;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.sports_assistant_system.Fragments.DevicesFragment;
import com.example.sports_assistant_system.Fragments.RecordsFragment;
import com.example.sports_assistant_system.Fragments.Sports.SportsFragment;
import com.example.sports_assistant_system.Fragments.AccountsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private SportsFragment sportsFragment;
    private RecordsFragment recordsFragment;
    private DevicesFragment devicesFragment;
    private AccountsFragment accountsFragment;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right,systemBars.bottom);
//            return insets;
//        });

        //初始化控件、设置点击事件
        bottomNavigationView = findViewById(R.id.BottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.devices){
                    SelectedFragment(0);
                } else if (item.getItemId()==R.id.sports) {
                    SelectedFragment(1);
                } else if (item.getItemId()==R.id.records) {
                    SelectedFragment(2);
                } else {
                    SelectedFragment(3);
                }
                return true;
            }
        });
    }

    private void SelectedFragment(int position){
        //fragment布局加载器
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        HideFragment(fragmentTransaction);

        //第一个被选中
        if(position == 0){
            if(devicesFragment == null) {
                devicesFragment = new DevicesFragment();
                fragmentTransaction.add(R.id.content,devicesFragment);
            }else {
                fragmentTransaction.show(devicesFragment);
            }
        } else if (position == 1) {
            if(sportsFragment == null) {
                sportsFragment = new SportsFragment();
                fragmentTransaction.add(R.id.content,sportsFragment);
            }else {
                fragmentTransaction.show(sportsFragment);
            }
        } else if (position == 2) {
            if(recordsFragment == null) {
                recordsFragment = new RecordsFragment();
                fragmentTransaction.add(R.id.content,recordsFragment);
            }else {
                fragmentTransaction.show(recordsFragment);
            }
        }else {
            if (accountsFragment == null) {
                accountsFragment = new AccountsFragment();
                fragmentTransaction.add(R.id.content, accountsFragment);
            } else {
                fragmentTransaction.show(accountsFragment);
            }
        }

        //提交
        fragmentTransaction.commit();
    }
    //点击其中一个fragment的时候需要将其他fragment隐藏
    private void HideFragment(FragmentTransaction fragmentTransaction){
        if (devicesFragment!=null){
            fragmentTransaction.hide(devicesFragment);
        }if (sportsFragment!=null){
            fragmentTransaction.hide(sportsFragment);
        }if (recordsFragment!=null){
            fragmentTransaction.hide(recordsFragment);
        }if (accountsFragment!=null){
            fragmentTransaction.hide(accountsFragment);
        }
    }
}