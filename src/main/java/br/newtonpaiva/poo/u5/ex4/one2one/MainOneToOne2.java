package br.newtonpaiva.poo.u5.ex4.one2one;

import br.newtonpaiva.poo.u5.ex4.FonteDeDados;

public class MainOneToOne2 {

    public static void main(String[] args) {
        var fonteDeDados = new FonteDeDados("BancoPU1");

        fonteDeDados.inicializar();

        var doc = new DocumentoDeIdentificacao(null, "Identidade", "MG-12345678");
        System.out.println(doc);
        System.out.println();

        var aluno = new Aluno(null, "José Pereira", doc);
        System.out.println(aluno);
        System.out.println();

        // SAVE
        fonteDeDados.salvar(doc);

        fonteDeDados.salvar(aluno);

        // GET
        var alunos = fonteDeDados.listar(Aluno.class);
        System.out.println("Alunos:");
        System.out.println(alunos);
        System.out.println();

        aluno = fonteDeDados.buscar(Aluno.class, aluno.getId());
        System.out.println(aluno);
        System.out.println();

        var docs = fonteDeDados.listar(DocumentoDeIdentificacao.class);
        System.out.println("Documentos:");
        System.out.println(docs);
        System.out.println();

        doc = fonteDeDados.buscar(DocumentoDeIdentificacao.class, doc.getId());
        System.out.println(doc);
        System.out.println();

        fonteDeDados.deletar(doc);

        fonteDeDados.deletar(aluno);

        fonteDeDados.encerrar();

    }

}
