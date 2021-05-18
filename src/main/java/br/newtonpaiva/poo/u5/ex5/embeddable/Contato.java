package br.newtonpaiva.poo.u5.ex5.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Contato {

    private String nomeContato;

    private String telefone;

    private String email;

    public Contato() {
        // TODO Auto-generated constructor stub
    }

    public Contato(String nome, String telefone, String email) {
        this.nomeContato = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nome) {
        this.nomeContato = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato [nome=" + nomeContato + ", telefone=" + telefone + ", email=" + email + "]";
    }

}
