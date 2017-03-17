package com.example.valhallasoft.usuariotaxa.Interactor.Submit;

/**
 * Created by Sandoval on 07/03/2017.
 */

public interface SubmitInteractor {

    interface OnSubmitFinishedListener{

        void onEmailError();

        void onPasswordError();

        void onNameError();

        void onLNameError();

        void onNumberError();

        void onMessageService(String message);

        void onSubmit(String message);

    }
    void Submit(String email, String password, String name, String lName, String number, OnSubmitFinishedListener listener);
}
