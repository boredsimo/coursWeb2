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

  
}
