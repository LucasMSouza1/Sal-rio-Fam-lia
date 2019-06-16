package com.bolsaFamilia.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Municipio {
	private int codigoIBGE;
	private String nomeIBGE;
	private String pais;
	private Uf uf;
	
	public int getCodigoIBGE() {
		return codigoIBGE;
	}
	
	public void setCodigoIBGE(int codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}
	
	public String getNomeIBGE() {
		return nomeIBGE;
	}
	
	public void setNomeIBGE(String nomeIBGE) {
		this.nomeIBGE = nomeIBGE;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " ["+  nomeIBGE  + uf +"] ";
	}
	
}
