/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemrentalkendaraan;

/**
 *
 * @author JENY SARAH C SILABAN
 */
public class Minibus extends Kendaraan {

    public Minibus(String kode, String nama, int kuota) {
        super(kode, nama, kuota);
    }

    @Override
    public String getJenis() {
        return "Minibus";
    }
}
