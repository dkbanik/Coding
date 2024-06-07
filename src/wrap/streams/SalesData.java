package wrap.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class SaleRecord {
    private String product;
    private double price;
    private int quantity;
    public SaleRecord(String product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }
    public String getProduct() {
        return product;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}

public class SalesData {
    public static void main(String[] args) {
        List<SaleRecord> sales = Arrays.asList(
                new SaleRecord("Laptop", 1200.00, 5),
                new SaleRecord("Smartphone", 800.00, 10),
                new SaleRecord("Tablet", 400.00, 8),
                new SaleRecord("Headphones", 100.00, 20),
                new SaleRecord("Smartwatch", 300.00, 15)
                                              );
        double totalRevenue = sales.stream()
                .mapToDouble(record ->
                    record.getQuantity()*record.getPrice()
                ).sum();
        System.out.println("total revenue " +totalRevenue);

        // Product with highest & lowest sales
        String product = sales.stream()
                              .sorted(Comparator.comparingDouble(record -> -record.getQuantity()*record.getPrice()))
                              .findFirst().get().getProduct();


        String product2 = sales.stream()
                               .min((r1, r2) -> Double.compare(r1.getQuantity()*r1.getPrice(),r2.getQuantity()*r2.getPrice()))
                               .get().getProduct();

        System.out.println("Product with highest sales "+product);
        System.out.println("Product with lowest sales "+product2);

        // avg sales
        double avg = sales.stream()
                .mapToDouble(record -> record.getPrice()).average().getAsDouble();

        System.out.println("Average "+avg);
        // Perform analysis using Java 8 streams and lambda expressions

    }

}
