package com.test.telefonica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.telefonica.entity.Variable;
import com.test.telefonica.services.IEjercicioService;

@RestController
@RequestMapping("/api")
public class Operacion {

	@Autowired
	private IEjercicioService ejercicioService;

	@GetMapping("/cuadratica")
	public ResponseEntity<?> cuadratica() {

		Variable variableABC = new Variable();
		variableABC.setA(2);
		variableABC.setB(7);
		variableABC.setC(2);

		String resp = ejercicioService.cuadratica(variableABC.getA(), variableABC.getB(), variableABC.getC());
		return ResponseEntity.ok().body("Respuesta: " + resp);

	}
	
	@GetMapping("/fibonnacci/{tamano}")
	public ResponseEntity<?> cuadratica(@PathVariable Integer tamano) {

		String resp = ejercicioService.fibonacci(tamano);
		return ResponseEntity.ok().body("Respuesta: " + resp);

	}

}
