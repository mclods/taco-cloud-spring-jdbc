package com.mclods.taco_cloud_spring_jdbc.repositories;

import com.mclods.taco_cloud_spring_jdbc.domain.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}

