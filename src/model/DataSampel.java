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