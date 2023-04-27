package com.enlazateplus.app.rest;

import java.util.List;
import java.util.Optional;
import static java.util.Objects.isNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.enlazateplus.app.dto.TipoComidaDTO;
import com.enlazateplus.app.rest.constantes.APIConstantes;
import com.enlazateplus.app.service.interfaces.TipoComidaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(APIConstantes.PATH_TIPOCOMIDA)
public class TipoComidaRest 
{
	private final TipoComidaService tipoComidaService;
	
	public TipoComidaRest(TipoComidaService tipoComidaService) {
		super();
		this.tipoComidaService = tipoComidaService;
	}
	
	@GetMapping
	public ResponseEntity<?> findByLike(){
		try {
			List<TipoComidaDTO> lstTipoComidaDTO = this.tipoComidaService.findByLike(null);
			if(isNull(lstTipoComidaDTO) || lstTipoComidaDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstTipoComidaDTO);
		}catch(Exception e) {
			log.info("Se genero una excepcion:", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/by-tipocomida")
	public ResponseEntity<?> findByLikeByNombreTipo(@RequestParam(name = "nomTipoComida") String nomTipoComida) {
		try {
			TipoComidaDTO producto = new TipoComidaDTO();
			producto.setNombretipo(nomTipoComida);
			List<TipoComidaDTO> lstTipoComidaDTO = this.tipoComidaService.findByLike(producto);
			if(isNull(lstTipoComidaDTO) || lstTipoComidaDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstTipoComidaDTO);
		}catch(Exception e) {
			log.info("Se producido una excepcion:", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/by-codigotipocomida")
	public ResponseEntity<?> findByByCodigoTipoComida(@RequestParam(name = "codtipocomida") String codtipocomida) {
		try {
			Optional<TipoComidaDTO> lstTipoComidaDTO = this.tipoComidaService
					.findByCtipocomida(Integer.valueOf(codtipocomida));
			if(!lstTipoComidaDTO.isPresent()){
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstTipoComidaDTO);
		}catch(Exception e) {
			log.info("Se producido una excepcion:", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	/*
	@PostMapping("/by-tipocomida")
	public ResponseEntity<?> findByLikeByNombreTipoComida(@RequestParam(name = "nomTipoComida") String nomTipoComida) {
		try {
			TipoComidaDTO producto = new TipoComidaDTO();
			producto.setNombretipo(nomTipoComida);
			List<TipoComidaDTO> lstTipoComidaDTO = this.tipoComidaService.findByLike(producto);
			if(isNull(lstTipoComidaDTO) || lstTipoComidaDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstTipoComidaDTO);
		}catch(Exception e) {
			log.info("Se producido una excepcion:", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	*/
}
