/**
 * 
 */
package com.demo.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.constant.EstadoCarritoEnum;
import com.demo.entity.CarritoDetalleEntity;
import com.demo.entity.CarritoEntity;
import com.demo.repository.ICarritoDetalleRepository;
import com.demo.request.CarritoPostReq;
import com.demo.request.CarritoPutReq;
import com.demo.response.CarritoDetalleResp;
import com.demo.response.CarritoResp;

/**
 * @author Pablo Jara
 *
 */
@Component
public class CarritoConverter {
	
	@Autowired
	private ICarritoDetalleRepository iCarritoDetalleRepository;
	
	@Autowired
	private CarritoDetalleConverter converterDetalle;

	public CarritoEntity convertirPostToEntity(CarritoPostReq obj) {
		CarritoEntity entity = new CarritoEntity();
		entity.setDescripcion(obj.getDescripcion());
		entity.setEstado(EstadoCarritoEnum.INCOMPLETO.name());
		entity.setPrecioTotal(0D);
		return entity;
	}

	public CarritoEntity convertirPutToEntity(CarritoEntity entityEntrance, CarritoPutReq obj) {
		CarritoEntity entity = new CarritoEntity();
		entity = entityEntrance;
		entity.setDescripcion(obj.getDescripcion());
		return entity;
	}

	public List<CarritoResp> converterListEntityToListResponse(List<CarritoEntity> listaEnList) {
		List<CarritoResp> listRreponse = new ArrayList<>();
		if (!listaEnList.isEmpty()) {
			listaEnList.forEach(a -> {
				listRreponse.add(convertToResponse(a));
			});
		}
		return listRreponse;
	}

	public CarritoResp convertToResponse(CarritoEntity entity) {
		CarritoResp response = new CarritoResp();
		response.setIdCarrito(entity.getIdCarrito());
		response.setDescripcion(entity.getDescripcion());
		response.setEstado(entity.getEstado());;
		response.setPrecioTotal(entity.getPrecioTotal());
		response.setListaProducto(buscarDetalleCarrito(entity.getIdCarrito()));
		return response;
	}

	private List<CarritoDetalleResp> buscarDetalleCarrito(UUID idCarrito) {
		List<CarritoDetalleEntity> lista = iCarritoDetalleRepository.findByPkIdCarrito(idCarrito);
		return converterDetalle.converterListEntityToListResponse(lista);
	}

}
