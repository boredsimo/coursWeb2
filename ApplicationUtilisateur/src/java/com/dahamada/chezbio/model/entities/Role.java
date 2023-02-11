/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahamada.chezbio.model.entities;

import java.io.Serializable;

/**
 *
 * @author dahamada
 */
public class Role implements Serializable{

    private int id;
    private String nom;
    private String description;

    public Role() {
    }

    public Role(int id) {
        this.id = id;
    }

    public Role(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public Role(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

         public String afficherTitreDesColonnes() {
         String message = "";
       message = String.format(" %-10s  %10s  %20s","Id","Nom","Description"); 
       message+="\n --------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message += String.format(" %-5d  %15s %30s ",this.id,this.nom, this.description); 
       return message;
    }

}
