/**
 * 
 */
package com.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.CarritoDetalleEntity;
import com.demo.entity.CarritoDetalleEntityPK;

/**
 * @author Pablo Jara
 *
 */
@Repository
public interface ICarritoDetalleRepository extends JpaRepository<CarritoDetalleEntity, CarritoDetalleEntityPK>{

	void deleteByPkIdCarrito(UUID id);

	List<CarritoDetalleEntity> findByPkIdCarrito(UUID idCarrito);

}
