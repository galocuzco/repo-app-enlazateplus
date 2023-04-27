package com.enlazateplus.app.service.implementations;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.enlazateplus.app.dto.MenuDTO;
import com.enlazateplus.app.entity.tablas.head.MenuEntity;
import com.enlazateplus.app.entity.tablas.head.RestauranteEntity;
import com.enlazateplus.app.mappers.MenuMapper;
import com.enlazateplus.app.repository.MenuRepository;
import com.enlazateplus.app.service.exception.ServiceException;
import com.enlazateplus.app.service.interfaces.MenuService;

@Service
public class MenuServiceImp implements MenuService
{
	private MenuRepository menuRepositorio;
	private MenuMapper menuMapper;
	
	public MenuServiceImp(MenuRepository menuRepositorio, MenuMapper menuMapper) {
		super();
		this.menuRepositorio = menuRepositorio;
		this.menuMapper = menuMapper;
	}

	@Override
	public List<MenuDTO> findByLike(MenuDTO menuDTO) throws ServiceException {
		try {
			List<MenuEntity> lstMenuEntity = this.menuRepositorio
					.findByLikeNombre("%"+menuDTO.getNombre()+"%");
			return this.menuMapper.toDTO(lstMenuEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<MenuDTO> findByID(Long id) throws ServiceException {
		return Optional.empty();
	}

	@Override
	public MenuDTO save(MenuDTO menuDTO) throws ServiceException {
		try {
			MenuEntity requestMenuEntity = this.menuMapper.toDTO(menuDTO);
			MenuEntity menuEntity = this.menuRepositorio.save(requestMenuEntity);
			return this.menuMapper.toDTO(menuEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Boolean update(MenuDTO t) throws ServiceException {
		return null;
	}

	@Override
	public Boolean delete(MenuDTO t) throws ServiceException {
		return null;
	}

}
