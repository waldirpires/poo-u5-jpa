package br.newtonpaiva.poo.u5.ex4.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "documento_identificacao", uniqueConstraints = {
        @UniqueConstraint(name = "aluno", columnNames = { "aluno_id" }) })
public class DocumentoDeIdentificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private String valor;

    @OneToOne(cascade = CascadeType.ALL)
    private Aluno aluno;

    public DocumentoDeIdentificacao(String nome, String valor) {
        super();
        this.nome = nome;
        this.valor = valor;
    }

    public DocumentoDeIdentificacao() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "DocumentoDeIdentificacao [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
