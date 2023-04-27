package com.enlazateplus.app.entity.tablas.head;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(schema="bd_pedidos", name="TMENU")
@Entity(name="MenuEntity")
public class MenuEntity 
{
	@Id
	@Column(name="CMENU")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cmenu;
	
	@Column(name="CTIPOCOMIDA")
	private Long ctipocomida;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DETALLE")
	private String detalle;
	
	@Column(name="COSTO")
	private BigDecimal costo;
	
	@Column(name="ESTADO")
	private String estado;
}
