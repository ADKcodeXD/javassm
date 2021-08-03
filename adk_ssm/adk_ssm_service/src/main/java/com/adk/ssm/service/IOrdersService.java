package com.adk.ssm.service;

import com.adk.ssm.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IOrdersService {
    List<Orders> findAll(int page, int pagesize);
    Orders findById(String id);

}
