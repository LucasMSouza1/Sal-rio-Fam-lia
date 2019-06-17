package com.bolsaFamilia.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.bolsaFamilia.demo.model.Consulta;
import com.bolsaFamilia.demo.model.ConsultaRepo;
import com.bolsaFamilia.demo.model.InfoMunicipio;


@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private ConsultaRepo consultaRepo;
	
	private List<InfoMunicipio> informacoesMunicipiosApi = new ArrayList<>();
	private List<Consulta> consultasBanco = new ArrayList<>();
	private String url;
	
	@PostMapping("/buscarInformacoes")
	public String buscarInformacoes(Model model, @RequestParam("anoMes") String anoMes, @RequestParam("codigoIbge") String codigoIbge) {		
		
		RestTemplate rt = new RestTemplate();
		String[] argumentos = anoMes.split("/");
				
		url = "http://www.transparencia.gov.br/api-de-dados/bolsa-familia-por-municipio?" +
		"mesAno=" + argumentos[1] + argumentos[0] + "&" + "codigoIbge=" + codigoIbge + "&" + "pagina1";
		
		ResponseEntity<List<InfoMunicipio>> response = rt.exchange(url,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<InfoMunicipio>>(){}
				);
	
		informacoesMunicipiosApi = response.getBody();
		
		model.addAttribute("informacoesMunicipio", informacoesMunicipiosApi);
		
		return "consulta";
				
	}
	
	@GetMapping("/create/{codigoIbge}")
	public String salvarConsulta(@PathVariable("codigoIbge") String codigoIbge, Model model) {
		
		consultasBanco = new ArrayList<Consulta>();
		consultasBanco = consultaRepo.findAll();
		List<Consulta> consultasDoMunicipio = new ArrayList<Consulta>();
		String paginaRetorno = "msg";
		boolean salvo = false;
		
		Consulta consulta = new Consulta();
		consulta.setCodigoMunicipio(informacoesMunicipiosApi.get(0).getMunicipio().getCodigoIBGE());
		consulta.setMesConsulta(informacoesMunicipiosApi.get(0).getDataReferencia());
		consulta.setNomeMunicipio(informacoesMunicipiosApi.get(0).getMunicipio().
				getNomeIBGE()); consulta.setQtdBeneficiarios(informacoesMunicipiosApi.get(0).
				getQuantidadeBeneficiados());
		consulta.setValorGasto(informacoesMunicipiosApi.get(0).getValor());
		 
		
		if(consultasBanco.size() != 0) {
			
			//Busca as consultas do municipio que ja foram salvas no banco.
			consultasDoMunicipio = consultaRepo.findByNomeMunicipioLike(consulta.getNomeMunicipio());
			
			
			if(consultasDoMunicipio.size() != 0) {
				for (Consulta consultaMunicipio : consultasDoMunicipio) {
					// Verifica se a consulta do mês buscado já está salva
					if(!consultaMunicipio.getMesConsulta().equals(consulta.getMesConsulta())){
						consultaRepo.save(consulta);
						salvo = true;
					}
				}
			}else {
				consultaRepo.save(consulta);
				salvo = true;
			}
						
		}else {
			consultaRepo.save(consulta);
			salvo = true;
		}
		
		model.addAttribute("salvo", salvo);
		
		return paginaRetorno;
	}
	
	
	@GetMapping("/")
	public String buscarConsultas(Model model) {
		consultasBanco = consultaRepo.findAll();
		
		model.addAttribute("informacoesMunicipio", consultasBanco);
				
		return "consultas-banco";
	}
	
	
	@GetMapping("/delete/{id}")
	public String excluir(@PathVariable("id") Integer id) {
		Consulta consulta = consultaRepo.findById(id).orElse(null);
		
		if(consulta != null) {
			consultaRepo.delete(consulta);
		}
		
		return "redirect:/";
	}
	
		
}
