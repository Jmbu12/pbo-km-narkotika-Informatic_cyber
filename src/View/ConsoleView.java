package view;

import model.Putusan;
import model.StatistikPutusan;
import util.InputHandler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * View berbasis konsol. Hanya bertugas menampilkan data dan menerima input
 * dari pengguna. TIDAK mengandung logika bisnis dan TIDAK mengakses Model
 * secara langsung — seluruh data diterima dalam bentuk yang sudah diproses
 * oleh Controller.
 *
 * @author GUI Designer
 */
public class ConsoleView {

    private final Scanner scanner;

    public ConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void tampilkanBanner() {
        System.out.println("=========================================================");
        System.out.println("   KNOWLEDGE MANAGEMENT SYSTEM (KMS)");
        System.out.println("   PUTUSAN PENGADILAN NARKOTIKA");
        System.out.println("=========================================================");
    }

    /**
     * Menampilkan menu utama dan mengembalikan pilihan pengguna (1-8).
     */
    public int tampilkanMenu() {
        System.out.println("\n----------------- MENU UTAMA -----------------");
        System.out.println("1. Tambah Putusan Baru");
        System.out.println("2. Tampilkan Semua Putusan");
        System.out.println("3. Cari Putusan (Nomor / Nama)");
        System.out.println("4. Filter Putusan (Jenis / Pengadilan / Vonis)");
        System.out.println("5. Hapus Putusan");
        System.out.println("6. Tampilkan Statistik");
        System.out.println("7. Urutkan Data (Vonis / Denda)");
        System.out.println("8. Keluar");
        System.out.println("-----------------------------------------------");
        return InputHandler.validasiPilihan("Pilih menu (1-8): ", 1, 8, scanner);
    }

    /**
     * Menampilkan daftar putusan dalam format tabel ringkas.
     */
    public void tampilkanDaftarPutusan(ArrayList<Putusan> list) {
        if (list == null || list.isEmpty()) {
            tampilkanPesan("Tidak ada data untuk ditampilkan.");
            return;
        }
        System.out.println("\n" + "=".repeat(100));
        System.out.printf("%-22s %-20s %-15s %-10s %-8s %-10s%n",
                "No. Perkara", "Nama Terdakwa", "Jenis Narkotika", "Berat(g)", "Vonis(bln)", "Kategori");
        System.out.println("-".repeat(100));
        for (Putusan p : list) {
            System.out.printf("%-22s %-20s %-15s %-10.1f %-8d %-10s%n",
                    p.getNomorPerkara(),
                    potong(p.getNamaTerdakwa(), 20),
                    potong(p.getJenisNarkotika(), 15),
                    p.getBeratBarangBukti(),
                    p.getVonisHukuman(),
                    p.getKategoriHukuman());
        }
        System.out.println("=".repeat(100));
        System.out.println("Total: " + list.size() + " data");
    }

    private String potong(String s, int maxLen) {
        if (s == null) return "";
        return s.length() <= maxLen ? s : s.substring(0, maxLen - 1) + "…";
    }

    public void tampilkanDetail(Putusan p) {
        if (p == null) {
            tampilkanPesan("Data tidak ditemukan.");
            return;
        }
        p.tampilkan(true);
    }

    public void tampilkanStatistik(StatistikPutusan stat) {
        if (stat == null) {
            tampilkanPesan("Statistik tidak tersedia.");
            return;
        }
        stat.tampilkanLaporan();
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(">> " + pesan);
    }
