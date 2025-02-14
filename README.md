# Grupal-Avanzada-II
 Trabajo grupal gestion de biblioteca

```sql
-- Creación de la tabla autor
CREATE TABLE IF NOT EXISTS autor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    fecha_nacimiento TEXT,
    nacionalidad TEXT
);

-- Creación de la tabla libro
CREATE TABLE IF NOT EXISTS libro (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT NOT NULL,
    isbn TEXT NOT NULL,
    ano_publicacion TEXT,
    precio REAL NOT NULL,
    autor_id INTEGER,
    FOREIGN KEY (autor_id) REFERENCES autor(id)
);
```
