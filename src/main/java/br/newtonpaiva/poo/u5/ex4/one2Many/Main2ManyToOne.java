package br.newtonpaiva.poo.u5.ex4.one2Many;

import br.newtonpaiva.poo.u5.ex4.AbstractMain;

public class Main2ManyToOne extends AbstractMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        var disciplina = new Disciplina("TADS-001", "Programação Orientada por Objetos");
        var curso = new Curso(null, "TADS", "Técnicas de Análise de Sistemas", "Exatas", 8, "presencial");
        curso.adicionarDisciplina(disciplina);
        salvar(curso);

        curso.removerDisciplina(disciplina);
        salvar(curso);
    }
}
