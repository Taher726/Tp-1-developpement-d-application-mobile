package com.example.applicationtpdevmobile.model;

public class User {
    private String nom;
    private String mdp;

    public User(String nom, String mdp){
        this.nom = nom;
        this.mdp = mdp;
    }

    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return this.nom;
    }
    public void setMdp(String mdp){
        this.mdp = mdp;
    }
    public String getMdp(){
        return this.mdp;
    }
}
