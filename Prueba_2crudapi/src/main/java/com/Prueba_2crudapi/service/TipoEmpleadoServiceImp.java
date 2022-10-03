package com.Prueba_2crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prueba_2crudapi.entity.TipoEmpleados;
import com.Prueba_2crudapi.repository.TipoEmpleadoRepository;

@Service
public class TipoEmpleadoServiceImp  implements TipoEmpleadoService{

	@Autowired TipoEmpleadoRepository tiporepo;

	@Override
	public List<TipoEmpleados> listaTipoEmpleado() {
		
		return tiporepo.findAll();
	}
}
