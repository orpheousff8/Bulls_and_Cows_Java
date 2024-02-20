package bullscows;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final char[] dict = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n=0, p=0;

        System.out.println("Input the length of the secret code:");
        try {
            n = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("Error: \"%s\" isn't a valid number.\n", n);
        }

        if (n > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");
        try {
            p = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("Error: \"%s\" isn't a valid number.\n", p);
        }

        if (p > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }

        if (n > p || n == 0) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", n, p);
            return;
        }
        scanner.nextLine(); //need this or next readLine() will get read an empty String.

        StringBuilder secretBuilder = new StringBuilder(n);
        while (true) {
            Random random = new Random();
            int r = random.nextInt(p);
            char c = dict[r];

            if (secretBuilder.toString().contains(c + "")) {
                continue;
            }

            secretBuilder.append(c);
            if (secretBuilder.length() == n) {
                break;
            }
        }
        String secret = secretBuilder.toString();

        System.out.println(getSecretMessage(secret, p));
//        System.out.printf("Okay, let's start a game! %s\n", secret);
        System.out.println("Okay, let's start a game!");

        int turn = 1;
        int bull = 0, cow;

        do {
            System.out.printf("Turn %d:\n", turn);
            turn++;

            String guess = scanner.nextLine();

            bull = countBull(secret, guess);
            cow = countCow(secret, guess) - bull;

            printResult(bull, cow);

        } while (bull < n);
        System.out.println("Congratulations! You guessed the secret code.");
    }

    private static int countCow(String secret, String guess) {
        int count = 0;

        for (char s : secret.toCharArray()) {
            if (guess.contains(s + "")) {
                count++;
            }
        }

        return count;
    }

    private static int countBull(String secret, String guess) {
        int count = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private static void printResult(int bull, int cow) {
        //there is a case that bull and cow = 0 when n=1 and guess=0
        System.out.print("Grade:");
        if (bull == 0 && cow == 0) {
            System.out.println(" 0 bulls and 0 cows");
        } else if (bull == 0 && cow == 1) {
            System.out.println(" 1 cow");
        } else if (bull == 0) {
            System.out.printf(" %d cows\n", cow);
        } else if (bull == 1 && cow == 1) {
            System.out.println(" 1 bull and 1 cow");
        } else if (bull == 1 && cow == 0) {
            System.out.println(" 1 bull");
        } else if (bull == 1) {
            System.out.printf(" 1 bull and %d cows\n", cow);
        } else if (cow == 1) {
            System.out.printf(" %s bulls and 1 cow\n", bull);
        } else if (cow == 0) {
            System.out.printf(" %s bulls\n", bull);
        } else {
            System.out.printf(" %d bulls and %d cows\n", bull, cow);
        }
    }

    private static String getSecretMessage(String secret, int possibleSymbol) {

        String secretMessage = "The secret is prepared: " + "*".repeat(secret.length()) + " (";

        if (possibleSymbol == 1) {
            secretMessage += "0).";
        } else if (possibleSymbol <= 10) {
            secretMessage += "0-" + dict[possibleSymbol - 1] + ").";
        } else if (possibleSymbol == 11) {
            secretMessage += "0-9, a).";
        } else {
            secretMessage += "0-9, a-" + dict[possibleSymbol - 1] + ").";
        }

        return secretMessage;
    }
}
