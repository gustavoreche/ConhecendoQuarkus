package br.com.dominio.ordem.repositorio;

import javax.enterprise.context.ApplicationScoped;

import br.com.dominio.ordem.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {

}
