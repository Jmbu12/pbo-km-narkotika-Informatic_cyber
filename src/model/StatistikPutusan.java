package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatistikPutusan {

    private int totalPutusan;
    private double rataRataVonis;
    private double rataRataDenda;
    private String jenisNarkotikaTerbanyak;
    private String[] distribusiPeran; // array statis berisi "Peran: jumlah (persen%)"

    private final ArrayList<Putusan> daftar;

    public StatistikPutusan(ArrayList<Putusan> daftar) {
        this.daftar = daftar;
        this.distribusiPeran = new String[0];
        hitungSemua();
    }

    public void hitungSemua() {
        totalPutusan = daftar.size();

        if (totalPutusan == 0) {
            rataRataVonis = 0.0;
            rataRataDenda = 0.0;
            jenisNarkotikaTerbanyak = "-";
            distribusiPeran = new String[0];
            return;
        }

        int totalVonis = 0;
        double totalDenda = 0.0;
        Map<String, Integer> hitungJenis = new HashMap<>();
        Map<String, Integer> hitungPeran = new HashMap<>();

        for (Putusan p : daftar) {
            totalVonis += p.getVonisHukuman();
            totalDenda += p.getVonisDenda();

            hitungJenis.merge(p.getJenisNarkotika(), 1, Integer::sum);
            hitungPeran.merge(p.getPeranTerdakwa(), 1, Integer::sum);
        }

        rataRataVonis = (double) totalVonis / totalPutusan;
        rataRataDenda = totalDenda / totalPutusan;

        jenisNarkotikaTerbanyak = "-";
        int maxJenis = -1;
        for (Map.Entry<String, Integer> entry : hitungJenis.entrySet()) {
            if (entry.getValue() > maxJenis) {
                maxJenis = entry.getValue();
                jenisNarkotikaTerbanyak = entry.getKey();
            }
        }

        distribusiPeran = new String[hitungPeran.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : hitungPeran.entrySet()) {
            double persen = (entry.getValue() * 100.0) / totalPutusan;
            distribusiPeran[idx] = String.format("%s: %d (%.1f%%)",
                    entry.getKey(), entry.getValue(), persen);
            idx++;
        }
    }

    public void tampilkanLaporan() {
        System.out.println("========== STATISTIK PUTUSAN ==========");
        System.out.println("Total Putusan          : " + totalPutusan);
        System.out.printf("Rata-rata Vonis         : %.1f bulan%n", rataRataVonis);
        System.out.printf("Rata-rata Denda         : Rp%,.0f%n", rataRataDenda);
        System.out.println("Jenis Narkotika Terbanyak: " + jenisNarkotikaTerbanyak);
        System.out.println("Distribusi Peran Terdakwa:");
        if (distribusiPeran.length == 0) {
            System.out.println("  (tidak ada data)");
        } else {
            for (String baris : distribusiPeran) {
                System.out.println("  - " + baris);
            }
        }
        System.out.println("=========================================");
    }

    public int getTotalPutusan() {
        return totalPutusan;
    }

    public double getRataRataVonis() {
        return rataRataVonis;
    }

    public double getRataRataDenda() {
        return rataRataDenda;
    }

    public String getJenisNarkotikaTerbanyak() {
        return jenisNarkotikaTerbanyak;
    }

    public String[] getDistribusiPeran() {
        return distribusiPeran;
    }
}