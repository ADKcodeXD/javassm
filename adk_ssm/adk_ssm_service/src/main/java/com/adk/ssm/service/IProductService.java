package com.adk.ssm.service;

import com.adk.ssm.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    public List<Product> findAll() throws Exception;
    public void addProduct(Product product) throws Exception;
}
