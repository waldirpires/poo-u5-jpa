package br.newtonpaiva.poo.u5.ex4.one2one;

import br.newtonpaiva.poo.u5.ex4.AbstractMain;

public class MainOneToOne extends AbstractMain {

    public static void main(String[] args) {

        var doc = new DocumentoDeIdentificacao(null, "Identidade", "MG-12345678");
        System.out.println(doc);
        System.out.println();

        var aluno = new Aluno(null, "José Pereira", doc);
        System.out.println(aluno);
        System.out.println();

        // SAVE
        salvar(doc);

        salvar(aluno);

        // GET
        var alunos = listar(Aluno.class);
        System.out.println("Alunos:");
        System.out.println(alunos);
        System.out.println();

        aluno = buscar(Aluno.class, aluno.getId());
        System.out.println(aluno);
        System.out.println();

        var docs = listar(DocumentoDeIdentificacao.class);
        System.out.println("Documentos:");
        System.out.println(docs);
        System.out.println();

        doc = buscar(DocumentoDeIdentificacao.class, doc.getId());
        System.out.println(doc);
        System.out.println();

        deletar(doc);

        deletar(aluno);

        encerrar();
    }

}
