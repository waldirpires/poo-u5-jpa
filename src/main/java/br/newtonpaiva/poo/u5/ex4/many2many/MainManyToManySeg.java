package br.newtonpaiva.poo.u5.ex4.many2many;

import br.newtonpaiva.poo.u5.ex4.AbstractMain;
import br.newtonpaiva.poo.u5.ex4.one2Many.Curso;
import br.newtonpaiva.poo.u5.ex4.one2Many.Disciplina;
import br.newtonpaiva.poo.u5.ex4.one2one.Aluno;
import br.newtonpaiva.poo.u5.ex4.one2one.DocumentoDeIdentificacao;

public class MainManyToManySeg extends AbstractMain {

    public static void main(String[] args) {
        // aluno
        var doc = new DocumentoDeIdentificacao("Identidade", "MG-10.567.890");

        var a = new Aluno("José Pereira", doc);

        // curso
        var c = new Curso("TADS", "Sistemas de Informação", "exatas", 8, "PRESENCIAL");

        // disciplina
        var d = new Disciplina("TADS-001", "Programação Orientada por Objetos");
        c.adicionarDisciplina(d);

        var d2 = new Disciplina("TADS-002", "Bancos de Dados");
        c.adicionarDisciplina(d2);

        var d3 = new Disciplina("TADS-005", "Programação Web");
        c.adicionarDisciplina(d3);

        salvar(c);

        d.adicionarAluno(a);
        d2.adicionarAluno(a);
        d3.adicionarAluno(a);

        salvar(d);
        salvar(d2);
        salvar(d3);

        System.out.println(a.getDisciplinas());
        System.out.println();

        System.out.println(d.getAlunos());
        System.out.println();

        System.out.println(d2.getAlunos());
        System.out.println();

        System.out.println(d3.getAlunos());
        System.out.println();

        d2.removerAluno(a);
        salvar(d2);

        encerrar();
    }

}
