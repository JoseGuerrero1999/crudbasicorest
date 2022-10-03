package com.Prueba_2crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Prueba_2crudapi.entity.EmpleadosEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadosEntity, Integer>{

	
}
