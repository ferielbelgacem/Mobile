/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.entities;

/**
 *
 * @author ferie
 */
public class Candidat {
    
    private int cin_Candidat;
    private String prenom_Candidat;
    private String nom_Candidat;
    private int age_Candidat;
    private String experience_Candidat;

    public Candidat(int cin_Candidat) {
        this.cin_Candidat = cin_Candidat;
    }
 
    public Candidat() {
    }

    public int getCin_Candidat() {
        return cin_Candidat;
    }

    public String getPrenom_Candidat() {
        return prenom_Candidat;
    }

    public String getNom_Candidat() {
        return nom_Candidat;
    }

    public int getAge_Candidat() {
        return age_Candidat;
    }

    public String getExperience_Candidat() {
        return experience_Candidat;
    }

   

    public void setCin_Candidat(int cin_Candidat) {
        this.cin_Candidat = cin_Candidat;
    }

    public void setPrenom_Candidat(String prenom_Candidat) {
        this.prenom_Candidat = prenom_Candidat;
    }

    public void setNom_Candidat(String nom_Candidat) {
        this.nom_Candidat = nom_Candidat;
    }

    public void setAge(int age_Candidat) {
        this.age_Candidat = age_Candidat;
    }

    public void setExperience_Candidat(String experience_Candidat) {
        this.experience_Candidat = experience_Candidat;
    }

    public Candidat(int cin_Candidat, String prenom_Candidat, String nom_Candidat, int age_Candidat, String experience_Candidat) {
        this.cin_Candidat = cin_Candidat;
        this.prenom_Candidat = prenom_Candidat;
        this.nom_Candidat = nom_Candidat;
        this.age_Candidat = age_Candidat ;
        this.experience_Candidat = experience_Candidat;
    }

    @Override
    public String toString() {
        return "Candidat{" + "cin_Candidat=" + cin_Candidat + ", prenom_Candidat=" + prenom_Candidat + ", nom_Candidat=" + nom_Candidat + ", age_Candidat=" + age_Candidat + ", experience_Candidat=" + experience_Candidat + "}\n";
    }

    

   
    
    
    
    
}
