package com.adk.ssm.service;

import com.adk.ssm.dao.ProductMapper;
import com.adk.ssm.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> productList = productMapper.findAll();
        return productList;
    }

    @Override
    public void addProduct(Product product) throws Exception {
        productMapper.addProduct(product);
    }
}
