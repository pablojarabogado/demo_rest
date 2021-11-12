/**
 * 
 */
package com.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.CarritoEntity;

/**
 * @author Pablo Jara
 *
 */
@Repository
public interface ICarritoRepository extends JpaRepository<CarritoEntity, UUID>{

}
