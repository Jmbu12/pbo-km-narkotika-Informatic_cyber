package controller;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;

import java.util.ArrayList;

public class KnowledgeController {
    private final KnowledgeRepository repository;

    public KnowledgeController(KnowledgeRepository repository) {
        this.repository = repository;
    }

    public boolean tambahPutusan(String[] data) {
        if (data == null || data.length < 12) {
            return false;
        }
        try {
            String nomorPerkara = data[0].trim();
            String pengadilan = data[1].trim();
            String tanggalPutusan = data[2].trim();
            String namaTerdakwa = data[3].trim();
            int umurTerdakwa = Integer.parseInt(data[4].trim());
            String jenisNarkotika = data[5].trim();
            double beratBarangBukti = Double.parseDouble(data[6].trim());
            String pasalDilanggar = data[7].trim();
            String peranTerdakwa = data[8].trim();
            int vonisHukuman = Integer.parseInt(data[9].trim());
            double vonisDenda = Double.parseDouble(data[10].trim());
            String namaHakim = data[11].trim();

            if (nomorPerkara.isEmpty() || namaTerdakwa.isEmpty()) {
                return false;
            }
            if (repository.cariByNomor(nomorPerkara) != null) {
                return false;
            }

            if (nomorPerkara.isEmpty() || namaTerdakwa.isEmpty()) {
                return false;
            }
            if (repository.cariByNomor(nomorPerkara) != null) {
                return false;
            }

            Putusan p = new Putusan(nomorPerkara, pengadilan, tanggalPutusan, namaTerdakwa,
                    umurTerdakwa, jenisNarkotika, beratBarangBukti, pasalDilanggar,
                    peranTerdakwa, vonisHukuman, vonisDenda, namaHakim);
            repository.simpan(p);
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }