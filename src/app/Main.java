package app;

import controller.KnowledgeController;
import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;
import model.DataSampel;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        KnowledgeRepository repository = new KnowledgeRepository();
        repository.getDaftarSemua().addAll(DataSampel.generate());

        KnowledgeController controller = new KnowledgeController(repository);
        ConsoleView view = new ConsoleView(scanner);

        view.tampilkanBanner();
        view.tampilkanPesan("Data sampel berhasil dimuat: " + controller.getTotalData() + " putusan.");


        boolean berjalan = true;
        while (berjalan) {
            int pilihan = view.tampilkanMenu();
            switch (pilihan) {
                case 1:
                    prosesTambah(controller, view, scanner);
                    break;
                case 2:
                    view.tampilkanDaftarPutusan(controller.tampilkanSemua());
                    break;
                case 3:
                    prosesCari(controller, view);
                    break;
                case 4:
                    prosesFilter(controller, view);
                    break;
                case 5:
                    prosesHapus(controller, view);
                    break;
                case 6:
                    view.tampilkanStatistik(controller.getStatistik());
                    break;
                case 7:
                    prosesUrutkan(controller, view);
                    break;
                case 8:
                    berjalan = false;
                    view.tampilkanPesan("Terima kasih. Program selesai.");
                    break;
                default:
                    view.tampilkanPesan("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }

    private static void prosesTambah(KnowledgeController controller, ConsoleView view, Scanner scanner) {
        String[] data = view.inputFormPutusan(scanner);
        boolean sukses = controller.tambahPutusan(data);
        if (sukses) {
            view.tampilkanPesan("Putusan berhasil ditambahkan. Total data: " + controller.getTotalData());
        } else {
            view.tampilkanPesan("Gagal menambahkan putusan. Periksa kembali data (nomor perkara mungkin duplikat atau ada nilai tidak valid).");
        }
    }

    private static void prosesCari(KnowledgeController controller, ConsoleView view) {
        int mode = view.inputPilihan("Cari berdasarkan: 1) Nomor Perkara  2) Nama Terdakwa : ", 1, 2);
        String keyword = view.inputString("Masukkan keyword: ");
        ArrayList<Putusan> hasil = controller.cariPutusan(keyword, mode == 1 ? "nomor" : "nama");
        view.tampilkanDaftarPutusan(hasil);
    }

    private static void prosesFilter(KnowledgeController controller, ConsoleView view) {
        int mode = view.inputPilihan(
                "Filter berdasarkan: 1) Jenis Narkotika  2) Pengadilan  3) Rentang Vonis (bulan) : ", 1, 3);
        ArrayList<Putusan> hasil;
        if (mode == 1) {
            String jenis = view.inputString("Masukkan jenis narkotika: ");
            hasil = controller.filterPutusan("jenis", jenis);
        } else if (mode == 2) {
            String pengadilan = view.inputString("Masukkan nama pengadilan: ");
            hasil = controller.filterPutusan("pengadilan", pengadilan);
        } else {
            String rentang = view.inputString("Masukkan rentang vonis (format min-max, contoh 0-12): ");
            hasil = controller.filterPutusan("vonis", rentang);
        }
        view.tampilkanDaftarPutusan(hasil);
    }

    private static void prosesHapus(KnowledgeController controller, ConsoleView view) {
        String nomor = view.inputString("Masukkan Nomor Perkara yang akan dihapus: ");
        boolean sukses = controller.hapusPutusan(nomor);
        view.tampilkanPesan(sukses ? "Data berhasil dihapus." : "Data tidak ditemukan.");
    }