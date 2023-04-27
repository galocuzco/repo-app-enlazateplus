package com.enlazateplus.app.rest;

import java.util.List;
import static java.util.Objects.isNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.enlazateplus.app.dto.RestauranteDTO;
import com.enlazateplus.app.rest.constantes.APIConstantes;
import com.enlazateplus.app.service.interfaces.RestauranteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(APIConstantes.PATH_RESTAURANTE)
public class RestauranteRest 
{
	private final RestauranteService restauranteService;
	
	public RestauranteRest(RestauranteService restauranteService) {
		super();
		this.restauranteService = restauranteService;
	}
	
	@GetMapping
	public ResponseEntity<?> findByLike(){
		try {
			List<RestauranteDTO> lstRestauranteDTO = this.restauranteService.findByLike(null);
			if(isNull(lstRestauranteDTO) || lstRestauranteDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstRestauranteDTO);
		}catch(Exception e) {
			log.info("Se genero una excepcion:", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/by-nombre")
	public ResponseEntity<?> findByLikeNombre(@RequestParam(name = "nombre", defaultValue = "") String nombre){
		try {
			RestauranteDTO restauranteDTO = new RestauranteDTO();
			restauranteDTO.setNombre(nombre);
			List<RestauranteDTO> lstRestauranteDTO = this.restauranteService.findByLike(restauranteDTO);
			if(isNull(lstRestauranteDTO) || lstRestauranteDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstRestauranteDTO);
		}catch(Exception e) {
			log.info("Se genero una excepcion:", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody RestauranteDTO restauranteDTO){
		try {
			RestauranteDTO resRestauranteDTO = this.restauranteService.save(restauranteDTO);
			if(isNull(resRestauranteDTO)) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(resRestauranteDTO);
		}catch(Exception e) {
			log.info("Se genero una excepcion:", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
