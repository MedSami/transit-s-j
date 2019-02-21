package com.jawaher.saida.transit_autobus.Model;

public class DataModel {

    int id;
    String nom, prenom, identifiant, email, password, numTel, type;
    String latitude,longitude;

    public DataModel(int id,String latitude,String longitude, String nom, String prenom, String identifiant, String email, String password, String numTel, String type) {
        this.id = id;
        this.nom = nom;
        this.latitude=latitude;
        this.longitude=longitude;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
