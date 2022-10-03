package com.Prueba_2crudapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Prueba_2crudapi.entity.EmpleadosEntity;
import com.Prueba_2crudapi.service.EmpleadoService;

@RestController
@RequestMapping("/form/empleado")
public class ApiCrudController {

	@Autowired
	private EmpleadoService empleservi;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<EmpleadosEntity>> listaEmpleado(){
		List<EmpleadosEntity> lista = empleservi.listaEmpleado();
		return ResponseEntity.ok(lista);
	}
	@PostMapping
	@ResponseBody
	public ResponseEntity<?>insertaActualiza(@Valid @RequestBody EmpleadosEntity obj , Errors errors){
		HashMap<String, Object> salida = new HashMap<>();
		List<ObjectError> lstErrors= errors.getAllErrors();
		List<String> lstMensaje = new ArrayList<String>();
		for(ObjectError objectError : lstErrors) {
			objectError.getDefaultMessage();
			lstMensaje.add(objectError.getDefaultMessage());
		}if (!CollectionUtils.isEmpty(lstMensaje)) {
			salida.put("Resultado", lstMensaje);
			return ResponseEntity.ok(salida);
		}
		EmpleadosEntity objSalida = empleservi.InsertActualizaEmpleado(obj);
		if (objSalida == null) {
			salida.put("mensaje", "Error en el registro");
		} else {
			salida.put("mensaje", "Se registor el empleado " + objSalida.getIdempleado());
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?>actualizaEmpleado(@RequestBody EmpleadosEntity obj){
		HashMap<String, Object> salida = new HashMap<>();
		Optional<EmpleadosEntity> optEmpleado = empleservi.buscarEmpleado(obj.getIdempleado());
		if (optEmpleado.isPresent()) {
			EmpleadosEntity objSalida = empleservi.InsertActualizaEmpleado(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error al actualizar");
			}
			else {
				salida.put("mensaje", "Se actualizo el empleado " + objSalida.getIdempleado());
			}
			}else {
				salida.put("mensaje", "No existe el empleado " + obj.getIdempleado());
			}	
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> eliminarEmpleado(@PathVariable("id")int id){
		HashMap<String, Object>salida = new HashMap<>();
		Optional<EmpleadosEntity> optEmpleado = empleservi.buscarEmpleado(id);
		if (optEmpleado.isPresent()) {
			empleservi.eliminaEmpleado(id);
			salida.put("mensaje", "Se elimino el empleado " + id);
		} else {
			salida.put("mensaje", "No existe el empleado " + id);
		}
		return ResponseEntity.ok(salida);
	}
	
}
