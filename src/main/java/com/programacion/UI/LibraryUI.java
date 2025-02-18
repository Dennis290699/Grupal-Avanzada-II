package com.programacion.UI;

import com.programacion.db.Book;
import com.programacion.repository.AuthorRepository;
import com.programacion.repository.BookRepository;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryUI extends JFrame {
    public LibraryUI(AuthorRepository authorRepository, BookRepository bookRepository) {
        setTitle("Gestor de libros");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear la barra de menús
        JMenuBar menuBar = new JMenuBar();

        // Menú de "Cambio de Tema"
        JMenu menuTheme = new JMenu("Cambio de Tema");
        menuBar.add(menuTheme);

        // Agregar opciones de tema
        JMenuItem lightThemeItem = new JMenuItem("Tema Claro (FlatIntelliJLaf)");
        JMenuItem darkThemeItem = new JMenuItem("Tema Oscuro (FlatDarculaLaf)");

        // Agregar las opciones al menú
        menuTheme.add(lightThemeItem);
        menuTheme.add(darkThemeItem);

        // Menú de "Filtros"
        JMenu menuBooksFilter = new JMenu("Filtros");
        menuBar.add(menuBooksFilter);

        // Agregar opción para buscar el libro con el precio más alto
        JMenuItem highestPriceItem = new JMenuItem("Buscar libro con mayor precio");

        menuBooksFilter.add(highestPriceItem);

        // Configurar la acción de cambiar el tema
        lightThemeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLookAndFeel(new FlatIntelliJLaf());
            }
        });

        darkThemeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLookAndFeel(new FlatDarculaLaf());
            }
        });

        // Configurar la acción para buscar el libro con el precio más alto
        highestPriceItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchHighestPriceBook(bookRepository);
            }
        });

        // Establecer la barra de menús
        setJMenuBar(menuBar);

        // Crear el panel de pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Authors", new AuthorPanel(authorRepository));
        tabbedPane.addTab("Books", new BookPanel(bookRepository, authorRepository));

        add(tabbedPane);

        setVisible(true);
    }

    private void setLookAndFeel(javax.swing.LookAndFeel lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
            SwingUtilities.updateComponentTreeUI(this);  // Actualizar la UI para reflejar el cambio de tema
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private void searchHighestPriceBook(BookRepository bookRepository) {
        Book highestPriceBook = bookRepository.findBookWithHighestPrice();

        if (highestPriceBook != null) {
            JOptionPane.showMessageDialog(this,
                    "Libro con el precio más alto: " + highestPriceBook.getTitle() +
                            "\nPrecio: " + highestPriceBook.getPrice(),
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron libros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
