package com.test.telefonica.services.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.test.telefonica.entity.Variable;
import com.test.telefonica.services.IEjercicioService;

@Service
public class ServiceImpl implements IEjercicioService {

	@Override
	public String cuadratica(Integer a, Integer b, Integer c) {

		Double resultado = (Math.pow(b, 2) - (4 * a * c));

		if (resultado >= 0) {

			Double[] soluciones;

			if (resultado == 0) {
				soluciones = new Double[1];
				try {
					soluciones[0] = (double) (((-b) - (4 * a * c)) / (2 * a));
				} catch (ArithmeticException e) {
					return "Error" + e.getMessage();
				}

			} else {
				soluciones = new Double[2];
				try {
					soluciones[0] = ((-b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
					soluciones[1] = ((-b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
				} catch (ArithmeticException e) {
					return "Error" + e.getMessage();
				}

			}

			return Arrays.toString(soluciones);
		} else {
			return "No existe solucion";
		}

	}

}
