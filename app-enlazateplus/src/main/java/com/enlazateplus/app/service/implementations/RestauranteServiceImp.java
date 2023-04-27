package com.enlazateplus.app.service.implementations;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.enlazateplus.app.dto.RestauranteDTO;
import com.enlazateplus.app.entity.tablas.head.RestauranteEntity;
import com.enlazateplus.app.mappers.RestauranteMapper;
import com.enlazateplus.app.repository.RestauranteRepository;
import com.enlazateplus.app.service.exception.ServiceException;
import com.enlazateplus.app.service.interfaces.RestauranteService;

@Service
public class RestauranteServiceImp implements RestauranteService 
{
	private RestauranteRepository restauranteRepositorio;
	private RestauranteMapper restauranteMapper;
	
	public RestauranteServiceImp(RestauranteRepository restaurantRepository, final RestauranteMapper restauranteMapper) {
		super();
		this.restauranteRepositorio = restaurantRepository;
		this.restauranteMapper = restauranteMapper;
	}
	
	@Override
	public List<RestauranteDTO> findByLike(RestauranteDTO restauranteDTO) throws ServiceException {
		try {
			List<RestauranteEntity> lstRestaurantesEntity = this.restauranteRepositorio
					.findByLikeNombre("%"+restauranteDTO.getNombre()+"%");
			return this.restauranteMapper.toDTO(lstRestaurantesEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<RestauranteDTO> findByID(Long idd) throws ServiceException {
		
		return Optional.empty();
	}

	@Override
	public RestauranteDTO save(RestauranteDTO restauranteDTO) throws ServiceException {
		try {
			RestauranteEntity requestRestauranteEntity = this.restauranteMapper.toDTO(restauranteDTO);
			RestauranteEntity restauranteEntity = this.restauranteRepositorio.save(requestRestauranteEntity);
			return this.restauranteMapper.toDTO(restauranteEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Boolean update(RestauranteDTO t) throws ServiceException {
		
		return null;
	}

	@Override
	public Boolean delete(RestauranteDTO t) throws ServiceException {
		
		return null;
	}

}
