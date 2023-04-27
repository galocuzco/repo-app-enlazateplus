package com.enlazateplus.app.service.implementations;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.enlazateplus.app.dto.TipoComidaDTO;
import com.enlazateplus.app.entity.tablas.head.TipoComidaEntity;
import com.enlazateplus.app.mappers.TipoComidaMapper;
import com.enlazateplus.app.repository.TipoComidaRepository;
import com.enlazateplus.app.service.exception.ServiceException;
import com.enlazateplus.app.service.interfaces.TipoComidaService;

@Service
public class TipoComidaServiceImp implements TipoComidaService 
{
	private TipoComidaRepository tipoComidaRepositorio;
	private TipoComidaMapper tipoComidaMapper;
	
	public TipoComidaServiceImp(TipoComidaRepository tipoComidaRepository, final TipoComidaMapper tipoComidaMapper) {
		super();
		this.tipoComidaRepositorio = tipoComidaRepository;
		this.tipoComidaMapper = tipoComidaMapper;
	}
	
	@Override
	public List<TipoComidaDTO> findByLike(TipoComidaDTO tipoComida) throws ServiceException {
		try {
			List<TipoComidaEntity> lstTipoComidaEntity = this.tipoComidaRepositorio
					.findByLikeNombreTipoComida("%"+tipoComida.getNombretipo()+"%");
			return this.tipoComidaMapper.toDTO(lstTipoComidaEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public Optional<TipoComidaDTO> findByCtipocomida(int codigoTipocomida) throws ServiceException {
		Optional<TipoComidaEntity> optTipoComida = this.tipoComidaRepositorio.findByCTipoComida(codigoTipocomida);
		if(optTipoComida.isPresent()){
			return Optional.ofNullable(this.tipoComidaMapper.toDTO(optTipoComida.get()));
		}
		return Optional.empty();
	}

	@Override
	public Optional<TipoComidaDTO> findByID(Long id) throws ServiceException {
		return Optional.empty();
	}

	@Override
	public TipoComidaDTO save(TipoComidaDTO t) throws ServiceException {
		return null;
	}

	@Override
	public Boolean update(TipoComidaDTO t) throws ServiceException {
		return null;
	}

	@Override
	public Boolean delete(TipoComidaDTO t) throws ServiceException {
		return null;
	}

}
