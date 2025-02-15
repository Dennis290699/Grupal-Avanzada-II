package com.programacion.UI;

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
        setSize(800, 600);
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
}
