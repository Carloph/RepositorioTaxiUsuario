package com.example.valhallasoft.usuariotaxa.Presenter.Submit;

import com.example.valhallasoft.usuariotaxa.Interactor.Submit.SubmitInteractor;
import com.example.valhallasoft.usuariotaxa.Interactor.Submit.SubmitInteractorImp;
import com.example.valhallasoft.usuariotaxa.View.Submit.SubmitView;

/**
 * Created by Sandoval on 07/03/2017.
 */

public class SubmitPresenterImp implements SubmitPresenter, SubmitInteractor.OnSubmitFinishedListener{

    private SubmitView submitView;
    private SubmitInteractorImp submitInteractorImp;

    public SubmitPresenterImp(SubmitView submitView){
        this.submitView = submitView;
        this.submitInteractorImp = new SubmitInteractorImp();
    }

    @Override
    public void Register(String email, String password, String name, String lName, String number) {
        if(submitView!=null){
            submitView.showProgress();
        }
        submitInteractorImp.Submit(email,password,name,lName,number,this);
    }

    @Override
    public void onDestroy() {
        submitView = null;
    }

    @Override
    public void onEmailError() {
        if(submitView!=null){
            submitView.setEmailError();
            submitView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if(submitView!=null){
            submitView.setPasswordError();
            submitView.hideProgress();
        }
    }

    @Override
    public void onNameError() {
        if(submitView!=null){
            submitView.setNameError();
            submitView.hideProgress();
        }
    }

    @Override
    public void onLNameError() {
        if(submitView!=null){
            submitView.setLNAMEError();
            submitView.hideProgress();
        }
    }

    @Override
    public void onNumberError() {
        if(submitView!=null){
            submitView.setNumberError();
            submitView.hideProgress();
        }
    }

    @Override
    public void onMessageService(String message) {
        submitView.hideProgress();
        submitView.setMessageService(message);
    }

    @Override
    public void onSubmit(String message) {
        submitView.hideProgress();
        submitView.navigateLogin(message);
    }
}
