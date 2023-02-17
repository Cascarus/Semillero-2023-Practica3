package com.Semillero2023.Practica3.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="COMPANIAS_SEGUROS")
@DynamicUpdate @DynamicInsert
public class CompaniaSeguro implements Serializable{

	private static final long serialVersionUID = -7476246797823899059L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMP_SEGUROS")
    @SequenceGenerator(sequenceName = "seq_comp_seguros", allocationSize = 1, name = "SEQ_COMP_SEGUROS")
	private Integer id;
	
	@Column(name="NUMERO_POLIZA")
	private Integer numero_poliza;
	
	@Column(name="NOMBRE_COMPANIA")
	private String nombre_compania;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero_poliza() {
		return numero_poliza;
	}

	public void setNumero_poliza(Integer numero_poliza) {
		this.numero_poliza = numero_poliza;
	}

	public String getNombre_compania() {
		return nombre_compania;
	}

	public void setNombre_compania(String nombre_compania) {
		this.nombre_compania = nombre_compania;
	}
	

}
