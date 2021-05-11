package br.newtonpaiva.poo.u5.ex3.jpa;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.newtonpaiva.poo.u5.ex1.model.Cliente;
import br.newtonpaiva.poo.u5.ex2.dao.Dao;

public class ClienteJpaDao implements Dao<Cliente>{

    private EntityManager entityManager;

    public ClienteJpaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Cliente> get(long id) {
        return Optional.ofNullable(entityManager.find(Cliente.class, id));
    }

    @Override
    public List<Cliente> getAll() {
        Query query = entityManager.createQuery("SELECT c FROM Cliente c"); //HQL
        
        return query.getResultList();
    }

    @Override
    public void save(Cliente t) {
        executeInsideTransaction(entityManager -> entityManager.persist(t));        
    }

    @Override
    public void update(Cliente t) {
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
    public void delete(Cliente t) {
        executeInsideTransaction(entityManager -> entityManager.remove(t));        
    }

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
