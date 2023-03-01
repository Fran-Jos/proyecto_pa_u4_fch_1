package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Persona;
import com.example.demo.service.IPersonaService;

@SpringBootApplication
public class ProyectoPaU4Fch1Application implements CommandLineRunner{

	@Autowired
	private IPersonaService iPersonaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4Fch1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Persona p1  = new Persona();
		p1.setApellido("Chango");
		p1.setCedula("35555532");
		p1.setGenero("Masculino");
		p1.setNombre("MArco");
		Persona p2  = new Persona();
		p2.setApellido("Chanataxi");
		p2.setCedula("122221332");
		p2.setGenero("Masculino");
		p2.setNombre("Francisco");
		Persona p3  = new Persona();
		p3.setApellido("Mancheno");
		p3.setCedula("1997733883");
		p3.setGenero("Masculino");
		p3.setNombre("José");
		
//		this.iPersonaService.guardar(p3);
//		this.iPersonaService.guardar(p2);
//		this.iPersonaService.guardar(p1);
		
		List<Persona> p = this.iPersonaService.buscarTodos();
		System.out.println(p);
		
		Persona n = this.iPersonaService.buscarPorId(2);
		
		n.setApellido("Novoa");
		
		this.iPersonaService.actualizar(n);

		
	}

}
