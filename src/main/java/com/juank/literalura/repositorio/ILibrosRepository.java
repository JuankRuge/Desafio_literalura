package com.juank.literalura.repositorio;

import com.juank.literalura.models.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILibrosRepository extends JpaRepository<Libros, Long> {
    Libros findByTitulo(String titulo);
    List<Libros> findByLenguajesContaining(String lenguaje);
}
