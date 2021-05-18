package br.newtonpaiva.poo.u5.ex6.heranca.tabelaporhierarquia;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
// tabela por hierarquia
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "funcionario")

// tabela por classe concreta
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//tabela por subclasse
//@Inheritance(strategy = InheritanceType.JOINED)

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String nome;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    public Funcionario(String nome, LocalDateTime inicio, LocalDateTime fim) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Funcionario() {
        // TODO Auto-generated constructor stub
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + ", inicio=" + inicio + ", fim=" + fim + "]";
    }

}
