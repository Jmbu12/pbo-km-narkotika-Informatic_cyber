package model;

public class Putusan implements Dapatdicetak {

    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;
    private String namaTerdakwa;
    private int umurTerdakwa;
    private String jenisNarkotika;
    private double beratBarangBukti; // gram
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman; // bulan
    private double vonisDenda; // rupiah
    private String namaHakim;

    private static int jumlahDibuat = 0;

    public Putusan() {
        this.nomorPerkara = "BELUM DIISI";
        this.pengadilan = "BELUM DIISI";
        this.tanggalPutusan = "BELUM DIISI";
        this.namaTerdakwa = "BELUM DIISI";
        this.umurTerdakwa = 0;
        this.jenisNarkotika = "BELUM DIISI";
        this.beratBarangBukti = 0.0;
        this.pasalDilanggar = "BELUM DIISI";
        this.peranTerdakwa = "BELUM DIISI";
        this.vonisHukuman = 0;
        this.vonisDenda = 0.0;
        this.namaHakim = "BELUM DIISI";
        jumlahDibuat++;
    }