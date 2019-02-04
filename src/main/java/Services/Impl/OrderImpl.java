package Services.Impl;

import Services.OrderService;
import dao.OrderDAO;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderImpl implements OrderService {

    @Autowired
    private OrderDAO orderRepository;

    public Order addOrder(Order order) {
    Order newOrder = orderRepository.saveAndFlush(order);

    return newOrder;
    }

    public void delete(long id) {
        orderRepository.delete(getById(id));

    }

    public Order getById(long id) {//кастомный метод для spr.data(См. OrderDAO)
        return orderRepository.getById(id);
    }

    public Order editOrder(Order ord) {
        return orderRepository.saveAndFlush(ord);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
