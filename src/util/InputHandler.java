package util;

import java.util.Scanner;


public final class InputHandler {

    private InputHandler() {
    }

    public static int validasiInt(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("  [ERROR] Input harus berupa angka bulat. Coba lagi.");
            }
        }
    }

    public static int validasiIntMinimal(String prompt, Scanner sc, int minimal) {
        while (true) {
            int nilai = validasiInt(prompt, sc);
            if (nilai < minimal) {
                System.out.println("  [ERROR] Nilai tidak boleh kurang dari " + minimal + ". Coba lagi.");
                continue;
            }
            return nilai;
        }
    }

    public static double validasiDouble(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("  [ERROR] Input harus berupa angka (desimal diperbolehkan). Coba lagi.");
            }
        }
    }

    public static double validasiDoubleMinimal(String prompt, Scanner sc, double minimal) {
        while (true) {
            double nilai = validasiDouble(prompt, sc);
            if (nilai < minimal) {
                System.out.println("  [ERROR] Nilai tidak boleh kurang dari " + minimal + ". Coba lagi.");
                continue;
            }
            return nilai;
        }
    }

    public static String validasiString(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input tidak boleh kosong");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("  [ERROR] " + e.getMessage() + ". Coba lagi.");
            }
        }
    }

    public static int validasiPilihan(String prompt, int min, int max, Scanner sc) {
        while (true) {
            int pilihan = validasiInt(prompt, sc);
            if (pilihan < min || pilihan > max) {
                System.out.println("  [ERROR] Pilihan harus antara " + min + " - " + max + ". Coba lagi.");
                continue;
            }
            return pilihan;
        }
    }
}