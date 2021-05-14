package br.newtonpaiva.poo.u5.ex4.one2Many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo;

    private String nome;

    private String area;

    private Integer numSemestres;

    private String regime;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Disciplina> disciplinas = new HashSet<>();

    public Curso(Integer id, String codigo, String nome, String area, Integer numSemestres, String regime) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.area = area;
        this.numSemestres = numSemestres;
        this.regime = regime;
    }

    public Curso() {
        // TODO Auto-generated constructor stub
    }

    public Integer getId() {
        return id;
    }

    public void adicionarDisciplina(Disciplina d) {
        this.disciplinas.add(d);
        d.setCurso(this);
    }

    public void removerDisciplina(Disciplina d) {
        this.disciplinas.remove(d);
        d.setCurso(null);
    }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", area=" + area + ", numSemestres="
                + numSemestres + ", regime=" + regime + ", disciplinas=" + disciplinas + "]";
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

}
