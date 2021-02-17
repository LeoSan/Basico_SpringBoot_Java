package com.platzi.marken.web.controller;

import com.platzi.marken.domain.Product;
import com.platzi.marken.domain.service.ProductService;
import com.platzi.marken.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{catid}")
    public Optional <List<Product>> getByCategory(@PathVariable("catid") int categoryId){
        return productService.getByCategory(categoryId);

    }

    @PostMapping("/save")
    public Product save(@RequestBody  Product product){
        return productService.save(product);

    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);

    }

}
