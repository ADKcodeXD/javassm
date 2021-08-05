package com.adk.ssm.dao;

import com.adk.ssm.domain.Permissions;
import com.adk.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    public List<Product> findAll() throws Exception;
    void addProduct(Product product);

}
