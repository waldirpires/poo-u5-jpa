package br.newtonpaiva.poo.u5.ex4.one2one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainOneToOne3 {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoPU1");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        var d = new DocumentoDeIdentificacao(null, "Identidade", "MG-12.345.678");
        var a = new Aluno(null, "José Pereira", d);
        salvar(a);

        fechar();
    }

    public static void main2(String[] args) {
        var a = new Aluno(null, "José Pereira", null);
        salvar(a);

        var d = new DocumentoDeIdentificacao(null, "Identidade", "MG-12.345.678");
        salvar(d);

        a.setDocumento(d); // realizar o mapeamento OneToOne
        salvar(a);

        fechar();
    }

    private static void fechar() {
        entityManager.close();
        entityManagerFactory.close();
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
