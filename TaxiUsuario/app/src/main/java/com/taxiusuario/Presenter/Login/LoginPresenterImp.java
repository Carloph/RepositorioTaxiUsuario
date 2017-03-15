package com.taxiusuario.Presenter.Login;

import com.taxiusuario.Interactor.Login.LoginInteractor;
import com.taxiusuario.Interactor.Login.LoginInteractorImp;
import com.taxiusuario.View.Login.LoginView;

/**
 * Created by Sandoval on 06/03/2017.
 */

public class LoginPresenterImp implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractorImp loginInteractor;

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImp();
    }

    @Override
    public void validateCredentials(String username, String password){
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setEmailError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onMessageService(String message) {
        loginView.setMessageService(message);
        loginView.hideProgress();
    }

    @Override
    public void onSuccessFinally(int status) {
        loginView.navigateToHome(status);
    }
}