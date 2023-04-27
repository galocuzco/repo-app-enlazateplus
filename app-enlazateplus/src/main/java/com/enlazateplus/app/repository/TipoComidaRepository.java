package com.enlazateplus.app.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.enlazateplus.app.entity.tablas.head.TipoComidaEntity;

public interface TipoComidaRepository extends JpaRepository<TipoComidaEntity, Long>
{
	@Query("select p from TipoComidaEntity p where upper(p.nombretipo) like upper(:nomtipoComida)")
	List<TipoComidaEntity> findByLikeNombreTipoComida(@Param("nomtipoComida") String nomtipoComida);
	
	@Query("select p from TipoComidaEntity p where ctipocomida = :codigotipoComida")
	Optional<TipoComidaEntity> findByCTipoComida(@Param("codigotipoComida") int codigotipoComida);
}
