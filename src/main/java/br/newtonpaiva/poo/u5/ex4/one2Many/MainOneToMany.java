package br.newtonpaiva.poo.u5.ex4.one2Many;

import br.newtonpaiva.poo.u5.ex4.AbstractMain;

public class MainOneToMany extends AbstractMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        var disciplina = new Disciplina(null, "TADS-001", "Programação Orientada por Objetos");
        salvar(disciplina);

        var curso = new Curso(null, "TADS", "Técnicas de Análise de Sistemas", "Exatas", 8, "presencial");
        salvar(curso);

        curso.adicionarDisciplina(disciplina);
        salvar(curso);

        curso.removerDisciplina(disciplina);
        salvar(curso);
    }

}
