package com.example.valhallasoft.usuariotaxa.Interactor.Login;

import android.text.TextUtils;
import android.util.Log;

import com.example.valhallasoft.usuariotaxa.RetrofitAPI.APIClient;
import com.example.valhallasoft.usuariotaxa.RetrofitAPI.APIService;
import com.example.valhallasoft.usuariotaxa.RetrofitAPI.ModelPOJO.ModelStatus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sandoval on 06/03/2017.
 */

public class LoginInteractorImp implements LoginInteractor{


    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener){

        boolean error = false;
        if (!isValidEmail(username)){
            listener.onUsernameError();
            error = true;
            return;
        }
        else if (TextUtils.isEmpty(password)){
            listener.onPasswordError();
            error = true;
            return;
        }
        else{

            APIService service = APIClient.getClient().create(APIService.class);
            Call<ModelStatus> userCall = service.verificationLogin(username,password);

            userCall.enqueue(new Callback<ModelStatus>() {
                @Override
                public void onResponse(Call<ModelStatus> call, Response<ModelStatus> response) {

                    Log.e("onResponse", "" + response.body().getMessage());

                    if(response.body().getStatus()==1) {

                        listener.onSuccessFinally(
                                response.body().getSesion().getIDUSER(),
                                response.body().getSesion().getEmail(),
                                response.body().getSesion().getName(),
                                response.body().getSesion().getLastName(),
                                response.body().getSesion().getNumber());

                    }else if(response.body().getStatus()!=1) {

                        listener.onMessageService(response.body().getMessage());

                    }else {
                        listener.onMessageService("Error de conexión, intente de nuevo");
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
}
