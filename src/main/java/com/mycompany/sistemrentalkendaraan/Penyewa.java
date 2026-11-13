package com.mycompany.sistemrentalkendaraan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JENY SARAH C SILABAN
 */
public class Penyewa extends Aktor {

    public Penyewa(String id, String nama) {
        super(id, nama);
    }

    @Override
    public String getInfo() {
        return "ID: " + getId() +
               ", Nama: " + getNama();
    }
}