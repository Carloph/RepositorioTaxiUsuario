package com.example.valhallasoft.usuariotaxa.Interactor.Submit;

import android.text.TextUtils;
import android.util.Log;

import com.example.valhallasoft.usuariotaxa.RetrofitAPI.APIClient;
import com.example.valhallasoft.usuariotaxa.RetrofitAPI.APIService;
import com.example.valhallasoft.usuariotaxa.RetrofitAPI.ModelPOJO.ModelStatus;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sandoval on 07/03/2017.
 */

public class SubmitInteractorImp implements SubmitInteractor{


    @Override
    public void Submit(final String email, final String password, final String name, final String lName, final String number, final OnSubmitFinishedListener listener) {

        boolean error = false;

        if (!isValidEmail(email)){
            listener.onEmailError();
            error = true;
            return;
        }
        else if (!isValidPassword(password)){
            listener.onPasswordError();
            error = true;
            return;
        }
        else if (TextUtils.isEmpty(name)){
            listener.onNameError();
            error = true;
            return;
        }
        else if (TextUtils.isEmpty(lName)){
            listener.onLNameError();
            error = true;
            return;
        }
        else if (isValidPhone(number)){
            listener.onNumberError();
            error = true;
            return;
        }
        else{
            APIService service = APIClient.getClient().create(APIService.class);
            Call<ModelStatus> userCall = service.submit(email,password,name,lName,number);

            userCall.enqueue(new Callback<ModelStatus>() {
                @Override
                public void onResponse(Call<ModelStatus> call, Response<ModelStatus> response) {

                    Log.e("onResponse", "" + response.body().getMessage());

                    if(response.body().getStatus()==1) {
                        listener.onSubmit(response.body().getMessage());
                    }
                    else if(response.body().getStatus()!=1){
                        listener.onMessageService(response.body().getMessage());
                    }
                    else {
                        listener.onMessageService("Error de red");
                    }
                }

                @Override
                public void onFailure(Call<ModelStatus> call, Throwable t) {
                    Log.e("onFailure", t.toString());
                }
            });
        }
    }

    public final static boolean isValidEmail(CharSequence email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        if(password.length() >= 8 && !TextUtils.isEmpty(password)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidPhone(String phone) {
        if(phone.length() != 10) {
            return !TextUtils.isEmpty(phone) && android.util.Patterns.PHONE.matcher(phone).matches();
        } else {
            return false;
        }
    }

}
