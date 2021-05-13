package br.newtonpaiva.poo.u5.ex4.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private DocumentoDeIdentificacao documento;

    public Aluno(Integer id, String nome, DocumentoDeIdentificacao documento) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }

    public Aluno() {
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", documento=" + documento + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setDocumento(DocumentoDeIdentificacao documento) {
        this.documento = documento;
    }
}
