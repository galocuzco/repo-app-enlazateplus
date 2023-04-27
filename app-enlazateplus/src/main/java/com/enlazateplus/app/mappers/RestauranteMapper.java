package com.enlazateplus.app.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.enlazateplus.app.dto.RestauranteDTO;
import com.enlazateplus.app.entity.tablas.head.RestauranteEntity;

@Mapper(componentModel = "spring")
public interface RestauranteMapper 
{	
	List<RestauranteDTO> toDTO(List<RestauranteEntity> lstEntity);
	RestauranteEntity toDTO(RestauranteDTO dto);
	RestauranteDTO toDTO(RestauranteEntity entity);
}
