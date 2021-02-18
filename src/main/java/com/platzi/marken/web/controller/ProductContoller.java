package com.platzi.marken.web.controller;

import com.platzi.marken.domain.Product;
import com.platzi.marken.domain.service.ProductService;
import com.platzi.marken.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductContoller {

    @Autowired//Es para no generar instancias manuales
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(prods -> new ResponseEntity<>(prods, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{catid}")
    public ResponseEntity<List<Product>>  getByCategory(@PathVariable("catid") int categoryId){
        return productService.getByCategory(categoryId)
                .map(prods -> new ResponseEntity<>(prods, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody  Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        if ( productService.delete(productId) ){
          return  new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }


    }

}
