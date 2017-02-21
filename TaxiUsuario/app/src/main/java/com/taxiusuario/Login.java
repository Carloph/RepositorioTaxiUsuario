package com.taxiusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private TextView tv_sig_in;
    private TextView tv_remember_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_sig_in = (TextView) findViewById(R.id.textView_sign_in);
        tv_remember_password = (TextView) findViewById(R.id.textView_remember_password);
        btn_login =  (Button) findViewById(R.id.button_login);



        tv_sig_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_sig_in = new Intent(Login.this,Register.class);
                startActivity(intent_sig_in);
            }
        });

        tv_remember_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_remember_password = new Intent(Login.this,RememberPassword.class);
                startActivity(intent_remember_password);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_home = new Intent(Login.this, Home.class);
                startActivity(intent_home);
            }
        });
    }
}
