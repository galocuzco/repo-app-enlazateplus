package com.enlazateplus.app.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.enlazateplus.app.dto.MenuDTO;
import com.enlazateplus.app.entity.tablas.head.MenuEntity;

@Mapper(componentModel = "spring")
public interface MenuMapper 
{
	List<MenuDTO> toDTO(List<MenuEntity> lstEntity);
	MenuEntity toDTO(MenuDTO dto);
	MenuDTO toDTO(MenuEntity entity);
}
