public class Smartphone extends Product {

    private String model;
    private String performance;

    public Smartphone(int id, String name, int price, String model, String performance) {
        super(id, name, price);
        this.performance = performance;
        this.model = model;
    }
}