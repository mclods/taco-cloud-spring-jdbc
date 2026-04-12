package com.mclods.taco_cloud_spring_jdbc.controllers;

import com.mclods.taco_cloud_spring_jdbc.domain.TacoOrder;
import com.mclods.taco_cloud_spring_jdbc.services.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/current")
    public String showOrderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors()) {
            return "orderForm";
        }

        orderService.saveOrder(tacoOrder);
        log.info("Order Submitted: {}", tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
