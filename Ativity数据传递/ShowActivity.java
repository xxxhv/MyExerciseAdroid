package com.none.data_t;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    private TextView tv_name;
    private TextView tv_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Intent intent;
        intent = getIntent();

        String name=intent.getStringExtra("name");
        String password=intent.getStringExtra("password");
        tv_name=(TextView) findViewById(R.id.tv_name);
        tv_password=(TextView) findViewById(R.id.tv_passw);
        tv_name.setText("用户名：" + name);
        tv_password.setText("密码：" + password);
    }
}
