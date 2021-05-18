package br.newtonpaiva.poo.u5.ex4.one2one;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.newtonpaiva.poo.u5.ex4.one2Many.Disciplina;

@Entity
@Table(name = "aluno", uniqueConstraints = {
        @UniqueConstraint(name = "documentacao", columnNames = { "documento_id" }) })
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private DocumentoDeIdentificacao documento;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Disciplina> disciplinas = new HashSet<>();

    public Aluno(String nome, DocumentoDeIdentificacao documento) {
        super();
        this.nome = nome;
        setDocumento(documento);
    }

    public Aluno() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", documento=" + documento + "]";
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

    public DocumentoDeIdentificacao getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoDeIdentificacao documento) {
        // se for desassociação
        if (documento == null && this.documento != null) {
            this.documento.setAluno(null);
        }
        // seta
        this.documento = documento;
        // se for associacao
        if (documento != null) {
            documento.setAluno(this);
        }
    }

    public void adicionarDisciplina(Disciplina d) {
        this.disciplinas.add(d);
    }

    public void removerDisciplina(Disciplina d) {
        this.disciplinas.remove(d);
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
