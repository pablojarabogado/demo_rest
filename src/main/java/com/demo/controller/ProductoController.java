/**
 * 
 */
package com.demo.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.constant.PatronUUID;
import com.demo.request.ProductoPostReq;
import com.demo.request.ProductoPutReq;
import com.demo.response.ProductoResp;
import com.demo.service.ProductoService;

/**
 * @author Pablo Jara
 *
 */
@RestController
@RequestMapping("productos")
@Validated
public class ProductoController {
	
	@Autowired
	private ProductoService service;

	@GetMapping
	public ResponseEntity<List<ProductoResp>> listar() {
		List<ProductoResp> lista = service.listar();
		return new ResponseEntity<List<ProductoResp>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductoResp> leerPorId(
			@NotEmpty
			@Pattern(regexp = PatronUUID.UUID_PATTERN,
			message = "El id no cumple con la especificación requerida.")
			@PathVariable("id") String id) {
		ProductoResp obj = service.leerPorId(UUID.fromString(id));
		return new ResponseEntity<ProductoResp>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductoResp> registrar(@Valid @RequestBody ProductoPostReq obj) {
		ProductoResp obj2 = service.registrar(obj);
		return new ResponseEntity<ProductoResp>(obj2, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> modificar(@Valid @RequestBody ProductoPutReq obj) {
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(
			@NotEmpty
			@Pattern(regexp = PatronUUID.UUID_PATTERN,
			message = "El id no cumple con la especificación requerida.")
			@PathVariable("id") String id) {

		service.eliminar(UUID.fromString(id));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
