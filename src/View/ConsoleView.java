package view;

import model.Putusan;
import model.StatistikPutusan;
import util.InputHandler;

import java.util.ArrayList;
import java.util.Scanner;

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