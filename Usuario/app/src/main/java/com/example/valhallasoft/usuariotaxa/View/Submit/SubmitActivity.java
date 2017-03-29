package com.example.valhallasoft.usuariotaxa.View.Submit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.valhallasoft.usuariotaxa.Presenter.Submit.SubmitPresenterImp;
import com.example.valhallasoft.usuariotaxa.R;
import com.example.valhallasoft.usuariotaxa.View.Login.LoginActivity;

public class SubmitActivity extends AppCompatActivity implements SubmitView{

    private EditText edt_email;
    private EditText edt_password;
    private EditText edt_name;
    private EditText edt_last_name;
    private EditText edt_number;
    private Button btn_submit;
    public ProgressDialog progressDialog;
    private SubmitPresenterImp presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

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
    public void setEmailError() { edt_email.setError("Favor de ingresar un correo electrónico válido");}

    @Override
    public void setPasswordError() {edt_password.setError("Favor de ingresar una contraseña de al menos 8 carácteres");}

    @Override
    public void setNameError() {edt_name.setError("Favor de ingresar su nombre");}

    @Override
    public void setLNAMEError() {edt_last_name.setError("Favor de ingresar su(s) apellido(s)");}

    @Override
    public void setNumberError() {edt_number.setError("Favor de ingresar su número telefónico de 10 dígitos");}

    @Override
    public void navigateLogin(String message) {
        Intent intent_login = new Intent(this,LoginActivity.class);
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
}
