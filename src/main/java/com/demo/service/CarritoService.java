/**
 * 
 */
package com.demo.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.constant.EstadoCarritoEnum;
import com.demo.converter.CarritoConverter;
import com.demo.entity.CarritoDetalleEntity;
import com.demo.entity.CarritoDetalleEntityPK;
import com.demo.entity.CarritoEntity;
import com.demo.entity.ProductoEntity;
import com.demo.entity.TipoProductoEntity;
import com.demo.repository.ICarritoDetalleRepository;
import com.demo.repository.ICarritoRepository;
import com.demo.request.CarritoCompletadoPutReq;
import com.demo.request.CarritoDetallePostReq;
import com.demo.request.CarritoPostReq;
import com.demo.request.CarritoPutReq;
import com.demo.response.CarritoResp;
import com.demo.utils.ValidacionGlobal;

/**
 * @author Pablo Jara
 *
 */
@Service
@Transactional
public class CarritoService {

	@Autowired
	private ValidacionGlobal validacionGlobal;

	@Autowired
	private ICarritoRepository repo;

	@Autowired
	private ICarritoDetalleRepository carritoDetalleRepository;

	@Autowired
	private CarritoConverter converter;
	
	@Autowired
	private ICarritoDetalleRepository iCarritoDetalleRepository;

	public List<CarritoResp> listar() {
		List<CarritoEntity> listResponse = repo.findAll();
		return converter.converterListEntityToListResponse(listResponse);
	}

	public CarritoResp leerPorId(UUID id) {
		CarritoEntity carrito = validacionGlobal.buscarCarrito(id);
		return converter.convertToResponse(carrito);
	}

	public CarritoResp registrar(CarritoPostReq obj) {
		CarritoEntity carritoInsertado = repo.save(converter.convertirPostToEntity(obj));
		for (CarritoDetallePostReq detalle : obj.getListaProducto()) {
			validacionGlobal.buscarProducto(detalle.getIdProducto());
			CarritoDetalleEntityPK pk = new CarritoDetalleEntityPK();
			pk.setIdCarrito(carritoInsertado.getIdCarrito());
			pk.setItemCarrito(UUID.randomUUID());
			CarritoDetalleEntity carritoDetalle = new CarritoDetalleEntity();
			carritoDetalle.setPk(pk);
			carritoDetalle.setIdProducto(detalle.getIdProducto());
			carritoDetalle.setCantidad(detalle.getCantidad());
			carritoDetalleRepository.save(carritoDetalle);
		}
		return leerPorId(carritoInsertado.getIdCarrito());
	}

	public void modificar(CarritoPutReq obj) {
		CarritoEntity carrito = validacionGlobal.buscarCarrito(obj.getIdCarrito());
		EstadoCarritoEnum.isCompleto(carrito.getEstado());
		carrito.setDescripcion(obj.getDescripcion());
		repo.save(carrito);

	}

	public void eliminar(UUID id) {
		CarritoEntity carrito = validacionGlobal.buscarCarrito(id);
		EstadoCarritoEnum.isCompleto(carrito.getEstado());
		carrito.setEstado(EstadoCarritoEnum.COMPLETO.name());
		carritoDetalleRepository.deleteByPkIdCarrito(id);
		repo.delete(carrito);

	}

	public CarritoResp completarCarrito(CarritoCompletadoPutReq obj) {
		CarritoEntity carrito = validacionGlobal.buscarCarrito(obj.getIdCarrito());
		EstadoCarritoEnum.isCompleto(carrito.getEstado());
		carrito.setEstado(EstadoCarritoEnum.COMPLETO.name());
		carrito.setPrecioTotal(calcularPrecio(obj.getIdCarrito()));
		return converter.convertToResponse(repo.save(carrito));

	}

	private Double calcularPrecio(UUID idCarrito) {
		List<CarritoDetalleEntity> lista = iCarritoDetalleRepository.findByPkIdCarrito(idCarrito);
		if(lista.isEmpty()) {
			return 0D;
		}else {
			Double calculo = 0D;
			Double precioUnitario = 0D;
			for (CarritoDetalleEntity detalle : lista) {
				precioUnitario = buscarPrecio(detalle.getIdProducto());
				calculo = calculo + (precioUnitario * detalle.getCantidad());
			}
			return calculo;
		}
	}

	private Double buscarPrecio(UUID idProducto) {
		ProductoEntity producto = validacionGlobal.buscarProducto(idProducto);
		TipoProductoEntity tipoProducto = validacionGlobal.buscarTipoProducto(producto.getIdTipoProducto());
		if(tipoProducto.getConDescuento()) {
			return producto.getPrecio()/2;
		}else {
			return producto.getPrecio();
		}
	}

}
