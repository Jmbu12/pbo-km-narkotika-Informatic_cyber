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