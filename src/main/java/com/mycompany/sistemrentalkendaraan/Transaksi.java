/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemrentalkendaraan;

/**
 *
 * @author JENY SARAH C SILABAN
 */
import java.io.Serializable;

public class Transaksi implements Serializable {
    private String idPenyewa;
    private String kodeKendaraan;
    private int jumlah;

    public Transaksi(String idPenyewa, String kodeKendaraan, int jumlah) {
        this.idPenyewa = idPenyewa;
        this.kodeKendaraan = kodeKendaraan;
        this.jumlah = jumlah;
    }

    public String getIdPenyewa() {
        return idPenyewa;
    }

    public String getKodeKendaraan() {
        return kodeKendaraan;
    }

    public int getJumlah() {
        return jumlah;
    }
}
