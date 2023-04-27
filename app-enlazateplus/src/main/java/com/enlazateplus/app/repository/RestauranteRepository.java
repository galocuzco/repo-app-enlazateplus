package com.enlazateplus.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.enlazateplus.app.entity.tablas.head.RestauranteEntity;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long>
{
	@Query("select p from RestauranteEntity p where upper(p.nombre) like upper(:nombre) and p.estado='act'")
	List<RestauranteEntity> findByLikeNombre(@Param("nombre") String nombre);
}
