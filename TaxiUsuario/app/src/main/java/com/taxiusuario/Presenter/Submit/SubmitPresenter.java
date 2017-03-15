package com.taxiusuario.Presenter.Submit;

/**
 * Created by Sandoval on 07/03/2017.
 */

public interface SubmitPresenter {
    void Register(String email, String password, String name, String lName, String number);

    void onDestroy();
}
