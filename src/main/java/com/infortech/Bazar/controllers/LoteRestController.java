package com.infortech.Bazar.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infortech.Bazar.model.classes.Lote;
import com.infortech.Bazar.model.repositorios.Facade;

@RestController
public class LoteRestController {
	Facade facade = new Facade();	
	
	@PostMapping("/Lote")
	public String create(@RequestBody Lote lote) {
		facade.createLote(lote);
		
		return "Lote inserido com sucesso!";
	}
	
	@PutMapping("/Lote")
	public String update(@RequestBody Lote lote) {
		return "Lote alterado com sucesso!";
	}
	
	@GetMapping("Lote/{id}")
	public Lote read(@PathVariable("id") int id) {
		return null;
	}
	
	@DeleteMapping("Lote/{id}")
	public String delete(@PathVariable("id") int id) {
		return "Lote deletado com sucesso!";
	}
	
	@GetMapping("Lote")
	public List<Lote> readAll(){
		return null;
	}
}
