package com.bolsaFamilia.demo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ConsultaRepo extends CrudRepository<Consulta, Integer> {
	public Consulta save(Consulta consulta);
	public List<Consulta> findAll();
	public List<Consulta> findByNomeMunicipioLike(String nome);
}
