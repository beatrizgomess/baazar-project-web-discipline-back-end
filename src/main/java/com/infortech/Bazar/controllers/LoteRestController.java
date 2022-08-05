package com.infortech.Bazar.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infortech.Bazar.model.classes.Lote;
import com.infortech.Bazar.model.repositorios.Facade;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*")
@RestController
public class LoteRestController {
	Facade facade = new Facade();	
	
	@PostMapping("/Lote")
	public String create(@RequestBody Lote lote) {
		Facade.getCurrentInstance().createLote(lote);
		return "Lote inserido com sucesso!";
	}
	
//	@PostMapping("/Lote")
//	public void create(@RequestBody Lote lt) {
//		try {
//			Facade.getCurrentInstance().createLote(lt);
//
//		}catch (SQLException e){
//			  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar o registro");
//		}
//	}
	
	
	@PutMapping("/Lote")
	public String update(@RequestBody Lote lote) {
		Facade.getCurrentInstance().updateLote(lote);
		return "Lote alterado com sucesso!";
	}
	
	@GetMapping("/Lote/{id}")
	public Lote read(@PathVariable("id") int id) {
		return Facade.getCurrentInstance().readLoteById(id);
	}
	
	@DeleteMapping("/Lote/{id}")
	public String delete(@PathVariable("id") int id) {
		Facade.getCurrentInstance().deleteLoteById(id);
		return "Lote deletado com sucesso!";
	}
	
	@GetMapping("/Lote")
	public List<Lote> readAll(){
		return Facade.getCurrentInstance().readAllLote();
	}
}
