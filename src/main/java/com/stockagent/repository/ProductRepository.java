package com.stockagent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stockagent.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	/**
	 * ADDICIONAL JPA method /findByCategoryId: . Searches and selects the list of
	 * products of a certain category.
	 * 
	 * @param id the id of the related category
	 * @return List <Product>
	 */
	@Query(value = "SELECT p FROM Product p INNER JOIN FETCH p.category c WHERE c.id = :id") // , nativeQuery = true
	 //"SELECT p FROM Product p WHERE p.category.id =: id";
	List<Product> findByCategoryId(@Param("id") Long id);
	
	/**
	 * ADDICIONAL JPA method /searchProductByName: . Searches and selects the list of
	 * products by its name.
	 * 
	 * @param id the id of the related supplier
	 * @return List <Product>
	 */	
	@Query(value = "SELECT p FROM Product p WHERE p.name LIKE %:name%")
	List<Product> searchProductByName(@Param("name") String name);

	/**
	 * ADDICIONAL JPA method /findBySupplierId: . Searches and selects the list of
	 * products of a certain supplier.
	 * 
	 * @param id the id of the related supplier
	 * @return List <Product>
	 */
//	@Query(value = "SELECT p FROM Product p INNER JOIN FETCH p.supplier s WHERE s.id = :id") // , nativeQuery = true
//	List<Product> findBySupplierId(@Param("id") Long id);
}