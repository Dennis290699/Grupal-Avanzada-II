package com.programacion.UI;

import com.programacion.db.Author;
import com.programacion.repository.AuthorRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AuthorPanel extends JPanel {
    private final AuthorRepository authorRepository;
    private JTable table;
    private DefaultTableModel tableModel;

    public AuthorPanel(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        setLayout(new BorderLayout());

        // Configurar la tabla
        tableModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Apellido", "Fecha de Nacimiento", "Nacionalidad"}, 0);
        table = new JTable(tableModel);
        loadAuthors();

        // Botones CRUD
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Agregar");
        JButton updateButton = new JButton("Actualizar");
        JButton deleteButton = new JButton("Eliminar");

        addButton.addActionListener(e -> addAuthor());
        updateButton.addActionListener(e -> updateAuthor());
        deleteButton.addActionListener(e -> deleteAuthor());

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadAuthors() {
        tableModel.setRowCount(0);
        List<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            tableModel.addRow(new Object[]{author.getId(), author.getName(), author.getLastName(), author.getBirthDate(), author.getNationality()});
        }
    }

    private void addAuthor() {
        JTextField nameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField birthDateField = new JTextField();
        JTextField nationalityField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(nameField);
        panel.add(new JLabel("Apellido:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Fecha de Nacimiento (YYYY-MM-DD):"));
        panel.add(birthDateField);
        panel.add(new JLabel("Nacionalidad:"));
        panel.add(nationalityField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Agregar Autor", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String birthDate = birthDateField.getText().trim();
            String nationality = nationalityField.getText().trim();

            if (name.isEmpty() || lastName.isEmpty() || birthDate.isEmpty() || nationality.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Author author = new Author();
            author.setName(name);
            author.setLastName(lastName);
            author.setBirthDate(birthDate);
            author.setNationality(nationality);

            authorRepository.save(author);
            loadAuthors();
        }
    }

    private void updateAuthor() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            Author author = authorRepository.findBy(id);

            if (author == null) {
                JOptionPane.showMessageDialog(this, "Autor no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JTextField nameField = new JTextField(author.getName());
            JTextField lastNameField = new JTextField(author.getLastName());
            JTextField birthDateField = new JTextField(author.getBirthDate());
            JTextField nationalityField = new JTextField(author.getNationality());

            JPanel panel = new JPanel(new GridLayout(4, 2));
            panel.add(new JLabel("Nombre:"));
            panel.add(nameField);
            panel.add(new JLabel("Apellido:"));
            panel.add(lastNameField);
            panel.add(new JLabel("Fecha de Nacimiento (YYYY-MM-DD):"));
            panel.add(birthDateField);
            panel.add(new JLabel("Nacionalidad:"));
            panel.add(nationalityField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Actualizar Autor", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String name = nameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String birthDate = birthDateField.getText().trim();
                String nationality = nationalityField.getText().trim();

                if (name.isEmpty() || lastName.isEmpty() || birthDate.isEmpty() || nationality.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                author.setName(name);
                author.setLastName(lastName);
                author.setBirthDate(birthDate);
                author.setNationality(nationality);
                authorRepository.save(author);
                loadAuthors();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un autor para actualizar.");
        }
    }

    private void deleteAuthor() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de eliminar este autor?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                Author author = authorRepository.findBy(id);
                if (author != null) {
                    // Verificar si el autor tiene libros asociados
                    if (author.getBooks() != null && !author.getBooks().isEmpty()) {
                        // Mostrar ventana con mensaje de error
                        JOptionPane.showMessageDialog(this,
                                "No se puede eliminar el autor porque tiene libros asociados.\n" +
                                        "Elimine o reasigne sus libros antes de intentar eliminarlo.",
                                "Error de eliminación",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        authorRepository.remove(author);
                        loadAuthors();
                        JOptionPane.showMessageDialog(this,
                                "Autor eliminado con éxito.",
                                "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this,
                                "No se puede eliminar el autor porque tiene libros asociados.\n" +
                                        "Elimine o reasigne sus libros antes de intentar eliminarlo.",
                                "Error de eliminación",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Autor no encontrado.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un autor para eliminar.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
