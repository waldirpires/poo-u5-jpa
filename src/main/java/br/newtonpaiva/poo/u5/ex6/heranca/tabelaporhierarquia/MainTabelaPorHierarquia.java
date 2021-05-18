package br.newtonpaiva.poo.u5.ex6.heranca.tabelaporhierarquia;

import java.time.LocalDateTime;

import br.newtonpaiva.poo.u5.ex4.AbstractMain;

public class MainTabelaPorHierarquia extends AbstractMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        showTables();

        showColumnsFromTable("funcionario");

        var f = new Funcionario("José Pereira", LocalDateTime.now().minusYears(2), null);
        salvar(f);

        var clt = new ContratoClt("Maria Silva", LocalDateTime.now().minusYears(1), null, 4000.0f, 200.f);
        salvar(clt);

        var pj = new ContratoPj("João Lima", LocalDateTime.now().minusYears(3), LocalDateTime.now(), 100.0f, 26);
        salvar(pj);

        encerrar();
    }

}
