package com.dio.santander.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

}
