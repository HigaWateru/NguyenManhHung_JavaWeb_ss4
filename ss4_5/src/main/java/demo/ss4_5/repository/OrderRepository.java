package demo.ss4_5.repository;

import demo.ss4_5.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    private Map<Long, Order> database = new HashMap<>();
    private Long currentId = 1L;

    public Order save(Order order) {
        order.setId(currentId++);
        database.put(order.getId(), order);
        return order;
    }

    public Order findById(Long id) {
        return database.get(id);
    }

    public void delete(Long id) {
        database.remove(id);
    }
}