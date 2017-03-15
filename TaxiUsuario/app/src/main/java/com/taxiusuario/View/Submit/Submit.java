package com.taxiusuario.View.Submit;

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
import android.widget.Toast;

import com.taxiusuario.Presenter.Submit.SubmitPresenterImp;
import com.taxiusuario.R;
import com.taxiusuario.View.Home.Home;
import com.taxiusuario.View.Login.Login;

import static android.R.attr.id;

public class Submit extends AppCompatActivity implements SubmitView{

    private EditText edt_email;
    private EditText edt_password;
    private EditText edt_name;
    private EditText edt_last_name;
    private EditText edt_number;
    private Button btn_submit;
    public ProgressDialog progressDialog;
    private SubmitPresenterImp presenter;
    private static final int REQUEST_ID_ACCESS_COURSE_FINE_LOCATION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        checkPermissionLocation();
        presenter = new SubmitPresenterImp(this);
        progressDialog = new ProgressDialog(this);
        btn_submit = (Button)findViewById(R.id.button_register);
        edt_email = (EditText)findViewById(R.id.edt_smit_email);
        edt_password = (EditText)findViewById(R.id.edt_smit_password);
        edt_name = (EditText)findViewById(R.id.edt_smit_name);
        edt_last_name = (EditText)findViewById(R.id.edt_smit_lst_name);
        edt_number = (EditText)findViewById(R.id.edt_smit_phone_num);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.Register(
                        edt_email.getText().toString(),
                        edt_password.getText().toString(),
                        edt_name.getText().toString(),
                        edt_last_name.getText().toString(),
                        edt_number.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
        progressDialog.setTitle("Por favor, espere...");
        progressDialog.show();
    }

    @Override
    public void hideProgress() {progressDialog.dismiss();}

    @Override
    public void setEmailError() { edt_email.setError("Favor de ingresar su correo electrónico");}

    @Override
    public void setPasswordError() {edt_password.setError("Favor de ingresar su contraseña");}

    @Override
    public void setNameError() {edt_name.setError("Favor de ingresar su nombre");}

    @Override
    public void setLNAMEError() {edt_last_name.setError("Favor de ingresar su(s) apellido(s)");}

    @Override
    public void setNumberError() {edt_number.setError("Favor de ingresar su número telefónico");}

    @Override
    public void navigateLogin(String message) {
        Intent intent_login = new Intent(this,Login.class);
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        startActivity(intent_login);
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

    @Override
    public void onBackPressed() {
        onDestroy();
        super.onBackPressed();
    }

    public void checkPermissionLocation(){
        if (Build.VERSION.SDK_INT >= 23) {
            int accessCoarsePermission
                    = ContextCompat.checkSelfPermission(Submit.this, android.Manifest.permission.ACCESS_COARSE_LOCATION);
            int accessFinePermission
                    = ContextCompat.checkSelfPermission(Submit.this, android.Manifest.permission.ACCESS_FINE_LOCATION);
            if (accessCoarsePermission != PackageManager.PERMISSION_GRANTED
                    || accessFinePermission != PackageManager.PERMISSION_GRANTED) {

                String[] permissions = new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,
                        android.Manifest.permission.ACCESS_FINE_LOCATION};
                ActivityCompat.requestPermissions(Submit.this, permissions,
                        REQUEST_ID_ACCESS_COURSE_FINE_LOCATION);
            }
        }
    }
}
