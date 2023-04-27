package com.enlazateplus.app.service.interfaces.general;

import java.util.List;
import java.util.Optional;
import com.enlazateplus.app.service.exception.ServiceException;

public interface GenericService<T>
{
	List<T> findByLike(T t) throws ServiceException;
	
	Optional<T> findByID(Long id) throws ServiceException; 
	
	T save(T t) throws ServiceException; 
	
	Boolean update(T t) throws ServiceException; 

	Boolean delete(T t) throws ServiceException; 
}
