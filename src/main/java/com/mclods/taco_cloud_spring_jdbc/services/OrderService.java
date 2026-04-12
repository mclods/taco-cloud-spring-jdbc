package com.mclods.taco_cloud_spring_jdbc.services;

import com.mclods.taco_cloud_spring_jdbc.domain.TacoOrder;

public interface OrderService {
    TacoOrder saveOrder(TacoOrder tacoOrder);
}
