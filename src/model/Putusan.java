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

    public String getNomorPerkara() {
        return nomorPerkara;
    }

    public void setNomorPerkara(String nomorPerkara) {
        this.nomorPerkara = nomorPerkara;
    }

    public String getPengadilan() {
        return pengadilan;
    }

    public void setPengadilan(String pengadilan) {
        this.pengadilan = pengadilan;
    }

    public String getTanggalPutusan() {
        return tanggalPutusan;
    }

    public void setTanggalPutusan(String tanggalPutusan) {
        this.tanggalPutusan = tanggalPutusan;
    }

    public String getNamaTerdakwa() {
        return namaTerdakwa;
    }

    public void setNamaTerdakwa(String namaTerdakwa) {
        this.namaTerdakwa = namaTerdakwa;
    }

    public int getUmurTerdakwa() {
        return umurTerdakwa;
    }

    public void setUmurTerdakwa(int umurTerdakwa) {
        if (umurTerdakwa < 0) {
            throw new IllegalArgumentException("Umur terdakwa tidak boleh negatif");
        }
        this.umurTerdakwa = umurTerdakwa;
    }

    public String getJenisNarkotika() {
        return jenisNarkotika;
    }

    public void setJenisNarkotika(String jenisNarkotika) {
        this.jenisNarkotika = jenisNarkotika;
    }

    public double getBeratBarangBukti() {
        return beratBarangBukti;
    }

    public void setBeratBarangBukti(double beratBarangBukti) {
        if (beratBarangBukti < 0) {
            throw new IllegalArgumentException("Berat barang bukti tidak boleh negatif");
        }
        this.beratBarangBukti = beratBarangBukti;
    }

    public String getPasalDilanggar() {
        return pasalDilanggar;
    }

    public void setPasalDilanggar(String pasalDilanggar) {
        this.pasalDilanggar = pasalDilanggar;
    }

    public String getPeranTerdakwa() {
        return peranTerdakwa;
    }

    public void setPeranTerdakwa(String peranTerdakwa) {
        this.peranTerdakwa = peranTerdakwa;
    }

    public int getVonisHukuman() {
        return vonisHukuman;
    }

    public void setVonisHukuman(int vonisHukuman) {
        if (vonisHukuman < 0) {
            throw new IllegalArgumentException("Vonis hukuman tidak boleh negatif");
        }
        this.vonisHukuman = vonisHukuman;
    }

    public double getVonisDenda() {
        return vonisDenda;
    }

    public void setVonisDenda(double vonisDenda) {
        if (vonisDenda < 0) {
            throw new IllegalArgumentException("Vonis denda tidak boleh negatif");
        }
        this.vonisDenda = vonisDenda;
    }

    public String getNamaHakim() {
        return namaHakim;
    }

    public void setNamaHakim(String namaHakim) {
        this.namaHakim = namaHakim;
    }

    // ===== STATIC METHOD =====
    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }

    @Override
    public void tampilkan() {
        System.out.println(ringkasanSingkat());
    }

    @Override
    public void tampilkan(boolean detail) {
        if (!detail) {
            tampilkan();
            return;
        }