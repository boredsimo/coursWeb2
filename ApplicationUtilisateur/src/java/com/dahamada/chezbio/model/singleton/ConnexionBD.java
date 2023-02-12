/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dahamada.chezbio.model.singleton;

import com.dahamada.chezbio.model.config.ConfigBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dahamada
 */
public class ConnexionBD {
      private static Connection conn=null;
    public static Connection getConnection() throws SQLException{
        try {
            // Le chargerment du driver, librairie
            Class.forName(ConfigBD.DRIVER);
                conn =  DriverManager.getConnection(ConfigBD.URL, ConfigBD.USER, ConfigBD.PASSWORD);
                 //   conn.setAutoCommit(false); // désactive l'auto-commit pour permettre les rollbacks

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
         //DriverManger est responsable de la selection de la BD et la création de la connexion
         return conn;
    }
    
    public static void closeConnection(){
    
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
