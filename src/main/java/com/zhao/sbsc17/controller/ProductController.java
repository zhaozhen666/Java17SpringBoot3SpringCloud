package com.zhao.sbsc17.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhao.sbsc17.dao.ProductMapper;
import com.zhao.sbsc17.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductMapper productMapper;

    @GetMapping("master")
    @DS("master")
    public Product master(){
        return productMapper.selectById(1L);
    }

    @GetMapping("slave1")
    @DS("slave1")
    public Product slave1(){
        return productMapper.selectById(1L);
    }

    @GetMapping("slave2")
    @DS("slave2")
    public Product slave2(){
        return productMapper.selectById(1L);
    }
}
