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

import com.demo.converter.TipoProductoConverter;
import com.demo.entity.TipoProductoEntity;
import com.demo.repository.ITipoProductoRepository;
import com.demo.request.TipoProductoPostReq;
import com.demo.request.TipoProductoPutReq;
import com.demo.response.TipoProductoResp;
import com.demo.utils.ValidacionGlobal;

/**
 * @author Pablo Jara
 *
 */
@Service
@Transactional
public class TipoProductoService {

	@Autowired
	private ITipoProductoRepository repo;

	@Autowired
	private TipoProductoConverter converter;
	
	@Autowired
	private ValidacionGlobal validacionGlobal;

	public List<TipoProductoResp> listar() {
		List<TipoProductoEntity> listaEnList = repo.findAll();
		return converter.converterListEntityToListResponse(listaEnList);
	}

	public TipoProductoResp leerPorId(UUID id) {
		TipoProductoEntity entity = validacionGlobal.buscarTipoProducto(id);

		return converter.convertToResponse(entity);
	}

	public TipoProductoResp registrar(@Valid TipoProductoPostReq obj) {
		TipoProductoResp reponse = converter.convertToResponse(repo.save(converter.convertPostToEntity(obj)));
		return reponse;
	}

	public void modificar(@Valid TipoProductoPutReq obj) {
		validacionGlobal.buscarTipoProducto(obj.getIdTipoProducto());
		repo.save(converter.convertPutToEntity(obj));

	}

	public void eliminar(UUID id) {
		TipoProductoEntity entity = validacionGlobal.buscarTipoProducto(id);
		repo.delete(entity);
	}

}
