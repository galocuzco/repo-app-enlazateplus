package com.enlazateplus.app.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class MenuDTO
{
	private Long cmenu;
	private Long ctipocomida;
	private String nombre;
	private String detalle;
	private BigDecimal costo;
	private String estado;
}
