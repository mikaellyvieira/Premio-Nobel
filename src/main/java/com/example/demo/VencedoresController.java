package com.example.demo;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VencedoresController {

	private VencedoresRepository repositorio;

	public VencedoresController(VencedoresRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	@GetMapping("/")
	public String paginaInicial() {
		
		
		
		return "paginaInicial";
	}
	
	@GetMapping("/novo")
	public String exibirForm(Model model) {
		Vencedor vencedor = new Vencedor();
		model.addAttribute("vencedor", vencedor);

		String[] premio = {"Prêmio da Paz", "Prêmio de Literatura", "Prêmio de Química", "Prêmio de Medicina", "Prêmio de Física"};

		model.addAttribute("todosPremio", premio);

		return "trofeu";
	}

	/*@PostMapping("/cadastrar")
	public String cadastrar(@ModelAttribute @Valid Vencedor vencedor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "trofeu";
		} else {
			return "dados-vencedores";
		}
	}*/
	
	@PostMapping("/cadastrar")
	public String cadastrar(@ModelAttribute @Valid Vencedor vencedor, BindingResult bindingResult) {
		vencedor.setLaureado(vencedor.getLaureado().toUpperCase());
		vencedor.setPais(vencedor.getPais().toUpperCase());
		vencedor.setAno(vencedor.getAno().toUpperCase());
		vencedor.setPremio(vencedor.getPremio().toUpperCase());
		vencedor.setDescricao(vencedor.getDescricao().toUpperCase());
		if (bindingResult.hasErrors()) {
			return "trofeu";
		} else {
			repositorio.save(vencedor);
			return "redirect:/listar";
		}

		
	}

	@GetMapping("/listar")
	public String listarVencedor(Model model) {
		Iterable<Vencedor> vencedores = repositorio.findAll();

		model.addAttribute("vencedores", vencedores);

		return "listar-vencedores";
	}

	@GetMapping("/exibir")
	public String exibir(Integer id, Model model) {
		Optional<Vencedor> vencedor = repositorio.findById(id);

		model.addAttribute("vencedor", vencedor.get());

		return "dados-vencedores";
	}

	@GetMapping("/excluir")
	public String excluir(Integer id) {
		repositorio.deleteById(id);

		return "redirect:/listar";
	}
	

	@GetMapping("/editar")
	public String editar(Integer id, Model model) {
		Optional<Vencedor> vencedor = repositorio.findById(id);
		
		String[] premio = {"Prêmio da Paz", "Prêmio de Literatura", "Prêmio de Química", "Prêmio de Medicina", "Prêmio de Física"};

		model.addAttribute("todosPremio", premio);

		model.addAttribute("vencedor", vencedor);

		return "editar-vencedores";

	}

}
	
