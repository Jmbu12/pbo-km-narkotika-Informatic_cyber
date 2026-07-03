package model;

public class PutusanNarkotikaBerat extends Putusan {

    private boolean terindikasiJaringan; // true jika diduga bagian dari jaringan/sindikat
    private String catatanKhusus;

    public PutusanNarkotikaBerat() {
        super();
        this.terindikasiJaringan = false;
        this.catatanKhusus = "-";
    }
    public PutusanNarkotikaBerat(String nomorPerkara, String pengadilan, String tanggalPutusan,
                                 String namaTerdakwa, int umurTerdakwa, String jenisNarkotika,
                                 double beratBarangBukti, String pasalDilanggar, String peranTerdakwa,
                                 int vonisHukuman, double vonisDenda, String namaHakim,
                                 boolean terindikasiJaringan, String catatanKhusus) {
        super(nomorPerkara, pengadilan, tanggalPutusan, namaTerdakwa, umurTerdakwa, jenisNarkotika,
                beratBarangBukti, pasalDilanggar, peranTerdakwa, vonisHukuman, vonisDenda, namaHakim);
        this.terindikasiJaringan = terindikasiJaringan;
        this.catatanKhusus = catatanKhusus;
    }
    public boolean isTerindikasiJaringan() {
        return terindikasiJaringan;
    }

    public void setTerindikasiJaringan(boolean terindikasiJaringan) {
        this.terindikasiJaringan = terindikasiJaringan;
    }

    public String getCatatanKhusus() {
        return catatanKhusus;
    }

    public void setCatatanKhusus(String catatanKhusus) {
        this.catatanKhusus = catatanKhusus;
    }

    // ===== METHOD OVERRIDING (polimorfisme) =====
    @Override
    public void tampilkan(boolean detail) {
        super.tampilkan(detail); // panggil versi induk dulu
        if (detail) {
            System.out.println("Indikasi Jaringan : " + (terindikasiJaringan ? "YA" : "Tidak"));
            System.out.println("Catatan Khusus    : " + catatanKhusus);
            System.out.println("=========================================");
        }
    }

    @Override
    public String ringkasanSingkat() {
        String base = super.ringkasanSingkat();
        return base + (terindikasiJaringan ? " [JARINGAN]" : "");
    }

    @Override
    public String toString() {
        return "PutusanNarkotikaBerat{" + super.toString() +
                ", terindikasiJaringan=" + terindikasiJaringan + "}";
    }
}