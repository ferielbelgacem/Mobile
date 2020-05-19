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
public class Employe {
       private int  id;
   private  String prenom_condidat;
      private  String nom_condidat;
   private int age;
   private String role;
     private int nbr_heure;
        private int nbr_conge;
    private  float salaire;
   private float prime;
   private int user;

    @Override
    public String toString() {
        return "Employes{" + "id=" + id + ", prenom_condidat=" + prenom_condidat + ", nom_condidat=" + nom_condidat + ", age=" + age + ", role=" + role + ", nbr_heure=" + nbr_heure + ", nbr_conge=" + nbr_conge + ", salaire=" + salaire + ", prime=" + prime + '}';
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Employe(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public Employe(int id, String prenom_condidat, String nom_condidat, int age, String role, int nbr_heure, int nbr_conge, float salaire, float prime) {
        this.id = id;
        this.prenom_condidat = prenom_condidat;
        this.nom_condidat = nom_condidat;
        this.age = age;
        this.role = role;
        this.nbr_heure = nbr_heure;
        this.nbr_conge = nbr_conge;
        this.salaire = salaire;
        this.prime = prime;
    }
 public Employe( String prenom_condidat, String nom_condidat, int age, String role, int nbr_heure, int nbr_conge, float salaire, float prime) {
        this.prenom_condidat = prenom_condidat;
        this.nom_condidat = nom_condidat;
        this.age = age;
        this.role = role;
        this.nbr_heure = nbr_heure;
        this.nbr_conge = nbr_conge;
        this.salaire = salaire;
        this.prime = prime;
    }
    public Employe() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrenom_condidat(String prenom_condidat) {
        this.prenom_condidat = prenom_condidat;
    }

    public void setNom_condidat(String nom_condidat) {
        this.nom_condidat = nom_condidat;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNbr_heure(int nbr_heure) {
        this.nbr_heure = nbr_heure;
    }

    public void setNbr_conge(int nbr_conge) {
        this.nbr_conge = nbr_conge;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }

    public int getId() {
        return id;
    }

    public String getPrenom_condidat() {
        return prenom_condidat;
    }

    public String getNom_condidat() {
        return nom_condidat;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public int getNbr_heure() {
        return nbr_heure;
    }

    public int getNbr_conge() {
        return nbr_conge;
    }

    public float getSalaire() {
        return salaire;
    }

    public float getPrime() {
        return prime;
    }
 

 

   
    
}
