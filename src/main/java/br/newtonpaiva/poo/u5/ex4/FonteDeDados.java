package br.newtonpaiva.poo.u5.ex4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FonteDeDados {

    private String pu;

    private EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    public FonteDeDados(String pu) {
        this.pu = pu;
    }

    public void inicializar() {
        entityManagerFactory = Persistence.createEntityManagerFactory(pu);

        entityManager = entityManagerFactory.createEntityManager();
    }

    public Object salvar(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        System.out.println("--- Salvo:");
        System.out.println(obj);
        System.out.println("---");
        System.out.println();

        return obj;
    }

    public Object atualizar(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();

        System.out.println("--- Atualizado:");
        System.out.println(obj);
        System.out.println("---");
        System.out.println();

        return obj;
    }

    public void deletar(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();

        System.out.println("--- Removido:");
        System.out.println(obj);
        System.out.println("---");
        System.out.println();
    }

    public <T> T buscar(Class<T> entityClass, Integer id) {
        var obj = entityManager.find(entityClass, id);
        System.out.println("--- GET by ID: " + id);
        System.out.println(obj);
        System.out.println("---");
        System.out.println();

        return obj;
    }

    public <T> List<T> listar(Class<T> entityClass) {
        return entityManager.createQuery("select a from " + entityClass.getSimpleName() + " a", entityClass)
                .getResultList();
    }

    public void encerrar() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
