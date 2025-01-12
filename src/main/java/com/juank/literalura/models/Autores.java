package com.juank.literalura.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int anoNacimiento;
    private int anoMuerte;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libros> libros = new ArrayList<>();

    public Autores(DatosAutores datosAutores) {
        this.name = datosAutores.nombreAutor();
        this.anoNacimiento = datosAutores.anoNacimiento();
        this.anoMuerte = datosAutores.anoMuerte();
    }

    public Autores() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAñoNacimiento() {
        return anoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public int getAñoMuerte() {
        return anoMuerte;
    }

    public void setAñoMuerte(int añoMuerte) {
        this.anoMuerte = anoMuerte;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }


    @Override
    // Obtener solo el título de los libros
    public String toString() {
        StringBuilder librosTitulos = new StringBuilder();
        for (Libros libro : libros) {
            librosTitulos.append(libro.getTitulo()).append(", ");
        }

        // Eliminar la última coma y espacio
        if (librosTitulos.length() > 0) {
            librosTitulos.setLength(librosTitulos.length() - 2);
        }

        return  "--------------- AUTOR ---------------" + "\n" +
                "Autor: " + name + "\n" +
                "Fecha de nacimiento: " + anoNacimiento + "\n" +
                "Fecha de fallecimiento: " + anoMuerte + "\n" +
                "Libros: " + librosTitulos + "\n";
    }
}
