package com.restaurant.bai2.controller;

import com.restaurant.ss4_1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Ss4_2Controller {

    private final OrderService orderService;

    @Autowired
    public Bai2Controller(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/bai2/orders")
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }
    @GetMapping("/bai2/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/bai2/menu")
    @ResponseBody
    public String getMenu(@RequestParam(value = "category", required = false, defaultValue = "chay") String category) {
        return "Menu loai: " + category;
    }
}