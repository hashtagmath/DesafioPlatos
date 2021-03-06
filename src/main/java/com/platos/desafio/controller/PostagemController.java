 package com.platos.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platos.desafio.model.Postagem;
import com.platos.desafio.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired 
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping("/estilo/{estilo}")
	public ResponseEntity<List<Postagem>> GetByEstilo(@PathVariable String estilo){
		return ResponseEntity.ok(repository.findAllByEstiloContainingIgnoreCase(estilo));
	}
	
	@GetMapping("temperatura")
	public ResponseEntity<PostagemSaidaDto> GetByTemperatura(@RequestBody PostagemEntradaDto entrada){
		Postagem postagem = repository.findFirstByTemperaturaMinLessThanEqualAndTemperaturaMaxGreaterThanEqual(entrada.getTemperature(),entrada.getTemperature());
		PostagemSaidaDto resultado = new PostagemSaidaDto();
		resultado.setBeerStyle(postagem.getEstilo());
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	

}
	