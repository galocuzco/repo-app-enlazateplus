package com.enlazateplus.app.entity.tablas.head;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(schema="bd_pedidos", name="TRESTAURANTE")
@Entity(name="RestauranteEntity")
public class RestauranteEntity 
{
	@Id
	@Column(name="CRESTAURANTE")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProducto")
//	@SequenceGenerator(sequenceName = "SEQ_PRODUCTO", allocationSize = 1, name = "seqProducto")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long crestaurante;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="CLASIFICACION")
	private String clasificacion;
	
	@Column(name="ESTADO")
	private String estado;
	
}
