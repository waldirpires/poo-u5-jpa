package br.newtonpaiva.poo.u5.ex4.one2Many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String codigo;

    private String nome;

    private String area;

    private Integer numSemestres;

    private String regime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    private Set<Disciplina> disciplinas = new HashSet<>(); // conjunto que não permite duplicadas

    public Curso(String codigo, String nome, String area, Integer numSemestres, String regime) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.area = area;
        this.numSemestres = numSemestres;
        this.regime = regime;
    }

    public Curso() {
        // TODO Auto-generated constructor stub
    }

    public void adicionarDisciplina(Disciplina d) {
        this.disciplinas.add(d);

        if (d != null) { // criando uma associacao
            d.setCurso(this);
        }
    }

    public void removerDisciplina(Disciplina d) {
        this.disciplinas.remove(d);

        if (d != null) { // removendo a associacao
            d.setCurso(null);
        }
    }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", area=" + area + ", numSemestres="
                + numSemestres + ", regime=" + regime + "]";
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getNumSemestres() {
        return numSemestres;
    }

    public void setNumSemestres(Integer numSemestres) {
        this.numSemestres = numSemestres;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

}
