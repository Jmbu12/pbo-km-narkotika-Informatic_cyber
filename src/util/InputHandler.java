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


