package com.api.ExportDataToExcel.repository;

import com.api.ExportDataToExcel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
