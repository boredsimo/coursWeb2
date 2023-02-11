/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahamada.chezbio.model.entities;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dahamada
 */
public class TestGestionUtilisateur {

    public static void main(String[] args) {
// déclartion des variables
        GestionUtilisateur donneesUtilisateurs = null;
        Utilisateur utilisateurTrouve = null;
        Scanner lectureClavier = new Scanner(System.in);
        GestionUtilisateur gestionUtilisateur = new GestionUtilisateur();
        donneesUtilisateurs = datasource(gestionUtilisateur);
        int id;
        String email;
        boolean active;
        String nom;
        String prenom;
        String password;
        String photo;
     
    
        byte choix = 0;

        do {
            afficherMenu();
            choix = lectureClavier.nextByte();
            switch (choix) {
                case 1:
                    Utilisateur utilisateur = new Utilisateur();
                    System.out.println(utilisateur.afficherTitreDesColonnes());
                    donneesUtilisateurs.afficherLesUtilisateurs();
                    break;
                case 2:
                    System.out.println("Entrez l'email de l'utilisateur ");
                    String email1 = lectureClavier.next();
                    System.out.println("Entrez le password de l'utilisateur ");
                    String password1 = lectureClavier.next();
                    if (donneesUtilisateurs.verifierEmailMotDePasse(email1, password1)) {

                        System.out.println("Connexion");
                        utilisateurTrouve = donneesUtilisateurs.chercherUtilisateurParEmail(email1);
                        for (Role role1 : utilisateurTrouve.getRoles()) {
                            if (role1 != null) {
                             
                                if (role1.getNom().toLowerCase().equalsIgnoreCase("admin")) {
                                    do {
                                        afficherMenuAdministrateur();
                                        choix = lectureClavier.nextByte();
                                        switch (choix) {
                                            case 1:
                                                System.out.println("Entrez l'id de l'utilisateur à supprimer ");
                                                byte indice = lectureClavier.nextByte();
                                                donneesUtilisateurs.supprimerUnUtilisateur(indice);
                                                break;
                                            case 2:
                                                System.out.println("Entrez l'id de l'utilisateur à modifier ");
                                                id = lectureClavier.nextByte();
                                                utilisateurTrouve = donneesUtilisateurs.chercherUtilisateurParId(id);
                                                System.out.println(utilisateurTrouve.toString());
                                                donneesUtilisateurs.modifierUnUtilisateur(id);
                                                break;
                                            case 3:
                                                afficherMenu();
                                                break;

                                            default:
                                                System.out.println("Option invalid");
                                                break;
                                        }

                                    } while (choix != 3);

                                }
                            }
                        }

                    } else {
                        System.out.println("Identifiant Invalide ");
                    }

                    break;
                case 3:
                    System.out.println("Entrez l'id de l'utilisateur");
                    id = lectureClavier.nextInt();
                    System.out.println("Entrez email ");
                     email = lectureClavier.next();
                    for (Utilisateur user : donneesUtilisateurs.getListeUtilisateurs()) {
                        if (user.getId() == id) {
                            System.out.println("un utilisateur existe déjà avec le même id : " + id);
                            System.out.println("Entrez un autre id");
                            id = lectureClavier.nextInt();
                            if (user.getEmail().equals(email)) {
                                System.out.println("un utilisateur existe déjà avec le même email : " + email);
                                System.out.println("Entrez un autre email ");
                                email = lectureClavier.next();
                            }
                        }
                    }
                    System.out.println("L'utilisateur est-il actif(oui/non)?");
                    String reponse = lectureClavier.next();
                    active = reponse.equals("oui") ? true : false;

                    System.out.println("Entrez le nom de l'utilisateur");
                     nom = lectureClavier.next();
                    System.out.println("Entrez le prenom ");
                    prenom = lectureClavier.next();
                    System.out.println("Entrez password");
                    password = lectureClavier.next();
                    System.out.println("Entrez la photo");
                     photo = lectureClavier.next();
                    for (int i = 0; i < donneesUtilisateurs.getListeUtilisateurs().size(); i++) {
                        if (donneesUtilisateurs.getListeUtilisateurs().get(i).getId() == id) {
                            System.out.println("un utilisateur existe déjà avec le même id : " + id);
                            System.out.println("Entrez un autre id");
                            id = lectureClavier.nextInt();
                            if (donneesUtilisateurs.getListeUtilisateurs().get(i).getEmail().equals(email)) {
                                System.out.println("un utilisateur existe déjà avec le même email : " + email);
                                System.out.println("Entrez un autre email ");
                                email = lectureClavier.next();
                            }
                        }

                    }

                    utilisateurTrouve = new Utilisateur(id, email, active, nom, prenom, password, photo);
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

                    utilisateurTrouve.ajouter(role);
                    donneesUtilisateurs.ajouterUnUtilisateur(utilisateurTrouve);
                    break;
                case 4:
                    System.out.println("Entrez l'id de l'utilisateur à chercher ");
                    id = lectureClavier.nextInt();
                    utilisateurTrouve = donneesUtilisateurs.chercherUtilisateurParId(id);
                    System.out.println(utilisateurTrouve.toString());
                    break;
                case 5:
                    System.out.println("Entrez le nom de l'utilisateur à chercher ");
                    nom = lectureClavier.next();
                    utilisateurTrouve = donneesUtilisateurs.chercherUtilisateurParNom(nom);
                    System.out.println(utilisateurTrouve.toString());

                    break;
                case 6:
                    System.out.println("Entrez l'email de l'utilisateur à chercher ");
                    email = lectureClavier.next();
                    utilisateurTrouve = donneesUtilisateurs.chercherUtilisateurParEmail(email);
                    System.out.println(utilisateurTrouve.toString());
                    break;
                case 7:
                    System.out.println("Entrez le nom du categorie de role à chercher ");
                    nom = lectureClavier.next();
                    String message = "";
                    message = String.format(" %-10s  %30s %15s %15s %15s %15s %25s  %-10s %10s %20s", "Id", "Email", "Active", "Nom", "Prenom",
                            "Password", "Photo", "IdRole", "NomRole", "Description");
                    message += "\n -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
                    System.out.println(message);
                    for (Utilisateur utilisateur1 : donneesUtilisateurs.trierUtilisateursParRole(nom)) {
                        if (utilisateur1 != null) {
                            //  System.out.println(utilisateur1.afficherTitreDesColonnes());
                            //System.out.println(utilisateur1.toString());
                            for (Role role1 : utilisateur1.getRoles()) {
                                if (role1 != null) {
                                    //   System.out.println(role1.afficherTitreDesColonnes());
                                    System.out.println(utilisateur1.toString() + "   " + role1.toString());
                                }
                            }
                        }

                    }
                    break;
           
                case 8:
                    System.out.println("liste des roles : ");
                    for (Utilisateur utilisateur1 : donneesUtilisateurs.getListeUtilisateurs()) {
                        //   List<Role> listeRoles = utilisateur1.getRoles();
                        if (utilisateur1 != null) {
                            //  System.out.println("utilisateur1  : " + utilisateur1.getNom());
                            for (Role roleParUtilisateur : utilisateur1.getRoles()) {
                                //  System.out.println("roleParUtilisateur : " + roleParUtilisateur);
                                if (roleParUtilisateur.getNom() != null) {
                                    if (roleParUtilisateur.getId() == 1 || roleParUtilisateur.getNom().equalsIgnoreCase("admin") || roleParUtilisateur.getDescription().contains("Peut tout faire")) {
                                        System.out.println(utilisateur1.getNom() + " : " + roleParUtilisateur.getNom());
                                    } else if (roleParUtilisateur.getId() == 2 || roleParUtilisateur.getNom().equalsIgnoreCase("Vendre") || roleParUtilisateur.getDescription().contains("Gère les prix")) {
                                        System.out.println(utilisateur1.getNom() + " : " + roleParUtilisateur.getNom());
                                    } else if (roleParUtilisateur.getId() == 3 || roleParUtilisateur.getNom().equalsIgnoreCase("Editeur") || roleParUtilisateur.getDescription().contains("Gère les catégories")) {
                                        System.out.println(utilisateur1.getNom() + " : " + roleParUtilisateur.getNom());
                                    } else if (roleParUtilisateur.getId() == 4 || roleParUtilisateur.getNom().equalsIgnoreCase("Expéditeur") || roleParUtilisateur.getDescription().contains("Peut voir les produits")) {
                                        System.out.println(utilisateur1.getNom() + " : " + roleParUtilisateur.getNom());
                                    } else if (roleParUtilisateur.getId() == 5 || roleParUtilisateur.getNom().equalsIgnoreCase("Assistant") || roleParUtilisateur.getDescription().contains("Gère les questions et Commentaires")) {
                                        System.out.println(utilisateur1.getNom() + " : " + roleParUtilisateur.getNom());
                                    }
                                }

                            }

                        }

                    }
                    break;
                case 9:
                    System.out.println("Au revoir ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Cette option n'existe pas ");
            }

        } while (choix != 9);

    }

