package com.mclods.taco_cloud_spring_jdbc.services.impl;

import com.mclods.taco_cloud_spring_jdbc.domain.TacoOrder;
import com.mclods.taco_cloud_spring_jdbc.repositories.OrderRepository;
import com.mclods.taco_cloud_spring_jdbc.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public TacoOrder saveOrder(TacoOrder tacoOrder) {
        return orderRepository.save(tacoOrder);
    }
}
