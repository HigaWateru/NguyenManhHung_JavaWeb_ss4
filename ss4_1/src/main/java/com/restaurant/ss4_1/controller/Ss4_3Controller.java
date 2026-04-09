package com.restaurant.ss4_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Ss4_3Controller {

    @GetMapping("/bai3/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return "Chi tiet don hang so " + id;
    }
}