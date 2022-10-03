package com.Prueba_2crudapi.service;
import java.util.List;
import java.util.Optional;

import com.Prueba_2crudapi.entity.EmpleadosEntity;

public interface EmpleadoService {

	public abstract List<EmpleadosEntity>listaEmpleado();
	public abstract EmpleadosEntity InsertActualizaEmpleado(EmpleadosEntity obj);
	public abstract void eliminaEmpleado (int idEmpleado);
	public abstract Optional<EmpleadosEntity> buscarEmpleado (int idEmpleado);
}
