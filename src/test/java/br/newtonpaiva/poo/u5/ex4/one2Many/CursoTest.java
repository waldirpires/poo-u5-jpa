package br.newtonpaiva.poo.u5.ex4.one2Many;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testAdicionarDisciplina() {
        // given:
        var curso = new Curso("001", "Análise de Sistemas", "exatas", 8, "EaD");
        var disciplina = new Disciplina("TAD-001", "Programação Orientada a Objetos");

        // when:
        curso.adicionarDisciplina(disciplina);

        // then:
        assertTrue(curso.getDisciplinas().contains(disciplina));
        // assertEquals(curso, disciplina.getCurso());
    }

    @Test
    void testRemoverDisciplina() {
        // given:
        var curso = new Curso("001", "Análise de Sistemas", "exatas", 8, "EaD");
        var disciplina = new Disciplina("TAD-001", "Programação Orientada a Objetos");

        curso.adicionarDisciplina(disciplina);

        // when:
        curso.removerDisciplina(disciplina);

        // then:
        assertFalse(curso.getDisciplinas().contains(disciplina));
        // assertNull(disciplina.getCurso());
    }

}
