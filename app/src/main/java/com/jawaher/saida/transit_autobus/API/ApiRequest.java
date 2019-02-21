package com.jawaher.saida.transit_autobus.API;

import com.jawaher.saida.transit_autobus.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {



    /******************** Authentification Login*******************/
    @GET("Login.php")
    Call<ResponseDataModel> Login(@Query("identifiant") String pseudo);
    /************** Select Arrets ****************/
    @GET("SelectArrets.php")
    Call<ResponseDataModel> getArrets(@Query("id") String id_chauffeur);



}
