package br.newtonpaiva.poo.u5.ex4.one2Many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo;

    private String nome;

    public Disciplina(Integer id, String codigo, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
    }

    public Disciplina() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Disciplina [id=" + id + ", codigo=" + codigo + ", nome=" + nome + "]";
    }

    public Integer getId() {
        return id;
    }
}
