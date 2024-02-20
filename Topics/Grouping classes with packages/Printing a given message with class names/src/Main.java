// Required Java imports

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Read input string
        String input = scanner.nextLine();

        // Instantiate classes and call display method
        var alpha = new classAlpha();
        var beta = new classBeta();

        alpha.display(input);
        beta.display(input);
    }
}

// Define your Package1 and ClassAlpha here
class classAlpha {
    public void display(String s) {
        System.out.printf("ClassAlpha: %s\n", s);
    }
}

// Define your Package2 and ClassBeta here
class classBeta {
    public void display(String s) {
        System.out.printf("ClassBeta: %s\n", s);
    }
}