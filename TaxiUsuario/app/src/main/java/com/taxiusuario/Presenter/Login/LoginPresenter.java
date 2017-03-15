package com.taxiusuario.Presenter.Login;

/**
 * Created by Sandoval on 06/03/2017.
 */

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
