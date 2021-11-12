/**
 * 
 */
package com.demo.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.converter.ProductoConverter;
import com.demo.entity.ProductoEntity;
import com.demo.repository.IProductoRepository;
import com.demo.request.ProductoPostReq;
import com.demo.request.ProductoPutReq;
import com.demo.response.ProductoResp;
import com.demo.utils.ValidacionGlobal;

/**
 * @author Pablo Jara
 *
 */
@Service
@Transactional
public class ProductoService {

	@Autowired
	private ProductoConverter converter;

	@Autowired
	private IProductoRepository repo;

	@Autowired
	private ValidacionGlobal validacionGlobal;

	public List<ProductoResp> listar() {
		List<ProductoEntity> listaEnList = repo.findAll();
		return converter.converterListEntityToListResponse(listaEnList);
	}

	public ProductoResp leerPorId(UUID id) {
		ProductoEntity entity = validacionGlobal.buscarProducto(id);
		return converter.convertToResponse(entity);
	}

	public ProductoResp registrar(@Valid ProductoPostReq obj) {
		validacionGlobal.buscarTipoProducto(obj.getIdTipoProducto());
		ProductoResp reponse = converter.convertToResponse(repo.save(converter.convertPostToEntity(obj)));
		return reponse;
	}

	public void modificar(@Valid ProductoPutReq obj) {
		validacionGlobal.buscarProducto(obj.getIdProducto());
		validacionGlobal.buscarTipoProducto(obj.getIdTipoProducto());
		repo.save(converter.convertPutToEntity(obj));

	}

	public void eliminar(UUID id) {
		ProductoEntity entity = validacionGlobal.buscarProducto(id);
		repo.delete(entity);
	}

}
