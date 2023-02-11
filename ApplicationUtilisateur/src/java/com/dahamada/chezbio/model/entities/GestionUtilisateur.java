/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahamada.chezbio.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dahamada
 */
public class GestionUtilisateur {
    // Déclaration d'un tableau dynamique d'utilisateur
    // en utilisant l'interface list
    // au lieu d'utiliser les classes concrets :
    // private  ArrayList<Etudiant> liste;
    // private  Vector<Etudiant> liste;
    //  private  LinkedList<Etudiant> liste;

    private List<Utilisateur> listeUtilisateurs;

    public GestionUtilisateur() {
        // Le constructeur fait appel au constructeur 
        // de la classe ArrayListe afin de déterminer l'adresses du premier element
        // allocation d'un espace mémoire du centre mémoire de l'ordinateur
        listeUtilisateurs = new ArrayList();
        // on pourrait également utiliser Vector ou LinkedList
        // liste = new Vector();
        // liste = new LinkedList();
    }

    public List<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
        this.listeUtilisateurs = listeUtilisateurs;
    }

   public void afficherLesUtilisateurs() {
        int nbEtudiants = listeUtilisateurs.size(); // lenght

        if (nbEtudiants > 0) {
            for (Utilisateur utilisateur : listeUtilisateurs) {
                System.out.println(utilisateur);
            }

        } else {
            System.out.println(" Il n' y pa d'utilisateurs dans cette liste ");
        }
    }
    // Cette méthode permet de placer un étudiant dans la liste
    // grace à la méthode add
    public void ajouterUnUtilisateur(Utilisateur utilisateur) {

        listeUtilisateurs.add(utilisateur);
    }

    //Cette méthode permet de  Suppression d'un étudiant
    public void supprimerUnUtilisateur(int indice) {
        //  String cle = creerUneCle(p, n);
        Utilisateur utilisateur = null;
        if (indice < listeUtilisateurs.size()) {
            utilisateur = (Utilisateur) listeUtilisateurs.get(indice);
        }
        if (utilisateur != null) {
            listeUtilisateurs.remove(indice);
            System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom() + " a été supprime ");

        } else {
            System.out.println(" L'utilisateur d'indice " + indice + " n'existe pas");
        }

    }
  public void modifierUnUtilisateur( int indice){
       Scanner lectureClavier = new Scanner(System.in);
       Utilisateur utilisateur = null;
        if (indice < listeUtilisateurs.size()) {
            utilisateur = (Utilisateur) listeUtilisateurs.get(indice);
        }
        if (utilisateur != null) {
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
                    utilisateur.setEmail(email);
                    utilisateur.setActive(active);
                    utilisateur.setNom(nom);
                    utilisateur.setPrenom(prenom);
                    utilisateur.setPassword(password);
                    utilisateur.setPhoto(photo);
                    
                    //role
                     System.out.println("Quel est le role de " + nom + " " + prenom + " ? ");
                    System.out.println("Choisir entre admin, vendeur, editeur, expediteur et assistant");
                    String roleUtilisateur = lectureClavier.next();
                    String userRole = roleUtilisateur.toLowerCase();
                    Role role = new Role();
                    switch (userRole) {
                        case "admin":
                            role.setNom("admin");
                            role.setId(1);
                            role.setDescription("Peut tout faire");
                            break;
                        case "vendeur":
                            role.setNom("vendeur");
                            role.setId(2);
                            role.setDescription("Gère les prix des produits,les clients, expédition, commandes et rapport de ventes");
                            break;
                        case "editeur":
                            role.setNom("editeur");
                            role.setId(3);
                            role.setDescription("Gère les categories, les produits");
                            break;
                        case "expéditeur":
                            role.setNom("expéditeur");
                            role.setId(4);
                            role.setDescription("Peut voir les products,peut voir les commandes");
                            break;
                        case "assistant":
                            role.setNom("assistant");
                            role.setId(5);
                            role.setDescription("Gère les questions et Commentaires");
                            break;
                        default:
                            System.out.println("ce role existe pas");
                            break;
                    }

                    utilisateur.ajouter(role);
                   
            System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom() + " a été modifié ");

        } else {
            System.out.println(" L'utilisateur d'indice " + indice + " n'existe pas");
        }
  
  }


    public Utilisateur chercherUtilisateurParId(int id) {

        Utilisateur utilisateurTrouve = null;
        for (Utilisateur utilisateur : listeUtilisateurs) {
            if (utilisateur.getId() == id) {
                utilisateurTrouve = utilisateur;

                break;

            } else {
                System.out.println("L'etudiant n'existe pas");
            }
        }
        return utilisateurTrouve;
    }

    public Utilisateur chercherUtilisateurParNom(String nom) {

        Utilisateur utilisateurTrouve = null;
        for (Utilisateur utilisateur : listeUtilisateurs) {
            if (utilisateur.getNom().toLowerCase().equals(nom.toLowerCase())) {
                utilisateurTrouve = utilisateur;

            }
        }
        return utilisateurTrouve;
    }

    public Utilisateur chercherUtilisateurParEmail(String email) {

        Utilisateur utilisateurTrouve = null;
        for (Utilisateur utilisateur : listeUtilisateurs) {
            if (utilisateur.getEmail().toLowerCase().equals(email.toLowerCase())) {
                utilisateurTrouve = utilisateur;

            }
        }
        return utilisateurTrouve;
    }

    // Cette method parcourt l'ensemble de la liste
    // gâce à la méthode size qui renvoie le nombre des étudiants
 

    public boolean verifierEmailMotDePasse(String email, String motDePasse) {
        boolean valid = false;
        for (Utilisateur utilisateur : listeUtilisateurs) {
            if (utilisateur.getEmail().equalsIgnoreCase(email) && utilisateur.getPassword().equalsIgnoreCase(motDePasse)) {
                valid = true;

            }
        }
        return valid;
    }

    public void ajouterUnRoleAUtilisateur(Utilisateur utilisateur, Role role) {

        for (Utilisateur chercherUtilisateur : listeUtilisateurs) {
            if (chercherUtilisateur != null) {
                chercherUtilisateur.ajouter(role);
            }

        }

    }


    public Utilisateur chercherUtilisateurParNomRole(String nomRole) {

        Utilisateur utilisateurTrouve = null;
        for (Utilisateur utilisateur : listeUtilisateurs) {

    
            List<Role> listeRoles = utilisateur.getRoles();
      
            for (Role role : listeRoles) {
                if (role.getNom() != null) {
              
                    if (role.getNom().equalsIgnoreCase(nomRole)) {
                        //   listeUtilisateurParRoleAdmin.add(utilisateur);
                        utilisateurTrouve = utilisateur;
                         break;
                    }
                }

            }
        

        }
        return utilisateurTrouve;
    }

 public List<Utilisateur> trierUtilisateursParRole(String nomRole) {
    List<Utilisateur> listeUtilisateurParRole = new ArrayList();
    for (Utilisateur utilisateur : listeUtilisateurs) {
        List<Role> listeRoles = utilisateur.getRoles();
        for (Role role : listeRoles) {
            if (role.getNom().equalsIgnoreCase(nomRole)) {
                listeUtilisateurParRole.add(utilisateur);
                break;
            }
        }
    }
    return listeUtilisateurParRole;
}
}
