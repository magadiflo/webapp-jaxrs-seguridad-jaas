package org.magadiflo.webapp.jaxws.services;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.magadiflo.webapp.jaxws.models.Curso;
import org.magadiflo.webapp.jaxws.repositories.CursoRepository;

import java.util.List;
import java.util.Optional;

@Stateless
@DeclareRoles({"USER", "ADMIN"})
public class CursoServiceImpl implements CursoService {

    @Inject
    private CursoRepository repository;

    @RolesAllowed({"USER", "ADMIN"})
    @Override
    public List<Curso> listar() {
        return this.repository.listar();
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public Curso guardar(Curso curso) {
        return this.repository.guardar(curso);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @Override
    public Optional<Curso> porId(Long id) {
        return Optional.ofNullable(this.repository.porId(id));
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public void eliminar(Long id) {
        this.repository.eliminar(id);
    }

}
