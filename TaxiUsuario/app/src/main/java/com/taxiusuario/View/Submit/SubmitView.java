package com.taxiusuario.View.Submit;

/**
 * Created by Sandoval on 07/03/2017.
 */

public interface SubmitView {

    void showProgress();

    void hideProgress();

    void setEmailError();

    void setPasswordError();

    void setNameError();

    void setLNAMEError();

    void setNumberError();

    void navigateLogin(String message);

    void setMessageService(String message);

}
