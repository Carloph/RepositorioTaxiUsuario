package com.taxiusuario.RetrofitAPI.ModelPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sandoval on 06/03/2017.
 */

public class ModelCredential {
    @SerializedName("ID_USER")
    @Expose
    private int iDUSER;

    public int getIDUSER() {
        return iDUSER;
    }

    public void setIDUSER(int iDCHOFER) {
        this.iDUSER = iDCHOFER;
    }
}
