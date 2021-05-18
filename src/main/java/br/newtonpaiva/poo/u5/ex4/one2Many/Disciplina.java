package br.newtonpaiva.poo.u5.ex4.one2Many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.newtonpaiva.poo.u5.ex4.one2one.Aluno;

@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String codigo;

    private String nome;

    @ManyToOne
    private Curso curso;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Aluno> alunos = new HashSet<>();

    public Disciplina(String codigo, String nome) {
        super();
        this.codigo = codigo;
        this.nome = nome;
    }

    public Disciplina() { // POJO
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Disciplina [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", curso=" + curso.getNome() + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void adicionarAluno(Aluno a) {
        this.alunos.add(a);
        a.adicionarDisciplina(this);
    }

    public void removerAluno(Aluno a) {
        this.alunos.remove(a);
        a.removerDisciplina(this);
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }
}
