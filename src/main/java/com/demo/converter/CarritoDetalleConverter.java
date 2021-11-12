/**
 * 
 */
package com.demo.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.demo.entity.CarritoDetalleEntity;
import com.demo.entity.CarritoDetalleEntityPK;
import com.demo.request.CarritoDetallePostReq;
import com.demo.request.CarritoDetallePutReq;
import com.demo.response.CarritoDetalleResp;

/**
 * @author Pablo Jara
 *
 */
@Component
public class CarritoDetalleConverter {

	public CarritoDetalleEntity convertirPostToEntity(CarritoDetallePostReq obj) {
		CarritoDetalleEntityPK pk = new CarritoDetalleEntityPK();
		pk.setIdCarrito(obj.getIdCarrito());
		pk.setItemCarrito(UUID.randomUUID());
		CarritoDetalleEntity entity = new CarritoDetalleEntity();
		entity.setPk(pk);
		entity.setIdProducto(obj.getIdProducto());
		entity.setCantidad(obj.getCantidad());
		return entity;
	}

	public CarritoDetalleEntity convertirPutToEntity(CarritoDetalleEntity entityEntrance, CarritoDetallePutReq obj) {
		entityEntrance.setCantidad(obj.getCantidad());
		return entityEntrance;
	}

	public List<CarritoDetalleResp> converterListEntityToListResponse(List<CarritoDetalleEntity> listaEnList) {
		List<CarritoDetalleResp> listRreponse = new ArrayList<>();
		if (!listaEnList.isEmpty()) {
			listaEnList.forEach(a -> {
				listRreponse.add(convertToResponse(a));
			});
		}
		return listRreponse;
	}

	public CarritoDetalleResp convertToResponse(CarritoDetalleEntity entity) {
		CarritoDetalleResp response = new CarritoDetalleResp();
		response.setIdCarrito(entity.getPk().getIdCarrito());
		response.setItemCarrito(entity.getPk().getItemCarrito());
		response.setIdProducto(entity.getIdProducto());
		response.setCantidad(entity.getCantidad());
		return response;
	}
}
