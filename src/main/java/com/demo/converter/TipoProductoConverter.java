/**
 * 
 */
package com.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.entity.TipoProductoEntity;
import com.demo.request.TipoProductoPostReq;
import com.demo.request.TipoProductoPutReq;
import com.demo.response.TipoProductoResp;

/**
 * @author Pablo Jara
 *
 */
@Component
public class TipoProductoConverter {

	public List<TipoProductoResp> converterListEntityToListResponse(List<TipoProductoEntity> listaEnList) {
		List<TipoProductoResp> listRreponse = new ArrayList<>();
		if (!listaEnList.isEmpty()) {
			listaEnList.forEach(a -> {
				listRreponse.add(convertToResponse(a));
			});
		}
		return listRreponse;
	}

	public TipoProductoResp convertToResponse(TipoProductoEntity a) {
		TipoProductoResp resp = new TipoProductoResp();
		resp.setIdTipoProducto(a.getIdTipoProducto());
		resp.setTipoProducto(a.getTipoProducto());
		resp.setConDescuento(a.getConDescuento());
		return resp;
	}

	public TipoProductoEntity convertPostToEntity(TipoProductoPostReq a) {
		TipoProductoEntity entity = new TipoProductoEntity();
		entity.setTipoProducto(a.getTipoProducto());
		entity.setConDescuento(a.getConDescuento());
		return entity;
	}

	public TipoProductoEntity convertPutToEntity(TipoProductoPutReq a) {
		TipoProductoEntity entity = new TipoProductoEntity();
		entity.setIdTipoProducto(a.getIdTipoProducto());
		entity.setTipoProducto(a.getTipoProducto());
		entity.setConDescuento(a.getConDescuento());
		return entity;
	}
}
