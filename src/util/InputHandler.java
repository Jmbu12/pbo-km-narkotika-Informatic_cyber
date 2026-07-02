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