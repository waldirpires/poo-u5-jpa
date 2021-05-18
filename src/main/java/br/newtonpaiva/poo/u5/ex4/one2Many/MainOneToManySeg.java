package br.newtonpaiva.poo.u5.ex4.one2Many;

import br.newtonpaiva.poo.u5.ex4.AbstractMain;

public class MainOneToManySeg extends AbstractMain {

    public static void main(String[] args) {
        var d = new Disciplina("TADS-001", "Programação Orientada por Objetos");
        var d2 = new Disciplina("TADS-002", "Bancos de Dados");
        var d3 = new Disciplina("TADS-005", "Programação Web");

        var c = new Curso("TADS", "Sistemas de Informação", "exatas", 8, "PRESENCIAL");

        salvar(c);

        c.adicionarDisciplina(d);
        c.adicionarDisciplina(d2);
        c.adicionarDisciplina(d3);

        salvar(c);

        c.removerDisciplina(d2);
        salvar(c);

        deletar(d2);
        buscar(Disciplina.class, d2.getId());

        encerrar();
    }

}
