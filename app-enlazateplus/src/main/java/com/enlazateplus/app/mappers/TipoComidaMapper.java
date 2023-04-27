package com.enlazateplus.app.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.enlazateplus.app.dto.TipoComidaDTO;
import com.enlazateplus.app.entity.tablas.head.TipoComidaEntity;

@Mapper(componentModel = "spring")
public interface TipoComidaMapper 
{	
	List<TipoComidaDTO> toDTO(List<TipoComidaEntity> lstEntity);
	TipoComidaEntity toDTO(TipoComidaDTO dto);
	TipoComidaDTO toDTO(TipoComidaEntity entity);
}
