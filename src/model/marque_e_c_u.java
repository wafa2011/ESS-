/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class marque_e_c_u {
    int id; 
    String nomECU;
    String description;

    public marque_e_c_u() {
    }
    
    public marque_e_c_u(int id, String nomECU, String description) {
        this.id = id;
        this.nomECU = nomECU;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomECU() {
        return nomECU;
    }

    public void setNomECU(String nomECU) {
        this.nomECU = nomECU;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
