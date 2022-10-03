package com.Prueba_2crudapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prueba_2crudapi.entity.EmpleadosEntity;
import com.Prueba_2crudapi.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImp implements EmpleadoService{

	
	@Autowired
	private EmpleadoRepository Emplerepo;
	
	@Override
	public List<EmpleadosEntity> listaEmpleado() {
		return Emplerepo.findAll();
	}

	@Override
	public EmpleadosEntity InsertActualizaEmpleado(EmpleadosEntity obj) {
		return Emplerepo.save(obj);
	}

	@Override
	public void eliminaEmpleado(int idEmpleado) {
		Emplerepo.deleteById(idEmpleado);
	}

	@Override
	public Optional<EmpleadosEntity> buscarEmpleado(int idEmpleado) {
		return  Emplerepo.findById(idEmpleado);
	}

}
