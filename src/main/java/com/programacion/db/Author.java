package com.programacion.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "autor")
@Getter
@Setter
@ToString(exclude = "books")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "apellido", nullable = false)
    private String lastName;

    @Column(name = "fecha_nacimiento", nullable = false)
    private String birthDate;

    @Column(name = "nacionalidad", nullable = false)
    private String nationality;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;
}