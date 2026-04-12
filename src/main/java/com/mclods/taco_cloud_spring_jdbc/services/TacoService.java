package com.mclods.taco_cloud_spring_jdbc.services;

import com.mclods.taco_cloud_spring_jdbc.domain.Taco;

public interface TacoService {
    Taco saveTaco(int orderId, Taco taco);
}
