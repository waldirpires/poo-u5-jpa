package br.newtonpaiva.poo.u5.ex4;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AbstractMain {

    private static final String PU = "BancoPU1";

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PU);

    protected static EntityManager entityManager = entityManagerFactory.createEntityManager();

    protected static void salvar(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj); // criar
        entityManager.getTransaction().commit();

        System.out.println("--- Salvo: (CREATE)");
        System.out.println(obj);
        System.out.println("---");
        System.out.println();
    }

    protected static void atualizar(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj); // atualização
        entityManager.getTransaction().commit();

        System.out.println("--- Atualizado (UPDATE by ID):");
        System.out.println(obj);
        System.out.println("---");
        System.out.println();
    }

    protected static void deletar(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();

        System.out.println("--- Removido (DELETE by ID):");
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
        var lista = entityManager.createQuery("select a from " + entityClass.getSimpleName() + " a", entityClass)
                .getResultList();

        System.out.println("--- LIST: " + entityClass.getSimpleName() + " - " + lista.size());
        for (var item : lista) {
            System.out.println("---");
            System.out.println(item);
            System.out.println("---");
        }
        System.out.println();

        return lista;
    }

    protected static void encerrar() {
        entityManager.close();
        entityManagerFactory.close();
    }

    protected static void nativeQuery(String s) {
        System.out.printf("-----------------------------%n'%s'%n", s);
        Query query = entityManager.createNativeQuery(s);
        List list = query.getResultList();
        for (Object o : list) {
            if (o instanceof Object[]) {
                System.out.println(Arrays.toString((Object[]) o));
            } else {
                System.out.println(o);
            }
        }
    }

    protected static void showTables() {
        nativeQuery("SHOW TABLES");
    }

    protected static <T> void showColumnsFromTable(String table) {
        nativeQuery("SHOW COLUMNS from " + table);
    }

}
