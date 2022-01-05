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
public class modele_e_c_u {
    int id;
    String nomModeleECU;
    int marqueECU_id;

    public modele_e_c_u() {
    }
    
    public modele_e_c_u(int id, String nomModeleECU, int marqueECU_id) {
        this.id = id;
        this.nomModeleECU = nomModeleECU;
        this.marqueECU_id = marqueECU_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomModeleECU() {
        return nomModeleECU;
    }

    public void setNomModeleECU(String nomModeleECU) {
        this.nomModeleECU = nomModeleECU;
    }

    public int getMarqueECU_id() {
        return marqueECU_id;
    }

    public void setMarqueECU_id(int marqueECU_id) {
        this.marqueECU_id = marqueECU_id;
    }
    
    
}
