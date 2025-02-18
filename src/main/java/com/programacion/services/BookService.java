package com.programacion.services;

import com.programacion.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@ApplicationScoped
public class BookService {

    @Inject
    private EntityManager em;

    public void deleteBook(int id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Book book = em.find(Book.class, id);
            if (book != null) {
                // Romper la asociación con el autor (si es necesario)
                if (book.getAuthor() != null) {
                    book.getAuthor().getBooks().remove(book);
                }
                em.remove(book);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }
}
