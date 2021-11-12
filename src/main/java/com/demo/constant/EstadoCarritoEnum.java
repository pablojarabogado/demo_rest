/**
 * 
 */
package com.demo.constant;

import java.util.Objects;

import com.demo.config.ModelNotFoundExeption;

/**
 * @author Pablo Jara
 *
 */
public enum EstadoCarritoEnum {

	INCOMPLETO, COMPLETO;

	public static void isCompleto(String estado) {
		if (Objects.equals(COMPLETO.name(), estado)) {
			throw new ModelNotFoundExeption("El carrito ya está en estado completado, ya no puede modificar nada.");
		}
	}
}
