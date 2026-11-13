/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemrentalkendaraan;

/**
 *
 * @author JENY SARAH C SILABAN
 */
import java.io.*;
import java.util.*;

public class SistemRental implements Serializable {
    private String namaRental;
    private HashMap<String, Penyewa> daftarPenyewa;
    private HashMap<String, Kendaraan> daftarKendaraan;
    private ArrayList<Transaksi> daftarTransaksi;

    public SistemRental(String namaRental) {
        this.namaRental = namaRental;

        daftarPenyewa = new HashMap<>();
        daftarKendaraan = new HashMap<>();
        daftarTransaksi = new ArrayList<>();
    }

    public void tambahPenyewa(String id, String nama) {
        Penyewa penyewa = new Penyewa(id, nama);
        daftarPenyewa.put(id, penyewa);
    }

    public void tambahKendaraan(String kode, String nama, int kuota) {
        Kendaraan kendaraan;

        if (nama.contains("SUV")) {
            kendaraan = new Mobil(kode, nama, kuota);
        } else if (nama.contains("Matic")) {
            kendaraan = new Motor(kode, nama, kuota);
        } else {
            kendaraan = new Minibus(kode, nama, kuota);
        }

        daftarKendaraan.put(kode, kendaraan);
    }

    public void prosesTransaksi(String id, String kode, int jumlah)
            throws RentalException {

        Penyewa penyewa = daftarPenyewa.get(id);

        if (penyewa == null) {
            throw new RentalException("Penyewa dengan ID " + id + " tidak ditemukan.");
        }

        Kendaraan kendaraan = daftarKendaraan.get(kode);

        if (kendaraan == null) {
            throw new RentalException("Kendaraan dengan kode " + kode +" tidak ditemukan.");
        }
        if (jumlah <= 0) {
            throw new RentalException("Jumlah kendaraan harus lebih dari 0.");
        }
        if (jumlah > kendaraan.getKuota()) {
            throw new RentalException("Kuota kendaraan " + kode +" tidak mencukupi.");
        }
        kendaraan.kurangiKuota(jumlah);

        Transaksi transaksi = new Transaksi(id, kode, jumlah);

        daftarTransaksi.add(transaksi);

        System.out.println("Transaksi berhasil: " +id + " - " + kode +" - Jumlah: " + jumlah);
    }

    public void jalankanTransaksiDariFile(String namaFile) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(namaFile));
        String baris;
        while ((baris = reader.readLine()) != null) {
            String[] dataTransaksi = baris.split("\\|");
            for (String data : dataTransaksi) {
                if (data.trim().isEmpty()) {
                    continue;
                }
                try {
                    String[] bagian = data.split("/");
                    String id = bagian[0].substring(3);
                    String kode = bagian[1].substring(3);
                    int jumlah = Integer.parseInt(bagian[2].substring(4));

                    prosesTransaksi(id, kode, jumlah);

                } 
                catch (RentalException e) {
                    System.out.println("Transaksi gagal: " + e.getMessage());
                } 
                catch (Exception e) {
                    System.out.println("Format transaksi tidak valid: " +data);
                }
            }
        }

        reader.close();
    }

    public void simpanLaporanAkhir() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("data_master.bak"));

            output.writeObject(this);
            output.close();

            System.out.println("Serialization berhasil disimpan.");

        } 
        catch (IOException e) {
            System.out.println("Gagal melakukan serialization: " +e.getMessage());
        }

        try {
            FileWriter writer = new FileWriter("laporan.txt");

            for (int i = 0; i < daftarTransaksi.size(); i++) {
                Transaksi transaksi = daftarTransaksi.get(i);
                writer.write(transaksi.getIdPenyewa() + "," + transaksi.getKodeKendaraan() + "," + transaksi.getJumlah() + "\n");
            }

            writer.close();
            System.out.println("Laporan CSV berhasil dibuat.");

        } 
        catch (IOException e) {
            System.out.println("Gagal membuat laporan: " +e.getMessage());
        }
    }
}