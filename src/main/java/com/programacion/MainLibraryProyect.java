package com.programacion;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.programacion.UI.LibraryUI;
import com.programacion.repository.AuthorRepository;
import com.programacion.repository.BookRepository;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import javax.swing.*;

public class MainLibraryProyect {
    public static void main(String[] args) {
        // Inicializar el contenedor CDI
        System.out.println("\n==================== INICIANDO CONTENEDOR =====================");
        SeContainer container = SeContainerInitializer.newInstance().initialize();

        // Configurar FlatLaf antes de lanzar la UI
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtener los repositorios desde CDI
        var repoAuthor = container.select(AuthorRepository.class).get();
        var repoBook = container.select(BookRepository.class).get();

        // Iniciar la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> new LibraryUI(repoAuthor, repoBook));

        // No cerrar el contenedor inmediatamente, lo mantendremos abierto mientras la UI está activa.
    }
}
