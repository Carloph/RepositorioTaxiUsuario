package com.taxiusuario.View.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.taxiusuario.Presenter.Login.LoginPresenterImp;
import com.taxiusuario.R;
import com.taxiusuario.View.Home.Home;
import com.taxiusuario.View.RememberPass.RememberPassword;
import com.taxiusuario.View.Submit.Submit;

public class Login extends AppCompatActivity implements LoginView{

    private TextView tv_sig_in;
    private TextView tv_remember_password;
    public ProgressDialog progressDialog;
    public EditText edt_email;
    public EditText edt_password;
    private Button btn_login;
    private LoginPresenterImp presenter;
    private static final int REQUEST_ID_ACCESS_COURSE_FINE_LOCATION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        checkPermissionLocation();
        presenter = new LoginPresenterImp(this);
        progressDialog = new ProgressDialog(this);
        tv_sig_in = (TextView) findViewById(R.id.textView_sign_in);
        tv_remember_password = (TextView) findViewById(R.id.textView_remember_password);
        btn_login =  (Button) findViewById(R.id.button_login);
        edt_email = (EditText)findViewById(R.id.editText_email);
        edt_password = (EditText)findViewById(R.id.editText_password);

        tv_sig_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_submit = new Intent(Login.this,Submit.class);
                startActivity(intent_submit);
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
                presenter.validateCredentials(edt_email.getText().toString(), edt_password.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
            progressDialog.setTitle("Por favor, espere...");
            progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void setEmailError() {
        edt_email.setError(getString(R.string.email_error));
    }

    @Override
    public void setPasswordError() {
        edt_password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome(int id) {

            Intent intent_home = new Intent(this,Home.class);
            intent_home.putExtra("ID_USER",id);
            startActivity(intent_home);
            finish();
    }

    @Override
    public void setMessageService(String message) {
        Toast.makeText(getApplication(),message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    public void checkPermissionLocation(){
        if (Build.VERSION.SDK_INT >= 23) {
            int accessCoarsePermission
                    = ContextCompat.checkSelfPermission(Login.this, android.Manifest.permission.ACCESS_COARSE_LOCATION);
            int accessFinePermission
                    = ContextCompat.checkSelfPermission(Login.this, android.Manifest.permission.ACCESS_FINE_LOCATION);
            if (accessCoarsePermission != PackageManager.PERMISSION_GRANTED
                    || accessFinePermission != PackageManager.PERMISSION_GRANTED) {

                String[] permissions = new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,
                        android.Manifest.permission.ACCESS_FINE_LOCATION};
                ActivityCompat.requestPermissions(Login.this, permissions,
                        REQUEST_ID_ACCESS_COURSE_FINE_LOCATION);
            }
        }
    }
}
