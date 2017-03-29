package com.example.valhallasoft.usuariotaxa.View.Login;

/**
 * Created by Sandoval on 06/03/2017.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setEmailError();

    void setPasswordError();

    void navigateToHome(int id_user,String email, String name, String last, String number);

    void setMessageService(String message);

}
