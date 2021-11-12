/**
 * 
 */
package com.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.entity.ProductoEntity;
import com.demo.request.ProductoPostReq;
import com.demo.request.ProductoPutReq;
import com.demo.response.ProductoResp;

/**
 * @author Pablo Jara
 *
 */
@Component
public class ProductoConverter {

	public List<ProductoResp> converterListEntityToListResponse(List<ProductoEntity> listaEnList) {
		List<ProductoResp> listRreponse = new ArrayList<>();
		if (!listaEnList.isEmpty()) {
			listaEnList.forEach(a -> {
				listRreponse.add(convertToResponse(a));
			});
		}
		return listRreponse;
	}
	
	public ProductoResp convertToResponse(ProductoEntity a) {
		ProductoResp resp = new ProductoResp();
		resp.setIdProducto(a.getIdProducto());
		resp.setNombre(a.getNombre());
		resp.setDescripcion(a.getDescripcion());
		resp.setSku(a.getSku());
		resp.setPrecio(a.getPrecio());
		resp.setIdTipoProducto(a.getIdTipoProducto());
		return resp;
	}

	public ProductoEntity convertPostToEntity(ProductoPostReq a) {
		ProductoEntity entity = new ProductoEntity();
		entity.setNombre(a.getNombre());
		entity.setDescripcion(a.getDescripcion());
		entity.setSku(a.getSku());
		entity.setPrecio(a.getPrecio());
		entity.setIdTipoProducto(a.getIdTipoProducto());
		return entity;
	}
	
	public ProductoEntity convertPutToEntity(ProductoPutReq a) {
		ProductoEntity entity = new ProductoEntity();
		entity.setIdProducto(a.getIdProducto());
		entity.setNombre(a.getNombre());
		entity.setDescripcion(a.getDescripcion());
		entity.setSku(a.getSku());
		entity.setPrecio(a.getPrecio());
		entity.setIdTipoProducto(a.getIdTipoProducto());
		return entity;
	}
}
