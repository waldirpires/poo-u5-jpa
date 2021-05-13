package br.newtonpaiva.poo.u5.ex4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractMain {

    private static final String PU = "BancoPU1";

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PU);

    protected static EntityManager entityManager = entityManagerFactory.createEntityManager();

    protected static void salvar(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        System.out.println("--- Salvo:");
        System.out.println(obj);
        System.out.println("---");
        System.out.println();
    }

    protected static void atualizar(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();

        System.out.println("--- Atualizado:");
        System.out.println(obj);
        System.out.println("---");
        System.out.println();
    }

    protected static void deletar(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
        System.out.println("--- Removido:");
        System.out.println(obj);
        System.out.println("---");
        System.out.println();
    }

    protected static <T> T buscar(Class<T> entityClass, Integer id) {
        var obj = entityManager.find(entityClass, id);
        System.out.println("--- GET by ID: " + id);
        System.out.println(obj);
        System.out.println("---");
        System.out.println();

        return obj;
    }

    protected static <T> List<T> listar(Class<T> entityClass) {
        return entityManager.createQuery("select a from " + entityClass.getSimpleName() + " a", entityClass)
                .getResultList();
    }

    protected static void encerrar() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
