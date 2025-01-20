package com.Spring.FirstWebApp.Service;

import com.Spring.FirstWebApp.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    Product product;
    List<Product> p = new ArrayList<>();


    public List<Product> getProduct() {
        p.add(new Product("Product A", 101, 1000));
        p.add(new Product("Product B", 102, 1500));
        p.add(new Product("Product C", 103, 2000));
        p.add(new Product("Product D", 104, 2500));
        p.add(new Product("Product E", 105, 3000));
        p.add(new Product("Product F", 106, 3500));
        p.add(new Product("Product G", 107, 4000));
        p.add(new Product("Product H", 108, 4500));
        p.add(new Product("Product I", 109, 5000));
        p.add(new Product("Product J", 110, 5500));
        return p;
    }

    public Product getProductById(int id) {
        return p.stream()
                .filter(pro -> pro.getProdid() == id) // Assumes getProdid() returns int
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found"));
    }


    public void addProduct( Product prod) {
        System.out.println(prod);
        p.add(prod);

    }
    public void toUpdate(Product pro)
    {
         int id =pro.getProdid();
         for(int i=0 ;i < p.size();i++)
         {
             if(id==p.get(i).getProdid())
             {
                 p.set(i,pro);
             }
         }
    }
    public void toDelete(int id) {
        p.removeIf(product -> product.getProdid() == id); // Remove the product with the given id
    }



}

