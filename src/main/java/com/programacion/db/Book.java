package com.programacion.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "libro")
@Getter
@Setter
@ToString(exclude = "author")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String title;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "ano_publicacion", nullable = false)
    private String yearPublication;

    @Column(name = "precio", nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Author author;
}