package com.example.revconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.revconnect.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}