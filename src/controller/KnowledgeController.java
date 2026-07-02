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

    public ArrayList<Putusan> cariPutusan(String keyword, String mode) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        if (keyword == null || mode == null) return hasil;

        switch (mode.toLowerCase()) {
            case "nomor":
                Putusan p = repository.cariByNomor(keyword);
                if (p != null) hasil.add(p);
                break;
            case "nama":
                hasil = repository.cariByNama(keyword);
                break;
            default:
                break;
        }
        return hasil;
    }

    public boolean hapusPutusan(String nomor) {
        return repository.hapus(nomor);
    }

    public boolean updatePutusan(String nomorLama, String[] dataBaru) {
        if (dataBaru == null || dataBaru.length < 12) return false;
        try {
            Putusan baru = new Putusan(
                    dataBaru[0].trim(), dataBaru[1].trim(), dataBaru[2].trim(), dataBaru[3].trim(),
                    Integer.parseInt(dataBaru[4].trim()), dataBaru[5].trim(),
                    Double.parseDouble(dataBaru[6].trim()), dataBaru[7].trim(), dataBaru[8].trim(),
                    Integer.parseInt(dataBaru[9].trim()), Double.parseDouble(dataBaru[10].trim()),
                    dataBaru[11].trim());
            return repository.update(nomorLama, baru);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

