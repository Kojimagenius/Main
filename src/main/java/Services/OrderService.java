package Services;

import model.Order;


import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    void deleteOrder(long id);
    Order getById(long id);
    Order editOrder(Order ord);
    List<Order>getAllOrders();
}