package com.bolsaFamilia.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoMunicipio {
	private int id;
	private String dataReferencia;
	private int quantidadeBeneficiados;
	private Municipio municipio;
	private float valor;
	private int codigoIBGE;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDataReferencia() {
		return dataReferencia;
	}
	
	public void setDataReferencia(String dataReferencia) {
		this.dataReferencia = dataReferencia;
	}
	
	public int getQuantidadeBeneficiados() {
		return quantidadeBeneficiados;
	}
	
	public void setQuantidadeBeneficiados(int quantidadeBeneficiados) {
		this.quantidadeBeneficiados = quantidadeBeneficiados;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public int getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(int codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " ["+  id  + municipio + quantidadeBeneficiados + dataReferencia  +"] ";
	}
		
}
