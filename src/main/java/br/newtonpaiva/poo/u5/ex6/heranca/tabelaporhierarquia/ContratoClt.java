package br.newtonpaiva.poo.u5.ex6.heranca.tabelaporhierarquia;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// tabela por hierarquia
@DiscriminatorValue("empregadoclt")

// tabela por classe concreta
//@Table(name = "contrato_clt")
//@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id")),
//        @AttributeOverride(name = "nome", column = @Column(name = "nome")) })

// tabela por subclasse
//@Table(name = "contrato_clt")
//@PrimaryKeyJoinColumn(name = "ID")
public class ContratoClt extends Funcionario {

    private Float salarioMensal;

    private Float bonus;

    public ContratoClt() {
        // TODO Auto-generated constructor stub
    }

    public ContratoClt(String nome, LocalDateTime inicio, LocalDateTime fim, Float salarioMensal, Float bonus) {
        super(nome, inicio, fim);
        this.salarioMensal = salarioMensal;
        this.bonus = bonus;
    }

    public Float getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(Float salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public Float getBonus() {
        return bonus;
    }

    public void setBonus(Float bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "ContratoClt [salarioMensal=" + salarioMensal + ", bonus=" + bonus + ", toString()=" + super.toString()
                + "]";
    }

}
