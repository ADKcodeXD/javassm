package com.adk.ssm.controller;

import com.adk.ssm.domain.Product;
import com.adk.ssm.service.IProductService;
import com.adk.ssm.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/addProduct.do")
    public String addProduct(Product product) throws Exception {
        product.setId(UUIDutils.getUUID());
        System.out.println(product);
        productService.addProduct(product);
        return "redirect:findAll.do";
    }
}
