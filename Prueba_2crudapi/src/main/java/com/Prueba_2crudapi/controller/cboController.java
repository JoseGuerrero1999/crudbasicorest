package com.Prueba_2crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Prueba_2crudapi.entity.TipoEmpleados;
import com.Prueba_2crudapi.service.TipoEmpleadoService;

@RestController
@RequestMapping("/test/tipo")
public class cboController {
	@Autowired
	private TipoEmpleadoService tiporepo;
	

	@GetMapping("/empleado")
	@ResponseBody
	public ResponseEntity<List<TipoEmpleados>> listatipoemple(){
		List<TipoEmpleados> lista = tiporepo.listaTipoEmpleado();
		return ResponseEntity.ok(lista);
	}

}
