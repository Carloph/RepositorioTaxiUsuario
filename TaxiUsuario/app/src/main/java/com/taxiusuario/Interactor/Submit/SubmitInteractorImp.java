package com.taxiusuario.Interactor.Submit;

import android.text.TextUtils;
import android.util.Log;

import com.taxiusuario.Interactor.Login.LoginInteractor;
import com.taxiusuario.RetrofitAPI.APIClient;
import com.taxiusuario.RetrofitAPI.APIService;
import com.taxiusuario.RetrofitAPI.ModelPOJO.ModelStatus;

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
        if (TextUtils.isEmpty(email)){
            listener.onEmailError();
            error = true;
            return;
        }
        else if (TextUtils.isEmpty(password)){
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
        else if (TextUtils.isEmpty(number)){
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

                    if(response.body().getStatus()>=1) {

                        listener.onSubmit(response.body().getMessage());

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
}
