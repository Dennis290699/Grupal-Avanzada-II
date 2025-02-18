package com.programacion.UI;

import com.programacion.db.Author;
import com.programacion.db.Book;
import com.programacion.repository.AuthorRepository;
import com.programacion.repository.BookRepository;
import com.programacion.services.BookService;
import jakarta.transaction.Transactional;
import jakarta.enterprise.inject.spi.CDI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class BookPanel extends JPanel {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private JTable table;
    private DefaultTableModel tableModel;

    public BookPanel(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;

        setLayout(new BorderLayout());

        // Configurar la tabla
        tableModel = new DefaultTableModel(new String[]{"ID", "Titulo", "ISBN", "Año de Publicación", "Precio", "Author ID"}, 0);
        table = new JTable(tableModel);
        loadBooks();

        // Botones CRUD
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Agregar");
        JButton updateButton = new JButton("Actualizar");
        JButton deleteButton = new JButton("Eliminar");
//        JButton highestPriceButton = new JButton("Buscar libro más caro");

        addButton.addActionListener(e -> addBook());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());

        // Acción para el botón de buscar libro más caro
//        highestPriceButton.addActionListener(e -> searchHighestPriceBook());

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
//        buttonPanel.add(highestPriceButton); // Agregar el nuevo botón al panel

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadBooks() {
        tableModel.setRowCount(0);
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            String authorName = book.getAuthor() != null ? book.getAuthor().getName() + " " + book.getAuthor().getLastName() : "Desconocido";
            tableModel.addRow(new Object[]{
                    book.getId(),
                    book.getTitle(),
                    book.getIsbn(),
                    book.getYearPublication(),
                    book.getPrice(),
                    authorName
            });
        }
    }

    private void addBook() {
        JTextField titleField = new JTextField();
        JTextField isbnField = new JTextField();
        JTextField yearPublicationField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField authorIdField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Título:"));
        panel.add(titleField);
        panel.add(new JLabel("ISBN:"));
        panel.add(isbnField);
        panel.add(new JLabel("Año de Publicación:"));
        panel.add(yearPublicationField);
        panel.add(new JLabel("Precio:"));
        panel.add(priceField);
        panel.add(new JLabel("ID de Autor:"));
        panel.add(authorIdField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Agregar Libro", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText().trim();
                String isbn = isbnField.getText().trim();
                String yearPublicationStr = yearPublicationField.getText().trim();
                double price = Double.parseDouble(priceField.getText().trim());
                int authorId = Integer.parseInt(authorIdField.getText().trim());

                // Validar campos
                if (title.isEmpty() || isbn.isEmpty() || yearPublicationStr.isEmpty() || price <= 0 || authorId <= 0) {
                    JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios y el precio debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Convertir el año de publicación a String
                String yearPublication = yearPublicationStr;

                Book book = new Book();
                book.setTitle(title);
                book.setIsbn(isbn);
                book.setYearPublication(yearPublication);
                book.setPrice(BigDecimal.valueOf(price));

                // Buscar el autor en la base de datos antes de asignarlo
                Author author = authorRepository.findBy(authorId);
                if (author != null) {
                    book.setAuthor(author);
                    bookRepository.save(book);
                    loadBooks();
                } else {
                    JOptionPane.showMessageDialog(this, "Autor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Formato de número inválido para el precio o el ID del autor", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            Book book = bookRepository.findBy(id);

            if (book == null) {
                JOptionPane.showMessageDialog(this, "Libro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JTextField titleField = new JTextField(book.getTitle());
            JTextField isbnField = new JTextField(book.getIsbn());
            JTextField yearPublicationField = new JTextField(book.getYearPublication());
            JTextField priceField = new JTextField(book.getPrice().toString());
            JTextField authorIdField = new JTextField(String.valueOf(book.getAuthor().getId()));

            JPanel panel = new JPanel(new GridLayout(5, 2));
            panel.add(new JLabel("Titulo:"));
            panel.add(titleField);
            panel.add(new JLabel("ISBN:"));
            panel.add(isbnField);
            panel.add(new JLabel("Año de Publicación:"));
            panel.add(yearPublicationField);
            panel.add(new JLabel("Precio:"));
            panel.add(priceField);
            panel.add(new JLabel("Author ID:"));
            panel.add(authorIdField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Actualizar Libro", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String newTitle = titleField.getText().trim();
                String newIsbn = isbnField.getText().trim();
                String newYearPublication = yearPublicationField.getText().trim();
                String newPrice = priceField.getText().trim();
                String newAuthorId = authorIdField.getText().trim();

                // Validación de campos
                if (newTitle.isEmpty() || newIsbn.isEmpty() || newYearPublication.isEmpty() || newPrice.isEmpty() || newAuthorId.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int newAuthorIdInt = Integer.parseInt(newAuthorId.trim());
                    BigDecimal newPriceValue = new BigDecimal(newPrice.trim());
                    int newYearPublicationInt = Integer.parseInt(newYearPublication.trim());

                    Author author = authorRepository.findBy(newAuthorIdInt);
                    if (author != null) {
                        book.setTitle(newTitle);
                        book.setIsbn(newIsbn);
                        book.setYearPublication(newYearPublication);
                        book.setPrice(newPriceValue);
                        book.setAuthor(author);

                        bookRepository.save(book);
                        loadBooks();
                    } else {
                        JOptionPane.showMessageDialog(this, "Autor no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Error en los campos numéricos. Verifique el formato de Año de Publicación, Precio y Author ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para actualizar.");
        }
    }

    private void deleteBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "¿Estás seguro de eliminar este libro?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                // Obtener el servicio gestionado por CDI
                BookService bookService = CDI.current().select(BookService.class).get();
                // Llamar al metodo del servicio para eliminar el libro dentro de una transacción
                bookService.deleteBook(id);
                // Recargar la tabla
                loadBooks();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    // Metodo para buscar el libro con el precio más alto
//    private void searchHighestPriceBook(BookRepository bookRepository) {
//        // Llamar al metodo findBookWithHighestPrice() ya definido en BookRepository
//        Book highestPriceBook = bookRepository.findBookWithHighestPrice();
//
//        // Mostrar el resultado
//        if (highestPriceBook != null) {
//            JOptionPane.showMessageDialog(this,
//                    "Libro con el precio más alto: " + highestPriceBook.getTitle() +
//                            "\nPrecio: " + highestPriceBook.getPrice(),
//                    "Resultado",
//                    JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(this, "No se encontraron libros.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
}
