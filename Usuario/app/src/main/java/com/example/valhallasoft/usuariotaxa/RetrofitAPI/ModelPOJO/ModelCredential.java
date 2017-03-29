package com.example.valhallasoft.usuariotaxa.RetrofitAPI.ModelPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sandoval on 06/03/2017.
 */

public class ModelCredential {
    @SerializedName("ID_CLIENTE")
    @Expose
    private int iDUSER;

    @SerializedName("EMAIL")
    @Expose
    private String email;

    @SerializedName("CONTRASENIA")
    @Expose
    private String password;

    @SerializedName("NOMBRE")
    @Expose
    private String name;

    @SerializedName("APELLIDOS")
    @Expose
    private String lastName;

    @SerializedName("CELULAR")
    @Expose
    private String number;

    public int getIDUSER() {
        return iDUSER;
    }

    public void setIDUSER(int iDCHOFER) {
        this.iDUSER = iDCHOFER;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getNumber() {return number;}

    public void setNumber(String number) {this.number = number;}
}
