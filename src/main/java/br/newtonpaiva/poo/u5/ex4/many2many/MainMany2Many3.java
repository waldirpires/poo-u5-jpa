package br.newtonpaiva.poo.u5.ex4.many2many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.newtonpaiva.poo.u5.ex4.one2Many.Disciplina;
import br.newtonpaiva.poo.u5.ex4.one2one.Aluno;
import br.newtonpaiva.poo.u5.ex4.one2one.DocumentoDeIdentificacao;

public class MainMany2Many3 {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoPU1");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        var disciplina = new Disciplina("TADS-001", "Programação Orientada por Objetos");
        var d = new DocumentoDeIdentificacao(null, "Identidade", "MG-12.345.678");
        var a = new Aluno(null, "José Pereira", d);

        disciplina.adicionarAluno(a);

        salvar(a);

        var d2 = new Disciplina("TADS-002", "Estrutura de Dados");
        var d3 = new Disciplina("TADS-003", "Fundamentos de Sistemas de Informação");
        d2.adicionarAluno(a);
        d3.adicionarAluno(a);
        salvar(a);

        var doc2 = new DocumentoDeIdentificacao(null, "Identidade", "MG-12.345.876");
        var a2 = new Aluno(null, "Maria Pereira", doc2);
        d2.adicionarAluno(a2);
        d3.adicionarAluno(a2);
        salvar(a2);

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
}
