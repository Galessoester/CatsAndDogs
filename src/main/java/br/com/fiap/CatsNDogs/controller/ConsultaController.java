package br.com.fiap.CatsNDogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.CatsNDogs.model.Consulta;
//import br.com.fiap.CatsNDogs.model.Tutor;
import br.com.fiap.CatsNDogs.model.repository.ConsultaRepository;
import br.com.fiap.CatsNDogs.model.repository.tutorRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private tutorRepository tutorRepository;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("consulta/index");
		List<Consulta> listaConsultas = consultaRepository.findAll();
		model.addObject("consultas", listaConsultas);
		return model;
	}
	
//	@GetMapping("/create")
//	public ModelAndView get() {
//		ModelAndView model = new ModelAndView("consulta/create");
//		List<Tutor> listaTutores = tutorRepository.findAll();
//		model.addObject("tutores", listaTutores);
//		return model;
//	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		return new ModelAndView("consulta/create");
	}
	
	@PostMapping("/create")
	public ResponseEntity<Consulta> create(@Valid @RequestBody Consulta consulta){
		consultaRepository.save(consulta);
		return new ResponseEntity<Consulta>(consulta, HttpStatus.CREATED);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		consultaRepository.deleteById(id);
		return "redirect:/consulta";
	}
}
