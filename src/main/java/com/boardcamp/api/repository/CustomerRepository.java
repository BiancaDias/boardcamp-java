package com.boardcamp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boardcamp.api.models.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

  @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM CustomerModel c WHERE c.cpf = :customerCpf")
  boolean existsByCpf(@Param("customerCpf") String customerCpf);
}
