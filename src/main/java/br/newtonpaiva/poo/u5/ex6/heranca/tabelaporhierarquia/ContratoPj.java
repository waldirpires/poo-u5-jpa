package br.newtonpaiva.poo.u5.ex6.heranca.tabelaporhierarquia;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// tabela por hierarquia
@DiscriminatorValue("empregadopj")

// tabela por classe concreta
//@Table(name = "contrato_pj")
//@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id")),
//        @AttributeOverride(name = "nome", column = @Column(name = "nome")) })

//tabela por subclasse
//@Table(name = "contrato_pj")
//@PrimaryKeyJoinColumn(name = "ID")
public class ContratoPj extends Funcionario {

    private Float valorHora;

    private Integer periodoEmMeses;

    public ContratoPj() {
        // TODO Auto-generated constructor stub
    }

    public ContratoPj(String nome, LocalDateTime inicio, LocalDateTime fim, Float valorHora, Integer periodoEmMeses) {
        super(nome, inicio, fim);
        this.valorHora = valorHora;
        this.periodoEmMeses = periodoEmMeses;
    }

    public Float getValorHora() {
        return valorHora;
    }

    public void setValorHora(Float valorHora) {
        this.valorHora = valorHora;
    }

    public Integer getPeriodoEmMeses() {
        return periodoEmMeses;
    }

    public void setPeriodoEmMeses(Integer periodoEmMeses) {
        this.periodoEmMeses = periodoEmMeses;
    }

    @Override
    public String toString() {
        return "ContratoPj [valorHora=" + valorHora + ", periodoEmMeses=" + periodoEmMeses + ", toString()="
                + super.toString() + "]";
    }

}
