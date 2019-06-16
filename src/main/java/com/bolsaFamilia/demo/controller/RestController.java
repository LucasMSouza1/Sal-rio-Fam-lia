package com.bolsaFamilia.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsaFamilia.demo.model.Consulta;
import com.bolsaFamilia.demo.model.ConsultaRepo;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	ConsultaRepo consultaRepo;
	
	@GetMapping("/listaConsultas")
	public List<Consulta> listarConsultas() {
		return consultaRepo.findAll();
	}
	
	@GetMapping("/listaConsultas/{nomeMunicipio}")
	public List<Consulta> buscarConsulta(@PathVariable("nomeMunicipio") String nomeMunicipio) {
		List<Consulta> consultas = new ArrayList<Consulta>();
		consultas = consultaRepo.findByNomeMunicipioLike(nomeMunicipio);
		return consultas;
	}
	
}
