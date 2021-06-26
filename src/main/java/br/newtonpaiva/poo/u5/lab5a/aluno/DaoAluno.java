package br.newtonpaiva.poo.u5.lab5a.aluno;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.newtonpaiva.poo.u5.ex1.model.Cliente;
import br.newtonpaiva.poo.u5.ex2.dao.Dao;

public class DaoAluno implements Dao<Aluno2>{

    private EntityManager entityManager;

	public DaoAluno(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public Optional<Aluno2> get(long id) {
        return Optional.ofNullable(entityManager.find(Aluno2.class, id));
	}

	@Override
	public List<Aluno2> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Aluno2 a"); //HQL
        
        return query.getResultList();
	}

	@Override
	public void save(Aluno2 t) {
        executeInsideTransaction(entityManager -> entityManager.persist(t));        
	}

	@Override
	public void update(Aluno2 t) {
        var existe = get(t.getId());
        
        if (existe.isPresent()) {
            var c = existe.get();
            
            c.setNome(t.getNome());
            c.setCpf(t.getCpf());
            
            executeInsideTransaction(entityManager -> entityManager.merge(c));
        } else {
            System.out.println("ERROR: Not found -> " + t.getClass().getSimpleName() + "." + t.getId());
        }       
	}

	@Override
	public void delete(Aluno2 t) {
        executeInsideTransaction(entityManager -> entityManager.remove(t));        		
	}

	// executa dentro da transação
    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit(); 
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
	
}
