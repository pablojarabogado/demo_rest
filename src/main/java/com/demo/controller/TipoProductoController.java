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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.constant.PatronUUID;
import com.demo.request.TipoProductoPostReq;
import com.demo.request.TipoProductoPutReq;
import com.demo.response.TipoProductoResp;
import com.demo.service.TipoProductoService;

/**
 * @author Pablo Jara
 *
 */
@RestController
@RequestMapping("tipos-productos")
@Validated
public class TipoProductoController {

	@Autowired
	private TipoProductoService service;

	@GetMapping
	public ResponseEntity<List<TipoProductoResp>> listar() {
		List<TipoProductoResp> lista = service.listar();
		return new ResponseEntity<List<TipoProductoResp>>(lista, HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<TipoProductoResp> leerPorId(@NotEmpty
			@Pattern(regexp = PatronUUID.UUID_PATTERN,
			message = "El id no cumple con la especificación requerida.")
			@RequestParam String id) {
		TipoProductoResp obj = service.leerPorId(UUID.fromString(id));
		return new ResponseEntity<TipoProductoResp>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TipoProductoResp> registrar(@Valid @RequestBody TipoProductoPostReq obj) {
		TipoProductoResp obj2 = service.registrar(obj);
		return new ResponseEntity<TipoProductoResp>(obj2, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> modificar(@Valid @RequestBody TipoProductoPutReq obj) {
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@NotEmpty
			@Pattern(regexp = PatronUUID.UUID_PATTERN,
			message = "El id no cumple con la especificación requerida.")
			 @PathVariable("id") String id) {
		service.eliminar(UUID.fromString(id));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
