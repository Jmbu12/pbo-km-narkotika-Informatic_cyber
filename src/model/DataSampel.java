package model;

import java.util.ArrayList;


public final class DataSampel {

    private DataSampel() {
        // utility class, tidak boleh diinstansiasi
    }

    private static final String[] PENGADILAN = {
            "PN Surabaya", "PN Sidoarjo", "PN Malang", "PN Jakarta Pusat",
            "PN Jakarta Selatan", "PN Bandung", "PN Semarang", "PN Medan",
            "PN Denpasar", "PN Makassar"
    };

    private static final String[] JENIS_NARKOTIKA = {
            "Sabu-sabu", "Ganja", "Ekstasi", "Heroin", "Tembakau Gorila"
    };

    private static final String[] PERAN = {
            "Bandar", "Kurir", "Pengguna", "Penyimpan", "Pengedar"
    };

    private static final String[] PASAL = {
            "Pasal 114 ayat (1) UU No. 35/2009",
            "Pasal 112 ayat (1) UU No. 35/2009",
            "Pasal 111 ayat (1) UU No. 35/2009",
            "Pasal 127 ayat (1) UU No. 35/2009",
            "Pasal 132 UU No. 35/2009"
    };

    private static final String[] NAMA_DEPAN = {
            "Andi", "Budi", "Citra", "Dewi", "Eko", "Fajar", "Gunawan", "Hesti",
            "Indra", "Joko", "Kartika", "Lukman", "Maya", "Nanda", "Oka",
            "Putra", "Qory", "Rudi", "Sari", "Tono", "Umar", "Vina", "Wawan",
            "Yusuf", "Zainal"
    };

    private static final String[] NAMA_BELAKANG = {
            "Saputra", "Wijaya", "Pratama", "Santoso", "Hidayat", "Kusuma",
            "Permana", "Setiawan", "Nugroho", "Lestari"
    };

    private static final String[] NAMA_HAKIM = {
            "Dr. H. Slamet Riyadi, S.H., M.H.",
            "Hj. Sri Wahyuni, S.H., M.H.",
            "Bambang Sutejo, S.H.",
            "Dewi Anggraini, S.H., M.H.",
            "Agus Purnomo, S.H."
    };
    public static ArrayList<Putusan> generate() {
        ArrayList<Putusan> daftar = new ArrayList<>();
        int totalData = 55;

        for (int i = 1; i <= totalData; i++) {
            String nomorPerkara = (1000 + i) + "/Pid.Sus/2024/PN Sby";
            String pengadilan = PENGADILAN[i % PENGADILAN.length];
            String tanggal = String.format("%02d-%02d-2024", (i % 28) + 1, (i % 12) + 1);
            String namaTerdakwa = NAMA_DEPAN[i % NAMA_DEPAN.length] + " "
                    + NAMA_BELAKANG[i % NAMA_BELAKANG.length];
            int umur = 19 + (i % 40); // 19 - 58 tahun
            String jenis = JENIS_NARKOTIKA[i % JENIS_NARKOTIKA.length];
            double berat = 0.5 + (i * 3.7) % 500; // variasi berat 0.5 - 500 gram
            String pasal = PASAL[i % PASAL.length];
            String peran = PERAN[i % PERAN.length];
            int vonis = 6 + (i * 5) % 180; // 6 - 185 bulan
            double denda = 1_000_000 + (i * 137_000) % 800_000_000;
            String hakim = NAMA_HAKIM[i % NAMA_HAKIM.length];

            // Selingi beberapa data sebagai PutusanNarkotikaBerat (subclass)
            // untuk kasus dengan peran Bandar/Pengedar dan berat besar -> demonstrasi polimorfisme
            if (peran.equals("Bandar") && berat > 100) {
                boolean jaringan = (i % 7 == 0);
                String catatan = jaringan
                        ? "Diduga bagian dari jaringan distribusi antar kota"
                        : "Beroperasi mandiri";
                daftar.add(new PutusanNarkotikaBerat(
                        nomorPerkara, pengadilan, tanggal, namaTerdakwa, umur, jenis,
                        berat, pasal, peran, vonis, denda, hakim, jaringan, catatan));
            } else {
                daftar.add(new Putusan(
                        nomorPerkara, pengadilan, tanggal, namaTerdakwa, umur, jenis,
                        berat, pasal, peran, vonis, denda, hakim));
            }
        }

        return daftar;
    }
}