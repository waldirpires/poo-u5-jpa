package br.newtonpaiva.poo.u5.ex4.one2one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documento_identificacao")
public class DocumentoDeIdentificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String valor;

    public DocumentoDeIdentificacao(Integer id, String nome, String valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public DocumentoDeIdentificacao() {
    }

    @Override
    public String toString() {
        return "DocumentoDeIdentificacao [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
    }

    public Integer getId() {
        return id;
    }
}
