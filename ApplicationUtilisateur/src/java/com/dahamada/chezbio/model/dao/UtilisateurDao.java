/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahamada.chezbio.model.dao;

import com.dahamada.chezbio.model.entities.Role;
import com.dahamada.chezbio.model.entities.Utilisateur;
import java.util.List;

/**
 *
 * @author dahamada
 */
public interface UtilisateurDao {

    List<Utilisateur> findAll();

    Utilisateur findById(int id);

    Utilisateur findByName(String nom);

    Utilisateur findByEmail(String email);

    Utilisateur findByNameRole(String nomRole);

    List<Role> findAllRole();

    List<Utilisateur> findAllByNameRole(String nomRole);

    Utilisateur existsByEmailAndPassword(String email, String motDePasse);

    boolean delete(int id);

    boolean create(Utilisateur utilisateur);

    boolean create(Utilisateur utilisateur, String nomRole);

    boolean update(Utilisateur utilisateur);

}
