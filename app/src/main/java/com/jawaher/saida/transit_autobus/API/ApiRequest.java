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
    Call<ResponseDataModel> Login(@Query("identifiant") String pseudo,
                                  @Query("type") String type);
    /************** Select Arrets ****************/
    @GET("SelectArrets.php")
    Call<ResponseDataModel> getArrets(@Query("id") String id_chauffeur);
/************** Select Voyages ****************/
    @GET("SelectVoyage.php")
    Call<ResponseDataModel> getVoyage();

    /************** Select Voyages & Bus****************/
    @GET("SelectBus.php")
    Call<ResponseDataModel> getVoyageBus();
    /******************** Supprimer Reservation*******************/
    @GET("SupprimerReservation.php")
    Call<ResponseDataModel> SuppReservation(@Query("idVoyage") String idVoyage);
    /*************** Inscrire  *******************/
    @FormUrlEncoded
    @POST("Inscrire.php")
    Call<ResponseDataModel> Inscrire(
            @Field("nom") String nom,
            @Field("prenom") String prenom,
            @Field("identifiant") String identfiant,
            @Field("email") String email,
            @Field("password") String password,
            @Field("numTel") String numTel
    );
    /*************** Inscrire  *******************/
    @FormUrlEncoded
    @POST("Reservation.php")
    Call<ResponseDataModel> Reservation(
            @Field("idClient") String idClient,
            @Field("idVoyage") String idVoyage);

    /************** Select Reservation ****************/
    @GET("SelectReservation.php")
    Call<ResponseDataModel> getReservation(@Query("idClient") String idClient);

}
