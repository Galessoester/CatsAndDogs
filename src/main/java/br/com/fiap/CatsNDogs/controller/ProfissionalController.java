package br.com.fiap.CatsNDogs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.CatsNDogs.model.Profissional;
import br.com.fiap.CatsNDogs.model.repository.ProfissionalRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/profissional")
public class ProfissionalController {
	
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("profissional/index");
		List<Profissional> listaProfissionais = profissionalRepository.findAll();
		
		model.addObject("profissionais", listaProfissionais);
		return model;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		return new ModelAndView("profissional/create");
	}
	
	@PostMapping("/create")
	public ResponseEntity<Profissional> create(@Valid @RequestBody Profissional profissional) {
		profissionalRepository.save(profissional);
		
		return new ResponseEntity<Profissional>(profissional, HttpStatus.CREATED);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		profissionalRepository.deleteById(id);
		return "redirect:/profissional";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long idProfissional) {
		Optional<Profissional> selecionado = profissionalRepository.findById(idProfissional);
		if(selecionado.isPresent()) {
			Profissional profissional = selecionado.get();
			model.addAttribute("profissional", profissional);
			return "profissional/edit";
		} else {
			return "redirect:/profissional";
		}
	}
	
	@PostMapping("/edit/{id}")
	public String create(@PathVariable("id") Long id, @ModelAttribute("profissional") Profissional objProfissional, Model model) {
		Profissional profissional = profissionalRepository.findById(id).orElse(null);
		
		profissional.setNome(objProfissional.getNome());
		profissional.setCrv(objProfissional.getCrv());
		profissional.setEspecialidade(objProfissional.getEspecialidade());
		profissional.setDisponibilidade(objProfissional.getDisponibilidade());
		profissional.setDuracao(objProfissional.getDuracao());
		
		profissionalRepository.save(profissional);
		
		model.addAttribute("profissional", profissional);
		
		return "redirect:/";
	}
	
}


