import java.util.Scanner;

public class Main {
    public static class Vehicle {
        // define your fields here
        protected int tires;
        protected String color;

        // define Vehicle constructor here

        public Vehicle(int tires, String color) {
            this.tires = tires;
            this.color = color;
        }

        // define toString method here
        @Override
        public String toString() {
            return "Tires: " + tires +
                    ", Color: " + color;
        }
    }

    public static class Car extends Vehicle {
        // define your fields here
        protected int speed;

        // define Car constructor here. Don't forget to use 'super' keyword to call parent's constructor.

        public Car(int tires, String color, int speed) {
            super(tires, color);
            this.speed = speed;
        }

        // override toString method to also include Car specifics
        @Override
        public String toString() {
            return "Tires: " + tires +
                    ", Color: " + color +
                    ", Speed: " + speed;
        }
    }

    public static void main(String[] args) {
        // test your classes with some instances here
        Scanner scanner = new Scanner(System.in);
        int tries = scanner.nextInt();
        scanner.nextLine();
        String color = scanner.nextLine();
        int speed = scanner.nextInt();

        Car c = new Car(tries, color, speed);
        System.out.println(c.toString());
    }
}