/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dahamada.chezbio.model.dao;

import com.dahamada.chezbio.model.entities.Role;
import com.dahamada.chezbio.model.entities.Utilisateur;
import com.dahamada.chezbio.model.singleton.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dahamada
 */
public class UtilisateurImplDao implements UtilisateurDao{
   private static final String SQL_SELECT_UTILISATEURS = "select * from utilisateurs";
   private static final String SQL_SELECT_UTILISATEUR_PAR_NOM = "select * from utilisateurs where nom = ?";
  private static final String SQL_INSERT_UTILISATEUR = "insert into utilisateurs(email,active,nom,prenom,password, photo) value(?,?,?,?,?,?)";

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> listeUtilisateurs = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UTILISATEURS);
           
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
               
            listeUtilisateurs = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));
                listeUtilisateurs.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeUtilisateurs;
    } 
  @Override
    public Utilisateur findByName(String nom) {
          Utilisateur utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UTILISATEUR_PAR_NOM);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, nom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

    @Override
    public boolean create(Utilisateur utilisateur) {
            boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_UTILISATEUR);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setString(1, utilisateur.getEmail());
            ps.setBoolean(2, utilisateur.isActive());
            ps.setString(3, utilisateur.getNom());
            ps.setString(4, utilisateur.getPrenom());

            ps.setString(5, utilisateur.getPassword());
            ps.setString(6, utilisateur.getPhoto());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean create(Utilisateur utilisateur, String nomRol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Utilisateur utilisateur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur findByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur findByNameRole(String nomRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> findAllRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> findAllByNameRole(String nomRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur existsByEmailAndPassword(String email, String motDePasse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
