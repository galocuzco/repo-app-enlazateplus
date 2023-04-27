package com.enlazateplus.app.entity.tablas.head;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(schema="bd_pedidos", name="TTIPOCOMIDA")
@Entity(name="TipoComidaEntity")
public class TipoComidaEntity
{
	@Id
	@Column(name="CTIPOCOMIDA")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ctipocomida;
	
	@Column(name="NOMBRETIPO")
	private String nombretipo;
	
	@Column(name="ESTADO")
	private String estado;
}
