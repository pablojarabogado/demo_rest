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

import com.demo.config.validation.CarritoDetalleGroup;
import com.demo.config.validation.CarritoGroup;
import com.demo.constant.PatronUUID;
import com.demo.request.CarritoCompletadoPutReq;
import com.demo.request.CarritoDetalleDeleteReq;
import com.demo.request.CarritoDetallePostReq;
import com.demo.request.CarritoDetallePutReq;
import com.demo.request.CarritoPostReq;
import com.demo.request.CarritoPutReq;
import com.demo.response.CarritoDetalleResp;
import com.demo.response.CarritoResp;
import com.demo.service.CarritoDetalleService;
import com.demo.service.CarritoService;

/**
 * @author Pablo Jara
 *
 */
@RestController
@RequestMapping("carritos")
@Validated
public class CarritoController {

	@Autowired
	private CarritoService service;

	@Autowired
	private CarritoDetalleService serviceDetalle;

	@GetMapping
	public ResponseEntity<List<CarritoResp>> listar() {
		List<CarritoResp> lista = service.listar();
		return new ResponseEntity<List<CarritoResp>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CarritoResp> leerPorId(
			@NotEmpty @Pattern(regexp = PatronUUID.UUID_PATTERN, message = "El id no cumple con la especificación requerida.") @PathVariable("id") String id) {
		CarritoResp obj = service.leerPorId(UUID.fromString(id));
		return new ResponseEntity<CarritoResp>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CarritoResp> registrar(
			@Valid @Validated(CarritoGroup.class) @RequestBody CarritoPostReq obj) {
		CarritoResp obj2 = service.registrar(obj);
		return new ResponseEntity<CarritoResp>(obj2, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> modificar(@Valid @RequestBody CarritoPutReq obj) {
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	@PutMapping("/completado")
	public ResponseEntity<CarritoResp> completarCarrito(@Valid @RequestBody CarritoCompletadoPutReq obj) {

		CarritoResp obj2 = service.completarCarrito(obj);
		return new ResponseEntity<CarritoResp>(obj2, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(
			@NotEmpty @Pattern(regexp = PatronUUID.UUID_PATTERN, message = "El id no cumple con la especificación requerida.") @PathVariable("id") String id) {

		service.eliminar(UUID.fromString(id));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PostMapping("/detalle")
	public ResponseEntity<CarritoDetalleResp> registrarItem(
			@Valid @Validated(CarritoDetalleGroup.class) @RequestBody CarritoDetallePostReq obj) {
		CarritoDetalleResp obj2 = serviceDetalle.registrarItem(obj);
		return new ResponseEntity<CarritoDetalleResp>(obj2, HttpStatus.CREATED);
	}

	@PutMapping("/detalle")
	public ResponseEntity<Object> modificarItem(
			@Valid @RequestBody CarritoDetallePutReq obj) {
		serviceDetalle.modificarItem(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	@DeleteMapping("/detalle")
	public ResponseEntity<Object> eliminarItem(@Valid @RequestBody CarritoDetalleDeleteReq obj) {

		serviceDetalle.eliminarItem(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
