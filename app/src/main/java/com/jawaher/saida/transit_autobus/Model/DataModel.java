package com.jawaher.saida.transit_autobus.Model;

public class DataModel {


    String nom, prenom, identifiant, email, password, numTel, type;
    String id,latitude,longitude,matricule;
    String titre, description, depart_latitude, depart_longitude, arriver_latitude, arriver_longitude;

    public DataModel() {
    }

    public DataModel(String id, String nom,String matricule, String prenom, String identifiant, String email, String password, String numTel, String type, String latitude, String longitude, String titre, String description, String depart_latitude, String depart_longitude, String arriver_latitude, String arriver_longitude) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule=matricule;
        this.identifiant = identifiant;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.titre = titre;
        this.description = description;
        this.depart_latitude = depart_latitude;
        this.depart_longitude = depart_longitude;
        this.arriver_latitude = arriver_latitude;
        this.arriver_longitude = arriver_longitude;
    }

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getDepart_latitude() {
        return depart_latitude;
    }

    public String getDepart_longitude() {
        return depart_longitude;
    }

    public String getArriver_latitude() {
        return arriver_latitude;
    }

    public String getArriver_longitude() {
        return arriver_longitude;
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
