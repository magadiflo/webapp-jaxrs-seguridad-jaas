package org.magadiflo.webapp.jaxws.repositories;

import org.magadiflo.webapp.jaxws.models.Curso;

import java.util.List;

public interface CursoRepository {

    List<Curso> listar();
    Curso guardar(Curso curso);
    Curso porId(Long id);
    void eliminar(Long id);

}
