package com.juank.literalura.repositorio;

import com.juank.literalura.models.Autores;
import com.juank.literalura.models.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IAutoresRepository  extends JpaRepository<Autores,Long> {
    Autores findByNameIgnoreCase(String nombre);
    List<Autores> findByAnoNacimientoLessThanEqualAndAnoMuerteGreaterThanEqual(int anoInicial, int anoFinal);
}
