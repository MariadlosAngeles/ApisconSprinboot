package com.maria.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sena")
public class SaludoController {

	@GetMapping()
	public String saludo() {
		return "Este es nnuestro primer ejemplo con SpringBoot";
	}
	
	@GetMapping("saludame")
	public String saludo2(@RequestParam(value="nombre",defaultValue="Bienvenid@") String nombre) {
		return "Hola " +nombre+" Este es nuestro primer ejemplo con SpringBoot";
	}
}
