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
import model.marque_e_c_u;


/**
 *
 * @author ASUS
 */
public class marque_e_c_u_sql {
     Connection cn = null;
     Statement st = null;
     ResultSet rs = null;
     marque_e_c_u mecu;
     marque_e_c_u[] mecus;

    public marque_e_c_u_sql(conxBD cb) {
       
        cn = cb.cn; 
        st= cb.st; 
        rs= cb.rs;
        mecu = new marque_e_c_u();
    }
    public void insert(String nomECU, String description){
     
         try {
             st.executeUpdate("INSERT INTO marque_e_c_u " + " VALUES (null,'"+nomECU+"', '"+description+"')");
         } catch (SQLException ex) {
             Logger.getLogger(marque_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
  public  marque_e_c_u[] select(){
       int taille = this.count();
       mecus= new marque_e_c_u[taille];
       mecu = new marque_e_c_u();
        int i=0;
         try {
             rs = st.executeQuery("SELECT * FROM marque_e_c_u");
            while(rs.next()){
                mecu.setId(rs.getInt("id"));
                mecu.setDescription(rs.getString("description"));
                mecu.setNomECU(rs.getString("nomECU"));
                mecus[i]=mecu;
                i++;
                mecu = new marque_e_c_u();
                
            }
    } catch (SQLException ex) {
             Logger.getLogger(marque_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
       return mecus; 
    }
    
      public  int select_nomECU(String nomecu){
      int id =0;
         try {
             rs = st.executeQuery("SELECT * FROM marque_e_c_u where nomECU='"+nomecu+"'");
             rs.next(); id= rs.getInt("id");
    } catch (SQLException ex) {
             Logger.getLogger(marque_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
       return id;
    }
      //counts 
       public int count()
    {
        int nb = 0;
         try {
             rs = st.executeQuery("SELECT COUNT(*) AS nb FROM marque_e_c_u");
             rs.next();
            nb = rs.getInt("nb");
         } catch (SQLException ex) {
             Logger.getLogger(modele_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        return nb;
    }
       
      
}
