/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.historique_dernier_acces;

/**
 *
 * @author ASUS
 */
public class historique_dernier_acces_sql {
    Connection cn = null;
     Statement st = null;
     ResultSet rs = null;
     historique_dernier_acces hda;
     historique_dernier_acces[] hstDAs;

    public historique_dernier_acces_sql( conxBD cb) {
        cn = cb.cn; 
        st= cb.st; 
        rs= cb.rs;
        hda = new historique_dernier_acces();
    }
    public void insert(String id_user, String date_acces){
        try {
            st.executeUpdate("INSERT INTO historique_dernier_acces " + " VALUES ('"+id_user+"','"+date_acces+"')");
        } catch (SQLException ex) {
            Logger.getLogger(historique_dernier_acces_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public int count()
    {
        int nb = 0;
         try {
             rs = st.executeQuery("SELECT COUNT(*) AS nbLignes FROM historique_dernier_acces");
             rs.next();
            nb = rs.getInt("nbLignes");
         } catch (SQLException ex) {
             Logger.getLogger(modele_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        return nb;
    }
    public  historique_dernier_acces[] selectAll(){
        hstDAs = new historique_dernier_acces[this.count()];
        int i = 0;
        hda = new historique_dernier_acces();
        try {
            rs = st.executeQuery("SELECT * FROM historique_dernier_acces");
            while(rs.next()){
                hda.setDate_acces(rs.getString("date_acces"));
                hda.setId_user(rs.getString("id_user"));
                hstDAs[i] = hda;
                i++;
                hda = new historique_dernier_acces();
            }
        } catch (SQLException ex) {
            Logger.getLogger(historique_dernier_acces_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hstDAs;
    }
    
}
