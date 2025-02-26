import java.util.ArrayList;
import java.util.List;
// Making a new conflict master branch
// Making a new conflict develop branch
public class OrderManager {
    private List<Order> orders = new ArrayList<>();

    public void processOrder(Order order) {
        orders.add(order);
        System.out.println("Processing order: " + order.getOrderId());

        // Create a new thread to update order status
        new Thread(() -> {
            try {
                Thread.sleep(3000); // Simulate processing time
                order.setOrderStatus(OrderStatus.SHIPPED);
                logOrderUpdate(order);

                Thread.sleep(3000); // Simulate delivery time
                order.setOrderStatus(OrderStatus.DELIVERED);
                logOrderUpdate(order);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Logs order updates
    private void logOrderUpdate(Order order) {
        System.out.println("Order " + order.getOrderId() + " is now " + order.getOrderStatus());
    }
}
