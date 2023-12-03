package com.example.applicationtpdevmobile.controller;

import com.example.applicationtpdevmobile.model.Patient;

public class Controller {
    //L’attribut de la classe (Patient)
    public Patient patient;

    public Controller(){

    }

    //La méthode “createPatient()” initialise le modèle par les propriétés d’un patient donné par l’utilisateur.
    public int createPatient(int age, boolean jeunez, String mesure){
        if (age <= 0 && mesure.isEmpty()) {
            return 1;
        }else if( age <=0)
            return -1;
        else if (mesure.isEmpty())
            return -2;
        float valmesure = Float.parseFloat(mesure);
        patient = new Patient(age, jeunez, valmesure);
        return 0;
    }

    //La méthode “getResponse()” qui retourne le résultat de l’analyse du niveau de glycémie.
    public String getResponse(){
        return this.patient.getReponse();
    }
}
