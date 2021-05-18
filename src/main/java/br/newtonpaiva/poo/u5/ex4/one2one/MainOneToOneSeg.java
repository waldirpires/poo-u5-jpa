package br.newtonpaiva.poo.u5.ex4.one2one;

import br.newtonpaiva.poo.u5.ex4.AbstractMain;

public class MainOneToOneSeg extends AbstractMain {

    public static void main(String[] args) {
        var d = new DocumentoDeIdentificacao("Identidade", "MG-10.567.890");

        var a = new Aluno("José Pereira", d);

        // salvar
        salvar(a);

        a.setDocumento(null);
        salvar(a);
//
//        buscar(Aluno.class, a.getId());
//
//        deletar(d);

        // buscar(Aluno.class, a.getId());

        var m = new Aluno("Maria Rosa Gonçalves", d);
        salvar(m);

        encerrar();

    }

}
