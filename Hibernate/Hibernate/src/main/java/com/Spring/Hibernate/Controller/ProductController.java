package com.Spring.Hibernate.Controller;

import com.Spring.Hibernate.Model.ProductModel;
import com.Spring.Hibernate.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping("/input")
    public ProductModel toAddProduct(@RequestBody ProductModel model) {
        return service.addModel(model);
    }


    @GetMapping("/input")
    public List<ProductModel> toShowproduct() {
        return service.toShowproduct();
    }
    @DeleteMapping("/input/{id}")
    public void toDelete( @PathVariable Long id)
    {
        service.toDelete(id);
    }
    @PutMapping("/input")
    public ProductModel toUpdate( @RequestBody  ProductModel model)
    {
        return  service.toUpdate(model);
    }

}
