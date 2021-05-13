package br.newtonpaiva.poo.u5.ex2.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.newtonpaiva.poo.u5.ex1.model.Cliente;

public class ClienteMemoriaDao implements Dao<Cliente> {

    private List<Cliente> clientes = new ArrayList<Cliente>();

    // Select * from Cliente c where c.id = ?
    public Cliente getOld(long id) {
        for (var c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }

        return null;
    }

    public Optional<Cliente> get(long id) {
        for (var c : clientes) {
            if (c.getId() == id) {
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

    public List<Cliente> getAll() {
        return clientes;
    }

    public void save(Cliente t) {
        this.clientes.add(t);
    }

    public void update(Cliente t) {
        var existe = get(t.getId());

        if (existe.isPresent()) {
            var c = existe.get();
            c.setNome(t.getNome());
            c.setCpf(t.getCpf());
        } else {
            this.clientes.add(t);
        }
    }

    public void delete(Cliente t) {
        var existe = get(t.getId());

        if (existe.isPresent()) {
            this.clientes.remove(t);
        } else {
            System.out.println("ERROR: Not found -> " + t.getClass().getSimpleName() + "." + t.getId());
        }
    }
}
