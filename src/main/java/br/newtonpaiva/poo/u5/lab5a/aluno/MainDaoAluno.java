package br.newtonpaiva.poo.u5.lab5a.aluno;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainDaoAluno {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoPU1");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
		var aluno = new Aluno2("123456", "123.456.789-01", "José Pereira", LocalDate.of(2000, 10, 11));
		
		var dao = new DaoAluno(entityManager);
		
		dao.save(aluno);
		
		var lido = dao.get(aluno.getId());
		System.out.println(lido);
		
		var alunos = dao.getAll();
		System.out.println("Alunos: " + alunos);
		
		aluno.setNome("Maria Rosa Gonçalves");
		dao.update(aluno);
		
		lido = dao.get(aluno.getId());
		System.out.println(lido);

		dao.delete(aluno);
		
		lido = dao.get(aluno.getId());
		System.out.println(lido);
	}
}
