package com.platzi.marken.web.controller;

import com.platzi.marken.domain.Product;
import com.platzi.marken.domain.service.ProductService;
import com.platzi.marken.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductContoller {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return  productService.getAll();

    }


    public Optional<Product> getProduct(int productId){
        return productService.getProduct(productId);
    }

    public Optional <List<Product>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);

    }

    public Product save(Product product){
        return productService.save(product);

    }

    public Boolean delete(int productId){
        return productService.delete(productId);

    }

}
