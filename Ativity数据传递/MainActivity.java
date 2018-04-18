package com.none.data_t;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    private EditText et_password;
    private Button btn_send;
    private EditText et_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name=(EditText) findViewById(R.id.et_name);
        et_password=(EditText) findViewById(R.id.et_passw);
        btn_send=(Button) findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDate();
            }
        });
    }

    public void passDate()
    {
        Intent intent=new Intent(this,ShowActivity.class);

        intent.putExtra("name",et_name.getText().toString().trim());
        intent.putExtra("password",et_password.getText().toString().trim());
        startActivity(intent);
    }
}
