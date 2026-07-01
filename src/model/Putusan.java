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
    public Putusan(String nomorPerkara, String pengadilan, String tanggalPutusan,
                   String namaTerdakwa, int umurTerdakwa, String jenisNarkotika,
                   double beratBarangBukti, String pasalDilanggar, String peranTerdakwa,
                   int vonisHukuman, double vonisDenda, String namaHakim) {
        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
        this.namaTerdakwa = namaTerdakwa;
        setUmurTerdakwa(umurTerdakwa);
        this.jenisNarkotika = jenisNarkotika;
        setBeratBarangBukti(beratBarangBukti);
        this.pasalDilanggar = pasalDilanggar;
        this.peranTerdakwa = peranTerdakwa;
        setVonisHukuman(vonisHukuman);
        setVonisDenda(vonisDenda);
        this.namaHakim = namaHakim;
        jumlahDibuat++;
    }
    public Putusan(String nomorPerkara, String namaTerdakwa, String jenisNarkotika,
                   double beratBarangBukti, int vonisHukuman) {
        this();
        this.nomorPerkara = nomorPerkara;
        this.namaTerdakwa = namaTerdakwa;
        this.jenisNarkotika = jenisNarkotika;
        setBeratBarangBukti(beratBarangBukti);
        setVonisHukuman(vonisHukuman);
    }