/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.conxBD;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class Solution {
    int id_solution;
    String nom_solution;
    String decription;
    Connection cn = null;
     Statement st = null;
     ResultSet rs = null;

     public Solution() {
        
    }
    
    public Solution(int id_solution, String nom_solution, String decription) {
        this.id_solution = id_solution;
        this.nom_solution = nom_solution;
        this.decription = decription;
    }

    public int getId_solution() {
        return id_solution;
    }

    public void setId_solution(int id_solution) {
        this.id_solution = id_solution;
    }

    public String getNom_solution() {
        return nom_solution;
    }

    public void setNom_solution(String nom_solution) {
        this.nom_solution = nom_solution;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

}
