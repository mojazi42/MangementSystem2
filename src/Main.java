import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Laptop and Smartphone products
        Products laptop = new Products("Laptop", 1200.0, 20, 5);
        Products smartphone = new Products("Smartphone", 800.0, 10, 3);

        // Display product details
        displayProductInfo(laptop);
        displayProductInfo(smartphone);

        // Get user input for average daily sales
        System.out.print("Enter average daily sales for Laptop: ");
        int laptopSales = scanner.nextInt();

        System.out.print("Enter average daily sales for Smartphone: ");
        int smartphoneSales = scanner.nextInt();

        // Predict stock depletion and restock suggestion for Laptop
        System.out.println("\nStock Prediction for Laptop:");
        displayStockPrediction(laptop, laptopSales);

        // Predict stock depletion and restock suggestion for Smartphone
        System.out.println("\nStock Prediction for Smartphone:");
        displayStockPrediction(smartphone, smartphoneSales);

        // Close scanner
        scanner.close();
    }

    // Method to display product information
    private static void displayProductInfo(Products product) {
        System.out.println("Product ID: " + product.getProductID());
        System.out.println("Name: " + product.getName());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Stock Level: " + product.getStockLevel());
        System.out.println("Reorder Threshold: " + product.getReorderThreshold());
        System.out.println("----------------------------");
    }

    // Method to display stock prediction and restocking suggestion
    private static void displayStockPrediction(Products product, int averageDailySales) {
        try {
            int daysLeft = StockPredictor.predictStockDepletion(product, averageDailySales);
            System.out.println("Days until stock out: " + daysLeft);
            System.out.println("Restock Suggestion: " + StockPredictor.suggestRestocking(product, averageDailySales));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
