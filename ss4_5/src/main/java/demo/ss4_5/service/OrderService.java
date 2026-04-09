package demo.ss4_5.service;

import demo.ss4_5.model.Order;
import demo.ss4_5.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order getOrder(Long id) {
        return repository.findById(id);
    }

    public Order createOrder(Order order) {
        order.setStatus("CREATED");
        return repository.save(order);
    }

    public String cancelOrder(Long id) {
        Order order = repository.findById(id);

        if (order == null) {
            return "Order không tồn tại";
        }

        repository.delete(id);
        return "Đã hủy đơn hàng " + id;
    }
}