package com.taxiusuario.RetrofitAPI.ModelPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.taxiusuario.RetrofitAPI.ModelPOJO.ModelCredential;

/**
 * Created by Sandoval on 06/03/2017.
 */

public class ModelStatus {
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("sesion")
    @Expose
    private ModelCredential sesion;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ModelCredential getSesion() {
        return sesion;
    }

    public void setSesion(ModelCredential sesion) {
        this.sesion = sesion;
    }
}
