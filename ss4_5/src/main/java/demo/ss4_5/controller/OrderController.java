package demo.ss4_5.controller;

import demo.ss4_5.model.Order;
import demo.ss4_5.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }
    @GetMapping
    public Object getAllOrder() {
        return "Danh sách đơn hàng: ";
    }

    @GetMapping("/{id}")
    public Object getOrder(@PathVariable("id") String id) {
        try {
            Long orderId = Long.parseLong(id);
            Order order = service.getOrder(orderId);
            if (order == null) return "Không tìm thấy đơn hàng";
            return order;
        } catch (NumberFormatException e) {
            return "ID đơn hàng phải là số!";
        }
    }
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return service.cancelOrder(id);
    }
}