package com.enlazateplus.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.enlazateplus.app.entity.tablas.head.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Long>
{
	@Query("select p from MenuEntity p where upper(p.nombre) like upper(:nombre) and p.estado='act'")
	List<MenuEntity> findByLikeNombre(@Param("nombre") String nombre);
}
