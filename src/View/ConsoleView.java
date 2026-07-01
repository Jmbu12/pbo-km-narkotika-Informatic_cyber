package view;

import model.Putusan;
import model.StatistikPutusan;
import util.InputHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {

    private final Scanner scanner;

    public ConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void tampilkanBanner() {
        System.out.println("=========================================================");
        System.out.println("   KNOWLEDGE MANAGEMENT SYSTEM (KMS)");
        System.out.println("   PUTUSAN PENGADILAN NARKOTIKA");
        System.out.println("=========================================================");
    }