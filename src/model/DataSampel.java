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