    public static void afficherMenu() {
        System.out.println("1. Afficher la liste des utilisateurs ");
        System.out.println("2. Se connecter ");
        System.out.println("3. Ajouter un utilisateur ");
        System.out.println("4. Chercher un utilisateur par id ");
        System.out.println("5. Chercher un utilisateur par nom ");
        System.out.println("6. Chercher un utilisateur par email ");
        System.out.println("7. Trier les utilisateurs par rôle ");
        System.out.println("8. Afficher le nom des utilisateurs et leur role ");
        System.out.println("9. Pour quitter  ");
        System.out.println("Faire votre choix : ");

    }

    public static void afficherMenuAdministrateur() {
        System.out.println("La liste des actions d'un adminsitrateur ");
        System.out.println("1. Supprimer un utilisateur ");
        System.out.println("2. Modifier un utilisateur ");

        System.out.println("3. Revenir au menu principal");
        System.out.println("Faire votre choix : ");

    }

    public static GestionUtilisateur datasource(GestionUtilisateur listeUtilisateur) {
        Role role = null;
        Utilisateur utilisateur;
         role = new Role(1, "Admin", "Peut tout faire");
        utilisateur = new Utilisateur(0, "root@gmail.com", true, "Root", "Root", "root", "root.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(1, "Admin", "Peut tout faire");
        utilisateur = new Utilisateur(1, "willsmith@gmail.com", true, "Will", "Smith", "Smith123", "WillSmith.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(1, "Admin", "Peut tout faire");
        utilisateur = new Utilisateur(2, "kanna.allada@gmail.com", true, "Allada", "Pavan", "Pavan123", "Allada Pavan.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(2, "Vendeur", "Peut tout faire");
        utilisateur = new Utilisateur(3, "aecllc.bnk@gmail.com", false, "Bruce", "Kitchell", "Kitchell123", "Bruce Kitchell.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);

        role = new Role(3, "Editeur", "Gère les categories, les produits");
        utilisateur = new Utilisateur(4, "muhammad.evran13@gmail.com", true, "Muhammad", "Evran", "Evran123", "Muhammad Evran.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(5, "Assistant", "Gère les questions et Commentaires");
        utilisateur = new Utilisateur(5, "kent.hervey8@gmail.com", true, "Kent", "Hervey", "Hervey123", "KentHervey.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(3, "Editeur", "Gère les categories, les produits");
        utilisateur = new Utilisateur(6, "alfredephraim26@gmail.com", false, "Alfred", "Ephraim", "Ephraim123", "Alfred.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(3, "Editeur", "Gère les categories, les produits");
        utilisateur = new Utilisateur(7, "nathihsa@gmail.com", true, "Nathi", "Sangweni", "Sangweni123", "Nathi_Sangweni.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(3, "Editeur", "Gère les categories, les produits");
        utilisateur = new Utilisateur(8, "ammanollashirisha2020@gmail.com", true, "Ammanolla", "Shirisha", "Shirisha123", "Ammanolla.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(2, "Vendeur", "Gère les prix des produits,les clients, expédition, commandes et rapport de ventes");
        utilisateur = new Utilisateur(9, "bfeeny238@hotmail.com", true, "Bill", "Feeny", "Feeny123", "Bill Feeny.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(2, "Vendeur", "Gère les prix des produits,les clients, expédition, commandes et rapport de ventes");
        utilisateur = new Utilisateur(10, "redsantosph@gmail.com", true, "Frederick", "Delos Santos", "Santos123", "Frederick Santos.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(3, "Editeur", "Gère les categories, les produits");
        utilisateur = new Utilisateur(11, "ro_anamaria@mail.ru", true, "Ana", "Maria", "Maria123", "Anna Maria.jpg");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);
        role = new Role(4, "Expéditeur", "Peut voir les products,peut voir les commandes");
        utilisateur = new Utilisateur(12, "maytassatya@hotmail.com", false, "Satya", "Narayana", "Narayana123", "Satya Narayana.png");
        utilisateur.ajouter(role);
        listeUtilisateur.ajouterUnUtilisateur(utilisateur);

        /*
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(2, "kanna.allada@gmail.com", true, "Allada", "Pavan", "Pavan123", "Allada Pavan.png"));
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(3, "aecllc.bnk@gmail.com", false, "Bruce", "Kitchell", "Kitchell123", "Bruce Kitchell.png"));
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(4, "muhammad.evran13@gmail.com", true, "Muhammad", "Evran", "Evran123", "Muhammad Evran.png"));
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(5, "kent.hervey8@gmail.com", true, "Kent", "Hervey", "Hervey123", "KentHervey.png"));
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(6, "alfredephraim26@gmail.com", false, "Alfred", "Ephraim", "Ephraim123", "Alfred.png"));
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(7, "nathihsa@gmail.com", true, "Nathi", "Sangweni", "Sangweni123", "Nathi_Sangweni.png"));
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(8, "ammanollashirisha2020@gmail.com", true, "Ammanolla", "Shirisha", "Shirisha123", "Ammanolla.png"));
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(9, "bfeeny238@hotmail.com", true, "Bill", "Feeny", "Feeny123", "Bill Feeny.png"));
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(10, "redsantosph@gmail.com", true, "Frederick", "delos Santos", "Santos123", "Frederick Santos.png"));
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(11, "ro_anamaria@mail.ru", true, "Ana", "Maria", "Maria123", "Anna Maria.jpg"));
        listeUtilisateur.ajouterUnUtilisateur(new Utilisateur(12, "maytassatya@hotmail.com", false, "Satya", "Narayana", "Narayana123", "Satya Narayana.png"));
         */
        return listeUtilisateur;
    }
}
