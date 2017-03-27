package com.example.valhallasoft.usuariotaxa.Interactor.Login;

/**
 * Created by Sandoval on 06/03/2017.
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener {

        void onUsernameError();

        void onPasswordError();

        void onMessageService(String message);

        void onSuccessFinally(int id, String name, String last, String number);
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}
