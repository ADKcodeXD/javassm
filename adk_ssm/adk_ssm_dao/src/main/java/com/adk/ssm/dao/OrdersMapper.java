package com.adk.ssm.dao;

import com.adk.ssm.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper {
    public List<Orders>findAll();
    public Orders findById(String id);
}
