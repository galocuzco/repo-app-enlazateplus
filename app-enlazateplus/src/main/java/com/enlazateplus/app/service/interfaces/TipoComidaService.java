package com.enlazateplus.app.service.interfaces;

import java.util.Optional;
import com.enlazateplus.app.dto.TipoComidaDTO;
import com.enlazateplus.app.service.exception.ServiceException;
import com.enlazateplus.app.service.interfaces.general.GenericService;

public interface TipoComidaService extends GenericService<TipoComidaDTO>
{
	Optional<TipoComidaDTO> findByCtipocomida(int codigoTipocomida ) throws ServiceException;
}
