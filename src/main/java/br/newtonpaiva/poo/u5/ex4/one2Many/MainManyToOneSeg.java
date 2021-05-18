package br.newtonpaiva.poo.u5.ex4.one2Many;

import br.newtonpaiva.poo.u5.ex4.AbstractMain;

public class MainManyToOneSeg extends AbstractMain {

    public static void main(String[] args) {
        var d = new Disciplina("TADS-001", "Programação Orientada por Objetos");
        var d2 = new Disciplina("TADS-002", "Bancos de Dados");
        var d3 = new Disciplina("TADS-005", "Programação Web");

        var c = new Curso("TADS", "Sistemas de Informação", "exatas", 8, "PRESENCIAL");

        c.adicionarDisciplina(d);
        salvar(c);

        buscar(Disciplina.class, d.getId());

        buscar(Curso.class, c.getId());
        System.out.println(c.getDisciplinas());

        c.adicionarDisciplina(d2);
        c.adicionarDisciplina(d3);
        salvar(c);

        listar(Disciplina.class);

        c.removerDisciplina(d2);
        salvar(c);

        c.setNome("Análise de Sistemas");
        c.setNumSemestres(10);
        atualizar(c);

        listar(Curso.class);

        deletar(c);

        encerrar();

    }

}
