import java.util.UUID;

public class Products {
    private UUID productID;
    private String name;
    private double price;
    private int stockLevel ;
    private int reorderThreshold;

    public Products(String name, double price,int stockLevel, int reorderThreshold){
        this.name = name;
        this.price = price;
        this.stockLevel = stockLevel;
        this.reorderThreshold = reorderThreshold;
        this.productID = UUID.randomUUID();


    }
    public UUID getProductID() {
        return productID;
    }
    public String getName() {
        return name;

    }
    public double getPrice() {
        return price;
    }
    public int getStockLevel() {
        return stockLevel;
    }
    public int getReorderThreshold() {
        return reorderThreshold;
    }
    public void reduceStock(int quantity){
        if(quantity > stockLevel){
            stockLevel -= quantity;
        }
        else {
            System.out.println("Not enought stock");
        }
    }

    public void restock(int quantity){
        if(quantity > stockLevel){
            stockLevel += quantity;
        }

    }
}


