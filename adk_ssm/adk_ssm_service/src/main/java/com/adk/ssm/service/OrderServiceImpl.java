package com.adk.ssm.service;

import com.adk.ssm.dao.OrdersMapper;
import com.adk.ssm.domain.Orders;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements IOrdersService{

    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<Orders> findAll(int page,int pageszie) {
        PageHelper.startPage(page,pageszie);
        return ordersMapper.findAll();
    }

    @Override
    public Orders findById(String id) {
        Orders orders=ordersMapper.findById(id);
        return orders;
    }
}
