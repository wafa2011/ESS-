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
import model.Solution;

/**
 *
 * @author ASUS
 */
public class solution_sql {
     Connection cn = null;
     Statement st = null;
     ResultSet rs = null;
     Solution sl;
     Solution[] sls;

    public solution_sql(conxBD cb) {
        cn = cb.cn; 
        st= cb.st; 
        rs= cb.rs;
        sl = new Solution();
    }
    public Solution[] select(){
        sls = new Solution[this.count()];
        sl = new Solution();
        int i = 0;
         try {
             rs = st.executeQuery("SELECT * FROM solution");
            while(rs.next()){
               sl.setId_solution(rs.getInt("id_solution"));
               sl.setNom_solution(rs.getString("nom_solution"));
               sl.setDecription(rs.getString("description"));
               sls[i]=sl;
               i++;
               sl = new Solution();
           }
    } catch (SQLException ex) {
             Logger.getLogger(marque_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return sls;
    }
    public void insert(  String nom_solution, String decription){
        try {
             st.executeUpdate("INSERT INTO solution " + " VALUES (null,'"+nom_solution+"',' "+decription+"')");
         } catch (SQLException ex) {
             Logger.getLogger(marque_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }
     public int selectSelonNom_solution(String  nom_solution){
        int  id_solution = 0;
         try {
            rs = st.executeQuery("SELECT * FROM solution where nom_solution='"+nom_solution+"'");
            while (rs.next()){
               id_solution = rs.getInt("id_solution");
            }
    } catch (SQLException ex) {
             Logger.getLogger(marque_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        return id_solution;
    }
     public int count()
    {
        int nb = 0;
         try {
             rs = st.executeQuery("SELECT COUNT(*) AS nbLignes FROM solution");
             rs.next();
            nb = rs.getInt("nbLignes");
         } catch (SQLException ex) {
             Logger.getLogger(modele_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        return nb;
    }
   
    
}
