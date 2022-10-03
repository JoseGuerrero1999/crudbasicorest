package com.Prueba_2crudapi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table (name = "empleados")
public class EmpleadosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idempleado ; 
	
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,20}" , message = "El nombre debe tener entre 2 y 50 caracteres")
	private String nombre ;
	
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,20}" , message = "El nombre debe tener entre 2 y 50 caracteres")
	private String apellido;
	
	@Pattern(regexp = "[0-9]{8}" ,message = "El documento de identidad debe tener 8 dígitos")
	private String dni;
	
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\\\s]{2,20}(@hotmail.com)" ,message = "Ingrese un correo de hotmail")
	private String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechacumpleaños;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtipoempleado")
	private TipoEmpleados tipoempleado;

}
