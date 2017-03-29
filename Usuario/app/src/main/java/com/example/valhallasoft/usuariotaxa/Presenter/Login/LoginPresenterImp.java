package com.example.valhallasoft.usuariotaxa.Presenter.Login;

import com.example.valhallasoft.usuariotaxa.Interactor.Login.LoginInteractor;
import com.example.valhallasoft.usuariotaxa.Interactor.Login.LoginInteractorImp;
import com.example.valhallasoft.usuariotaxa.View.Login.LoginView;

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
    public void onSuccessFinally(int id, String email,String name, String last, String number) {
        loginView.hideProgress();
        loginView.navigateToHome(id,email,name,last,number);
    }
}