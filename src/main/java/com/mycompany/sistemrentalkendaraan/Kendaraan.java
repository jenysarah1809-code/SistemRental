package com.mycompany.sistemrentalkendaraan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JENY SARAH C SILABAN
 */
import java.io.Serializable;

public abstract class Kendaraan implements Serializable {
    private String kode;
    private String nama;
    private int kuota;

    public Kendaraan(String kode, String nama, int kuota) {
        this.kode = kode;
        this.nama = nama;
        this.kuota = kuota;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getKuota() {
        return kuota;
    }

    public void kurangiKuota(int jumlah) {
        kuota -= jumlah;
    }

    public abstract String getJenis();
}