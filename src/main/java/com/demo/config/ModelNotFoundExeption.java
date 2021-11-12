/**
 * 
 */
package com.demo.config;

/**
 * @author Pablo Jara
 *
 */

public class ModelNotFoundExeption extends RuntimeException {

	public ModelNotFoundExeption(String mensaje) {
		super(mensaje);
	}

}
