package com.Spring.Hibernate.Repo;

import com.Spring.Hibernate.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductModel,Long> {
}
