public class StockPredictor {
    public static int predictStockDepletion(Products product, int averageDailySales) {
        if (averageDailySales <= 0) {
            throw new IllegalArgumentException("Average daily sales must be greater than zero.");
        }
        return product.getStockLevel() / averageDailySales;
    }

    public static String suggestRestocking(Products product, int averageDailySales) {
        int daysLeft = predictStockDepletion(product, averageDailySales);
        if (product.getStockLevel() <= product.getReorderThreshold()) {
            return "Urgent: Restock immediately.";
        } else if (daysLeft <= 5) {
            return "Moderate: Consider restocking soon.";
        } else {
            return "Stock is sufficient for now.";
        }
    }
}
