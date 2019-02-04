package Services;

import model.Order;


import java.util.List;

public interface OrderService {
    Order addOrder(Order order);
    void delete(long id);
    Order getById(long id);//кастомный метод для spr.data(См. OrderDAO)
    Order editOrder(Order ord);
    List<Order>getAllOrders();
}