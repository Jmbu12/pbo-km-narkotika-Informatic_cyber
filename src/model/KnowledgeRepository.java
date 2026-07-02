package model;

import java.util.ArrayList;
import java.util.Comparator;

public class KnowledgeRepository {

    private ArrayList<Putusan> daftarPutusan;

    public KnowledgeRepository() {
        this.daftarPutusan = new ArrayList<>();
    }


    public void simpan(Putusan p) {
        if (p == null) {
            throw new IllegalArgumentException("Data putusan tidak boleh null");
        }
        daftarPutusan.add(p);
    }

    public Putusan cariByNomor(String nomor) {
        if (nomor == null) return null;
        for (Putusan p : daftarPutusan) {
            if (p.getNomorPerkara().equalsIgnoreCase(nomor.trim())) {
                return p;
            }
        }
        return null;
    }


    public ArrayList<Putusan> cariByNama(String nama) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        if (nama == null) return hasil;
        String key = nama.trim().toLowerCase();
        for (Putusan p : daftarPutusan) {
            if (p.getNamaTerdakwa().toLowerCase().contains(key)) {
                hasil.add(p);
            }
        }
        return hasil;
    }


    public ArrayList<Putusan> filterByJenis(String jenis) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        if (jenis == null) return hasil;
        String key = jenis.trim().toLowerCase();
        for (Putusan p : daftarPutusan) {
            if (p.getJenisNarkotika().toLowerCase().contains(key)) {
                hasil.add(p);
            }
        }
        return hasil;
    }


    public ArrayList<Putusan> filterByPengadilan(String pengadilan) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        if (pengadilan == null) return hasil;
        String key = pengadilan.trim().toLowerCase();
        for (Putusan p : daftarPutusan) {
            if (p.getPengadilan().toLowerCase().contains(key)) {
                hasil.add(p);
            }
        }
        return hasil;
    }


    public ArrayList<Putusan> filterByRentangVonis(int minBulan, int maxBulan) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        for (Putusan p : daftarPutusan) {
            if (p.getVonisHukuman() >= minBulan && p.getVonisHukuman() <= maxBulan) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public boolean hapus(String nomor) {
        Putusan p = cariByNomor(nomor);
        if (p == null) {
            return false;
        }
        return daftarPutusan.remove(p);
    }


    public boolean update(String nomorLama, Putusan dataBaru) {
        for (int i = 0; i < daftarPutusan.size(); i++) {
            if (daftarPutusan.get(i).getNomorPerkara().equalsIgnoreCase(nomorLama.trim())) {
                daftarPutusan.set(i, dataBaru);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Putusan> getDaftarSemua() {
        return daftarPutusan;
    }

    public int getTotalData() {
        return daftarPutusan.size();
    }


    public void urutkanByVonis() {
        daftarPutusan.sort(Comparator.comparingInt(Putusan::getVonisHukuman));
    }


    public void urutkanByDendaTerbesar() {
        daftarPutusan.sort(Comparator.comparingDouble(Putusan::getVonisDenda).reversed());
    }
}