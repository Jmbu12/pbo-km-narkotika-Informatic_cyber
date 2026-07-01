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