package com.example.sports_assistant_system.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sports_assistant_system.MainActivity;
import com.example.sports_assistant_system.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private EditText etTnumber,etPassword;
    private TextView tvRegister,tvChangePwd,tvLoginByTnumber;
    private Switch swRememberPwd;
    /*sharedpreference功能*/
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private DBOpenHelper dbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,systemBars.bottom);
            return insets;
        });
        Init();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        dbOpenHelper = new DBOpenHelper(this);
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Boolean isremember = sharedPreferences.getBoolean("remember_password",false);
        if (isremember){
            String username = sharedPreferences.getString("username","");
            String tnumber = sharedPreferences.getString("tnumber","");
            String password = sharedPreferences.getString("password","");
            etTnumber.setText(tnumber);
            etPassword.setText(password);
            swRememberPwd.setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_login){
            String getTnumber = etTnumber.getText().toString();
            String getPassword = etPassword.getText().toString();

            boolean loginStatus = dbOpenHelper.mDataBaseLogin(getTnumber,getPassword);//传输入框获取的账号密码
            if (loginStatus)//判断布尔类型传的是成功还是失败了 当login是对的，说明登录成功了
            {
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();

                editor = sharedPreferences.edit();
                if (swRememberPwd.isChecked()) {
                    editor.putBoolean("remember_password", true);
                    editor.putString("tnumber",getTnumber);
                    editor.putString("password",getPassword);
                }
                else{
                    editor.clear();
                }
                editor.commit();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                intent.putExtra("tnumber",getTnumber);
                intent.putExtra("password",getPassword);

                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId()==R.id.tv_register) {
            Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent1);
//            finish();
        } else if (v.getId()==R.id.tv_changepwd) {
            Intent intent = new Intent(LoginActivity.this, ChangePasswordActivity.class);
            startActivity(intent);
        } else if (v.getId()==R.id.tv_login_by_tnumber) {
            Intent intent = new Intent(LoginActivity.this, LoginbyTnumberActivity.class);
            startActivity(intent);
        }
    }

    private void Init() {
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvRegister = (TextView) findViewById(R.id.tv_register);
        etTnumber = (EditText) findViewById(R.id.et_tnumber);
        etPassword = (EditText) findViewById(R.id.et_password);
        swRememberPwd = (Switch) findViewById(R.id.sw_rememberpwd);
        tvChangePwd = (TextView) findViewById(R.id.tv_changepwd);
        tvLoginByTnumber = (TextView) findViewById(R.id.tv_login_by_tnumber);
        tvChangePwd.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvLoginByTnumber.setOnClickListener(this);
    }
}