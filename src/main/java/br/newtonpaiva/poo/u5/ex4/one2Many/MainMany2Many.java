package br.newtonpaiva.poo.u5.ex4.one2Many;

import br.newtonpaiva.poo.u5.ex4.AbstractMain;
import br.newtonpaiva.poo.u5.ex4.one2one.Aluno;
import br.newtonpaiva.poo.u5.ex4.one2one.DocumentoDeIndentificacao;

public class MainMany2Many extends AbstractMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        var disciplina = new Disciplina(null, "TADS-001", "Programação Orientada por Objetos");
        salvar(disciplina);

        var doc = new DocumentoDeIndentificacao(null, "Identidade", "MG-12345678");
        salvar(doc);

        var aluno = new Aluno(null, "João Silva", doc);
        salvar(aluno);

        disciplina.adicionarAluno(aluno);
        salvar(disciplina);

        disciplina.removerAluno(aluno);
        salvar(disciplina);
    }

}
