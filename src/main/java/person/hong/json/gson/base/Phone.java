package person.hong.json.gson.base;

public class Phone {

    private String number;
    private double price;

    public Phone() {
        super();
    }

    public Phone(String number, double price) {
        super();
        this.number = number;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone [number=" + number + ", price=" + price + "]";
    }

}
