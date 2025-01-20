package com.Spring.FirstWebApp.Controller;

import com.Spring.FirstWebApp.Model.Product;
import com.Spring.FirstWebApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProduct() {
        return service.getProduct();
    }

    @GetMapping("products/{id}")
    public Product toGetProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/products")

    public void toAddProduct(@RequestBody Product pro) {
        service.addProduct(pro
        );
    }

    @PutMapping("/products")
    public void toUpdateProduct(@RequestBody Product prod) {
        System.out.println(prod);
        service.toUpdate(prod);
    }
    @DeleteMapping("/products/{pro}")
    public void toDelete(@PathVariable int pro) {
        service.toDelete(pro);
        System.out.println("PRODUCT IS DELETED with ID: " + pro);
    }

}