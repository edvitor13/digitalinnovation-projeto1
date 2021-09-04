package com.dio.live.support;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServiceBase<R extends JpaRepository<M, Long>, M extends Model> {
	@Autowired
	R repository;
	
	public M save(M model) {
		return repository.save(model);
	}
	
	public List<M> findAll() {
		return repository.findAll();
	}
	
	public Optional<M> findById(Long id) {
		return repository.findById(id);
	}
	
	public M update(M model) {
		return repository.save(model);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
