package br.newtonpaiva.poo.u5.ex4.one2Many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainManyToOne2 {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoPU1");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        var d = new Disciplina("TADS-001", "Programação Orientada a Objetos");
        var c = new Curso(null, "NP-001", "Análise de Sistemas", "exatas", 8, "presencial");

        c.adicionarDisciplina(d);
        salvar(c);

        var d2 = new Disciplina("TADS-002", "Estrutura de Dados");
        var d3 = new Disciplina("TADS-003", "Fundamentos de Sistemas de Informação");
        c.adicionarDisciplina(d2);
        c.adicionarDisciplina(d3);
        salvar(c);

        c.removerDisciplina(d);
        salvar(c);

        fechar();

    }

    private static void fechar() {
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Fonte de dados fechada com sucesso.");
    }

    private static void salvar(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();

        System.out.println("--- CRIADO");
        System.out.println(obj);
        System.out.println("---");
        System.out.println();
    }

    private static void delete(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();

        System.out.println("--- CRIADO");
        System.out.println(obj);
        System.out.println("---");
        System.out.println();
    }

}
