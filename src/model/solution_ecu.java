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
public class solution_ecu {
    int id_ecu;
    int id_solution;

    public solution_ecu() {
    }

    public solution_ecu(int id_ecu, int id_solution) {
        this.id_ecu = id_ecu;
        this.id_solution = id_solution;
    }

    public int getId_ecu() {
        return id_ecu;
    }

    public void setId_ecu(int id_ecu) {
        this.id_ecu = id_ecu;
    }

    public int getId_solution() {
        return id_solution;
    }

    public void setId_solution(int id_solution) {
        this.id_solution = id_solution;
    }
    
}
