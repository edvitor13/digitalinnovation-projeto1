package com.dio.live.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.live.model.Movimentacao;
import com.dio.live.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoService service;
	
	public MovimentacaoService getService() {
		return this.service;
	}
	
	@PostMapping
	public Movimentacao create(
			@RequestBody Movimentacao model) 
	{
		return this.getService().save(model);
	}
	
	@GetMapping
	public List<Movimentacao> getList() {
		return this.getService().findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movimentacao> getById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(
			this.getService().findById(id)
			.orElseThrow(() -> new RuntimeException("Model n?o encontrado"))
		);
	}
	
	@PutMapping
	public Movimentacao update(
		@RequestBody Movimentacao model
	) {
		return this.getService().update(model);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		try {
			this.getService().deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@DeleteMapping("/{idInicial}/{idFinal}")
	public void deleteBetweenIds(
			@PathVariable("idInicial") Long idInicial, 
			@PathVariable("idFinal") Long idFinal
	) {
		for (Long i=idInicial; i <= idFinal; i++) {
			try {
				this.getService().deleteById(i);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
