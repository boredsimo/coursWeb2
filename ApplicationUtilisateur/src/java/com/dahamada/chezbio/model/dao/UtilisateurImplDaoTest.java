/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahamada.chezbio.model.dao;

import com.dahamada.chezbio.model.entities.Role;
import com.dahamada.chezbio.model.entities.Utilisateur;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dahamada
 */
public class UtilisateurImplDaoTest {

    public static void main(String[] args) {
    testFindAll();
     testFindByName();
     testCreate();
      testFindAll();
      
    }

    public static void testFindAll() {
        System.out.println("findAll");
        UtilisateurImplDao instance = new UtilisateurImplDao();
        // List<Utilisateur> expResult = null;
        List<Utilisateur> result = instance.findAll();
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Utilisateur utilisateur : result) {
            System.out.println(utilisateur.toString());
        }
    }
  public static void testFindByName() {
        System.out.println("findByName");
        String nom = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        nom = lectureClavier.next();
        Utilisateur result = instance.findByName(nom);
        System.out.println(result.toString());

    }
    public static void testCreate() {
        System.out.println("create");
        Utilisateur utilisateur = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez email ");
        String email = lectureClavier.next();
        System.out.println("L'utilisateur est-il actif(oui/non)?");
        String reponse = lectureClavier.next();
        boolean active = reponse.equals("oui") ? true : false;

        System.out.println("Entrez le nom de l'utilisateur");
        String nom = lectureClavier.next();
        System.out.println("Entrez le prenom ");
        String prenom = lectureClavier.next();
        System.out.println("Entrez password");
        String password = lectureClavier.next();
        System.out.println("Entrez la photo");
        String photo = lectureClavier.next();
        utilisateur = new Utilisateur(email, active, nom, prenom, password, photo);
     
        boolean result = instance.create(utilisateur);
        if (result) {
            System.out.println("insertion reussite");
        } else {
            System.out.println("insertion echec ");
        }

    }

  
}
