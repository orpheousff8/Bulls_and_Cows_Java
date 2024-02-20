import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Donut c = new Donut();
        c.setFlavor("vanilla");
        c.setPrice(1.0);

        Donut v = new Donut();
        v.setFlavor("chocolate");
        v.setPrice(1.5);

        DonutStore donutStore = new DonutStore(new Donut[]{c, v});

        System.out.println(donutStore.sellDonut(input.nextLine()));
    }
}

class Donut {

    // Your code here
    private String flavor;
    private double price;

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlavor() {
        return this.flavor;
    }

    public double getPrice() {
        return this.price;
    }

}

class DonutStore {
    // Your code here
    Donut[] donuts;

    public DonutStore(Donut[] donuts) {
        this.donuts = donuts;
    }

    public double sellDonut(String flavor) {
        for (Donut donut : this.donuts) {
            if (Objects.equals(donut.getFlavor(), flavor)) {
                return donut.getPrice();
            }
        }
        return 0.0;
    }
}