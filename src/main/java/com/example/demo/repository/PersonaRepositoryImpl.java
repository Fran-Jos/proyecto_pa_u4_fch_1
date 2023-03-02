package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class PersonaRepositoryImpl implements IPersonaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		
		TypedQuery<Persona>query = this.entityManager.createNamedQuery("buscarTodos", Persona.class);
		
		return query.getResultList();
	}

	@Override
	public Persona buscarPorId(Integer id) {
		return this.entityManager.find(Persona.class, id);
	}


	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona p = this.buscarPorId(id);
		
		this.entityManager.remove(p);
	}

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.persist(persona);
	}

}
