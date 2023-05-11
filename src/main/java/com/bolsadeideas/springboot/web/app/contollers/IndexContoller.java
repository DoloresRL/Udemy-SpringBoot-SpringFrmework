package com.bolsadeideas.springboot.web.app.contollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app")
public class IndexContoller {
	//@RequestMapping(value="/index",method=RequestMethod.GET)//Primera forma
	//@RequestMapping(value="/index")//Segunda forma
	//@GetMapping(value="/index")//Tercera Forma
	@GetMapping({"/index","/","","/home"})//Cuarta Forma => Mapeado a varias rutas
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan");
		usuario.setApellido("Perez");
		usuario.setEmail("JuanPerez@correo.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", "Perfil de usuario ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		model.addAttribute("titulo", "Lista de usuarios ");
		model.addAttribute("usuarios", usuarios);
		return "listar";
		
	}

}
