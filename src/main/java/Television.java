package main.java;

public class Television implements Watchable {
    private final String name;
    private final double price;
    private final int warranty;
    private final boolean years;

    public static void connectivity() {
        System.out.println("Modern TV sets can be connected to PC or Laptop through HDMI cable.");
    }

    public Television() {
        this("default", 0);
    }

    public Television(String name, double price) {
        this(name, price, 1);
    }

    public Television(String name, double price, int warranty) {
        this.name = name;
        this.price = price;
        this.warranty = warranty;
        years = warranty > 1;
    }

    public void warranty() {
        if (years)
            System.out.println(getName() + " TV comes with " + getWarranty() + " years standard warranty.");
        else
            System.out.println(getName() + " TV comes with " + getWarranty() + " year standard warranty.");
    }

    @Override
    public void watch() {
        System.out.println("Watching " + getName() + " " + getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "%-15s %.2f".formatted(name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getWarranty() {
        return warranty;
    }
}
