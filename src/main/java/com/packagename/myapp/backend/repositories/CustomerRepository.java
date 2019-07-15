package com.packagename.myapp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packagename.myapp.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
