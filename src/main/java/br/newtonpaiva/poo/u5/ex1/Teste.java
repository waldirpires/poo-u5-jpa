package br.newtonpaiva.poo.u5.ex1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.newtonpaiva.poo.u5.ex1.model.Cliente;

public class Teste {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoPU1");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

//		 INSERT
        Cliente cliente = new Cliente();
        cliente.setNome("GOOGLE");
        cliente.setCpf("123456789-01");
        System.out.println(cliente);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        System.out.println(cliente);

        // LIST
        var clientes = entityManager.createQuery("select c from Cliente c", Cliente.class).getResultList();
        System.out.println("Clientes:");
        System.out.println(clientes);

        // FIND
        cliente = entityManager.find(Cliente.class, cliente.getId());
        System.out.println(cliente);

        // MODIFY
        cliente.setNome("FACEBOOK INC.");
        cliente.setCpf("987654321-01");
        System.out.println(cliente);

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
        System.out.println(cliente);

//         DELETE
//        cliente = entityManager.find(Cliente.class, cliente.getId());
//        System.out.println(cliente);
//        entityManager.getTransaction().begin();
//        entityManager.remove(cliente);
//        entityManager.getTransaction().commit();

        // FIND after delete
        cliente = entityManager.find(Cliente.class, cliente.getId());
        System.out.println(cliente);

        entityManager.close();
        entityManagerFactory.close();

    }

}
