package com.mclods.taco_cloud_spring_jdbc.services.impl;

import com.mclods.taco_cloud_spring_jdbc.domain.Taco;
import com.mclods.taco_cloud_spring_jdbc.repositories.TacoRepository;
import com.mclods.taco_cloud_spring_jdbc.services.TacoService;
import org.springframework.stereotype.Service;

@Service
public class TacoServiceImpl implements TacoService {
    private final TacoRepository tacoRepository;

    public TacoServiceImpl(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @Override
    public Taco saveTaco(int orderId, Taco taco) {
        return tacoRepository.save(orderId, taco);
    }
}
