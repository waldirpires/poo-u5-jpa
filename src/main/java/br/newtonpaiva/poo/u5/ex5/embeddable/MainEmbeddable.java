package br.newtonpaiva.poo.u5.ex5.embeddable;

import br.newtonpaiva.poo.u5.ex4.AbstractMain;

public class MainEmbeddable extends AbstractMain {

    public static void main(String[] args) {
        var contato = new Contato("José das Couves", "31.99123.4567", "zedascouves@gmail.com");

        var empresa = new Empresa("Instituto Newton Paiva", contato);

        salvar(empresa);

        buscar(Empresa.class, empresa.getId());

        listar(Empresa.class);

        empresa.setNome("Instituto Newton Paiva Ltda.");
        empresa.getContato().setNomeContato("José das Couves Pereira");
        atualizar(empresa);

        deletar(empresa);

        buscar(Empresa.class, empresa.getId());

        encerrar();
    }

}
