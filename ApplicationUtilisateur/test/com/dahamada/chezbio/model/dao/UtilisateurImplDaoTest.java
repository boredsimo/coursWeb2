/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.dahamada.chezbio.model.dao;

import com.dahamada.chezbio.model.entities.Role;
import com.dahamada.chezbio.model.entities.Utilisateur;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dahamada
 */
public class UtilisateurImplDaoTest {
    
    public UtilisateurImplDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
     @Test
   public  void testFindAll() {
        System.out.println("findAll");
        UtilisateurImplDao instance = new UtilisateurImplDao();
        List<Utilisateur> expResult = null;
        List<Utilisateur> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    
    }

    /**
     * Test of findById method, of class UtilisateurImplDao.
     */
    
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Utilisateur expResult = null;
        Utilisateur result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class UtilisateurImplDao.
     */
   @Test
    public void testFindByName() {
        System.out.println("findByName");
        String nom = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Utilisateur expResult = null;
        Utilisateur result = instance.findByName(nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEmail method, of class UtilisateurImplDao.
     */
   @Test
    public void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Utilisateur expResult = null;
        Utilisateur result = instance.findByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UtilisateurImplDao.
     */
   @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class UtilisateurImplDao.
     */
       @Test
    public void testCreate() {
        System.out.println("create");
        Utilisateur utilisateur = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.create(utilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UtilisateurImplDao.
     */
   
    public void testUpdate() {
        System.out.println("update");
        Utilisateur utilisateur = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.update(utilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existsByEmailAndPassword method, of class UtilisateurImplDao.
     */
    
    public void testExistsByEmailAndPassword() {
        System.out.println("existsByEmailAndPassword");
        String email = "";
        String motDePasse = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Utilisateur expResult = null;
        Utilisateur result = instance.existsByEmailAndPassword(email, motDePasse);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class UtilisateurImplDao.
     */
    @Test
    public void testCreate_Utilisateur() {
        System.out.println("create");
        Utilisateur utilisateur = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.create(utilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class UtilisateurImplDao.
     */
    @Test
    public void testCreate_Utilisateur_Role() {
        System.out.println("create");
        Utilisateur utilisateur = null;
        String role = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.create(utilisateur, role);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class UtilisateurImplDao.
     */
    @Test
    public void testCreate_Utilisateur_String() {
        System.out.println("create");
        Utilisateur utilisateur = null;
        String nomRole = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.create(utilisateur, nomRole);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllRole method, of class UtilisateurImplDao.
     */
    @Test
    public void testFindAllRole() {
        System.out.println("findAllRole");
        UtilisateurImplDao instance = new UtilisateurImplDao();
        List<Role> expResult = null;
        List<Role> result = instance.findAllRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByNameRole method, of class UtilisateurImplDao.
     */
  

    /**
     * Test of findByNameRole method, of class UtilisateurImplDao.
     */
    @Test
    public void testFindByIdRole() {
        System.out.println("findByIdRole");
         String nomRole = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Utilisateur expResult = null;
        Utilisateur result = instance.findByNameRole(nomRole);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
