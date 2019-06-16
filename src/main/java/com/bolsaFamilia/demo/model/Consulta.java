package com.bolsaFamilia.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeMunicipio;
	private float valorGasto;
	private int qtdBeneficiarios;
	private String mesConsulta;
	private int codigoMunicipio;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}
	
	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}
	
	public float getValorGasto() {
		return valorGasto;
	}
	
	public void setValorGasto(float valorGasto) {
		this.valorGasto = valorGasto;
	}
	
	public int getQtdBeneficiarios() {
		return qtdBeneficiarios;
	}
	
	public void setQtdBeneficiarios(int qtdBeneficiarios) {
		this.qtdBeneficiarios = qtdBeneficiarios;
	}
	
	public String getMesConsulta() {
		return mesConsulta;
	}
	
	public void setMesConsulta(String mesConsulta) {
		this.mesConsulta = mesConsulta;
	}

	public int getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(int codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}
	
	
}
