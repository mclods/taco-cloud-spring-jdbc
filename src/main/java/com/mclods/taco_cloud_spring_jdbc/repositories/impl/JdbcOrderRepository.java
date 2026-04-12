package com.mclods.taco_cloud_spring_jdbc.repositories.impl;

import com.mclods.taco_cloud_spring_jdbc.domain.Taco;
import com.mclods.taco_cloud_spring_jdbc.domain.TacoOrder;
import com.mclods.taco_cloud_spring_jdbc.repositories.OrderRepository;
import com.mclods.taco_cloud_spring_jdbc.services.TacoService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    private final JdbcTemplate jdbcTemplate;
    private final TacoService tacoService;

    public JdbcOrderRepository(JdbcTemplate jdbcTemplate, TacoService tacoService) {
        this.jdbcTemplate = jdbcTemplate;
        this.tacoService = tacoService;
    }

    @Override
    public TacoOrder save(TacoOrder order) {
        order.setOrderDate(LocalDateTime.now());

        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "INSERT INTO " +
                        "taco_order(delivery_name, delivery_street, delivery_city, delivery_state, " +
                        "delivery_zip, cc_number, cc_expiration, cc_cvv, order_date) VALUES" +
                        "(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                List.of(
                        order.getDeliveryName(),
                        order.getDeliveryStreet(),
                        order.getDeliveryCity(),
                        order.getDeliveryState(),
                        order.getDeliveryZip(),
                        order.getCcNumber(),
                        order.getCcExpiration(),
                        order.getCcCVV(),
                        order.getOrderDate()
                ));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);

        int orderId = keyHolder.getKey().intValue();
        order.setId(orderId);

        // Save the tacos present in the order
        List<Taco> tacos = order.getTacos();
        for(Taco taco : tacos) {
            tacoService.saveTaco(order.getId(), taco);
        }

        return order;
    }
}
