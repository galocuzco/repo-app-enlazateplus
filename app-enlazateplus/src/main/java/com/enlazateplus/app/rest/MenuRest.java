package com.enlazateplus.app.rest;

import static java.util.Objects.isNull;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.enlazateplus.app.dto.MenuDTO;
import com.enlazateplus.app.rest.constantes.APIConstantes;
import com.enlazateplus.app.service.interfaces.MenuService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(APIConstantes.PATH_MENU)
public class MenuRest 
{
	private final MenuService menuService;

	public MenuRest(MenuService menuService) {
		super();
		this.menuService = menuService;
	}
	
	@GetMapping
	public ResponseEntity<?> findByLike(){
		try {
			List<MenuDTO> lstMenuDTO = this.menuService.findByLike(null);
			if(isNull(lstMenuDTO) || lstMenuDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstMenuDTO);
		}catch(Exception e) {
			log.info("Se genero una excepcion:", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/by-nombre")
	public ResponseEntity<?> findByLikeNombre(@RequestParam(name = "nombre", defaultValue = "") String nombre){
		try {
			MenuDTO menuDTO = new MenuDTO();
			menuDTO.setNombre(nombre);
			List<MenuDTO> lstMenuDTO = this.menuService.findByLike(menuDTO);
			if(isNull(lstMenuDTO) || lstMenuDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstMenuDTO);
		}catch(Exception e) {
			log.info("Se genero una excepcion:", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody MenuDTO restauranteDTO){
		try {
			MenuDTO resMenuDTO = this.menuService.save(restauranteDTO);
			if(isNull(resMenuDTO)) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(resMenuDTO);
		}catch(Exception e) {
			log.info("Se genero una excepcion:", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
