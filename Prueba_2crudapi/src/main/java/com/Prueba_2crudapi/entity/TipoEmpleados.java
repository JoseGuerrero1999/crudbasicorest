package com.Prueba_2crudapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "tipoempleado")
public class TipoEmpleados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtipoempleado ;
	private String tipoempleado;

}
