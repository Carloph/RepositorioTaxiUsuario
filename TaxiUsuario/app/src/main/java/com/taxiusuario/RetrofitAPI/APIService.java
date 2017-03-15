package com.taxiusuario.RetrofitAPI;

import com.taxiusuario.RetrofitAPI.ModelPOJO.ModelStatus;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Sandoval on 06/03/2017.
 */

public interface APIService {

    @GET("login.php")
    Call<ModelStatus> verificationLogin(@Query("EMAIL") String email,
                                        @Query("CONTRASENIA") String password);
    @FormUrlEncoded
    @POST("submit.php")
    Call<ModelStatus> submit(@Field("EMAIL") String email,
                             @Field("CONTRASENIA") String contrasenia,
                             @Field("NOMBRE") String nombre,
                             @Field("APELLIDOS") String apellidos,
                             @Field("CELULAR") String celular);

}
