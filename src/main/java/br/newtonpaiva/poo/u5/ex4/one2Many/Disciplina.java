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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo;

    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    private Curso curso;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Aluno> alunos = new HashSet<>();

    public Disciplina(String codigo, String nome) {
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

    public Curso getCurso() {
        return curso;
    }
}
