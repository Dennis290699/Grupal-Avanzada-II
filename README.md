# Grupal-Avanzada-II

Este es un proyecto de gestión de una biblioteca utilizando Java, Gradle, JPA, y CDI, con una interfaz de usuario en Swing. La aplicación permite realizar operaciones CRUD sobre los libros y autores en una base de datos SQLite, con un enfoque en la manipulación de datos persistentes mediante JPA y consultas avanzadas.

## Descripción

El proyecto consiste en una aplicación de gestión de una biblioteca. La aplicación permite realizar las siguientes tareas:

- **Registrar autores y libros**.
- **Consultar información sobre libros y autores**.
- **Actualizar y eliminar datos**.
- **Visualización mediante una interfaz gráfica en Swing**.

Se emplea la arquitectura **Model-View-Controller (MVC)**, donde los modelos (`Book`, `Author`, etc.) se manejan mediante repositorios y servicios, y la vista se gestiona mediante componentes de UI como `AuthorPanel` y `BookPanel`.

## Tecnologías

- **Java 11** (o superior)
- **Gradle** (para la gestión del build)
- **JPA** (para la persistencia de datos)
- **CDI** (para la inyección de dependencias)
- **Swing** (para la interfaz gráfica)
- **SQLite** (base de datos)

## Estructura del Proyecto

La estructura de directorios de este proyecto es la siguiente:

```
Grupal-Avanzada-II
├── .gradle/                  # Archivos de configuración de Gradle
├── .idea/                    # Archivos de configuración de IntelliJ IDEA
├── bin/                      # Archivos compilados y clases generadas
├── build/                    # Archivos generados por Gradle (compilación, test, etc.)
├── gradle/                   # Archivos de configuración del wrapper de Gradle
├── src/                      # Código fuente del proyecto
│   ├── main/                 # Archivos de código fuente en Java
│   └── test/                 # Archivos de pruebas unitarias
├── books.db                  # Base de datos SQLite utilizada en el proyecto
├── build.gradle.kts          # Archivo de configuración de Gradle
├── gradlew                   # Script para ejecutar Gradle en sistemas Unix
├── gradlew.bat               # Script para ejecutar Gradle en sistemas Windows
├── LICENSE                   # Licencia del proyecto
├── README.md                 # Este archivo
└── schema-books-db.sql       # Script SQL para inicializar la base de datos
```

### Descripción de las carpetas:

- **.gradle/**: Archivos generados por Gradle para la gestión del proyecto.
- **.idea/**: Configuración de IntelliJ IDEA.
- **bin/**: Archivos compilados.
- **build/**: Archivos generados tras la ejecución de Gradle.
- **gradle/**: Archivos del wrapper de Gradle.
- **src/**: Código fuente del proyecto. Se encuentra dividido en `main` y `test`.
- **books.db**: Base de datos SQLite que almacena la información de los libros y autores.
- **schema-books-db.sql**: Script SQL utilizado para crear e insertar datos en la base de datos.
- **LICENSE**: Archivo de licencia del proyecto.

## Estructura de la Base de Datos

El proyecto utiliza una base de datos SQLite para almacenar la información de los libros y los autores. La base de datos contiene dos tablas principales: `autor` y `libro`.

### Tablas

#### `autor`
La tabla `autor` almacena información sobre los autores de los libros. Tiene la siguiente estructura:

```sql
CREATE TABLE IF NOT EXISTS autor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,    -- Identificador único del autor
    nombre TEXT NOT NULL,                     -- Nombre del autor
    apellido TEXT NOT NULL,                   -- Apellido del autor
    fecha_nacimiento TEXT,                    -- Fecha de nacimiento del autor (opcional)
    nacionalidad TEXT                         -- Nacionalidad del autor (opcional)
);
```

- **id**: Identificador único del autor.
- **nombre**: Nombre del autor.
- **apellido**: Apellido del autor.
- **fecha_nacimiento**: Fecha de nacimiento del autor (opcional).
- **nacionalidad**: Nacionalidad del autor (opcional).

#### `libro`
La tabla `libro` almacena información sobre los libros disponibles en la biblioteca. Está relacionada con la tabla `autor` mediante la clave foránea `autor_id`. Su estructura es la siguiente:

```sql
CREATE TABLE IF NOT EXISTS libro (
    id INTEGER PRIMARY KEY AUTOINCREMENT,   -- Identificador único del libro
    titulo TEXT NOT NULL,                    -- Título del libro
    isbn TEXT NOT NULL,                      -- ISBN del libro
    ano_publicacion TEXT,                    -- Año de publicación del libro (opcional)
    precio REAL NOT NULL,                    -- Precio del libro
    autor_id INTEGER,                        -- Referencia al autor del libro
    FOREIGN KEY (autor_id) REFERENCES autor(id)  -- Relación con la tabla 'autor'
);
```

- **id**: Identificador único del libro.
- **titulo**: Título del libro.
- **isbn**: ISBN del libro.
- **ano_publicacion**: Año de publicación del libro (opcional).
- **precio**: Precio del libro.
- **autor_id**: ID del autor relacionado con el libro, que es una clave foránea a la tabla `autor`.

### Datos Iniciales

El proyecto incluye un script SQL llamado `schema-DataInserts-books-db.sql` que se utiliza para insertar datos de ejemplo en la base de datos. Este script se encuentra en el directorio `src/main/resources/` y se puede ejecutar al inicializar la aplicación.

## Cómo ejecutar el proyecto

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone <url-del-repositorio>
   ```

2. Asegúrate de tener **Java 11** o superior instalado.

3. Usa el script de Gradle para compilar y ejecutar la aplicación:

    - En sistemas Unix:
      ```bash
      ./gradlew run
      ```
    - En sistemas Windows:
      ```bash
      gradlew.bat run
      ```

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, abre un **issue** o envía un **pull request**.

## Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

