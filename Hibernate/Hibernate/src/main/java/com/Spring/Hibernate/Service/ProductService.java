
package com.Spring.Hibernate.Service;

import com.Spring.Hibernate.Model.ProductModel;
import com.Spring.Hibernate.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    // Method to add a new product
    public ProductModel addModel(ProductModel model) {
        return productRepo.save(model);  // Saves the product to the database
    }

    public List<ProductModel> toShowproduct() {
        return productRepo.findAll();
    }

    public void toDelete(Long id) {
        productRepo.deleteById(id);
    }

    public ProductModel toUpdate(ProductModel model) {
        return productRepo.save(model);
    }
}
