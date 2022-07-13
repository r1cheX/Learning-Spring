package com.ingenieriaweb.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.app.models.entity.Empleado;

@Repository
public class EmpleadoDaoImpl implements IEmpleadoDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Empleado").getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Empleado findOne(Long id) {
		return em.find(Empleado.class, id);
	}
	
	@Override
	@Transactional
	public void save(Empleado empleado) {
		if (empleado.getId() != null && empleado.getId() > 0) {
			em.merge(empleado);
		} else {
			em.persist(empleado);
		}
	}
	
	
	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
	}
	
	
	

}
