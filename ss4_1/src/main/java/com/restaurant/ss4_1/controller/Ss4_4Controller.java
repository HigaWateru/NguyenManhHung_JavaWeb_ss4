package com.restaurant.ss4_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ss4_4Controller {

    @GetMapping("/bai4/products")
    public String getProducts(
            @RequestParam String category,
            @RequestParam int limit,
            ModelMap model) {
        model.addAttribute("category", category).addAttribute("limit", limit).addAttribute("message", "Tim kiem thanh cong");

        return "productList";
    }
}