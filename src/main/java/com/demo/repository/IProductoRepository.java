/**
 * 
 */
package com.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.ProductoEntity;

/**
 * @author Pablo Jara
 *
 */
@Repository
public interface IProductoRepository extends JpaRepository<ProductoEntity, UUID>{

}
