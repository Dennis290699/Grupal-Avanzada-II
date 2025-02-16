package com.programacion.repository;

import com.programacion.db.Book;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

@Repository
public interface BookRepository extends EntityRepository<Book, Integer> {
    List<Book> findBooksByAuthor(String authorName);
    Book findBookByIsbn(String isbn);

    // Metodo para obtener el libro con el precio más alto utilizando ForkJoin
    default Book findBookWithHighestPrice() {
        List<Book> books = findAll();
        ForkJoinPool pool = new ForkJoinPool();

        BookWithHighestPriceTask task = new BookWithHighestPriceTask(books, 0, books.size());
        return pool.invoke(task);
    }

    // Clase interna para el ForkJoinTask
    class BookWithHighestPriceTask extends RecursiveTask<Book> {
        private final List<Book> books;
        private final int start;
        private final int end;

        public BookWithHighestPriceTask(List<Book> books, int start, int end) {
            this.books = books;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Book compute() {
            if (end - start <= 10) {
                // Si el tamaño del subproblema es pequeño, procesamos en el hilo actual
                Book maxPriceBook = null;
                for (int i = start; i < end; i++) {
                    Book book = books.get(i);
                    if (maxPriceBook == null || book.getPrice().compareTo(maxPriceBook.getPrice()) > 0) {
                        maxPriceBook = book;
                    }
                }
                return maxPriceBook;
            } else {
                // Dividir el trabajo en dos tareas
                int mid = (start + end) / 2;
                BookWithHighestPriceTask leftTask = new BookWithHighestPriceTask(books, start, mid);
                BookWithHighestPriceTask rightTask = new BookWithHighestPriceTask(books, mid, end);

                leftTask.fork();  // Iniciar la tarea en paralelo
                Book rightResult = rightTask.fork().join(); // Ejecutar la tarea en paralelo
                Book leftResult = leftTask.join();  // Esperar el resultado de la tarea izquierda

                // Comparar ambos resultados
                if (leftResult.getPrice().compareTo(rightResult.getPrice()) > 0) {
                    return leftResult;
                } else {
                    return rightResult;
                }
            }
        }
    }
}
