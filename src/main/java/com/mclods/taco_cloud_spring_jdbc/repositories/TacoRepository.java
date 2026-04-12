package com.mclods.taco_cloud_spring_jdbc.repositories;

import com.mclods.taco_cloud_spring_jdbc.domain.Taco;

public interface TacoRepository {
    Taco save(int orderId, Taco taco);
}
